package com.dexter.movieappcompose.domain.usecase.tv_show

import com.dexter.movieappcompose.data.remote.repository.TvShowRepository
import com.dexter.movieappcompose.domain.model.tv_show.TvShow
import com.dexter.movieappcompose.domain.model.tv_show.mapToTvShow
import com.dexter.movieappcompose.utils.BaseUseCase
import com.dexter.movieappcompose.utils.common.state.UiState
import com.dexter.movieappcompose.utils.ext.suspendSubscribe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOnAirTvShowUseCase @Inject constructor(
    private val tvShowRepository: TvShowRepository,
) : BaseUseCase<Nothing, UiState<List<TvShow>>>() {
    override fun execute(requestParam: Nothing?): Flow<UiState<List<TvShow>>> =
        flow {
            emit(UiState.Loading)
            tvShowRepository.getOnAirTvShow().collect {
                it.suspendSubscribe(
                    doOnSuccess = { data ->
                        val tvShows = mutableListOf<TvShow>()
                        val listTvShow = data.payload?.results?.map { item ->
                            item.mapToTvShow()
                        }
                        tvShows.addAll(listTvShow.orEmpty())
                        emit(UiState.Success(tvShows))
                    },
                    doOnError = { error ->
                        UiState.Error(error.message.orEmpty())
                    }
                )
            }
        }
}
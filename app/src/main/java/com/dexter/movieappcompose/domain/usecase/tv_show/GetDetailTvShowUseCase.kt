package com.dexter.movieappcompose.domain.usecase.tv_show

import com.dexter.movieappcompose.data.remote.repository.TvShowRepository
import com.dexter.movieappcompose.domain.model.tv_show.DetailTvShow
import com.dexter.movieappcompose.domain.model.tv_show.mapToDetailTvShow
import com.dexter.movieappcompose.utils.BaseUseCase
import com.dexter.movieappcompose.utils.common.state.UiState
import com.dexter.movieappcompose.utils.ext.suspendSubscribe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailTvShowUseCase @Inject constructor(
    private val tvShowRepository: TvShowRepository,
) : BaseUseCase<Int, UiState<DetailTvShow>>() {
    override fun execute(requestParam: Int?): Flow<UiState<DetailTvShow>> =
        flow {
            emit(UiState.Loading)
            val tvShowId = requestParam ?: 0
            tvShowRepository.getDetailTvShow(tvShowId).collect {
                it.suspendSubscribe(
                    doOnSuccess = { data ->
                        val tvShowDetail = data.payload?.mapToDetailTvShow()
                        if (tvShowDetail != null) {
                            emit(UiState.Success(tvShowDetail))
                        } else {
                            emit(UiState.Error("Data Is Empty"))
                        }
                    },
                    doOnError = { error ->
                        emit(UiState.Error(error.message.toString()))
                    }
                )
            }
        }
}
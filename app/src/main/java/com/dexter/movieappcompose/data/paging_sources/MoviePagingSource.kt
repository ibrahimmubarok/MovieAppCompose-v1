package com.dexter.movieappcompose.data.paging_sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dexter.movieappcompose.data.remote.services.MovieApiServices
import com.dexter.movieappcompose.domain.model.Movie
import com.dexter.movieappcompose.domain.model.toMovie
import com.dexter.movieappcompose.utils.network.ApiHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviePagingSource(
    private val api: MovieApiServices,
) : PagingSource<Int, Movie>() {

    companion object {
        private const val PAGINATION_INIT_PAGE = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val currentPage = params.key.takeIf { it != 0 } ?: PAGINATION_INIT_PAGE

        return try {
            val result = withContext(Dispatchers.IO) {
                ApiHandler.handleApi {
                    api.getPopularMovies(
                        page = currentPage
                    )
                }
            }

            val totalPages = result.payload?.totalPages ?: PAGINATION_INIT_PAGE
            val data = result.payload?.results ?: listOf()

            LoadResult.Page(
                data = data.map { it.toMovie() },
                prevKey = null,
                nextKey = if (currentPage < totalPages) currentPage + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
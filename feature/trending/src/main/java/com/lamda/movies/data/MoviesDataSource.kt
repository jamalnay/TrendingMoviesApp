package com.lamda.movies.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lamda.movies.data.model.toMovie
import com.lamda.movies.data.network.service.MoviesService
import com.lamda.movies.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException


internal class MoviesDataSource(
    private val moviesApi: MoviesService
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val page = params.key ?: 1
            val response = moviesApi.getMovies(page = page)
            LoadResult.Page(
                data = response.results.map { it.toMovie() },
                prevKey = null,
                nextKey = if(response.results.isNotEmpty()) response.page + 1 else null
            )
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }
    }

}
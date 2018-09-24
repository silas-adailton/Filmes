package com.oliveira.silas.cad

import com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import com.oliveira.silas.domain.movies.Movie
import com.oliveira.silas.domain.movies.interactor.GetPopularMoviesInteractor
import io.reactivex.Maybe
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner.Silent::class)
class MovieViewModelTest {

    @Mock
    private lateinit var getPopularMoviesInteractor: GetPopularMoviesInteractor
//      val getPopularMoviesInteractor = mock(GetPopularMoviesInteractor::class.java)

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(getPopularMoviesInteractor)
    }

    @Test
    @Throws(Exception::class)
    fun `When fetching the movie list, you must update the result`() {
        val listMovie = mockListMovies()
//        movieViewModel.loadMovies(BuildConfig.API_KEY)

        `when`(getPopularMoviesInteractor.execute(any(GetPopularMoviesInteractor.Request::class.java))).thenReturn(Maybe.just(listMovie))
        movieViewModel.getPopularMoviesInteractor.Request(BuildConfig.API_KEY)

        movieViewModel.loadMovies(BuildConfig.API_KEY)
//        verify(movieViewModel.loadMovies(BuildConfig.API_KEY))

//        assertThat(movieViewModel.result, `is`(notNullValue()))

        assertThat(movieViewModel.result, `is`(listMovie))
    }

    private fun mockListMovies(): List<Movie> {

        return listOf(Movie(true, null, 1, "Teste", "21/09/2018", "tasrddtsa",
                2F, "uydasd", false, 5F, 5))

    }

//    private fun <T> any(type : Class<T>): T {
//        Mockito.any(type)
//        return uninitialized()
//    }
//
//    private fun <T> uninitialized(): T {
//        return null as T
//    }
}
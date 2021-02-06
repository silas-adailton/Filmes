package br.com.oliveira.silas.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.oliveira.silas.movies.domain.interactor.GetPopularMoviesInteractor
import br.com.oliveira.silas.movies.ui.main.movie.MovieViewModel
import com.nhaarman.mockitokotlin2.any
import io.reactivex.Maybe
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@Suppress("IllegalIdentifier")
class MovieViewModelTest {

    @Mock
    lateinit var getPopularMoviesInteractor: GetPopularMoviesInteractor
//    @Mock
//    lateinit var getTopRateMoviesInteractor: GetTopRateMoviesInteractor

    lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(
                getPopularMoviesInteractor,
        )

//        movieViewModel = MovieViewModel(
//                getPopularMoviesInteractor,
//                getTopRateMoviesInteractor,
//                getMorePopularMoviesInteractor,
//                getMoreTopRateMoviesInteractor
//        )
    }

    @Test
    @Throws(Exception::class)
    fun `When fetching the movie list, you must update the result`() {
        val listMovie = MovieMock.getListMovies()

        `when`(getPopularMoviesInteractor.execute(any())).thenReturn(Maybe.just(listMovie))
        movieViewModel.loadMovies(BuildConfig.API_KEY)

        assertThat(movieViewModel.result, `is`(listMovie))
    }

    @Test
    fun `when fetch is unsuccessful, should return an exception`() {
        val exception = Exception()
        `when`(getPopularMoviesInteractor.execute(any())).thenReturn(Maybe.error(exception))
        movieViewModel.loadMovies(BuildConfig.API_KEY)

        assertThat(exception.toString(), `is`(movieViewModel.error.get()))
    }
}
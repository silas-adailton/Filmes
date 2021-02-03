package br.com.oliveira.silas.cad

//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.oliveira.silas.cad.ui.main.movie.MovieViewModel
import br.com.oliveira.silas.movies.domain.Movie
import br.com.oliveira.silas.movies.domain.interactor.GetPopularMoviesInteractor
import br.com.oliveira.silas.movies.ui.main.movie.MovieViewModel
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.nullable
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.runners.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner.Silent::class)
class MovieViewModelTest {

    @Mock
    lateinit var getPopularMoviesInteractor: GetPopularMoviesInteractor
    @Mock
//    lateinit var getTopRateMoviesInteractor: GetTopRateMoviesInteractor
//    @Mock
//    lateinit var getMorePopularMoviesInteractor: GetMorePopularMoviesInteractor
//    @Mock
//    lateinit var getMoreTopRateMoviesInteractor: GetMoreTopRateMoviesInteractor

    lateinit var movieViewModel: MovieViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieViewModel = MovieViewModel(
                getPopularMoviesInteractor,
                getTopRateMoviesInteractor,
                getMorePopularMoviesInteractor,
                getMoreTopRateMoviesInteractor)
    }

    @Test
    @Throws(Exception::class)
    fun `When fetching the movie list, you must update the result`() {
        val listMovie = mockListMovies()

        `when`(getPopularMoviesInteractor.execute(any(GetPopularMoviesInteractor.Request::class.java))).thenReturn(Maybe.just(listMovie))
//        movieViewModel.getPopularMoviesInteractor.Request(BuildConfig.API_KEY)

        movieViewModel.loadPopularMovies(BuildConfig.API_KEY)

        assertThat(movieViewModel.result, `is`(listMovie))
    }

    private fun mockListMovies(): List<Movie> {

        return listOf(Movie(true, null, 1, "Teste", "21/09/2018", "tasrddtsa",
                2F, "uydasd", false, 5F, 5,"hfhfhf"))

    }
}
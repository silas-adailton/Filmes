package br.com.oliveira.silas.domain

import br.com.oliveira.silas.domain.mocks.MovieMock
import br.com.oliveira.silas.domain.util.TestScheduler
import br.com.oliveira.silas.movies.domain.RepositoryMovies
import br.com.oliveira.silas.movies.domain.Schedulers
import br.com.oliveira.silas.movies.domain.interactor.GetPopularMoviesInteractor
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations
import java.lang.Exception

class GetPopularMoviesInteractorTest {
    @Mock
    lateinit var moviesRepository: RepositoryMovies

    lateinit var schedulers: Schedulers
    lateinit var getPopularMoviesInteractor: GetPopularMoviesInteractor

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        schedulers = TestScheduler()
        getPopularMoviesInteractor = GetPopularMoviesInteractor(schedulers, moviesRepository)
    }

    @Test
    fun `Should return a list movies from repository when call is successful`() {
        val list = MovieMock.getListMovies()
        `when`(moviesRepository.getMovies(anyString())).thenReturn(Maybe.just(list))

        val result = getPopularMoviesInteractor
                .execute(getPopularMoviesInteractor.Request(anyString()))
                .test()

        result
                .assertComplete()
                .assertNoErrors()
                .assertValue(list)

        Mockito.verify(moviesRepository).getMovies(anyString())

    }

    @Test
    fun `Should return an exception from repository when call is unsuccessful`() {
        val exception = Exception()
        `when`(moviesRepository.getMovies(anyString())).thenReturn(Maybe.error(exception))

        val result = getPopularMoviesInteractor
                .execute(getPopularMoviesInteractor.Request(anyString()))
                .test()

        result
                .assertNotComplete()
                .assertNoValues()
                .assertError(exception)

        Mockito.verify(moviesRepository).getMovies(anyString())
    }
}
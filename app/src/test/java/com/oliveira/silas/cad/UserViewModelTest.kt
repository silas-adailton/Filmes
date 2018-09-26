package com.oliveira.silas.cad

import com.oliveira.silas.cad.ui.main.user.UserViewModel
import com.oliveira.silas.domain.user.User
import com.oliveira.silas.domain.user.interactor.UserInteractor
import io.reactivex.Maybe
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class UserViewModelTest {


    val userInteractor = mock(UserInteractor::class.java)

    private lateinit var userViewModel : UserViewModel

    @Before
    fun setUp() {
        userViewModel = UserViewModel(userInteractor)
    }

    @Test
    @Throws(Exception::class)
    fun getUserSuccess() {

        val listUser: MutableList<User> = listOf(User(1,"Teste",34,"gdgdfgdfgdgdfg")).toMutableList()

        `when`(userInteractor.execute(ArgumentMatchers.nullable(UserInteractor.Request::class.java))).thenReturn(Maybe.just(listUser))
        
        userViewModel.getUser()

        assertThat(userViewModel.result, `is`(listUser))

    }
}
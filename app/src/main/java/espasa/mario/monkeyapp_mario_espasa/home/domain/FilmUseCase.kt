package espasa.mario.monkeyapp_mario_espasa.home.domain

import espasa.mario.monkeyapp.login.data.LoginRepository
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import espasa.mario.monkeyapp_mario_espasa.home.data.FilmRepository

class FilmUseCase {
    private val repository = FilmRepository()

    suspend operator fun invoke() :List<Film>{
        return repository.doFilms()
    }


}

/*private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String) :Boolean{
        return repository.doLogin(user, password)
    }*/
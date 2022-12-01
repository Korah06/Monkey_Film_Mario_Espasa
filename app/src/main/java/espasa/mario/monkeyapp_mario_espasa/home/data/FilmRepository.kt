package espasa.mario.monkeyapp_mario_espasa.home.data

import espasa.mario.monkeyapp.login.data.network.LoginService
import espasa.mario.monkeyapp_mario_espasa.home.data.network.FilmService

class FilmRepository {
    private val api = FilmService()

    suspend fun doFilms():List<Film>{
        return api.doFilms()
    }
}
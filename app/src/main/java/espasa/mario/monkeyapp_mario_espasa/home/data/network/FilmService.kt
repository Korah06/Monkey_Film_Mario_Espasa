package espasa.mario.monkeyapp_mario_espasa.home.data.network

import espasa.mario.monkeyapp.core.network.RetrofitHelper
import espasa.mario.monkeyapp.login.data.network.LoginClient
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmService {

    private val retrofit = RetrofitHelper.getFilms()

    suspend fun doFilms():List<Film>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(FilmClient::class.java).doFilmList()
            response.body()?.filmList ?: emptyList()
        }
    }

}

/*return withContext(Dispatchers.IO) {
            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.loginOk ?: false
        }*/
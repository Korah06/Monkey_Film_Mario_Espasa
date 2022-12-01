package espasa.mario.monkeyapp_mario_espasa.home.data.network

import espasa.mario.monkeyapp.login.data.network.response.LoginResponse
import espasa.mario.monkeyapp_mario_espasa.home.data.network.response.FilmResponse
import retrofit2.Response
import retrofit2.http.GET

interface FilmClient {

    @GET("/v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9")
    suspend fun doFilmList(): Response<FilmResponse>
}
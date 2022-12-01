package espasa.mario.monkeyapp_mario_espasa.home.data.network.response

import com.google.gson.annotations.SerializedName
import espasa.mario.monkeyapp_mario_espasa.home.data.Film

data class FilmResponse(@SerializedName("success") val filmList: List<Film>)

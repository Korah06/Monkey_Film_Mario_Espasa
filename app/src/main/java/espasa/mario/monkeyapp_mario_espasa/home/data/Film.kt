package espasa.mario.monkeyapp_mario_espasa.home.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Film(
    @Json(name = "category")
    val category: String,
    @Json(name = "catel")
    val catel: Int,
    @Json(name = "description")
    val description: String,
    @Json(name = "genre")
    val genre: List<String>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "score")
    val score: Int,
    @Json(name = "title")
    val title: String,
    var favorite:Boolean = false
)
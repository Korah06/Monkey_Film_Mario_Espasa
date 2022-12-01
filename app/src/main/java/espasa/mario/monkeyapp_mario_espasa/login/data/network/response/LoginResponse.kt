package espasa.mario.monkeyapp.login.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse (@SerializedName("ok") val loginOk: Boolean)

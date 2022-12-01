package espasa.mario.examen_mario_espasa.navigation

import espasa.mario.monkeyapp_mario_espasa.home.data.Film

sealed class AppScreens(val route:String){
    object LoginScreen: AppScreens("login_screen")
    object RegisterScreen: AppScreens("register_screen")
    object HomeScreen : AppScreens("home_screen")
    object FavoriteScreen : AppScreens("favorite_screen")
    object CreateScreen : AppScreens("create_screen")

    object DetailsActivity: AppScreens("detailsActivity/{id}"){
        fun createRoute(id:Int) ="detailsActivity/${id}"
    }


}

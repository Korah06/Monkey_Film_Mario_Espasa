package espasa.mario.examen_mario_espasa.navigation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import espasa.mario.monkeyapp.login.ui.Login
import espasa.mario.monkeyapp.login.ui.LoginViewModel
import espasa.mario.monkeyapp_mario_espasa.create.ui.Create
import espasa.mario.monkeyapp_mario_espasa.detail.ui.Detail
import espasa.mario.monkeyapp_mario_espasa.favorites.ui.Favorite
import espasa.mario.monkeyapp_mario_espasa.home.ui.FilmViewModel
import espasa.mario.monkeyapp_mario_espasa.home.ui.Home
import espasa.mario.monkeyapp_mario_espasa.register.ui.Register
import espasa.mario.t_final_mario_espasa.composables.MyDownMenu
import espasa.mario.t_final_mario_espasa.composables.MyToolBar

@Composable
fun AppNavigation() {
    var filmViewModel = FilmViewModel()
    filmViewModel.devolverLista()
    var loginViewModel = LoginViewModel()

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
        composable(route = AppScreens.LoginScreen.route) {
            Login(navController, filmViewModel, loginViewModel)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            Register(navController)
        }
        composable(route = AppScreens.HomeScreen.route) {
            Home(navController, filmViewModel, loginViewModel)
        }
        composable(route = AppScreens.FavoriteScreen.route) {
            Favorite(navController, filmViewModel, loginViewModel)
        }

        composable(route = AppScreens.CreateScreen.route) {
            Create(navController, filmViewModel)
        }

        composable(
            route = AppScreens.DetailsActivity.route, arguments = listOf(
                navArgument("id") { type = NavType.IntType }

            )
        ) {navBackStackEntry ->
            Detail(
                navController = navController,
                filmViewModel = filmViewModel,
                id = navBackStackEntry.arguments?.getInt("id") ?: 1
            )
        }


    }
}

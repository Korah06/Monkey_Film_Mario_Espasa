package espasa.mario.t_final_mario_espasa.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import espasa.mario.examen_mario_espasa.navigation.AppScreens


@Composable
fun MyDownMenu(navController: NavController) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
        BottomNavigation() {

            BottomNavigationItem(
                selected = false,
                onClick = { navController.navigate(route = AppScreens.HomeScreen.route) },
                icon = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                },
                label = { Text(text = "Home") }
            )
            BottomNavigationItem(
                selected = false,
                onClick = { navController.navigate(route = AppScreens.FavoriteScreen.route) },
                icon = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorites")
                },
                label = { Text(text = "Favorites") }
            )
        }
    }
}
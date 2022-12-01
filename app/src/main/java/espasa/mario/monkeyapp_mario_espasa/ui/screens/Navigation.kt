package espasa.mario.monkeyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import espasa.mario.monkeyapp.model.Routes

@Composable
fun ScreenOne(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(text = "Pantalla 1", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navigationController.navigate(Routes.ScreenTwo.route)})
    }

}

@Composable
fun ScreenTwo(navigationController: NavHostController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ){
        Text(text = "Pantalla 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.ScreenThree.createRoute(88)) })
    }

}

@Composable
fun ScreenThree(navigationController: NavHostController, score: Int?){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ){
        Text(text = "Pantalla 3 = $score", modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate(Routes.ScreenFour.createRoute("Me suicido")) })
    }

}

@Composable
fun ScreenFour(navigationController: NavHostController, title: String?){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ){
        Text(text = "Pantalla 4 + $title", modifier = Modifier.align(Alignment.Center).clickable { navigationController.navigate(Routes.ScreenOne.route) })
    }

}

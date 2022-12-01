package espasa.mario.monkeyapp_mario_espasa

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import espasa.mario.examen_mario_espasa.navigation.AppNavigation
import espasa.mario.monkeyapp.login.data.network.response.LoginResponse
import espasa.mario.monkeyapp.login.ui.LoginViewModel
import espasa.mario.monkeyapp.ui.theme.MonkeyApp_Mario_EspasaTheme
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import espasa.mario.monkeyapp_mario_espasa.home.data.network.response.FilmResponse
import espasa.mario.monkeyapp_mario_espasa.home.domain.FilmUseCase
import espasa.mario.monkeyapp_mario_espasa.home.ui.FilmViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonkeyApp_Mario_EspasaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()

                }
            }
        }
    }
}

/*
@Composable
fun eje(filmViewModel: FilmViewModel){

    Button(onClick = {filmViewModel.devolverLista()}){
    }
}*/
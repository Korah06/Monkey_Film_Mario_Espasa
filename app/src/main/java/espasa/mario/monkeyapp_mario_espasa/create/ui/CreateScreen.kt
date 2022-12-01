package espasa.mario.monkeyapp_mario_espasa.create.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import espasa.mario.monkeyapp.ui.theme.Shapes
import espasa.mario.monkeyapp_mario_espasa.home.ui.FilmViewModel
import espasa.mario.t_final_mario_espasa.composables.MyDownMenu
import espasa.mario.t_final_mario_espasa.composables.MyToolBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Create(
    navController: NavController, filmViewModel: FilmViewModel
) {
    Scaffold(
        topBar = { MyToolBar() },
        bottomBar = { MyDownMenu(navController) }
    ) {
        ContentC(navController, filmViewModel)
    }
}

@Composable
fun ContentC(navController: NavController, filmViewModel: FilmViewModel) {
    val title = rememberSaveable { mutableStateOf("") }
    val generos = rememberSaveable { mutableStateOf("") }
    val descripcion = rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //TITULO
        Text(text = "Escriba el titulo")
        OutlinedTextField(
            value = title.value,
            onValueChange = { title.value = it },
            placeholder = { Text(text = "Titulo") },
            singleLine = true,
            modifier = Modifier.clip(Shapes.small),
        )
        Spacer(modifier = Modifier.height(10.dp))
        //Generos
        Text(text = "Generos")
        OutlinedTextField(
            value = generos.value,
            onValueChange = { generos.value = it },
            placeholder = { Text(text = "Titulo") },
            singleLine = true,
            modifier = Modifier.clip(Shapes.small),
        )
        Spacer(modifier = Modifier.height(10.dp))
        //DESCRIPCION
        Text(text = "Escrive la descripcion")
        OutlinedTextField(
            value = descripcion.value,
            onValueChange = { descripcion.value = it },
            placeholder = { Text(text = "Titulo") },
            modifier = Modifier.clip(Shapes.small),
        )
        //BOTON
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                Toast.makeText(context, "Aun no se encuentra en funcionamiento", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.width(150.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF47978E9),
                disabledBackgroundColor = Color(0xFF78C48F9),
                contentColor = Color.White,
                disabledContentColor = Color.White
            )
        ) {
            Text(text = "Añadir film")
        }

    }

}
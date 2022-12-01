package espasa.mario.monkeyapp_mario_espasa.detail.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import espasa.mario.examen_mario_espasa.navigation.AppScreens
import espasa.mario.monkeyapp.login.ui.LoginViewModel
import espasa.mario.monkeyapp_mario_espasa.R
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import espasa.mario.monkeyapp_mario_espasa.home.ui.ContentH
import espasa.mario.monkeyapp_mario_espasa.home.ui.FilmViewModel
import espasa.mario.t_final_mario_espasa.composables.MyDownMenu
import espasa.mario.t_final_mario_espasa.composables.MyToolBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Detail(
    navController: NavController, filmViewModel: FilmViewModel, id: Int
) {

    Scaffold(
        topBar = { MyToolBar() },
        bottomBar = { MyDownMenu(navController) },
        modifier = Modifier.fillMaxSize()
    ) {
        ContentD(filmViewModel.listaPelis, id, navController)
    }
}

@Composable
fun ContentD(films: LiveData<List<Film>>, id: Int, navController: NavController) {
    for (i in 0 until films.value!!.size) {
        if (films.value!![i].id == id) {
            //IMAGEN
            Column() {
                Row(Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.blinders),
                        contentDescription = "",
                        modifier = Modifier
                            .height(230.dp)
                            .fillMaxWidth()
                    )
                }

                Row(modifier = Modifier.padding(8.dp)) {
                    //DESCRIPCION Y TEXTO
                    Column() {
                        Text(text = films.value!![i].title, color = Color.Gray)
                        Text(
                            text = films.value!![i].description,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.width(400.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(), Arrangement.End
                    ) {

                        Column() {
                            //LIKE ICON
                            IconButton(onClick = {
                                films.value!![i].favorite = !films.value!![i].favorite
                                navController.navigate(route = AppScreens.HomeScreen.route)
                            }) {
                                Icon(
                                    modifier = Modifier.size(25.dp),
                                    imageVector = if (!films.value!![i].favorite) Icons.Filled.Favorite else Icons.Default.Favorite,
                                    contentDescription = "add",
                                    tint = if (!films.value!![i].favorite) Color.Gray else Color.Red
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}
package espasa.mario.monkeyapp_mario_espasa.favorites.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import espasa.mario.examen_mario_espasa.navigation.AppScreens
import espasa.mario.monkeyapp.login.ui.LoginViewModel
import espasa.mario.monkeyapp_mario_espasa.R
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import espasa.mario.monkeyapp_mario_espasa.home.ui.FilmViewModel
import espasa.mario.monkeyapp_mario_espasa.home.ui.MySheet

import espasa.mario.t_final_mario_espasa.composables.MyDownMenu
import espasa.mario.t_final_mario_espasa.composables.MyToolBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Favorite(navController: NavController,filmViewModel: FilmViewModel,loginViewModel: LoginViewModel) {
    Scaffold(
        topBar = { MyToolBar() },
        bottomBar = { MyDownMenu(navController) }
    ) {
        ContentF(navController,filmViewModel,loginViewModel)
    }
}

@Composable
fun ContentF(navController: NavController, filmViewModel: FilmViewModel, loginViewModel: LoginViewModel) {
    //val scrollState = rememberScrollState()

    Column(modifier = Modifier
        //.verticalScroll(scrollState)
        .fillMaxWidth()) {
        MySheetsF(films = filmViewModel.listaPelis, navController)
    }
}





//-------------------------------
// CREACION DE CELDAS
//-------------------------------




@Composable
fun MySheetF(film: Film, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    if (!expanded) {

        Row(modifier = Modifier
            .padding(8.dp)
            .clickable {
                expanded = !expanded
            }) {
            Image(
                painter = painterResource(
                    id = when (film.catel) {
                        1 -> R.drawable.c1
                        2 -> R.drawable.c2
                        3 -> R.drawable.c3
                        4 -> R.drawable.c4
                        5 -> R.drawable.c5
                        6 -> R.drawable.c6
                        7 -> R.drawable.c7
                        8 -> R.drawable.c8
                        9 -> R.drawable.c9
                        10 -> R.drawable.c10
                        else -> R.drawable.peaky
                    }
                ), contentDescription = "", Modifier.size(50.dp)
            )
            Column() {
                Text(text = film.title, color = Color.Gray)
                Text(
                    text = film.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(200.dp)
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), Arrangement.End
            ) {

                Column() {
                    //MAS INFO
                    IconButton(onClick = {
                        navController.navigate(route = AppScreens.DetailsActivity.createRoute(film.id))
                    }) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Browse"
                        )
                    }
                    //LIKE ICON
                    IconButton(onClick = {
                        film.favorite = !film.favorite
                        navController.navigate(route = AppScreens.FavoriteScreen.route)
                    }) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = if (!film.favorite) Icons.Filled.Favorite else Icons.Default.Favorite,
                            contentDescription = "add",
                            tint = if (!film.favorite) Color.Gray else Color.Red
                        )
                    }

                }


            }

        }
    } else {
        Column(modifier = Modifier.clickable {
            expanded = !expanded
        }) {
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.blinders),
                    contentDescription = "",
                    modifier = Modifier
                        .height(230.dp)
                        .fillMaxWidth()
                )
            }

            Row(modifier = Modifier
                .padding(8.dp)
                .clickable {
                    expanded = !expanded
                }) {


                Column() {
                    Text(text = film.title, color = Color.Black)
                    Text(
                        text = film.description,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.width(300.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), Arrangement.End
                ) {

                    Column() {
                        //MAS INFO
                        IconButton(onClick = {
                            navController.navigate(route = AppScreens.DetailsActivity.createRoute(film.id))
                        }) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Browse"
                            )
                        }
                        //LIKE ICON
                        IconButton(onClick = {
                            film.favorite = !film.favorite
                            navController.navigate(route = AppScreens.FavoriteScreen.route)
                        }) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                imageVector = if (!film.favorite) Icons.Filled.Favorite else Icons.Default.Favorite,
                                contentDescription = "add",
                                tint = if (!film.favorite) Color.Gray else Color.Red
                            )
                        }

                    }


                }

            }

        }


    }


    //FINAL FUN

}


@Composable
fun MySheetsF(films: LiveData<List<Film>>, navController: NavController) {
    LazyColumn{
        items(films.value!!.size){ index ->
            if(films.value!![index].favorite)MySheetF(film = films.value!![index], navController = navController)
        }
    }
}
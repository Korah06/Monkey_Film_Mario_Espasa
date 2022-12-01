package espasa.mario.t_final_mario_espasa.composables

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun MyToolBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        title = { Text(text = "MonkeyFilms") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Abrir menu")
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Añadir")
            }
        }

    )

}

@Composable
fun MySimpleToolBar() {
    TopAppBar(
        title = { Text(text = "MonkeyFilms", color = Color.White) },
        backgroundColor = MaterialTheme.colors.surface
        )

}
/*
@Composable
fun MyDialog(){

    var txtFieldError by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }

    Dialog(onDismissRequest = { /*TODO*/ }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Direcciones",
                            style = TextStyle(
                                fontSize = 50.sp,
                                fontFamily = FontFamily.Default
                            )
                        )

                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = {name = it },
                        label = { Text(text = "First Name") }

                    )
                    OutlinedTextField(
                        value = surname,
                        onValueChange = {surname = it },
                        label = { Text(text = "Last name") }

                    )
                    OutlinedTextField(
                        value = location,
                        onValueChange = {location = it },
                        label = { Text(text = "Localizacion") }

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        Button(
                            onClick = {
                                if (name.isEmpty() || surname.isEmpty() || location.isEmpty()) {
                                    txtFieldError = "Field can not be empty"
                                    return@Button
                                }
                            },
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(text = "Send")
                        }
                    }
                }
            }
        }
    }
}
*/
package espasa.mario.monkeyapp_mario_espasa.composables

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import espasa.mario.monkeyapp.ui.theme.Shapes

@Composable
fun ForgotPassword(showDialog: Boolean, dissmissDialog: () -> Unit) {

    val emailValue = rememberSaveable { mutableStateOf("") }



    if (showDialog) {
        Dialog(
            onDismissRequest = { dissmissDialog() },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
        ) {

            Surface(
                shape = RoundedCornerShape(5.dp), color = Color.White
            ) {

                Box(contentAlignment = Alignment.Center) {

                    Column(Modifier.padding(10.dp)) {

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        ) {
                            Text(
                                text = "Introduce el correo para que le enviemos la pagina de cambio de contraseña",
                                color = Color.Gray
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        ) {
                            TextField(value = emailValue.value,
                                onValueChange = { emailValue.value = it },
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.LightGray
                                ),
                                modifier = Modifier.clip(Shapes.small)
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp)
                        ) {
                            Button(onClick = { dissmissDialog() }) {
                                Text(text = "Enviar")
                            }
                        }
                    }
                }
            }
        }
    }


}
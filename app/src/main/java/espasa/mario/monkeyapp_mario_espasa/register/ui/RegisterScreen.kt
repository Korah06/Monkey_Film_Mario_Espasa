package espasa.mario.monkeyapp_mario_espasa.register.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import espasa.mario.monkeyapp.login.ui.Content
import espasa.mario.monkeyapp.ui.theme.Shapes
import espasa.mario.t_final_mario_espasa.composables.MySimpleToolBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Register(navController: NavController) {
    Scaffold(
        topBar = { MySimpleToolBar() },
        content = {
            ContentR(
                navController = navController,
            )
        }
    )
}

@Composable
fun ContentR(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var usuarioValue by remember { mutableStateOf("") }
        var emailValue by remember { mutableStateOf("") }
        var passwordValue by remember { mutableStateOf("") }
        var passwordConfirmValue by remember { mutableStateOf("") }

        val counterMaxLength = 50

        //NOMBRE
        OutlinedTextField(
            value = usuarioValue,
            onValueChange = { usuarioValue = it },
            label = { Text("Usuario") }
        )
        Text(
            text = "${usuarioValue.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(end = 60.dp)
                .align(Alignment.End) //4
        )

        //EMAIL
        OutlinedTextField(
            value = emailValue,
            onValueChange = { emailValue = it },
            label = { Text(text = "Email") }
        )
        Text(
            text = "${emailValue.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(end = 60.dp)
                .align(Alignment.End) //4
        )

        //CONTRASEÑA
        OutlinedTextField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
            label = { Text(text = "Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )
        Text(
            text = "${passwordValue.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(end = 60.dp)
                .align(Alignment.End) //4
        )

        //REPITE CONTRASEÑA
        OutlinedTextField(
            value = passwordConfirmValue,
            onValueChange = { passwordConfirmValue = it },
            label = { Text(text = "Repite la contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )
        Text(
            text = "${passwordConfirmValue.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(end = 60.dp)
                .align(Alignment.End) //4
        )
        Spacer(modifier = Modifier.padding(top = 30.dp))

        var Deportes by rememberSaveable { mutableStateOf(false) }
        var Accion by rememberSaveable { mutableStateOf(false) }
        var sifi by rememberSaveable { mutableStateOf(false) }
        var romance by rememberSaveable { mutableStateOf(false) }
        var historicas by rememberSaveable { mutableStateOf(false) }
        var documentales by rememberSaveable { mutableStateOf(false) }

        val options =
            arrayOf("Deportes", "Accion", "Si-Fi", "Romance", "Historicas", "Documentales")

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.width(60.dp))
            Checkbox(checked = Deportes, onCheckedChange = { Deportes = !Deportes })
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = options[0],
                modifier = Modifier.clickable { Deportes = !Deportes })

            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(checked = Accion, onCheckedChange = { Accion = !Accion })
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = options[1],
                modifier = Modifier.clickable { Accion = !Accion }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.width(60.dp))
            Checkbox(checked = sifi, onCheckedChange = { sifi = !sifi })
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = options[2],
                modifier = Modifier.clickable { sifi = !sifi })

            Spacer(modifier = Modifier.width(42.dp))
            Checkbox(checked = romance, onCheckedChange = { romance = !romance })
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = options[3],
                modifier = Modifier.clickable { romance = !romance })
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Spacer(modifier = Modifier.width(60.dp))
            Checkbox(checked = historicas, onCheckedChange = { historicas = !historicas })
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = options[4],
                modifier = Modifier.clickable { historicas = !historicas })

            Checkbox(checked = documentales, onCheckedChange = { documentales = !documentales })
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = options[5],
                modifier = Modifier.clickable { documentales = !documentales })
        }



        Button(
            onClick = {
                Toast.makeText(context, "Aun no se encuentra en funcionamiento", Toast.LENGTH_SHORT)
                    .show()
            },
            modifier = Modifier.width(120.dp),
            shape = Shapes.small
        ) {
            Text(text = "Registrarse")
        }
    }
}
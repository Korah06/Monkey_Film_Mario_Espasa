package espasa.mario.monkeyapp.login.ui

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import espasa.mario.examen_mario_espasa.navigation.AppScreens
import espasa.mario.monkeyapp.ui.theme.Shapes
import espasa.mario.monkeyapp_mario_espasa.R
import espasa.mario.monkeyapp_mario_espasa.composables.ForgotPassword
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import espasa.mario.monkeyapp_mario_espasa.home.ui.FilmViewModel
import espasa.mario.t_final_mario_espasa.composables.MySimpleToolBar
import espasa.mario.t_final_mario_espasa.models.User
import retrofit2.http.Header


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Login(
    navController: NavController,
    filmViewModel: FilmViewModel,
    loginViewModel: LoginViewModel
) {
    Scaffold(
        topBar = { MySimpleToolBar() },
        content = {
            Content(
                navController = navController,
                filmViewModel = filmViewModel,
                loginViewModel = loginViewModel
            )
        }
    )
}

object usuario : User("a", "Admin@email.com", "a")

val users = arrayListOf<User>(usuario)

@Composable
fun Content(
    navController: NavController,
    filmViewModel: FilmViewModel,
    loginViewModel: LoginViewModel
) {

    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")

    var entry = rememberSaveable { mutableStateOf(false) }
    val showDialog = rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "MONKEYFILM",
                fontSize = 40.sp
            )
        }

        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.size(16.dp))
            Email(email) {
                loginViewModel.onLoginChanged(email = it, password = password)
            }
            Spacer(modifier = Modifier.size(4.dp))
            Password(password) {
                loginViewModel.onLoginChanged(email = email, password = it)
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = {
                    loginViewModel.onButtonLoginPress(navController)
                },
                modifier = Modifier.width(100.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.surface,
                    contentColor = Color.White,
                    disabledContentColor = Color.White
                )
            ) {
                Text(text = "entrar")
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "¿Aún no te has registrado?",
                    modifier = Modifier.clickable { navController.navigate(route = AppScreens.RegisterScreen.route) },
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black
                )


            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "¿Has olvidado la contraseña?",
                    modifier = Modifier.clickable { showDialog.value = true },
                    textDecoration = TextDecoration.Underline,
                    color = Color.Black
                )
            }
        }

    }

    ForgotPassword(showDialog = showDialog.value, dissmissDialog = { showDialog.value = false })
}


@Composable
fun Password(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth().clip(Shapes.small),
        placeholder = { Text(stringResource(id = R.string.password)) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = imagen,
                    contentDescription = stringResource(id = R.string.show_password)
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun Email(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth().clip(Shapes.small),
        placeholder = { Text(text = stringResource(id = R.string.email)) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


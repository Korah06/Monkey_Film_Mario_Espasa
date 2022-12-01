package espasa.mario.monkeyapp.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import espasa.mario.examen_mario_espasa.navigation.AppScreens
import espasa.mario.monkeyapp.login.domain.LoginUseCase
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val loginUseCase = LoginUseCase()

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isButtonLoginEnable = MutableLiveData<Boolean>()
    val isButtonLoginEnable: LiveData<Boolean> = _isButtonLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isButtonLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 5

    fun onButtonLoginPress(navController: NavController,) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if(result){
                Log.i("DAM","Se ha completado el login")
                navController.navigate(route = AppScreens.HomeScreen.route)
            }
            _isLoading.value = false
        }
    }

}
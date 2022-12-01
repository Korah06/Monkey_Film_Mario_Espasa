package espasa.mario.monkeyapp_mario_espasa.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import espasa.mario.monkeyapp_mario_espasa.home.data.Film
import espasa.mario.monkeyapp_mario_espasa.home.domain.FilmUseCase
import kotlinx.coroutines.launch
import kotlin.math.log

class FilmViewModel:ViewModel() {
    /*
    init {
        viewModelScope.launch {
            _listaPelis = MutableLiveData(filmUseCase())
        }
    }*/

    private var _listaPelis = MutableLiveData<List<Film>>()
    var listaPelis : LiveData<List<Film>> = _listaPelis

    val filmUseCase = FilmUseCase()

    fun changeList(){
        listaPelis = _listaPelis
    }

    fun devolverLista(){
        viewModelScope.launch {
            _listaPelis = MutableLiveData(filmUseCase())
            changeList()
        }
    }
}


package espasa.mario.monkeyapp.model

import androidx.annotation.DrawableRes

class MediaModel (
    var id:Int,
    var title :String,
    var description:String,
    @DrawableRes var cartel:Int,
    var score:Int,
    var favorite:Boolean = false,
    var genre:List<String>){
}
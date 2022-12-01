package espasa.mario.monkeyapp.model

sealed class Routes(val route:String){
    object ScreenOne:Routes("ScreenOne")
    object ScreenTwo:Routes("ScreenTwo")
    object ScreenThree:Routes("ScreenThree/{score}"){fun createRoute(score:Int) = "screenThree/$score"}
    object ScreenFour:Routes("ScreenFour?title={title}"){fun createRoute(title:String?) = "screenFour?title=$title"}
}

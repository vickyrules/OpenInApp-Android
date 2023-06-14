package com.mine.openinapp_android.navigation


interface NavigationDestination {
   val title:String
   val route:String
}

object HomeDestination: NavigationDestination {
    override val title = "Dashboard"
    override val route: String = "dashboard"
}
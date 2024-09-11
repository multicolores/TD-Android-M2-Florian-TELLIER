package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.ListScreen
import com.example.myapplication.ui.screen.MainScreen
import com.example.myapplication.ui.screen.YuGiOhScreen

object NavigationPath {
    const val MAIN_SCREEN = "main_screen"
    const val LIST_SCREEN = "list_screen"
    const val YUGIOH_SCREEN = "yugioh_screen"
}

fun NavGraphBuilder.addMainScreenNav(
    onButtonClick: () -> Unit,
    onButton2Click: () -> Unit,
    ) {
    composable(
        route = NavigationPath.MAIN_SCREEN
    ) {
        MainScreen(
            onButtonClick = {
                onButtonClick()
            } ,
            onButtonClick2 = {
                onButton2Click()
            }
        )
    }
}


fun NavGraphBuilder.addListScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.LIST_SCREEN,
    ) {
        ListScreen(navController)
    }
}

fun NavGraphBuilder.addYuGiOhScreenNavigation(navController: NavController) {
    composable(
        route = NavigationPath.YUGIOH_SCREEN,
    ) {
        YuGiOhScreen(navController)
    }
}


@Composable
fun HomeNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = NavigationPath.MAIN_SCREEN,
    ) {
        addMainScreenNav(
            onButtonClick = { navController.navigate(NavigationPath.LIST_SCREEN) },
            onButton2Click = { navController.navigate(NavigationPath.YUGIOH_SCREEN) }
        )
        addListScreenNavigation(navController = navController)
        addYuGiOhScreenNavigation(navController = navController)
    }
}

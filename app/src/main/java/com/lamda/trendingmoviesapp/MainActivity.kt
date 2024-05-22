package com.lamda.trendingmoviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lamda.trendingmoviesapp.navigation.NavigationGraph
import com.lamda.trendingmoviesapp.ui.theme.TrendingMoviesAppTheme


class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrendingMoviesAppTheme {
                navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}

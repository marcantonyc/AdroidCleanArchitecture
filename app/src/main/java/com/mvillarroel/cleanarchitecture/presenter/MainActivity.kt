package com.mvillarroel.cleanarchitecture.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mvillarroel.cleanarchitecture.R
import com.mvillarroel.cleanarchitecture.presenter.coin_list.CoinListScreen
import com.mvillarroel.cleanarchitecture.presenter.coin_detail.CoinDetailScreen
import com.mvillarroel.cleanarchitecture.presenter.ui.theme.CleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureTheme{
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
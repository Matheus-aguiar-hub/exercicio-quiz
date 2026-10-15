package com.example.exerccios_lista5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exerccios_lista5.ui.screens.HomeScreen
import com.example.exerccios_lista5.ui.theme.ExercíciosLista5Theme
import com.example.exerccios_lista5.ui.theme.screens.QuizScreen
import com.example.exerccios_lista5.ui.theme.screens.ResultScreen
import com.example.exerccios_lista5.viewmodel.QuizViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExercíciosLista5Theme {
                val nav = rememberNavController()
                val vm: QuizViewModel =
                    viewModel()   // um único ViewModel compartilhado pelas 3 telas

                NavHost(
                    navController = nav,
                    startDestination = "home",
                    modifier = Modifier.systemBarsPadding()
                ) {
                    composable("home") {
                        HomeScreen(vm) { vm.restart(); nav.navigate("quiz") }
                    }
                    composable("quiz") {
                        QuizScreen(vm) { nav.navigate("result") { popUpTo("home") } }
                    }
                    composable("result") {
                        ResultScreen(vm) {
                            vm.restart()
                            nav.navigate("quiz") { popUpTo("home") }
                        }
                    }
                }
            }
        }
    }
}
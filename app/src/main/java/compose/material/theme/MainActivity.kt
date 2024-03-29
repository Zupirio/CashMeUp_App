package compose.material.theme

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.material.theme.home.CarouselCard
import compose.material.theme.home.CashPayment
import compose.material.theme.home.DashboardScreen
import compose.material.theme.login.LoginPage
import compose.material.theme.login.RegisterPage
import compose.material.theme.login.ResetPage
import compose.material.theme.login.VerifyPage
import compose.material.theme.theme.Material3ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val splashScreen = installSplashScreen()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            Material3ComposeTheme {
//                CashMeUpNavHost()
                LoginApplication()
            }
        }
    }

    @Preview
    @Composable
    fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "splash_page", builder = {
            composable("splash_page", content = { SplashScreen(navController = navController) })
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { RegisterPage(navController = navController) })
            composable("reset_page", content = { ResetPage(navController = navController) })
            composable("verify_page", content = { VerifyPage(navController = navController) })
            composable("dashboard", content = { DashboardScreen(navController = navController) })
            composable("cashpayment_page", content = { CashPayment(navController = navController) })
            composable("image_slider", content = { CarouselCard() })
        })
    }
}
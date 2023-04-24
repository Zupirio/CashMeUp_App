package compose.material.theme


sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")

    object LoginPage : Screen("login_page")

    object RegisterPage : Screen("register_page")

    object VerifyPage : Screen("verify_page")

    object  ResetPage : Screen("reset_page")

    object  DashboardPage : Screen("dashboard_page")

    object  CashPayment : Screen("cashpayment_page")

}

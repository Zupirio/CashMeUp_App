package com.ecashmeup.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecashmeup.app.Destinations.DASHBOARD_ROUTE
import com.ecashmeup.app.Destinations.EPAYMENT_ROUTE
import com.ecashmeup.app.Destinations.OTP_SEND_ROUTE
import com.ecashmeup.app.Destinations.OTP_VERIFY_ROUTE
import com.ecashmeup.app.Destinations.RESET_PASSWORD_ROUTE
import com.ecashmeup.app.Destinations.SIGN_IN_ROUTE
import com.ecashmeup.app.Destinations.SIGN_UP_ROUTE
import com.ecashmeup.app.Destinations.SPLASH_ROUTE
import com.ecashmeup.app.Destinations.SURVEY_RESULTS_ROUTE
import com.ecashmeup.app.epayment.EPaymentRoute
import com.ecashmeup.app.home.DashboardRoute
import com.ecashmeup.app.signinsignup.SignInRoute
import com.ecashmeup.app.signinsignup.otpsend.OTPSendRoute
import com.ecashmeup.app.signinsignup.otpverify.OTPVerifyRoute
import com.ecashmeup.app.signinsignup.resetpassword.ResetPasswordRoute
import compose.material.theme.signinsignup.SignUpRoute
import com.ecashmeup.app.survey.SurveyResultScreen


object Destinations {
    const val SPLASH_ROUTE = "splash_page"
    const val SIGN_IN_ROUTE = "login_page"
    const val SIGN_UP_ROUTE = "register_page"
    const val RESET_PASSWORD_ROUTE = "reset_page"
    const val OTP_SEND_ROUTE = "otp_send_page"
    const val OTP_VERIFY_ROUTE = "otp_verify_page"
    const val DASHBOARD_ROUTE = "dashboard_page"
    const val EPAYMENT_ROUTE = "epayment_page"
    const val SURVEY_RESULTS_ROUTE = "surveyresults"
}
@Composable
fun CashMeUpNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE,
    ) {
        composable(SIGN_IN_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            SignInRoute(
                email = startingEmail,
                onSignInSubmitted = {
                    navController.navigate(DASHBOARD_ROUTE)
                },
                navController
            )
        }

        composable(SIGN_UP_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            SignUpRoute(
                email = startingEmail,
                onSignUpSubmitted = {
                    navController.navigate(DASHBOARD_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(RESET_PASSWORD_ROUTE) {
            ResetPasswordRoute(
                onResetSubmitted = {
                    navController.navigate(OTP_SEND_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(OTP_SEND_ROUTE) {
            OTPSendRoute(
                onResetSubmitted = {
                    navController.navigate(OTP_VERIFY_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(OTP_VERIFY_ROUTE) {
            OTPVerifyRoute(
                onResetSubmitted = {
                    navController.navigate(DASHBOARD_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(EPAYMENT_ROUTE) {
            EPaymentRoute(
                onNavUp = navController::navigateUp,
            )
        }

        composable(DASHBOARD_ROUTE) {
            DashboardRoute(
                rememberNavController(),
                onClick = {
                    navController.navigate(EPAYMENT_ROUTE)
                }
            )
        }

        composable(SPLASH_ROUTE) {
            SplashScreen(
                navController
            )
        }


        composable(SURVEY_RESULTS_ROUTE) {
            SurveyResultScreen {
                navController.popBackStack(SIGN_IN_ROUTE, false)
            }
        }
    }
}

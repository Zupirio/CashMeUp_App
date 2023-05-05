/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package compose.material.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.material.theme.signinsignup.SignUpScreen
import compose.material.theme.signinsignup.SignUpViewModel
import compose.material.theme.signinsignup.SignUpViewModelFactory
import compose.material.theme.Destinations.SIGN_IN_ROUTE
import compose.material.theme.Destinations.SIGN_UP_ROUTE
import compose.material.theme.Destinations.SURVEY_RESULTS_ROUTE
import compose.material.theme.Destinations.SURVEY_ROUTE
import compose.material.theme.Destinations.WELCOME_ROUTE
import compose.material.theme.signinsignup.SignInRoute
import compose.material.theme.signinsignup.SignInScreen
import compose.material.theme.signinsignup.SignInViewModel
import compose.material.theme.signinsignup.SignInViewModelFactory
import compose.material.theme.signinsignup.SignUpRoute
import compose.material.theme.signinsignup.WelcomeRoute
import compose.material.theme.signinsignup.WelcomeScreen
import compose.material.theme.signinsignup.WelcomeViewModel
import compose.material.theme.signinsignup.WelcomeViewModelFactory
import compose.material.theme.survey.SurveyResultScreen
import compose.material.theme.survey.SurveyRoute

object Destinations {
    const val WELCOME_ROUTE = "login_page"
    const val SIGN_UP_ROUTE = "register_page"
    const val SIGN_IN_ROUTE = "verify_page"
    const val SURVEY_ROUTE = "survey"
    const val SURVEY_RESULTS_ROUTE = "surveyresults"
}

@Composable
fun CashMeUpNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = SIGN_UP_ROUTE,
    ) {
        composable(WELCOME_ROUTE) {
            WelcomeRoute(
                onNavigateToSignIn = {
                    navController.navigate("verify_page")
                },
                onNavigateToSignUp = {
                    navController.navigate("register_page")
                },
                onSignInAsGuest = {
                    navController.navigate(SURVEY_ROUTE)
                },
            )
        }

        composable(SIGN_IN_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            SignInRoute(
                email = startingEmail,
                onSignInSubmitted = {
                    navController.navigate(SURVEY_ROUTE)
                },
                onSignInAsGuest = {
                    navController.navigate(SURVEY_ROUTE)
                }
            )
        }

        composable(SIGN_UP_ROUTE) {
            val startingEmail = it.arguments?.getString("email")
            SignUpRoute(
                email = startingEmail,
                onSignUpSubmitted = {
                    navController.navigate(SURVEY_ROUTE)
                },
                onSignInAsGuest = {
                    navController.navigate(SURVEY_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(SURVEY_ROUTE) {
            SurveyRoute(
                onSurveyComplete = {
                    navController.navigate(SURVEY_RESULTS_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }

        composable(SURVEY_RESULTS_ROUTE) {
            SurveyResultScreen {
                navController.popBackStack(WELCOME_ROUTE, false)
            }
        }
    }
}

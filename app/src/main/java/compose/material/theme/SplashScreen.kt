package compose.material.theme

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.core:
import androidx.navigation.NavController
import kotlinx.coroutines.delay

//https://dimovski-d.medium.com/splash-screen-with-jetpack-compose-side-effects-in-compose-how-to-use-them-2a90eb6e1d34

@Preview
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

        delay(2000L)

//        navController.navigate(Screen.LoginPage.route) {
//            popUpTo(Screen.LoginPage.route) { inclusive = true }
//        }
        navController.navigate("reset_page"){
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        }

    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ecashmeup),
            contentDescription = "Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.padding(top = 50.dp)
        ) {
//            Text(
//                text = "www.ecashmeup.com",
//                style = TextStyle(
//                    fontWeight = FontWeight.Black,
//                    fontFamily = FontFamily(Font(R.font.jost_book)),
//                    fontSize = 27.sp,
//                    color = Color.Black
//                ),
//            )

            Text(
                text = "Anytime Anywhere",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.jost_book)),
                    fontSize = 14.sp,
                    color = Color.Black
                ),
            )

        }
    }
}
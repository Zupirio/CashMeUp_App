package compose.material.theme.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import compose.material.theme.R
import compose.material.theme.util.NiaOutlinedButton

@Composable
fun ResetPage(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
    ) {


        Box(
            modifier = Modifier
                .padding(top = 100.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.paper_plane),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),

                )
            Column(
                modifier = Modifier.padding(16.dp)
                .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                ,

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //.........................Spacer
                Spacer(modifier = Modifier.height(40.dp))

                //.........................Text: title
                androidx.compose.material3.Text(
                    text = "Verification",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 130.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.height(8.dp))

                //.........................Text: title
                androidx.compose.material3.Text(
                    text = "We will send you a One Time Password on your phone number",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
//                        .padding(top = 130.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.height(8.dp))


                ResetEmailID()
                Spacer(modifier = Modifier.padding(3.dp))

                val gradientColor = listOf(Color(0xFFFF8C00), Color(0xFFFF8C00))
                val cornerRadius = 16.dp


                Spacer(modifier = Modifier.padding(10.dp))
               /* Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Login", fontSize = 20.sp)
                }*/
                androidx.compose.material3.TextButton(onClick = {

                    navController.navigate("verify_page"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }

                }) {
                    GradientButtonReset(
                        gradientColors = gradientColor,
                        cornerRadius = cornerRadius,
                        nameButton = "Verify",
                        navController
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))

                NiaOutlinedButton(onClick = {}) {
                    androidx.compose.material3.Text(text = "Cancel")
                }

                Spacer(modifier = Modifier.padding(100.dp))
//                androidx.compose.material3.TextButton(onClick = {
//
//                    navController.navigate("register_page"){
//                        popUpTo(navController.graph.startDestinationId)
//                        launchSingleTop = true
//                    }
//
//                }) {
//                    androidx.compose.material3.Text(
//                        text = "Sign Up?",
//                        letterSpacing = 1.sp,
//                        style = MaterialTheme.typography.labelLarge
//                    )
//                }

                Spacer(modifier = Modifier.padding(5.dp))


            }


        }

    }


}


//...........................................................................
@Composable
private fun GradientButtonReset(
    gradientColors: List<Color>,
    cornerRadius: Dp,
    nameButton: String,
    navController: NavController
) {

    androidx.compose.material3.Button(
        modifier = Modifier
            .fillMaxWidth().absolutePadding(10.dp, 0.dp, 10.dp, 0.dp),
        onClick = {
            navController.navigate("verify_page"){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },

        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),
//                    shape = roundedCornerShape
                )
//                .clip(roundedCornerShape)
                /*.background(
                    brush = Brush.linearGradient(colors = gradientColors),
                    shape = RoundedCornerShape(cornerRadius)
                )*/
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}



//email id
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ResetEmailID() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = {
            Text("ID/Passport",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelMedium,
            ) },
        placeholder = { Text(text = "ID/Passport") },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onBackground,
            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )

    )
}

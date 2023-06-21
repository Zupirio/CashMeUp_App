package compose.material.theme.home

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.*
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecashmeup.app.Destinations.OTP_VERIFY_ROUTE
import com.ecashmeup.app.R
import com.ecashmeup.app.ui.theme.md_theme_light_onPrimary

//import compose.material.theme.ui.theme.AuthenticationAppTheme


@Preview
@Composable
fun preview2() {
    IconGrid()
}


@Composable
fun IconGrid(
//     navController: NavController,
) {
    val navController = rememberNavController()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
                .padding(20.dp),
        ) {
            val context = LocalContext.current
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    IconSection(
                        onClick = {
                            navController.navigate(OTP_VERIFY_ROUTE)
                        },
                        image = painterResource(id = R.drawable.ic_esignatures),
                        text = "Cash Payment"
                    )
                    IconSection(
                        onClick = {
                            Toast.makeText(
                                context,
                                "This feature is not yet implemented in this configuration",
                                Toast.LENGTH_LONG
                            ).show()
                        },
                        image = painterResource(id = R.drawable.ic_debicheck),
                        text = "DebiCheck"
                    )
                }
                Row(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    IconSection(
                        onClick = {
                            Toast.makeText(
                                context,
                                "This feature is not yet implemented in this configuration",
                                Toast.LENGTH_LONG
                            ).show()
                        },
                        image = painterResource(id = R.drawable.ic_naedo),
                        text = "NAEDO"
                    )
                    IconSection(
                        onClick = {
                            Toast.makeText(
                                context,
                                "This feature is not yet implemented in this configuration",
                                Toast.LENGTH_LONG
                            ).show()
                        },
                        image = painterResource(id = R.drawable.ic_efticon),
                        text = "EFT Debit Order"
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DevicesGridView(navController : NavController) {
//    val navController = rememberNavController()
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            IconSection(
                onClick = {
                        navController.navigate(OTP_VERIFY_ROUTE)
                },
                image = painterResource(id = R.drawable.ic_esignatures),
                text = "Cash Payment"
            )
            IconSection(
                onClick = {
                            Toast.makeText(
                                context,
                                "This feature is not yet implemented in this configuration",
                                Toast.LENGTH_LONG
                            ).show()
                          },
                image = painterResource(id = R.drawable.ic_debicheck),
                text = "DebiCheck"
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            IconSection(
                onClick = {
                    Toast.makeText(
                        context,
                        "This feature is not yet implemented in this configuration",
                        Toast.LENGTH_LONG
                    ).show()
                },
                image = painterResource(id = R.drawable.ic_naedo),
                text = "NAEDO"
            )
            IconSection(
                onClick = {
                    Toast.makeText(
                        context,
                        "This feature is not yet implemented in this configuration",
                        Toast.LENGTH_LONG
                    ).show()
                },
                image = painterResource(id = R.drawable.ic_efticon),
                text = "EFT Debit Order"
            )
        }
    }
}


//==================================================================================================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconSection(
    onClick: () -> Unit,
    image: Painter,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(10.dp)
            .width(150.dp)
    ) {
        Image(
            painter = image,
            contentDescription = "icon",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = text,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            style = TextStyle(fontSize = 16.sp, fontWeight = W500, color = md_theme_light_onPrimary))
    }
}



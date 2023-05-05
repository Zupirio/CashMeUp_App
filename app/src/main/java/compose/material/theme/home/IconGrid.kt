package compose.material.theme.home

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.*
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import compose.material.theme.R
import compose.material.theme.Screen
import compose.material.theme.model.DataItem
import compose.material.theme.theme.md_theme_dark_onPrimary
import compose.material.theme.theme.md_theme_light_onPrimary

//import compose.material.theme.ui.theme.AuthenticationAppTheme


@Preview
@Composable
fun preview2() {
    IconGrid(rememberNavController())
}


@Composable
fun IconGrid(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
                .padding(20.dp),
        ) {
            DevicesGridView(navController)
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
                    navController.navigate("cashpayment_page"){
                        popUpTo("home")
                        launchSingleTop = true
                    }
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

////////////////////////////////////////////////////////////////////////////////////////////////////

@ExperimentalFoundationApi
@Composable
fun DevicesSection(
    item: List<DataItem>,
) {
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 26.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(item.size) {
            Card(
                modifier = Modifier
                    .padding(end = 20.dp, bottom = 20.dp)
                    .width(135.dp)
                    .height(153.dp)
                    .clip(RoundedCornerShape(16.dp))
//                    .height(80.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.padlock),
                        contentDescription = "icon1",
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(text = item[it].text, style = TextStyle(fontSize = 12.sp))
                    Text(text = item[it].textInfo, style = TextStyle(fontSize = 9.sp))
                    Image(
                        painter = item[it].IconCase,
                        contentDescription = "icon3"
                    )


                }

            }
        }
    }
}


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



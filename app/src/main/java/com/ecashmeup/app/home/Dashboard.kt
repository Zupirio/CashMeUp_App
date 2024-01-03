package com.ecashmeup.app.home


import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ecashmeup.app.R
import com.ecashmeup.app.ui.theme.md_theme_light_onPrimary
import com.ecashmeup.app.util.NewBar

@Preview
@Composable
fun Preview() {
    DashboardScreen(rememberNavController(), onClick = {})
}


@Composable
fun DashboardScreen(navController: NavController, onClick: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
        ) {
            item {

                NewBar(text = "eCashMeUp")
//                CarouselSection()
                SearchBar()
                DevicesGridView(onClick)
            }


        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Preview
@Composable
fun CarouselSection(
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround,

        ) {
        item {
            ImagesCard(
                image = painterResource(id = R.drawable.im_public_private_banner)
            )
            Spacer(modifier = Modifier.width(15.dp))
            ImagesCard(
                image = painterResource(id = R.drawable.im_posmachinebanner)
            )
            Spacer(modifier = Modifier.width(15.dp))
            ImagesCard(
                image = painterResource(id = R.drawable.im_debicheckvp1)
            )
            Spacer(modifier = Modifier.width(15.dp))
            ImagesCard(
                image = painterResource(id = R.drawable.im_goalbanner)
            )
            Spacer(modifier = Modifier.width(15.dp))
            ImagesCard(
                image = painterResource(id = R.drawable.im_insuranceonboarding)
            )
            Spacer(modifier = Modifier.width(15.dp))
            ImagesCard(
                image = painterResource(id = R.drawable.im_loanbanner2)
            )
        }


    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun ImagesCard(
    image: Painter
) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(16.dp)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = "icon1",
                modifier = Modifier.align(Alignment.End)
            )
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DevicesGridView(onClick: () -> Unit) {
    val navController = rememberNavController()
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            IconSection(
                onClick = onClick,
                image = painterResource(id = R.drawable.ic_esignatures),
                text = "Cash Payment"
            )
            IconSection(
                onClick = {navController.navigate("navigate")},
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
                        "Coming Soon",
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
                        "Coming Soon",
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
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W500, color = md_theme_light_onPrimary))
    }
}


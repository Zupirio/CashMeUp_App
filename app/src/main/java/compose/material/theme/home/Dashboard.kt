package compose.material.theme.home


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import compose.material.theme.util.NewBar
import compose.material.theme.R
import compose.material.theme.util.HomeTopAppBar

@Preview
@Composable
fun Preview() {
    DashboardScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
//                .padding(20.dp),
        ) {
            item {
//                TopAppBar()

                NewBar(text = "eCashMeUp")
//                HomeTopAppBar(
//                    topAppBarState = rememberTopAppBarState()
//                )
//                WelcomeBox()
//                CarouselCard()
                CarouselSection()
                SearchBar()
                IconGrid(navController)
//                RunningAppliances()
//                ModeCard()
//                BillCard()
            }


        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun WelcomeBox(
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .background(MaterialTheme.colorScheme.onPrimary)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Welcome to CashMeUp!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.weight(8f)
            )
//            Column {
//                Text(
//                    text = "06:30", style = MaterialTheme.typography.headlineMedium,
//                    color = MaterialTheme.colorScheme.primary,
//                )
//                Text(
//                    text = "PM", style = TextStyle(fontSize = 9.sp),
//                )
//            }
        }
//        Text(text = "Ramky Rajendran", style = MaterialTheme.typography.bodyLarge)
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun ModeCard(
) {
    Card(
        modifier = Modifier
            .padding(top = 26.dp)
            .width(315.dp)
            .height(216.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Evening Mode ON", style = MaterialTheme.typography.bodyLarge)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "6", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Garden lights", style = TextStyle(fontSize = 12.sp))
                    Text(text = "03:30:33", style = TextStyle(fontSize = 9.sp), color = MaterialTheme.colorScheme.onBackground)

                }
                Column {
                    Text(text = "4", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "cordial light", style = TextStyle(fontSize = 12.sp))
                    Text(text = "03:30:33", style = TextStyle(fontSize = 9.sp), color = MaterialTheme.colorScheme.onBackground)

                }
                Column {
                    Text(text = "2", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Hall Lights", style = TextStyle(fontSize = 12.sp))
                    Text(text = "02:30:33", style = TextStyle(fontSize = 9.sp), color = MaterialTheme.colorScheme.onBackground)
                }

            }
            Text(
                text = "All lights will switch of automatically as per the timer which is there in the setting.",
                style = TextStyle(fontSize = 10.sp)
            )
        }

    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun RunningAppliances(
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 26.dp)

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Running Appliances",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.weight(8f)
            )
            Text(
                text = "See All", style = MaterialTheme.typography.bodySmall,
                color = Color.Blue,
            )

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

//    Card(
//        modifier = Modifier
//    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
//                .width(200.dp)
//                .height(250.dp)
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
//}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun BillCard(
) {
    Card(
        modifier = Modifier
            .padding(top = 26.dp)
            .width(315.dp)
            .height(186.dp)
            .clip(RoundedCornerShape(16.dp)),
    ) {

        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(26.dp)) {
            Box {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Box {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.padlock),
                                contentDescription = "icon3"
                            )

                            Column {
                                Text(
                                    text = "January 19 Bill",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Row {
                                    Text(text = "Due Date", style = TextStyle(fontSize = 11.sp))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "6 Days",
                                        style = TextStyle(fontSize = 12.sp),
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }


                            }
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "467", style = MaterialTheme.typography.headlineMedium)
                        Text(text = "Units", style = TextStyle(fontSize = 10.sp))
                    }


                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Box {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.padlock),
                            contentDescription = "icon3",
                        )
                        Spacer(modifier = Modifier.width(5.dp))


                        Text(text = "Dill Amount", style = TextStyle(fontSize = 11.sp))


                    }
                }
                Text(text = "₹ 4,654.27", style = TextStyle(fontSize = 11.sp))


            }


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,


                ) {
                Text(text = "View Breakdown", style = TextStyle(fontSize = 12.sp), color = Color.Blue)
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .width(111.dp)
                        .height(40.dp)
                        .clip(
                            RoundedCornerShape(6.dp)
                        )
                        .background(color = Color.Blue)
                ) {
                    Text(text = "Pay Bill", style = TextStyle(fontSize = 12.sp), color = Color.White)
                }
            }


        }


    }


}
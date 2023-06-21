package com.ecashmeup.app.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ecashmeup.app.util.TopAppBar
import compose.material.theme.util.BottomNav


@Preview
@Composable
fun Preview2() {
    CashPayment()
}
@Composable
fun CashPayment() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
//                .padding(20.dp),
        ) {
            item {
                TopAppBar(text = "eCashMeUp",  rememberNavController())

                Spacer(modifier = Modifier.padding(50.dp))

                FormTwoPage()
                BottomNav()
            }
        }
    }
}


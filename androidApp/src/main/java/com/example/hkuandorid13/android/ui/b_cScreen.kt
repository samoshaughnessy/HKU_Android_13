package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun B_cScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier,
    viewModel: HKUViewModel,
    navController: NavController
){
    Column(
        modifier = Modifier
            .padding(25.dp)
            .background(color = md_theme_dark_background.copy(alpha = 0.4f))
            .shadow(2.dp, shape = RectangleShape)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {

        Text(
            "進入中途宿舍需要哪些條件？\n",
            lineHeight = 50.sp, fontSize =35.sp, fontWeight = FontWeight.Bold,textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)            )


        OrderedList(listItems = orderedPoints)
        BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.B_b )
        NextButton(nextButton = onNextButtonClicked)
        HKULogo()
    }
}

val orderedPoints = listOf("15歲或以上的復元人士", "精神狀況穩定，沒有傳染病、酗酒或濫用藥物", "具有基本自我照顧能力，並與其他人和睦相處", "同意參與個人復原計畫")


@Composable
fun OrderedList(listItems: List<String>){
    listItems.forEachIndexed { index, information ->
        Row {
            val realIndex = index + 1
            Text( text = "  $realIndex. ", fontSize = 20.sp)
            Text( text = "$information \n", fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun B_cScreenPreview() {
    HKUTheme {
        B_cScreen(
            modifier = Modifier.fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
        )
    }
}
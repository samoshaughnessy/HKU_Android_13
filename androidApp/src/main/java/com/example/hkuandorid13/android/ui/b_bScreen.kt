package com.example.hku_a_ios_001.android.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
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
fun B_bScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier,
    viewModel: HKUViewModel,
    navController: NavController
){
    val requiredContext = LocalContext.current
    Column(
            modifier = Modifier
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {

            Text(
                "香港中途宿舍位置",
                lineHeight = 50.sp, fontSize =35.sp, fontWeight = FontWeight.Bold,textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally))


            Text(
                "\n點擊下面的鏈接查看香港所有中途宿舍的完整列表。該列表包括地址和重要的聯絡信息。\n",
                lineHeight = 30.sp, fontSize =20.sp, textAlign = TextAlign.Start)

        HyperlinkText(
            fullText = "點擊這裡"
            ,
            hyperLinks = mutableMapOf(
                "點擊這裡" to "https://www.swd.gov.hk/storage/asset/section/675/tc/HWH_Aug_2022.pdf",
            ),
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                color = Color.Blue,
                fontWeight = FontWeight.ExtraBold,
            ),
            linkTextFontWeight = FontWeight.Bold,
            linkTextColor = Color.Blue,
            fontSize = 20.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )


        BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.B_a )
            NextButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}


@Preview
@Composable
fun B_bScreenPreview() {
    HKUTheme {
        B_bScreen(
            modifier = Modifier.fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
        )
    }
}
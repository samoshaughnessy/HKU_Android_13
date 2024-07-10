package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun F_bScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier,
    viewModel: HKUViewModel,
    navController: NavController
){

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(20.dp)
        ) {

            Text(
                "醫生沒有正\n" +
                        "當理由卻拒絕\n" +
                        "調整相關限制...",
                lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Text(
                "\n如果醫生沒有正當理由卻拒絕調整您的相關限制，您可以聯絡所在醫院的病人聯絡主任辦公室。爲了保證您的訴求得到合適的處理，您可以考慮書面記錄過程。 我要怎麼做才能使條件放寬？\n" +
                "\n" +
                        "您的記錄最後可以以表格形式呈現，盡可能詳細地記錄您在何時、何地向誰提出過怎樣的訴求，獲得了怎樣的回覆。一份合理且詳細的書面記錄可以幫助您 跟進相關事項的進度，同 時在您\n" +
                        "需要維護自身權 利時作爲證據支持"
            )
            Image(
                painter = painterResource(com.example.hkuandorid13.android.R.drawable.doctor),
                contentDescription = "background_image", modifier = Modifier.scale(0.7f))
            BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.F_a )
            HomeButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}

@Preview
@Composable
fun F_bScreenPreview() {
    HKUTheme {
        F_bScreen(
            modifier = Modifier.fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
        )
    }
}



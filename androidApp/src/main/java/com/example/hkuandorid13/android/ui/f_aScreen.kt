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
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun F_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier
){

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(10.dp)
        ) {

            Text(
                "可以向精神科醫生\n" +
                        "提出的問題",
                lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )


            Text(
                "\n為什麼我必須被施加有條件釋放令？\n \n" +
                "我要怎麼做才能使條件放寬？\n \n" +
                "藥物令我感到不適，你能調整我的藥物嗎？ \n \n " +
                "我的心理健康狀況診斷結果是什麼？ \n \n " +
                "距離我上次診斷已經很久了，我  \n" + "覺得自己好轉了，  你可以再次診  斷我嗎 \n", fontSize = 20.sp
            )
            Image(
                painter = painterResource(com.example.hkuandorid13.android.R.drawable.doctor),
                contentDescription = "background_image", modifier = Modifier.scale(0.7f))

            NextButton(nextButton = onNextButtonClicked)

            HKULogo()
        }
}

@Preview
@Composable
fun F_aScreenPreview() {
    HKUTheme {
        F_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}



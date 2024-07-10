package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun E_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier
){
        Column(
            modifier = Modifier
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {

            Text(
                "提出覆核申請需要\n" +
                        "提交哪些資料？",
                lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )


            Text(
                "\n根據《精神健康覆核審裁處規則》第136C章，第II部第3條規定：\n \n" + "1.申請必須以書面提出 \n", fontSize = 20.sp
            )

            Text( buildAnnotatedString {
                append("2.申請書須由服務對象")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append("或")
                }
                append("由任何獲得服務對象授權代其提出申請的人簽署。")
            }, fontSize = 20.sp
            )
            NextButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}

@Preview
@Composable
fun E_aScreenPreview() {
    HKUTheme {
        E_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}



package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun D_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier
){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
            Text(
                "如果有條件\n" +
                        "釋放令不合理 \n",
                lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            Text("\n點擊下面的連結以下載精神健康覆核審裁處申請表格。請確保根據處理您有條件釋放的醫院聯網選擇正確的申請表格。（例如：如果是九龍西聯網處理您的案件，請選擇九龍西聯網（中）精神健康覆核審裁處申請表格以繼續您的申請。）\n", fontSize = 20.sp)
            HyperlinkText(
                fullText = "[點擊這裡]"
                ,
                hyperLinks = mutableMapOf(
                    "[點擊這裡]" to "https://drive.google.com/drive/folders/112hh4dKkwt3d8RsNfBCiQAC0YjMff-Cm?usp=drive_link",
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                ),
                linkTextFontWeight = FontWeight.Bold,
                linkTextColor = Color.Blue,
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Text(
                "\n向精神健康覆核審裁處申請覆核您的有條件釋放令\n", fontWeight = FontWeight.Bold, fontSize = 20.sp
            )
            Text(
                "-您每年只能對您的有條件釋放令提出覆核申請一次 \n \n" +
                "-您必須親自向精神健康覆核審裁處提出覆核申請，因為醫務人員不會將處於有條件釋放令下的服務對象轉介至精神健康覆核審裁處； \n \n" +
                "-即使院長認為不需要再對服務對象進行隔離治療，院長也沒有辦法直接釋放服務對象；\n \n" +
                "-解除或取消：只有精神健康覆核審裁處有權力；醫務人員和院長沒有權力直接解除或者取消有條件釋放令，但是實踐中醫生可以解除您需要遵守的全部條件，從而達到同樣效果" , fontSize = 20.sp
            )

            NextButton(nextButton = onNextButtonClicked)

            HKULogo()
            }
}

@Preview
@Composable
fun D_aScreenPreview() {
    HKUTheme {
        D_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}

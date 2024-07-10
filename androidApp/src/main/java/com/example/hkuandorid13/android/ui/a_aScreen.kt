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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun A_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier

){
        Column(
            modifier = Modifier.padding(25.dp).background(color = md_theme_dark_background.copy(alpha = 0.4f)).shadow(2.dp, shape = RectangleShape).padding(10.dp),
                    verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                    "什麼是有條\n" +
                            "件釋放？",
                lineHeight = 50.sp, fontSize = 40.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                "相比於無條件釋放，有條件釋放令要求您出院後遵守一些特定的條件，如果您未遵守這些條件，而院長認為基於您的健康或安全，或為保護他人著想而有需要有可能將您重新召回精神病院。\n" +
                        "\n", fontSize = 20.sp
            )
            Text("相關條例", fontSize = 20.sp)
            Text(
                " 《精神健康條例》（第136章）\n" +
                        "第42B條", fontWeight = FontWeight.Bold, fontSize = 20.sp
            ) // Bold
            Text(
                "若病人獲准出院或將對社會構成風險，院長可發出有條件釋放令並施加條件，以限制相關病人出院後的自由。在該法例下，有條件釋放需符合兩個條件:" +
                        "\n \n" +
                        "1）院長覺得該名病人有刑事暴力的病例，或有使用刑事暴力的傾向；但" +
                        "\n \n" +
                        "2）院長認為，在釋放令所指明條件的規限下，可安全地將該病人釋放。" +
                        "\n \n" +
                        "若獲有條件釋放的病人沒有遵守基於第42B條第3款所規限的任何條件，該名病人或將被重新召回醫院。", fontSize = 20.sp
            )
            NextButton(nextButton = onNextButtonClicked)
        HKULogo()
        }
}



@Preview
@Composable
fun A_aScreenPreview() {
    HKUTheme {
        A_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}
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
import androidx.navigation.NavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun C_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier,
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
                "您會被召回醫院嗎？",
                lineHeight = 50.sp, fontSize = 40.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                "\n您仍有可能被召回醫院，如果院長認為您: \n", fontWeight = FontWeight.Bold, fontSize = 20.sp
            )

            Text("  -未能遵守施加的條件\n\n" +
                "  -為了您的健康或安全，或者為了保護他人，有需要將您召回醫院\n", fontSize = 20.sp
            )

            Text(
                "如果院長決定召回您，您會： \n", fontWeight = FontWeight.Bold, fontSize = 20.sp
            )

            Text("  -收到正式的書面通知\n\n" +
                    "   -在通知中規定的時間內需要自行回到醫院\n\n" + "-如果您在被召回後未有返回醫院，您可能會被扣押並被強制送回醫院" , fontSize = 20.sp
            )

            NextButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}


@Preview
@Composable
fun C_aScreenPreview() {
    HKUTheme {
        C_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}

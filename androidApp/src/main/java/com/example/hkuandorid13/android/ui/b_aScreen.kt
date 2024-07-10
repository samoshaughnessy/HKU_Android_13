package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun B_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier
){

    val context = LocalContext.current

    val displayMetrics = context.resources.displayMetrics

    //Width And Height Of Screen
    val width = displayMetrics.widthPixels
    val height = displayMetrics.heightPixels

    //Device Density
    val density = displayMetrics.density

    Column(
        modifier = Modifier
            .padding(25.dp)
            .background(color = md_theme_dark_background.copy(alpha = 0.4f))
            .shadow(2.dp, shape = RectangleShape)
            .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

        Text(
            "什麼是中途宿舍?\n",
            lineHeight = 50.sp, fontSize =35.sp, fontWeight = FontWeight.Bold,textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            "-為有條件釋放者提供的指定住所，提供膳食服務\n\n" +
                    "-提供個人輔導及小組/社區活動\n\n" +
                    "-週末及節假日可以請假\n\n" +
                    "-經登記，家人和朋友可以來訪\n\n" +
                    "-居住期限根據個人需要和進度，由院長決定", fontSize = 20.sp
        )


            Image(
                painter = painterResource(com.example.hkuandorid13.android.R.drawable.house), // fix image alignment
                contentDescription = "background_image",
                modifier = Modifier.offset(x = if(width > 720){200} else {150}
                    .dp, y=0.dp) // pixel vs galaxy
            )

        Spacer(modifier = Modifier.height(20.dp))

        NextButton(nextButton = onNextButtonClicked)
        HKULogo()
    }
}

@Preview
@Composable
fun B_aScreenPreview() {
    HKUTheme {
        B_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}
package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun H_aScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier
){
    val requiredContext = LocalContext.current

        Column(
            modifier = Modifier
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(10.dp),
                 verticalArrangement = Arrangement.SpaceBetween,
            ) {

            Text(
                "重要聯絡人", lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                "\n如果認為施加的條件不合理，您可以聯絡律師或專業人士確認條件是否不合理:\n", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(com.example.hkuandorid13.android.R.drawable.logo2),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .scale(2f),
                    contentDescription = null,
                )
            }
            Text(
                "\n法律援助署", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

            Text( "ladinfo@lad.gov.hk", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openEmail(context = requiredContext, email = "ladinfo@lad.gov.hk")
                } )
            Text( "+852 2537 7677", fontSize = 20.sp,color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openDialPad(context = requiredContext, phoneNum = "+85225377677")
                } )
            Text(
                        "香港金鐘道66號政府合署\n", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )





            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
              painter = painterResource(com.example.hkuandorid13.android.R.drawable.concord_mutual_aid), // replace image....?
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .scale(1f),
                    contentDescription = null,
                )
            }
            Text(
                "\n康和互助社聯會"
                ,fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            Text( "concord.maca@gmail.com", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openEmail(context = requiredContext, email = "concord.maca@gmail.com")
                } )

            Text( "+852 3586 0567", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openDialPad(context = requiredContext, phoneNum = "+85235860567")
                } )
            Text( "+852 6826 0720", fontSize = 20.sp,color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openDialPad(context = requiredContext, phoneNum = "+85268260720")
                } )
            Text(
                        "石硤尾南山邨南逸樓地下3-10號", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            HyperlinkText(
                fullText =  "https://concordorghk.wordpress.com/ \n",
                hyperLinks = mutableMapOf(
                    "https://concordorghk.wordpress.com/" to "https://concordorghk.wordpress.com/",
                ),
                textStyle = TextStyle(
                    textAlign = TextAlign.Center,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                ),
                linkTextColor = Color.Blue,
                linkTextFontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(com.example.hkuandorid13.android.R.drawable.hk_dignity), // replace image....?
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .scale(1f),
                    contentDescription = null,
                )
            }
            Text(
                "\n香港守護尊嚴中心", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

            Text( "info@dignityinstitute.com", fontSize = 20.sp, color = Color.Blue,fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openEmail(context = requiredContext, email = "info@dignityinstitute.com")
                } )
            Text( "+852 9728 5969", fontSize = 20.sp,color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openDialPad(context = requiredContext, phoneNum = "+85297285969")
                } )
            Text(
                        "P.O. Box 28557\n" +
                        "香港告士打道郵政局", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            HyperlinkText(
                fullText = "www.dignityinstitute.com \n"
                ,
                hyperLinks = mutableMapOf(
                    "www.dignityinstitute.com" to "https://www.dignityinstitute.com",
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


            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(com.example.hkuandorid13.android.R.drawable.hong_kong_flag), // replace image....?
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .scale(1f),
                    contentDescription = null,
                )
            }
            Text(
                "\n精神健康覆核審裁處\n" +
                        "香港添馬添美道2號政府總部東翼19樓", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text( "+852 2594 5636", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openDialPad(context = requiredContext, phoneNum = "+85225945636")
                } )

            HyperlinkText(
                fullText = "https://www.healthbureau.gov.hk/cn/committees/mhrt.htm\n"
                ,
                hyperLinks = mutableMapOf(
                    "https://www.healthbureau.gov.hk/cn/committees/mhrt.htm" to "https://www.healthbureau.gov.hk/cn/committees/mhrt.htm",
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



            HomeButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}

@Preview
@Composable
fun H_aScreenPreview() {
    HKUTheme {
        H_aScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}





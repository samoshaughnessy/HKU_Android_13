package com.example.hku_a_ios_001.android.ui

import android.content.Intent
import android.net.Uri
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background


@Composable
fun D_bScreen(
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
//               horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            Text(
                "精神健康\n" + "覆核審裁（MHRT) \n",
                lineHeight = 50.sp, fontSize = 33.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

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
                "\n精神健康覆核審裁處（MHRT）負責處理有條件釋放令下的覆核，並決定申請人是否適合被解除有條件釋放令。MHRT由一名具有適當法律經驗的主席、一名醫生、一名社工和一名具備行政或臨床心理學經驗或知識或其他資格或經驗的人組成。 \n \n" +
                "覆核申請時，您可以獲得如下幫助：\n", fontSize = 20.sp
            )

            val bulletItems = listOf("條件釋放令下的服務對象轉介至精神健康覆核審裁處申請表格往往可以在醫院填寫。在醫院填表時，可以獲得醫務社工的協助\n", "一般來說，當您提出覆核申請時，申訴專員不應該詢問您多餘的問題\n", "詢問機當局及提出覆核申請的過程，建議您盡量採用書面形式，如是口頭形式，建議盡量錄音，保留溝通過程中的證據，以防醫院施加不合理的條件\n", "可由您或您的親屬提出申請；申請法律援助以支付法律代表的費用；\n", "您有權在法律代表或其他授權代表的陪同下出席覆核申請聆訊；\n"  )

            BulletList(listItems = bulletItems)

            Text(
                "聯絡精神健康\n" +
                        "覆核審裁處",
                lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
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
                "精神健康覆核審裁處 \n" +
                        "香港添馬添美道2號政府總部東翼19樓 \n"
                ,
                fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )

            Text( "+852 2594 5636 \n", fontSize = 20.sp, color = Color.Blue, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    openDialPad(context = requiredContext, phoneNum = "+85225945636")
                } )



            HyperlinkText(
                fullText = "https://www.healthbureau.gov.hk/cn/\n" +
                        "committees/mhrt.htm",
                hyperLinks = mutableMapOf(
                    "https://www.healthbureau.gov.hk/cn/" to "https://www.healthbureau.gov.hk/cn/committees/mhrt.htm",
                    "committees/mhrt.htm" to "https://www.healthbureau.gov.hk/cn/committees/mhrt.htm",
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


            BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.D_a )
            HomeButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}

@Preview
@Composable
fun D_bScreenPreview() {
    HKUTheme {
        D_bScreen(
                modifier = Modifier.fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
            )
    }
}

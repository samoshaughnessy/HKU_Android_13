package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun E_bScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier,
    viewModel: HKUViewModel,
    navController: NavController
){
        Column(
            modifier = Modifier
                .padding(25.dp)
                .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                .shadow(2.dp, shape = RectangleShape)
                .padding(20.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
            Text(
                "申請書需要包括\n" +
                        "哪些內容？ ",
                lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                "\n申請書須盡可能包括以下資料：\n", fontWeight = FontWeight.Bold, fontSize = 20.sp
            )
            Text(
                "服務對象姓名，以及身分證號碼；", fontSize = 20.sp
            )

            StyledList(listItems = styledListItems)


            Text(
                "除此之外： \n" +
                "1. 凡提出申請的人是服務對象的親屬，則須述明該服務對象的姓名、地址及身分證號碼，以及申請人與該服務對象的關係；\n \n" +
                "2. 如果服務對象希望授權代表，還需提供授權代表的姓名、地址以及現有身分證的號碼。如仍未授權其他人為代表，則需述明該服務對象是否打算授權代表，抑或是否有意自行處理其個案。 \n \n" +
                "3. 根據相關規定，如上述指明的任何一項資料並未包括在申請書上，則在切實可行範圍內，負責當局（即院長、醫生、懲教署署長、社會福利署署長等有關人士）須提供該項資料。但我們依然建議您盡可能全面地自行準備相關资料。"
            , fontSize = 20.sp)
            BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.E_a )
            HomeButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}

val styledListItems = listOf(Pair("服務對象的地址，包括\n", "1. "), Pair("服務對象正被羈留的地方或", "a. "), Pair("服務對象的非官方監護人姓名及地址，以及監護人的分證的號碼；或\n", "b. "),  Pair("如已獲有條件釋放或已獲授予離院許可，則須述明服務對象最後被羈留或現時可被羈留的地方，現時的地址，以及規定服務對象須前往就醫的精神科門診診療所的地址；\n", "c. "), Pair("該服務對象被羈留或可被留所根據本條例中的條文；\n", "2. ")
)

@Composable
fun StyledList ( listItems: List<Pair<String, String>>){
    listItems.forEach{
        Row {
            Text( text = "  \t\t" + it.second, fontSize = 20.sp)
            Text( text = it.first, fontSize = 20.sp)        }
    }
}

@Preview
@Composable
fun E_bScreenPreview() {
    HKUTheme {
        E_bScreen(
            modifier = Modifier
                .fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
        )
    }
}



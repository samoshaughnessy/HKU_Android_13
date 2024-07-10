package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

val bulletPointsB_D = listOf("宵禁（或會影響您的工作；\n", "在一定範圍內限制您的財務自由；\n", "規定您在首次入住中途宿舍的數周或數月內，不得離開中途宿舍。\n")

@Composable
fun B_dScreen(
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
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
//              horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "中途宿舍額外限制 \n",
            lineHeight = 50.sp, fontSize =35.sp, fontWeight = FontWeight.Bold,textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            "中途宿舍可能施加額外限制，例如：", fontSize = 20.sp
        )

        BulletList2(listItems = bulletPointsB_D, indentedItem = "可能：入住首三個月外出要登記 \n")
        Text(
            "如果您發現中途宿舍的限制不合理，該怎麼辦？\n \n" +
                    "-尋求律師和非政府組織的\n" +
                    "（聯繫方式見後）\n\n" +
                    "-向有關當局，如申訴專員公署提出投訴\n\n" + "其他選擇：向社會福利署提出申訴" , fontSize = 20.sp
        )

        BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.B_c )
        NextButton(nextButton = onNextButtonClicked)
        HKULogo()
    }
}

@Composable
fun BulletList2(listItems: List<String>, indentedItem: String){
    listItems.forEach {
        Row {
            Text( text = "\u2022 \t\t", fontSize = 20.sp)
            Text( text = it, fontSize = 20.sp)
        }
    }
    if(indentedItem.isNotEmpty()){
        Row {
            Text( text = "      。\t\t", fontSize = 20.sp)
            Text( text = indentedItem, fontSize = 20.sp)
        }
    }

}

@Preview
@Composable
fun B_dScreenPreview() {
    HKUTheme {
        B_dScreen(
            modifier = Modifier.fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
        )
    }
}

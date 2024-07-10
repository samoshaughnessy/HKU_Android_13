package com.example.hku_a_ios_001.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background
@Composable
fun A_cScreen(
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier,
    viewModel: HKUViewModel,
    navController: NavController
){
    val context = LocalContext.current

    val displayMetrics = context.resources.displayMetrics

    //Width And Height Of Screen
    val width = displayMetrics.widthPixels
    val height = displayMetrics.heightPixels

    //Device Density
    val density = displayMetrics.density
    Box(
        modifier = Modifier
            .zIndex(1f)
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(com.example.hkuandorid13.android.R.drawable.dotted_arrow),
            contentDescription = "arrow",
            modifier = Modifier
                .absoluteOffset(x = (-25).dp, y = (400).dp)
                .scale(
                    if (height > 1300) {
                        0.8f
                    } else {
                        0.6f
                    }
                ) // fix for pixel and galaxy
        )
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(25.dp)
            .background(color = md_theme_dark_background.copy(alpha = 0.4f))
            .shadow(2.dp, shape = RectangleShape)
            .padding(20.dp)


    ) {
        Text(
            "什麼是“條件”？ \n",
            lineHeight = 50.sp, fontSize = 35.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            "由院長在簽署釋放令時施加; \n " +
        "常見規限條件包括:", fontSize = 20.sp
        )
        Text("居住在指定地點（比如中途宿舍）\n" +
                "-服用指定藥物\n\n" +
                "-定期到院長指定的診所覆診\n\n" +
                "-接受社會福利署署長監督\n", fontSize = 20.sp)

        Text("• \t\t理論上院長可以施加" , fontSize=20.sp)
//       Add in blue Arrow
        Text( buildAnnotatedString {
            withStyle(style = SpanStyle(color=Color.Blue)){
                append("一切合理")
            }
            append("的條件，沒有明確的")
        }, fontSize = 20.sp
        )
        Text(" 禁止 \n", fontSize = 20.sp)


        Box(
            modifier=Modifier.height(30.dp)
        ){}
        Text(
            " 什麼是“合理”？",fontSize = 20.sp, fontWeight = FontWeight.Bold
        )
        BulletList(listItems = bulletPoints)
        BackButton(destination = HKUScreen.A_b, viewModel = viewModel, navController = navController)
        HomeButton(nextButton = onNextButtonClicked)
        HKULogo()
        }

}



val bulletPoints = listOf("對控制病情、確保人身安全有實際作用\n", "與該人所患的病情相關\n", "與病情相應，不能在不必要的情況下侵犯個人生活\n")

@Composable
fun BulletList(listItems: List<String>){
    listItems.forEach {
        Row {
            Text( text = "\u2022 \t\t", fontSize = 20.sp)
            Text( text = it, fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun A_cScreenPreview() {
    HKUTheme {
        A_bScreen(
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
            modifier = Modifier.fillMaxHeight()
        )
    }
}
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
import androidx.navigation.compose.rememberNavController
import com.example.hkuandorid13.android.HKUScreen
import com.example.hkuandorid13.android.ui.theme.HKUTheme
import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background

@Composable
fun C_cScreen(
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
                "您的有條件釋放" +
                        "\n" +
                        "令將會持續多久？ \n",
                lineHeight = 50.sp, fontSize = 33.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,   modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                "再次入院後，有條件釋放令還有效嗎？\n", fontWeight = FontWeight.Bold, fontSize = 20.sp
            ) // Bold


            Text(
                "-有條件釋放令的持續時間不一樣，這取決於醫務人員和院長的決定。 \n\n" +
                "-但是，它將無限期地持續，一直到您向精神健康覆核審裁處提出的覆核申請成功為止。 \n\n" +
                "-只有您自己的覆核申請有可能終止有條件釋放令（醫生不能夠法定上解除您的有條件釋放令，但實踐中醫生可以解除您需要遵守的條件) \n\n" +
                "-根據我們的研究，很多服務對象並不知道有權向精神健康覆核審裁處提出覆核申請。", fontSize = 20.sp
            )

            BackButton(viewModel = viewModel, navController = navController, destination = HKUScreen.C_b )
            HomeButton(nextButton = onNextButtonClicked)
            HKULogo()
        }
}

@Preview
@Composable
fun C_cScreenPreview() {
    HKUTheme {
        C_cScreen(
            modifier = Modifier.fillMaxHeight(),
            viewModel = HKUViewModel(),
            navController = rememberNavController(),
        )
    }
}

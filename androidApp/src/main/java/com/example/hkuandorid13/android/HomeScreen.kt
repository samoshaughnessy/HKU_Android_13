package com.example.hkuandorid13.android

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.hku_a_ios_001.android.ui.HKUViewModel
import com.example.hku_a_ios_001.android.ui.HomeScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource

import com.example.hku_a_ios_001.android.ui.A_aScreen
import com.example.hku_a_ios_001.android.ui.A_bScreen
import com.example.hku_a_ios_001.android.ui.A_cScreen
import com.example.hku_a_ios_001.android.ui.B_aScreen
import com.example.hku_a_ios_001.android.ui.B_bScreen
import com.example.hku_a_ios_001.android.ui.B_cScreen
import com.example.hku_a_ios_001.android.ui.B_dScreen
import com.example.hku_a_ios_001.android.ui.B_eScreen
import com.example.hku_a_ios_001.android.ui.C_aScreen
import com.example.hku_a_ios_001.android.ui.C_bScreen
import com.example.hku_a_ios_001.android.ui.C_cScreen
import com.example.hku_a_ios_001.android.ui.D_aScreen
import com.example.hku_a_ios_001.android.ui.D_bScreen
import com.example.hku_a_ios_001.android.ui.E_aScreen
import com.example.hku_a_ios_001.android.ui.E_bScreen
import com.example.hku_a_ios_001.android.ui.F_aScreen
import com.example.hku_a_ios_001.android.ui.F_bScreen
import com.example.hku_a_ios_001.android.ui.G_aScreen
import com.example.hku_a_ios_001.android.ui.H_aScreen

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

import com.example.hkuandorid13.android.ui.theme.md_theme_dark_background
import com.example.hkuandorid13.android.data.OrderUiState
import com.example.hkuandorid13.android.R

enum class HKUScreen(val string:String){ // can add size with int value to alter size of titles if required
    Home("有條件釋放咨詢庫"),
    A_a("什麼是有條件釋放？"),
    A_b("病人在有條件下獲釋放出院的命令摹本 ▼"),
    A_c("什麼是“條件”？ ▼"),
    B_a("什麼是中途宿舍? ▼"),
    B_b("香港中途宿舍位置 ▼"),
    B_c("進入中途宿舍需要哪些條件？ ▼"),
    B_d("中途宿舍額外限制 ▼"),
    B_e("如何申請？ ▼"),
    C_a("您會被召回醫院嗎？ ▼"),
    C_b("有條件釋放令召回 ▼"),
    C_c("您的有條件釋放令將會持續多久？ ▼"),
    D_a("如果有條件釋放令不合理？ ▼"),
    D_b("精神健康覆核審裁（MHRT) ▼"),
    E_a("提出覆核申請需要提交哪些資料？ ▼"),
    E_b("申請書需要包括哪些內容？ ▼"),
    F_a("可以向精神科醫生提出的問題 ▼"),
    F_b("醫生沒有正當理由卻拒絕調整相關限制... ▼"),
    G_a("有條件釋放者是否了解他們的情況"),
    H_a("重要聯絡人"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun    HKUAppBar(
    currentScreen : OrderUiState,
    modifier: Modifier = Modifier,
    viewModel: HKUViewModel,
) {
    // edit to allow drop down menu
//    if(currentScreen.openHamburger){
//        println("hide")
//    } else {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    currentScreen.currentPage.string,
                    color = Color.White,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = if ((currentScreen.currentPage !== HKUScreen.Home)) {
                        Modifier.fillMaxWidth(0.85f).clickable {
                            if (!currentScreen.openDropDown) {
                                viewModel.openDropDown()
                            } else {
                                viewModel.closeDropDown()
                            }
                        }
                    } else {
                        Modifier.fillMaxWidth(0.85f)
                    }
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = md_theme_dark_background.copy(alpha = 0.4f)
            ),
            modifier = modifier,
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu",
                    modifier = Modifier.scale(1.5f).clickable(enabled = true) {
                        if (!currentScreen.openHamburger) {
                            viewModel.openHamburger()
                        } else {
                            viewModel.closeHamburger()
                        }
                    }
                )
            }
        )
//    }

}
@Composable
fun HKUApp(
    viewModel: HKUViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
            topBar = {
                HKUAppBar(
                    currentScreen = uiState,
                    viewModel = viewModel,
                )
            }
        )
        { innerPadding ->
            Box(
                modifier = Modifier
                .background(color = Color.Black)
                .fillMaxSize()
                .paint(
                    painterResource(id = com.example.hkuandorid13.android.R.drawable.jackimage),
                    contentScale = ContentScale.FillHeight
                )
                .verticalScroll(
                    rememberScrollState()
                )
            )
            {
                if (uiState.openHamburger) {
                    BurgerMenuDropDown(
                        viewModel=viewModel,
                        showOrHide = uiState.openHamburger,
                        modifier = Modifier.zIndex(1f),
                        navController = navController
                    )
                } else {
                    if(uiState.openDropDown){
                        ArrowDropDownMenu(
                            currentScreen = uiState,
                            viewModel = viewModel,
                        navController = navController,
                        modifier = Modifier
                    )
                    }
                    NavHost(
                        navController = navController,
                        startDestination = HKUScreen.Home.name,
                        modifier = Modifier
                            .padding(innerPadding)

                    ) {
                        composable(route = HKUScreen.Home.name) {
                            HomeScreen(
                                viewModel = viewModel,
                                navController = navController,
                                // this on nextButtonClicked needs to be altered here as previously we are always passing one destination, in this case, we could go anywhere..
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.A_a.name) {
                            A_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.A_b.name)
                                    viewModel.setPage(HKUScreen.A_b)
                                    viewModel.closeDropDown()
                                },

                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.A_b.name) {
                            A_bScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.A_c.name)
                                    viewModel.setPage(HKUScreen.A_c)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )

                        }
                        composable(route = HKUScreen.A_c.name) {
                            A_cScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )

                        }

                        composable(route = HKUScreen.B_a.name) {
                            B_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.B_b.name)
                                    viewModel.setPage(HKUScreen.B_b)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.B_b.name) {
                            B_bScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.B_c.name)
                                    viewModel.setPage(HKUScreen.B_c)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }

                        composable(route = HKUScreen.B_c.name) {
                            B_cScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.B_d.name)
                                    viewModel.setPage(HKUScreen.B_d)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }

                        composable(route = HKUScreen.B_d.name) {
                            B_dScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.B_e.name)
                                    viewModel.setPage(HKUScreen.B_e)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }

                        composable(route = HKUScreen.B_e.name) {
                            B_eScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.C_a.name) {
                            C_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.C_b.name)
                                    viewModel.setPage(HKUScreen.C_b)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.C_b.name) {
                            C_bScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.C_c.name)
                                    viewModel.setPage(HKUScreen.C_c)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.C_c.name) {
                            C_cScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.D_a.name) {
                            D_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.D_b.name)
                                    viewModel.setPage(HKUScreen.D_b)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.D_b.name) {
                            D_bScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.E_a.name) {
                            E_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.E_b.name)
                                    viewModel.setPage(HKUScreen.E_b)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.E_b.name) {
                            E_bScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.F_a.name) {
                            F_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.F_b.name)
                                    viewModel.setPage(HKUScreen.F_b)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.F_b.name) {
                            F_bScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                viewModel = viewModel, navController = navController,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.G_a.name) {
                            G_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                        composable(route = HKUScreen.H_a.name) {
                            H_aScreen(
                                onNextButtonClicked = {
                                    navController.navigate(HKUScreen.Home.name)
                                    viewModel.setPage(HKUScreen.Home)
                                    viewModel.closeDropDown()
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                            )
                        }
                    }
                }
            }
        }

}

val abList = listOf(Pair("什麼是有條件釋放？", HKUScreen.A_a.name), Pair("病人在有條件下獲釋放出院的命令摹本", HKUScreen.A_b.name),Pair("什麼是“條件”？", HKUScreen.A_c.name))
val bdList  = listOf(
        Pair("什麼是中途宿舍?", HKUScreen.B_a.name), Pair("香港中途宿舍位置", HKUScreen.B_b.name), Pair("進入中途宿舍需要哪些條件？", HKUScreen.B_c.name),
        Pair("中途宿舍額外限制", HKUScreen.B_d.name), Pair("如何申請？", HKUScreen.B_e.name)
)
val cbList = listOf(Pair("您會被召回醫院嗎？", HKUScreen.C_a.name),Pair("有條件釋放令召回", HKUScreen.C_b.name), Pair("您的有條件釋放令將會持續多久", HKUScreen.C_c.name))
val dbList = listOf(Pair("如果有條件釋放令不合理",HKUScreen.D_a.name), Pair("精神健康覆核審裁(MHRT)",HKUScreen.D_b.name))
val ebList = listOf(Pair("提出覆核申請需要提交哪些資料？", HKUScreen.E_a.name), Pair("申請書需要包括哪些內容？", HKUScreen.E_b.name))
val fbList = listOf(Pair("可以向精神科醫生提出的問題", HKUScreen.F_a.name), Pair("醫生沒有正當理由卻拒絕調整相關限制...",HKUScreen.F_b.name))



@Composable
fun InnerMenu (    
    list: List<Pair<String, String>>,
    viewModel: HKUViewModel,
    navController: NavHostController,
    currentScreen : OrderUiState,
    ){
    list.forEach(){it ->
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .border(border = BorderStroke(1.dp, color=Color.Black))
                .padding(20.dp)
                .zIndex(2f)
                .clickable {
                    if(!currentScreen.openDropDown){
                        viewModel.openDropDown()
                    } else {
                        viewModel.closeDropDown()
                    }
                    navController.navigate(it.second)
                }
        ){
            Text(it.first, fontSize = 15.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }
    }
    
}

@Composable
fun ArrowDropDownMenu (
    viewModel: HKUViewModel,
    navController: NavHostController,
    modifier: Modifier,
    currentScreen: OrderUiState
) {
    Box(
        modifier =  if( (currentScreen.currentPage == HKUScreen.G_a) || (currentScreen.currentPage == HKUScreen.H_a)){
            Modifier
        } else {
            Modifier.padding(20.dp)
                .fillMaxSize()
                .offset(x = 0.dp, y = 70.dp)
                .background(color = Color.Gray.copy(alpha = 0.95F))
                .shadow(2.dp, shape = RectangleShape)
                .zIndex(1f)
                .defaultMinSize(minWidth = 200.dp, minHeight = 150.dp)
        }
        ,
    ) {
        Column(modifier
            .padding(15.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            ) {
            if((currentScreen.currentPage == HKUScreen.A_a) || (currentScreen.currentPage == HKUScreen.A_b) || (currentScreen.currentPage == HKUScreen.A_c)){
                Column  (
                    Modifier.fillMaxSize()
                ){
                    InnerMenu(list = abList, viewModel= viewModel, navController= navController, currentScreen = currentScreen)
                }
            } else if ((currentScreen.currentPage == HKUScreen.B_a) || (currentScreen.currentPage == HKUScreen.B_b) || (currentScreen.currentPage == HKUScreen.B_c) || (currentScreen.currentPage == HKUScreen.B_d)|| (currentScreen.currentPage == HKUScreen.B_e)){
                Column  (
                    Modifier.fillMaxSize()
                ){
                    InnerMenu(list = bdList, viewModel= viewModel, navController= navController, currentScreen = currentScreen)
                }
            } else if ((currentScreen.currentPage == HKUScreen.C_a) || (currentScreen.currentPage == HKUScreen.C_b)|| (currentScreen.currentPage == HKUScreen.C_c)){
                Column  (
                    Modifier.fillMaxSize()
                ){
                    InnerMenu(list = cbList, viewModel= viewModel, navController= navController, currentScreen = currentScreen)
                }
            }else if ((currentScreen.currentPage == HKUScreen.D_a) || (currentScreen.currentPage == HKUScreen.D_b)){
                Column  (
                    Modifier.fillMaxSize()
                ){
                    InnerMenu(list = dbList, viewModel= viewModel, navController= navController, currentScreen = currentScreen)
                }
            }else if ((currentScreen.currentPage == HKUScreen.E_a) || (currentScreen.currentPage == HKUScreen.E_b)){
                Column  (
                    Modifier.fillMaxSize()
                ){
                    InnerMenu(list = ebList, viewModel= viewModel, navController= navController, currentScreen = currentScreen)
                }
            }else if ((currentScreen.currentPage == HKUScreen.F_a) || (currentScreen.currentPage == HKUScreen.F_b)){
                Column  (
                    Modifier.fillMaxSize()
                ){
                    InnerMenu(list = fbList, viewModel= viewModel, navController= navController, currentScreen = currentScreen)
                }
            }
        }
    }
}

@Composable
fun SelectDropItem(
    labelResourceId: String,
    itemImagePath: Int,
    buttonClick: () -> Unit = {},
){
    Box(
        modifier = Modifier
            .defaultMinSize(minWidth = 300.dp, minHeight = 10.dp)
            .clickable { buttonClick() }
    ) {
        Row (
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(itemImagePath),
                contentDescription = null,
                modifier = Modifier.size(width = 70.dp, height = 70.dp).padding(10.dp)
            )
            Text(labelResourceId, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }

}



@Composable
fun BurgerMenuDropDown (
    viewModel: HKUViewModel,
    navController: NavHostController,
    showOrHide : Boolean,
    modifier: Modifier,
){
    if (showOrHide) {
        Box(
            modifier = Modifier.absoluteOffset(x=0.dp, y=90.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .background(color = md_theme_dark_background.copy(alpha = 0.4f))
                    .shadow(2.dp, shape = RectangleShape),
            ) {

                SelectDropItem(labelResourceId = "有條件釋放",
                    itemImagePath = R.drawable._1__door,
                    buttonClick = {
                        navController.navigate(HKUScreen.A_a.name)
                        viewModel.setPage(HKUScreen.A_a)
                        viewModel.closeHamburger()
                    }
                )

                SelectDropItem(
                    labelResourceId = "中途宿舍",
                    itemImagePath = R.drawable._2__house,
                    buttonClick = {
                        navController.navigate(HKUScreen.B_a.name)
                        viewModel.setPage(HKUScreen.B_a)
                        viewModel.closeHamburger()
                    }
                )

                SelectDropItem(
                    labelResourceId = "您會被召回醫院嗎？",
                    itemImagePath = R.drawable._3__clipboard,
                    buttonClick = {
                        navController.navigate(HKUScreen.C_a.name)
                        viewModel.setPage(HKUScreen.C_a)
                        viewModel.closeHamburger()
                    }
                )
                SelectDropItem(
                    labelResourceId = "如果有條件釋放令不合理？",
                    itemImagePath = R.drawable._4__scales,
                    buttonClick = {
                        navController.navigate(HKUScreen.D_a.name)
                        viewModel.setPage(HKUScreen.D_a)
                        viewModel.closeHamburger()
                    }
                )
                SelectDropItem(
                    labelResourceId = "復核申請需要哪些資料？",
                    itemImagePath = R.drawable._5__docs,
                    buttonClick = {
                        navController.navigate(HKUScreen.E_a.name)
                        viewModel.setPage(HKUScreen.E_a)
                        viewModel.closeHamburger()
                    }
                )
                SelectDropItem(
                    labelResourceId = "可以向你的醫生提出的問題",
                    itemImagePath = R.drawable._6__doctor,
                    buttonClick = {
                        navController.navigate(HKUScreen.F_a.name)
                        viewModel.setPage(HKUScreen.F_a)
                        viewModel.closeHamburger()
                    }
                )
                SelectDropItem(
                    labelResourceId = "有條件釋放令統計",
                    itemImagePath = R.drawable._7__stats,
                    buttonClick = {
                        navController.navigate(HKUScreen.G_a.name)
                        viewModel.setPage(HKUScreen.G_a)
                        viewModel.closeHamburger()
                    }
                )
                SelectDropItem(
                    labelResourceId = "重要聯絡人",
                    itemImagePath = R.drawable._8__contact,
                    buttonClick = {
                        navController.navigate(HKUScreen.H_a.name)
                        viewModel.setPage(HKUScreen.H_a)
                        viewModel.closeHamburger()
                    }
                )

                Box(Modifier.height(120.dp)){}
            }
        }
    }
    }

// can remove before launch
//private fun cancelOrderAndNavigateToStart(
//    viewModel: HKUViewModel,
//    navController: NavHostController
//) {
//    viewModel.resetOrder()
//    navController.popBackStack(HKUScreen.Home.name, inclusive = false)
//}
//



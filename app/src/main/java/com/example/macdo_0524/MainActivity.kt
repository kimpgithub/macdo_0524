package com.example.macdo_0524

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.macdo_0524.ui.theme.MACDO_0524Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MACDO_0524Theme {
                AppNavigator()
            }
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("second") { SecondScreen(navController) }
    }
}

data class ButtonItem(val label: String, val imageRes: Int)

@Composable
fun MainScreen(navController: NavHostController) {

    val buttonItems = listOf(
        ButtonItem("🍔 바오패밀리와 함께 해쉬브라운!", R.drawable.macdo_1_2),
        ButtonItem("🍟 맥도날드와 신선한 식재료 찾기 게임 대공개", R.drawable.macdo_1_3),
        ButtonItem("🍔 바오패일리 투게더 팩 출시!", R.drawable.macdo_1_4),
        ButtonItem("🍟 가성비 간식 맛집 \n 맥도날드 해피스낵!", R.drawable.macdo_1_5),
        ButtonItem("🍔 맥윙은 못참지! \n 오늘부터 1일 1맥윙!", R.drawable.macdo_1_6),
        ButtonItem("🍟 빠삭하게 빠져드는 맛, \n 맥크리스피!", R.drawable.macdo_1_7),
        ButtonItem("🍔 단짠촉촉 맥그리들로 \n 따뜻하게 채우는 아침", R.drawable.macdo_1_8),
        ButtonItem("🍟 갓 구워낸 따뜻하고 신선한 \n 베이컨 토마토 에그 머핀!", R.drawable.macdo_1_9),
        ButtonItem("🍔 상큼달콤! \n NEW 천도복숭아 칠러 출시!", R.drawable.macdo_1_10)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // 화면 상단 1/4 박스
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.macdo_1_1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // 이미지 확대/축소 방식 설정
                    modifier = Modifier.fillMaxWidth()
                )
            }
            // 무한 스크롤 버튼 영역
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            ) {
                items(buttonItems) { item ->
                    Button(
                        onClick = { navController.navigate("second") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp) // 화면 비율에 따라 적절한 높이 설정
                            .padding(vertical = 8.dp),
                        shape = MaterialTheme.shapes.medium // 기본 둥근 사각형 모양
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = painterResource(id = item.imageRes), // 각 버튼에 맞는 이미지
                                contentDescription = null,
                                modifier = Modifier.size(320.dp) // 이미지 크기 설정
                            )
                            Divider(modifier = Modifier.height(2.dp))
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = item.label, fontSize = 16.sp)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)

data class MenuItem(val name: String, val imageRes: Int)

@Composable
fun SecondScreen(navController: NavHostController) {
    val menuItems = listOf(
        MenuItem("추천메뉴", R.drawable.macdo_2_2),
        MenuItem("버거세트", R.drawable.macdo_2_3),
        MenuItem("해피스낵", R.drawable.macdo_2_4),
        MenuItem("스낵 & 사이드", R.drawable.macdo_2_5),
        MenuItem("음료", R.drawable.macdo_2_6),
        MenuItem("디저트", R.drawable.macdo_2_7),
        MenuItem("해피밀", R.drawable.macdo_2_8)
    )

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = "Back",)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "M오더 주문", fontSize = 32.sp, color = Color.Black)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.macdo_2_1), // 예시 아이콘 리소스
                        contentDescription = "M오더 아이콘",
                        modifier = Modifier.size(48.dp), // 아이콘 크기 조정
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "강남2호", fontSize = 16.sp, color = Color.Black)
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "운영시간: 24시간", fontSize = 14.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "매장 변경하기", fontSize = 14.sp, color = Color.Blue)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(text = "메뉴 살펴보기", fontSize = 20.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(menuItems) { menuItem ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = menuItem.imageRes),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp) // 이미지 크기 설정
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = menuItem.name, fontSize = 24.sp, color = Color.Black)
                    }
                    Divider(modifier = Modifier.height(1.dp))
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MACDO_0524Theme {
        AppNavigator()
    }
}

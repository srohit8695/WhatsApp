package com.example.wassapppractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wassapppractice.ui.theme.WassappPracticeTheme
import com.example.wassapppractice.ui.theme.wassAppThemeColor
import com.example.wassapppractice.views.WhatsAppCalls
import com.example.wassapppractice.views.WhatsAppChat
import com.example.wassapppractice.views.WhatsAppStatus
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WassappPracticeTheme {
                whatsApp()
            }
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun whatsApp() {
        var context = LocalContext.current
        var toolBar: @Composable () -> Unit = {
            TopAppBar(
                title = {
                    Text(
                    text = "Whatsapp",
                    color = Color.White,
                    fontSize = 20.sp
                    )
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Clicked to search",Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }

                    IconButton(onClick = {
                        Toast.makeText(context, "Clicked to Message",Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            Icons.Filled.MailOutline,
                            contentDescription = "Message",
                            tint = Color.White
                        )
                    }

                    IconButton(onClick = {
                        Toast.makeText(context, "Clicked to Menu",Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                },
                backgroundColor = wassAppThemeColor,
                elevation = AppBarDefaults.TopAppBarElevation
            )
        }

        Scaffold(
            topBar = {
                     toolBar()
            },
            content = {
                WhatsAppTap()
            }
        )
    }

     @ExperimentalPagerApi
     @Composable
    fun WhatsAppTap() {
        val pagerState = rememberPagerState(pageCount = 3)
         Column {
             Tabs(pagerState)
             TabsContent(pagerState)
         }
    }

    @ExperimentalPagerApi
    @Composable
    fun Tabs(pagerState: PagerState) {
        var list = listOf("CHATS","STATUS","CALLS")
        val scope = rememberCoroutineScope()

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = wassAppThemeColor,
            contentColor = Color.Gray,
            indicator = {   tabPosition ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPosition),
                    height = 3.dp,
                    color = Color.White
                )
            }
        ) {
            list.forEachIndexed{ index, s ->   
                Tab(
                    text = {
                        Text(
                            list.get(index),
                            color = Color.White
                        )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                         scope.launch {
                             pagerState.animateScrollToPage(index)
                         }
                    }
                )
            }
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun TabsContent(pagerState: PagerState) {
        HorizontalPager(state = pagerState) {page ->
            when(page){
                0 -> WhatsAppChat()
                1 -> WhatsAppStatus()
                2 -> WhatsAppCalls()
            }
        }
    }
}

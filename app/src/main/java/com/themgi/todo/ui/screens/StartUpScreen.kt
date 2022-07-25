package com.themgi.todo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.themgi.todo.R
import com.themgi.todo.Screen
import com.themgi.todo.data.ImageRow
import com.themgi.todo.ui.components.ImageCarousel
import com.themgi.todo.ui.components.Layout
import com.themgi.todo.ui.components.PrimaryButton
import com.themgi.todo.ui.components.TextPrimaryButton
import kotlinx.coroutines.launch

val imageList = listOf(
    ImageRow(
        imageResource = R.drawable.ic_clock_juggle,
        contentDescription = "Clock Juggling",
        headLineText = R.string.manage_your_tasks,
        labelText = R.string.easily_manage
    ),
    ImageRow(
        imageResource = R.drawable.ic_calander,
        contentDescription = "Calendar",
        headLineText = R.string.create_daily_routine,
        labelText = R.string.personalized_experience
    ),
    ImageRow(
        imageResource = R.drawable.ic_organization,
        contentDescription = "Organization",
        headLineText = R.string.organize,
        labelText = R.string.organize_daily_tasks
    ),
)

@OptIn(ExperimentalPagerApi::class)
suspend fun changeImage(pagerState: PagerState, navHostController: NavHostController) {
    if (pagerState.currentPage < pagerState.pageCount - 1) {
        pagerState.animateScrollToPage(pagerState.currentPage + 1)
    } else {
        navHostController.navigate(Screen.WelcomeScreen.route)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StartUpScreen(navHostController: NavHostController) {
    val pagerState = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()

    val onButtonClick: () -> Unit = {
        coroutineScope.launch {
            changeImage(pagerState = pagerState, navHostController = navHostController)
        }
    }

    Layout {
        TextPrimaryButton(
            text = stringResource(id = R.string.skip).uppercase(),
        ) {
            navHostController.navigate(Screen.WelcomeScreen.route)
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageCarousel(imageList = imageList, pagerState = pagerState)
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            TextPrimaryButton(text = stringResource(id = R.string.back).uppercase()) {
                navHostController.popBackStack()
            }
            PrimaryButton(
                text = (if (pagerState.currentPage == pagerState.pageCount - 1) stringResource(id = R.string.get_started) else stringResource(
                    id = R.string.next
                )).uppercase(), onClick = onButtonClick
            )
        }
    }
}

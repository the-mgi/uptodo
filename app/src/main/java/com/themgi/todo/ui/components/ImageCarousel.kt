package com.themgi.todo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.themgi.todo.data.ImageRow

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier,
    imageList: List<ImageRow>,
    pagerState: PagerState,
) {
    HorizontalPager(
        count = imageList.size,
        state = pagerState,
    ) { page ->
        val currentItem = imageList[page]
        Column() {
            Image(
                painter = painterResource(id = currentItem.imageResource),
                contentDescription = currentItem.contentDescription,
                modifier = Modifier
                    .width(213.dp)
                    .height(277.dp)
                    .padding(bottom = 40.dp)
                    .align(Alignment.CenterHorizontally)

            )
            HeadlineAndLabel(
                headlineText = stringResource(id = currentItem.headLineText),
                labelText = stringResource(
                    id = currentItem.labelText
                )
            )
        }
    }
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 20.dp)) {
        for (i in imageList.indices) {
            Box(
                modifier = modifier
                    .padding(end = 5.dp)
                    .height(5.dp)
                    .width(30.dp)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .background(
                        if (pagerState.currentPage == i) Color.White else Color(
                            0xFFAFAFAF
                        )
                    )
                    .alpha(if (pagerState.currentPage == i) 0.87f else 1.0f)
            )
        }
    }
}
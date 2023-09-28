package com.arnoract.cinemoapp.feature.ui.finder

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arnoract.cinemoapp.R
import com.arnoract.cinemoapp.feature.ui.finder.model.UiItemMovieFinder

@Composable
fun ItemMovieFinder(uiItemMovieFinder: UiItemMovieFinder, onClickedItem: (Int) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(148.dp)
        .clip(RoundedCornerShape(8.dp))
        .clickable {
            onClickedItem(uiItemMovieFinder.id)
        }) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(uiItemMovieFinder.imageUrl)
                .crossfade(true).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(148.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(colorResource(id = R.color.black))
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = uiItemMovieFinder.genre,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.gray700)
            )
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = uiItemMovieFinder.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = uiItemMovieFinder.releaseDate,
                fontSize = 14.sp,
                color = colorResource(id = R.color.gray500)
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.view_more_label),
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.gray500)
                )
                Icon(
                    tint = colorResource(id = R.color.gray500),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "View more"
                )
            }
        }
    }
}
package com.arnoract.cinemoapp.feature.ui.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arnoract.cinemoapp.R
import com.arnoract.cinemoapp.feature.ui.Screen
import com.arnoract.cinemoapp.feature.ui.finder.MovieFinderContent
import org.koin.androidx.compose.getViewModel

@Composable
fun MyFavoriteScreen(
    navHostController: NavHostController, viewModel: MyFavoriteViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = stringResource(id = R.string.my_favorite_title_label),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        MovieFinderContent(viewModel.uiState.collectAsState().value) {
            navHostController.navigate(Screen.MovieDetail.createRoute(it))
        }
    }
}
package com.arnoract.cinemoapp.ui.feature.finder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
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
import com.arnoract.cinemoapp.ui.Screen
import org.koin.androidx.compose.getViewModel

@Composable
fun MovieFinderScreen(
    navHostController: NavHostController, viewModel: MovieFinderViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = viewModel.searchText.collectAsState().value,
            onValueChange = {
                viewModel.onTextChanged(it)
            },
            label = { Text(stringResource(id = R.string.search_label)) })
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = stringResource(id = R.string.movie_finder_title_label),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        MovieFinderContent(viewModel.uiState.collectAsState().value) {
            navHostController.navigate(Screen.MovieDetail.createRoute(it))
        }
    }
}
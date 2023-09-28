package com.arnoract.cinemoapp.feature.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.arnoract.cinemoapp.R
import com.arnoract.cinemoapp.feature.ui.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationAppBar(
    navController: NavController,
    currentRoute: String,
    anyFavorite: Boolean = false,
) {
    val context = LocalContext.current
    TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = colorResource(id = R.color.black),
        titleContentColor = colorResource(id = R.color.white),
        navigationIconContentColor = colorResource(id = R.color.white),
        actionIconContentColor = colorResource(id = R.color.white)
    ), title = {
        Text(text = context.getString(R.string.app_name))
    }, navigationIcon = {
        when (currentRoute) {
            Screen.MovieDetail.route, Screen.MyFavorite.route -> {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "Navigate"
                    )
                }
            }
        }
    }, actions = {
        if (currentRoute == Screen.MovieFinder.route) {
            IconButton(onClick = {
                navController.navigate(Screen.MyFavorite.route)
            }) {
                Icon(
                    imageVector = if (anyFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Navigate"
                )
            }
        }
    })
}
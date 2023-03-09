package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibianViewModel
import com.example.amphibians.ui.screens.HomeScreen
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory

@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {

    Scaffold(
    modifier = modifier.fillMaxSize(),
    topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val amphibianViewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
            HomeScreen(
                uiState = amphibianViewModel.amphibianUiState
            )
        }
    }
}

fun viewModel(factory: ViewModelProvider.Factory): AmphibianViewModel {
    return viewModel(factory = AmphibianViewModel.Factory)
}

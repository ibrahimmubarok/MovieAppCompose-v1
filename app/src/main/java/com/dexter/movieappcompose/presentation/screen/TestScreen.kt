package com.dexter.movieappcompose.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dexter.movieappcompose.presentation.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.navigation.Profile

@Composable
fun TestScreen(
    profile: Profile,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BannerTitle(text = profile.name)
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        BannerTitle(text = profile.address)
    }
}
package com.dexter.movieappcompose.presentation.screen.about

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dexter.movieappcompose.R
import com.dexter.movieappcompose.presentation.component.common.BannerTitle
import com.dexter.movieappcompose.presentation.navigation.Profile
import com.dexter.movieappcompose.presentation.ui.theme.Typography
import com.dexter.movieappcompose.presentation.ui.theme.White1
import com.google.gson.Gson

@Composable
fun AboutScreen(
    onNavigateToTestScreen: (String) -> Unit
) {
    ProfileContent(onNavigateToTestScreen = onNavigateToTestScreen)
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    onNavigateToTestScreen: (String) -> Unit,
) {
    val data = Profile(
        name = "Tom & Jerry",
        address = "Jl. Cidodol, RT.009/RW.011"
    )
    val dataJson = Uri.encode(Gson().toJson(data))
    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onNavigateToTestScreen.invoke(dataJson)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BannerTitle(
            text = stringResource(id = R.string.label_about_me),
            modifier = modifier.padding(vertical = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.img_me),
            contentDescription = "Avatar",
            modifier = modifier
                .padding(4.dp)
                .border(2.dp, Color.White, CircleShape)
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(
            text = stringResource(R.string.label_my_name),
            modifier = modifier.padding(
                top = 8.dp,
                start = 32.dp,
                end = 32.dp
            ),
            style = Typography.displayMedium.copy(
                color = White1,
                fontSize = 16.sp,
            )
        )
        Text(
            text = stringResource(R.string.label_my_email),
            modifier = modifier.padding(horizontal = 32.dp),
            style = Typography.displayMedium.copy(
                color = White1,
                fontSize = 16.sp,
            )
        )
    }
}
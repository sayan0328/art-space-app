package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import com.example.artspace.ui.theme.Pink40
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var image by remember { mutableStateOf(R.drawable.pic1) }
    var title by remember { mutableStateOf(R.string.pic1_title) }
    var artist by remember { mutableStateOf(R.string.pic1_artist) }
    var year by remember { mutableStateOf(R.string.pic1_year) }
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ArtworkWall(image)
        Spacer(modifier = Modifier.height(15.dp))
        ArtworkDescriptor(title, artist, year)
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Button(onClick = {
                when(image) {
                    R.drawable.pic1 -> {
                        image = R.drawable.pic5
                        title = R.string.pic5_title
                        artist = R.string.pic5_artist
                        year = R.string.pic5_year
                    }
                    R.drawable.pic2 -> {
                        image = R.drawable.pic1
                        title = R.string.pic1_title
                        artist = R.string.pic1_artist
                        year = R.string.pic1_year
                    }
                    R.drawable.pic3 -> {
                        image = R.drawable.pic2
                        title = R.string.pic2_title
                        artist = R.string.pic2_artist
                        year = R.string.pic2_year
                    }
                    R.drawable.pic4 -> {
                        image = R.drawable.pic3
                        title = R.string.pic3_title
                        artist = R.string.pic3_artist
                        year = R.string.pic3_year
                    }
                    R.drawable.pic5 -> {
                        image = R.drawable.pic4
                        title = R.string.pic4_title
                        artist = R.string.pic4_artist
                        year = R.string.pic4_year
                    }
                }
            }) {
                Text(text = stringResource(R.string.prev), modifier = Modifier.padding(horizontal = 10.dp))
            }
            Spacer(modifier = Modifier.width(125.dp))
            Button(onClick = {
                when(image) {
                    R.drawable.pic1 -> {
                        image = R.drawable.pic2
                        title = R.string.pic2_title
                        artist = R.string.pic2_artist
                        year = R.string.pic2_year
                    }
                    R.drawable.pic2 -> {
                        image = R.drawable.pic3
                        title = R.string.pic3_title
                        artist = R.string.pic3_artist
                        year = R.string.pic3_year
                    }
                    R.drawable.pic3 -> {
                        image = R.drawable.pic4
                        title = R.string.pic4_title
                        artist = R.string.pic4_artist
                        year = R.string.pic4_year
                    }
                    R.drawable.pic4 -> {
                        image = R.drawable.pic5
                        title = R.string.pic5_title
                        artist = R.string.pic5_artist
                        year = R.string.pic5_year
                    }
                    R.drawable.pic5 -> {
                        image = R.drawable.pic1
                        title = R.string.pic1_title
                        artist = R.string.pic1_artist
                        year = R.string.pic1_year
                    }
                }
            }) {
                Text(text = stringResource(R.string.next), modifier = Modifier.padding(horizontal = 20.dp))

            }
        }
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Surface(
        modifier = Modifier,
        shadowElevation = 5.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Image (painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .padding(40.dp)
                .size(400.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        tonalElevation = 10.dp,
        color = Color(0xffffebcf),
        shape = RoundedCornerShape(15.dp),
    ) {
        Column(modifier = Modifier.padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text (text = stringResource(title), fontSize = 40.sp, fontFamily = FontFamily.Cursive)
            Row {
                Text(text = stringResource(artist), fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = stringResource(year))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
package com.audiobooks.podcasts.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.audiobooks.podcasts.R
import com.audiobooks.podcasts.model.Podcast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastListScreen(podcastList: List<Podcast>, onShowDetails: (podcast: Podcast) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.str_podcast), fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(items = podcastList) { _, item ->
                PodcastItem(podcast = item, onItemClick = {
                    onShowDetails(
                        Podcast(
                            title = item.title,
                            description = item.description,
                            id = item.id,
                            image = item.image,
                            publisher = item.publisher
                        )
                    )
                })

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(0.8.dp)
                        .background(Color.LightGray)
                )

            }

        }
    }

}


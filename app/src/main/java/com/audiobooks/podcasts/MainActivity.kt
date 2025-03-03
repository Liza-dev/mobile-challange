package com.audiobooks.podcasts

import PodcastDetailScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.audiobooks.podcasts.model.Podcast
import com.audiobooks.podcasts.navigation.CustomNavType
import com.audiobooks.podcasts.navigation.PodcastDetails
import com.audiobooks.podcasts.navigation.PodcastList
import com.audiobooks.podcasts.ui.PodcastListScreen
import com.audiobooks.podcasts.ui.PodcastListViewModel
import com.audiobooks.podcasts.ui.theme.PodcastsTheme
import kotlin.reflect.typeOf


class MainActivity : ComponentActivity() {
    private val podcastListViewModel by viewModels<PodcastListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            PodcastsTheme {
                NavHost(
                    navController = navController,
                    startDestination = PodcastList,
                    modifier = Modifier.safeDrawingPadding()
                ) {
                    composable<PodcastList> {
                        PodcastListScreen(podcastListViewModel.podcastList,  onShowDetails = { podcast ->
                                navController.navigate(PodcastDetails(podcast))
                           })
                        podcastListViewModel.getPodcastList()
                    }
                    composable<PodcastDetails>(
                        typeMap = mapOf(typeOf<Podcast>() to CustomNavType.PodcastType)
                    ) { backStackEntry ->

                        val route = backStackEntry.toRoute<PodcastDetails>()
                        PodcastDetailScreen(route.podcast, navController)
                    }
                }
            }
        }
    }
}

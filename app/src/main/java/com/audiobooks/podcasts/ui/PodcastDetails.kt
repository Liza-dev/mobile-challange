import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.audiobooks.podcasts.R
import com.audiobooks.podcasts.model.Podcast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PodcastDetailScreen(podcast: Podcast, navController: NavController) {
    var isPressed by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.str_back), fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = podcast.title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = podcast.publisher,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = rememberImagePainter(
                    data = podcast.image,
                    builder = {
                        placeholder(R.drawable.placeholder_round_image)
                        transformations(CircleCropTransformation())
                    }
                ),

                contentDescription = podcast.description,
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(onClick = { isPressed =! isPressed}, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )) {
                Text(if(isPressed) stringResource(R.string.str_favourited) else stringResource(R.string.str_favourite))
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = podcast.description,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}

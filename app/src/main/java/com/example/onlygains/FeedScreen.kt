package com.example.onlygains

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.onlygains.data.models.Post


@Composable
fun FeedScreen(workoutViewModel: WorkoutViewModel,navController:NavController) {

    val posts by workoutViewModel.posts.collectAsState()
    
    if (posts.isEmpty()){
        CircularProgressIndicator()
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
        ) {
            HorizontalDivider()
        }
        LazyColumn {
            items(posts) { post ->
                PostItem(post = post,workoutViewModel=workoutViewModel,
                        navController)
            }
        }
    }
}

@Composable
fun RoundImageCard(
    image: Int, modifier: Modifier = Modifier
        .padding(8.dp)
        .size(64.dp)
) {
    Card(shape = CircleShape, modifier = modifier) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun VerticalDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
            .alpha(0.3f)
            .padding(top = 8.dp, bottom = 8.dp)
            .background(Color.LightGray)
    )
}

@Composable
fun HorizontalDivider() {
    Divider(
        color = Color.LightGray,
        thickness = 1.dp,
        modifier = Modifier
            .alpha(0.3f)
            .padding(top = 8.dp, bottom = 8.dp)
    )
}

@Composable
fun PostItem(post: Post,workoutViewModel: WorkoutViewModel,navController: NavController) {
    val imagePainter= rememberImagePainter(data = "https://i.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(Color.White)
    ) {
        /*Row(verticalAlignment = Alignment.CenterVertically) {
            RoundImageCard(
                image = ,
                Modifier
                    .size(48.dp)
                    .padding(4.dp)
            )
            Text(text =salim, fontWeight = FontWeight.Bold)
        }*/
        AsyncImage(model= ImageRequest.Builder(LocalContext.current)
            .data("https://picsum.photos/500/500")
            .crossfade(true).build(),
            placeholder = painterResource(id =R.drawable.back_workout_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(text = post.description, modifier = Modifier.padding(8.dp),
        color=Color.Gray)
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(imagePainter,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Red)
            )
            Text(text = "${post.likes} likes", modifier = Modifier.padding(start = 8.dp),
            color=Color.Gray)
        }
        Text(
            text = "comments",
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        Button(
            modifier = Modifier.padding(8.dp),onClick = { workoutViewModel.get_specific_workout(post.wid)
                navController.navigate(route = "e")}, content =
            {
                Text(text = "Workout")
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray))
    }
}
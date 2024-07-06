package com.example.letscook.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.letscook.model.recipe.RecipeDto


@Composable
fun RecipeListScreen() {

    var randomRecipes by remember { mutableStateOf<List<RecipeDto>>(emptyList()) }

}

@Composable
fun RecipeListContent(
    randomRecipes: List<RecipeDto>,
    onClick: (RecipeDto) -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            text = "Let's Cook"
        )
        RecipeSession(
            label = "Random Recipes",
            recipeList = randomRecipes,
            onClick = onClick
        )
    }
}

@Composable
fun RecipeSession(
    label: String,
    recipeList: List<RecipeDto>,
    onClick: (RecipeDto) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            text = label
        )
        Spacer(modifier = Modifier.size(8.dp))
        RecipeList(recipeList = recipeList, onClick = onClick)
    }
}


@Composable
fun RecipeList(
    recipeList: List<RecipeDto>,
    onClick: (RecipeDto) -> Unit
) {
    LazyRow {
        items(recipeList) {
            RecipeItem(
                recipeDto = it,
                onClick = onClick
            )
        }
    }
}


@Composable
fun RecipeItem(
    recipeDto: RecipeDto,
    onClick: (RecipeDto) -> Unit
) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .clickable {
                onClick.invoke(recipeDto)
            }
    ) {

        AsyncImage(
            modifier = Modifier
                .padding(end = 4.dp)
                .width(120.dp)
                .height(150.dp),
            contentScale = ContentScale.Crop,
            model = recipeDto.image,
            contentDescription = "${recipeDto.title} recipe image",
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = recipeDto.title)
        Text(text = recipeDto.summary)
    }
}


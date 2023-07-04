package com.samuelokello.moviq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samuelokello.moviq.ui.theme.MoviqTheme

class MainActivity : ComponentActivity() {
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MoviqTheme {
				
				Scaffold(
					topBar = {
						TopAppBar(
							title = {
								Row(
									modifier = Modifier
										.fillMaxWidth()
										.padding(10.dp),
									horizontalArrangement = Arrangement.SpaceBetween,
									verticalAlignment = Alignment.CenterVertically
								
								) {
									
									Icon(
										imageVector = Icons.Default.Menu,
										contentDescription = null)
									Image(
										modifier = Modifier
											.size(25.dp)
											.clip(shape = RoundedCornerShape(20.dp)),
										painter = painterResource(id = R.drawable.profile1),
										contentDescription =null
									)
								}
							}
						)
					}
				)
				{ paddingValues ->
					LazyColumn(modifier = Modifier
						.fillMaxSize()
						.padding(paddingValues)
						.padding(10.dp)){
						item {
							Row(
								modifier = Modifier
									
									.padding(10.dp)
									.fillMaxWidth(),
								horizontalArrangement = Arrangement.spacedBy(170.dp)
							
							) {
								
								Text(
									text = "Activity",
									fontWeight = FontWeight.ExtraBold,
								)
								Row(
									modifier=Modifier.fillMaxWidth(),
									horizontalArrangement = Arrangement.SpaceBetween,
								)
								{
									Text(
										text = "Friends",
										color = Color.Blue)
									Text(
										text = "You",
										color = Color.Gray)
								}
								
							}
							
							Column(modifier = Modifier
								.fillMaxSize()
								.padding(10.dp)) {
								Row(
									modifier=Modifier.fillMaxWidth(),
									horizontalArrangement = Arrangement.SpaceBetween
								) {
									Text(text = "Gregory")
									Text(
										fontWeight = FontWeight.ExtraLight,
										color= Color.Gray,
										text = "2 min"
									)
								}
//								Text(
//									fontWeight = FontWeight.ExtraLight,
//									color= Color.Gray,
//									text = "liked collection")
//								Text(
//									color= Color.Blue,
//									text = "The Best of Robert Downney Jr"
//								)
								
							}
							Column(modifier = Modifier.fillMaxSize()) {
								Row( modifier=Modifier.fillMaxWidth(),
									horizontalArrangement = Arrangement.SpaceBetween,) {
									Text(text = "Stewart")
									Text(
										fontWeight = FontWeight.ExtraLight,
										color= Color.Gray,
										text = "1 hour"
									)
								}
								Text(
									fontWeight = FontWeight.ExtraLight,
									color= Color.Gray,
									text = "Liked")
							}
							LazyRow(
								modifier = Modifier.fillMaxWidth() .clip(shape = RoundedCornerShape(20.dp))
							){
								items(movies){ movies ->
									Image(
										modifier= Modifier
											.size(200.dp)
											
											.padding(10.dp),
										painter = painterResource(movies.image), contentDescription =null )
								}
							}
							
							Column(modifier = Modifier
								.fillMaxSize()
								.padding(10.dp)) {
								Row(
									modifier=Modifier.fillMaxWidth(),
									horizontalArrangement = Arrangement.SpaceBetween,) {
									Text(text = "Gregory")
									Text(
										fontWeight = FontWeight.ExtraLight,
										color= Color.Gray,
										text = "2 min"
									)
								}
								Text(
									fontWeight = FontWeight.ExtraLight,
									color= Color.Gray,
									text = "liked collection"
								)
								Text(
									color= Color.Blue,
									text = "Watch the official trailer for"
								)
								Text(
									color= Color.Red,
									text = "The Irishman"
								)
								
							}
							Column(modifier = Modifier.fillMaxSize()) {
								Row( modifier=Modifier.fillMaxWidth(),
									horizontalArrangement = Arrangement.SpaceBetween,) {
									Text(text = "Stewart")
									Text(
										fontWeight = FontWeight.ExtraLight,
										color= Color.Gray,
										text = "1 hour")
								}
								Text(
									fontWeight = FontWeight.ExtraLight,
									color= Color.Gray,
									text = "Posted")
							}
							LazyRow(
								modifier = Modifier.fillMaxWidth() .clip(shape = RoundedCornerShape(20.dp))
							){
								items(movies){ movies ->
									Image(
										modifier= Modifier
											.size(200.dp)
											
											.padding(10.dp),
										painter = painterResource(movies.image), contentDescription =null
									)
								}
							}
						}
					}
					
				}
			}
		}
	}
}

data class Movies(
	val image:Int,
	val name:String,
	
	)

val movies= listOf(
	Movies(
		image=R.drawable.image1,
		name= "Avengers",
		
		),
	Movies(
		image=R.drawable.image_,
		name= "Iron Man",
		
		),
	Movies(
		image= R.drawable.jocker,
		name= "Hunger Game",
		
		),
	Movies(
		image=R.drawable.sm_across,
		name= "Last Resort",
		
		)
	
	
)


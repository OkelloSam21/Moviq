package com.samuelokello.moviq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.input.key.Key.Companion.G
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuelokello.moviq.ui.theme.MyGray
import com.samuelokello.moviq.ui.theme.MoviqTheme
import com.samuelokello.moviq.ui.theme.MyOrange


class MainActivity : ComponentActivity() {
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MoviqTheme {
				
				Scaffold(topBar = {
					Column(
						modifier = Modifier.padding(horizontal = 16.dp),
					) {
						TopAppBar(navigationIcon = {
							Image(
								imageVector = Icons.Default.Menu,
								contentDescription = null,
							)
						}, actions = {
							Image(
								modifier = Modifier
									.size(40.dp)
									.clip(RoundedCornerShape(20.dp)),
								painter = painterResource(id = R.drawable.profile1),
								contentDescription = null,
								contentScale = ContentScale.Crop,
							)
						}, title = {})
						
						Row(
							modifier = Modifier.fillMaxWidth(),
							horizontalArrangement = Arrangement.SpaceBetween,
						) {
							Text(
								text = "Activity",
								fontWeight = FontWeight.SemiBold,
								fontSize = 24.sp,
							)
							
							Row(
								horizontalArrangement = Arrangement.spacedBy(12.dp),
							) {
								var SelectedTab by remember {
									mutableStateOf("Friends")
								}
								RoundedCard(title = "Friends",
									selectedCard = SelectedTab,
									onClickCard = { title ->
										SelectedTab = title
									})
								
								RoundedCard(title = "You",
									selectedCard = SelectedTab,
									onClickCard = { title ->
										SelectedTab = title
									})
							}
							
							
						}
						
					}
				}) { paddingValues ->
					LazyColumn(
						modifier = Modifier
							.fillMaxSize()
							.padding(paddingValues)
							.padding(10.dp)
					) {
						item {
							CollectionComponent(
								circleContent = {
									Text(text = "G")
								},
								name = "Gregor",
								time = "2 min",
								type = "Liked Collection",
								content = {
									Text(
										"The Best of Robert Downey Jr",
										color = MyOrange,
										fontWeight = FontWeight.SemiBold
									)
								},
							)
						}
						item {
							CollectionComponent(
								circleContent = {
									Text(text = "S")
								},
								name = "Stewart",
								time = "1 min",
								type = "Liked",
								content = {
									Column() {
										Spacer(modifier = Modifier.height(8.dp))
										LazyRow(
											horizontalArrangement = Arrangement.spacedBy(8.dp),
										){
											items(movies){ movies ->
												Card(
													modifier = Modifier
														.width(180.dp)
														.height(150.dp),
												) {
													Image(
														modifier = Modifier.fillMaxSize(),
														painter = painterResource(id = movies.image),
														contentDescription = null,
														contentScale = ContentScale.Crop,
													)
												}
											}
										}
										Spacer(modifier = Modifier.height(8.dp))
										Button(
											modifier =  Modifier.fillMaxWidth(),
											onClick = { /*TODO*/ },
											shape = RoundedCornerShape(8.dp),
											colors = ButtonDefaults.buttonColors(
												containerColor = MyGray,
												contentColor = Color.Gray,
												),
										)
											{
											Text(text = "2 more")
										}
									}
								},
							)
						}
						
						item {
							CollectionComponent(
								backgroundColor = Color.Black,
								circleContent = {
												Image(
													painter = painterResource(id = R.drawable.sm_across),
													contentDescription = null,
													contentScale = ContentScale.Crop,
												)
								},
								name = "Netflix",
								time = "10 min",
								type = "posted",
								content = {
									Column{
										Spacer(modifier = Modifier.height(8.dp))
											Text(
												text = "Watch the Official trailer for",
												fontWeight = FontWeight.SemiBold,
												fontSize = 16.sp,
											)
										Text(
											text = "The Irish Man",
											fontWeight = FontWeight.SemiBold,
											fontSize = 16.sp,
										)

										Spacer(modifier = Modifier.height(8.dp))
										
//										Image(
//											modifier = Modifier
//												.height(200.dp)
//												.clip(RoundedCornerShape(12.dp)),
//											painter = painterResource(id = R.drawable.sm_across),
//											contentDescription = null,
//											contentScale =  ContentScale.Crop,
//										)
										LazyRow(
											horizontalArrangement = Arrangement.spacedBy(8.dp),
										){
											items(movies){ movies ->
												Card(
													modifier = Modifier
														.width(180.dp)
														.height(150.dp),
												) {
													Image(
														modifier = Modifier.fillMaxSize(),
														painter = painterResource(id = movies.image),
														contentDescription = null,
														contentScale = ContentScale.Crop,
													)
												}
											}
										}
									}
								}
							)
						}
						
						
					}
				}
			}
		}
		
	}
	
	@Composable
	private fun CollectionComponent(
		name: String,
		time: String,
		type: String,
		content: @Composable () -> Unit,
		circleContent: @Composable () -> Unit,
		backgroundColor: Color = MyGray,
	) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.spacedBy(12.dp),
		) {
			CircleWithLetter(
				backgroundColor = backgroundColor,
				content = {
					circleContent()
				},
			)
			Column() {
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceBetween,
				) {
					Text(
						text = name,
						fontWeight = FontWeight.SemiBold,
					)
					Text(
						text = time,
						color = Color.Gray,
					)
				}
				Text(
					type,
					color = Color.Gray,
				)
				content()
			}
		}
	}
	
}




@Composable
fun RoundedCard(
	selectedCard: String,
	title: String,
	onClickCard: (title: String) -> Unit,
) {
	var selected = selectedCard == title
	Box(
		modifier = Modifier
			.height(40.dp)
			.clip(RoundedCornerShape(20.dp))
			.background(
				if (selected) {
					Color(0xFFFE8157)
				} else {
					Color(0xffecf1f2)
				}
			)
			.clickable { onClickCard(title) },
	) {
		Text(
			modifier = Modifier.padding(horizontal = 16.dp),
			color = if (selected) {
				Color.White
			} else {
				Color.Black
			},
			text = title,
		)
	}
}

@Composable
fun CircleWithLetter(
	content: @Composable () -> Unit,
	backgroundColor: Color,
) {
	Box(
		modifier = Modifier
			.size(40.dp)
			.clip(CircleShape)
			.background(backgroundColor),
		contentAlignment = Alignment.Center,
	) {
		content()
	}
}

data class Movies(
	val image: Int,
	val name: String,
	
	)

val movies = listOf(
	Movies(
		image = R.drawable.image1,
		name = "Avengers",
		
		), Movies(
		image = R.drawable.image_,
		name = "Iron Man",
		
		), Movies(
		image = R.drawable.jocker,
		name = "Hunger Game",
		
		), Movies(
		image = R.drawable.sm_across,
		name = "Last Resort",
		
		)

)



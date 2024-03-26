package com.appsinvo.jetpackcomposedemo.ui

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomNavBar() {

    var context = LocalContext.current
    val fortyPx = context.resources.displayMetrics.density * 50


    var screenWidth = context.resources.displayMetrics.widthPixels - fortyPx

    Log.d("flvmkfmnvf", screenWidth.toString())
    Log.d("flvmkfmnvf", (screenWidth / 2).toString())
    Log.d("flvmkfmnvf", (screenWidth / 10).toString())

    var dWidth = (screenWidth / 9)
    Log.d("flvmkfmnvf", (dWidth * 5).toString())
    Log.d("flvmkfmnvf", (screenWidth / context.resources.displayMetrics.density).toString())

    //Allocating width of 5 nodes to mainNode.
    var mainWidth = (dWidth * 5) / context.resources.displayMetrics.density

    var restWidth = dWidth / context.resources.displayMetrics.density

    Log.d("'dldvmkfvmf", restWidth.toString())
    Log.d("'dldvmkfvmf", mainWidth.toString())


    var row1Width by remember {
        mutableStateOf(mainWidth)
    }
    var row2Width by remember {
        mutableStateOf(restWidth)
    }
    var row3Width by remember {
        mutableStateOf(restWidth)
    }
    var row4Width by remember {
        mutableStateOf(restWidth)
    }
    var row5Width by remember {
        mutableStateOf(restWidth)
    }


    var row1TextALPHA by remember {
        mutableStateOf(1f)
    }

    var row2TextALPHA by remember {
        mutableStateOf(0f)
    }

    var row3TextALPHA by remember {
        mutableStateOf(0f)
    }

    var row4TextALPHA by remember {
        mutableStateOf(0f)
    }

    var row5TextALPHA by remember {
        mutableStateOf(0f)
    }

    var row1TextALPHAState by remember {
        mutableStateOf(true)
    }


    var row1Animation = animateDpAsState(
        targetValue = row1Width.dp,
        animationSpec = tween(durationMillis = 300)
    ) { dp -> row1TextALPHA = if (dp == mainWidth.dp) 1f else 0f }.value
    var row2Animation = animateDpAsState(
        targetValue = row2Width.dp,
        animationSpec = tween(durationMillis = 300)
    ) { dp -> row2TextALPHA = if (dp == mainWidth.dp) 1f else 0f }.value
    var row3Animation = animateDpAsState(
        targetValue = row3Width.dp,
        animationSpec = tween(durationMillis = 300)
    ) { dp -> row3TextALPHA = if (dp == mainWidth.dp) 1f else 0f }.value
    var row4Animation = animateDpAsState(
        targetValue = row4Width.dp,
        animationSpec = tween(durationMillis = 300)
    ) { dp -> row4TextALPHA = if (dp == mainWidth.dp) 1f else 0f }.value
    var row5Animation = animateDpAsState(
        targetValue = row5Width.dp,
        animationSpec = tween(durationMillis = 300)
    ) { dp -> row5TextALPHA = if (dp == mainWidth.dp) 1f else 0f }.value






    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)
    )
    {
        Row(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .border(2.dp, Color.Black, RoundedCornerShape(20.dp))
                .background(color = Color.White, RoundedCornerShape(20.dp))
                .padding(top = 7.dp, start = 5.dp, end = 5.dp, bottom = 7.dp)

        ) {
               Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
                  .width(row1Animation)
                  .background(Brush.linearGradient(if(row1TextALPHA == 1f) listOf(Color.Red, Color.Green)else listOf(Color.Transparent,Color.Transparent)), shape = RoundedCornerShape(20.dp))
                   .padding(top = 4.dp, bottom = 4.dp, start = 2.dp, end = 2.dp)
                  .clickable {
                      row1Width = mainWidth
                      row2Width = restWidth
                      row3Width = restWidth
                      row4Width = restWidth
                      row5Width = restWidth
                  })
              {
                  Row() {
                      Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email")
                      Text(text = " Hello Hello Hello Hello",
                          maxLines = 1,
                          overflow = TextOverflow.Ellipsis,
                          modifier = Modifier
                              .graphicsLayer {
                                  alpha = row1TextALPHA
                              })
                  }
          }
             Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
              .width(row2Animation)
                 .background(
                     Brush.linearGradient(if(row2TextALPHA == 1f) listOf(Color.Red, Color.Green)else listOf(Color.Transparent,Color.Transparent)),
                     shape = RoundedCornerShape(20.dp)
                 )
              .padding(top = 4.dp, bottom = 4.dp, start = 2.dp, end = 2.dp)
              .clickable {
                  row1Width = restWidth
                  row2Width = mainWidth
                  row3Width = restWidth
                  row4Width = restWidth
                  row5Width = restWidth

              })
              {
              Row() {
                  Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email")
                  Text(text = " Hello Hello Hello Hello Hello 2",
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis,
                      modifier = Modifier
                          .weight(1f)
                          .graphicsLayer {
                              alpha = row2TextALPHA
                          })
              }
              }
              Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
              .width(row3Animation)
              .background(
                  Brush.linearGradient(if(row3TextALPHA == 1f) listOf(Color.Red, Color.Green)else listOf(Color.Transparent,Color.Transparent)),
                  shape = RoundedCornerShape(20.dp)
              )
              .padding(top = 4.dp, bottom = 4.dp, start = 2.dp, end = 2.dp)
              .clickable {
                  row1Width = restWidth
                  row2Width = restWidth
                  row3Width = mainWidth
                  row4Width = restWidth
                  row5Width = restWidth
              })
              {
              Row() {
                  Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email")
                  Text(
                      text = " Hello Hello Hello Hello Hello 2",
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis,
                      modifier = Modifier.graphicsLayer {
                          alpha = row3TextALPHA
                      })
              }
          }
              Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
              .width(row4Animation)
              .background(
                  Brush.linearGradient(if(row4TextALPHA == 1f) listOf(Color.Red, Color.Green)else listOf(Color.Transparent,Color.Transparent)),
                  shape = RoundedCornerShape(20.dp)
              )
              .padding(top = 4.dp, bottom = 4.dp, start = 2.dp, end = 2.dp)

              .clickable {
                  row1Width = restWidth
                  row2Width = restWidth
                  row3Width = restWidth
                  row4Width = mainWidth
                  row5Width = restWidth
              })
              {
              Row() {
                  Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email")
                  Text(
                      text = " Hello Hello Hello Hello Hello 2",
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis,
                      modifier = Modifier.graphicsLayer {
                          alpha = row4TextALPHA
                      })
              }
          }
              Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
              .width(row5Animation)
              .background(
                  brush = Brush.linearGradient(if(row5TextALPHA == 1f) listOf(Color.Red, Color.Green)else listOf(Color.Transparent,Color.Transparent)),
                  shape = RoundedCornerShape(20.dp)
              )
              .padding(top = 4.dp, bottom = 4.dp, start = 2.dp, end = 2.dp)
              .clickable {
                  row1Width = restWidth
                  row2Width = restWidth
                  row3Width = restWidth
                  row4Width = restWidth
                  row5Width = mainWidth
              })
              {
              Row() {
                  Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email")
                  Text(
                      text = " Hello Hello Hello Hello Hello 2",
                      maxLines = 1,
                      overflow = TextOverflow.Ellipsis,
                      modifier = Modifier.graphicsLayer {
                          alpha = row5TextALPHA
                      })
              }
          }
    }
}}


@Preview( backgroundColor = 0xFF3F00FF)
@Composable
fun previewCustomBottomNavBar(){
    CustomBottomNavBar()
}


package com.appsinvo.jetpackcomposedemo.ui

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Visibility

@OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun AnimBottomNavBar(){


    var icon1Visibility by remember {
        mutableStateOf(0)
    }

    var textWidth by remember {
        mutableStateOf(Int.MAX_VALUE)
    }
        
//        var textWidthAnim =  animateIntAsState(targetValue = textWidth, animationSpec = expandHorizontally() ).value

    var visibility by remember {
        mutableStateOf(true)
    }

val visibleState = remember {
        MutableTransitionState(true)
    }

    var wieghtCount by remember{
        mutableStateOf(3f)
    }

        Column(modifier = Modifier
            .fillMaxSize()
            .clickable {
//                visibility = !visibility
                visibleState.targetState = !visibleState.targetState

                wieghtCount = 1f
            }
            .padding(start = 20.dp, end = 20.dp)) {

            var modifier1 = Modifier.animateContentSize()
           modifier1 = if(!visibleState.targetState && !visibleState.currentState) modifier1.weight(2f, fill = true) else modifier1




            Row(modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = LinearOutSlowInEasing
                    )
                )){

                
                    Row(modifier = Modifier
                        .wrapContentWidth()
                        .weight(wieghtCount)
                        .animateContentSize()) {
                        Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email",modifier = Modifier.animateContentSize())
                        Text(text = "Hello broHello Hello Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.animateContentSize().wrapContentSize())
                    }


                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth()
                    .animateContentSize()) {
                    Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email",modifier = Modifier.animateContentSize())
                    if(!true) Text(text = "Hello broHello Hello Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", maxLines = 1,modifier = Modifier.animateContentSize().wrapContentSize())
                }
                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth()
                    .animateContentSize()) {
                    Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email",modifier = Modifier.animateContentSize())
                    if(!true) Text(text = "Hello broHello Hello Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", maxLines = 1,modifier = Modifier.animateContentSize().wrapContentSize())
                }
                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth()
                    .animateContentSize()) {
                    Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email",modifier = Modifier.animateContentSize())
                    if(!true) Text(text = "Hello broHello Hello Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", maxLines = 1,modifier = Modifier.animateContentSize().wrapContentSize())
                }
                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth()
                    .animateContentSize()) {
                    Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email",modifier = Modifier.animateContentSize())
                    if(!true)Text(text = "Hello broHello Hello Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", maxLines = 1,modifier = Modifier.animateContentSize().wrapContentSize())
                }
                Row(modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth()
                    .animateContentSize()) {
                    Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email",modifier = Modifier.animateContentSize())
                    if(!true)Text(text = "Hello broHello Hello Hello Hello HelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHelloHello", maxLines = 1,modifier = Modifier.animateContentSize().wrapContentSize())
                }


              /*  Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email", modifier = Modifier
                    .animateContentSize().wrapContentWidth())
                Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email", modifier = Modifier
                    .animateContentSize().wrapContentWidth())
                Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email", modifier = Modifier
                    .animateContentSize().wrapContentWidth())
                Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Email", modifier = Modifier
                    .animateContentSize().wrapContentWidth())*/
            }





        }

    }

@Preview(showSystemUi = true, showBackground = true)
@Composable()
fun previewAnimBottomNavBar(){
    AnimBottomNavBar()
}
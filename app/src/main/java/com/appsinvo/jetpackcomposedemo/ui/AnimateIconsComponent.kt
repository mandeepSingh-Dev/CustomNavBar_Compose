package com.appsinvo.jetpackcomposedemo.ui

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AnimateIconsComponent() {

    val cScope = rememberCoroutineScope()

    var icon = remember {
        mutableStateOf(Icons.Rounded.Create)
    }

    var icon1RotateAngle by remember {
        mutableStateOf(0f)
    }
    var rotateIcon1 = remember {
        Animatable(0f)
    }

    var icon2RotateAngle by remember {
        mutableStateOf(180f)
    }
    var rotateIcon2 = remember {
        Animatable(180f)
    }


    var icon1Alpha by remember {
        mutableStateOf(1f)
    }
    var icon1AlphaAnim = animateFloatAsState(targetValue = icon1Alpha, animationSpec = tween(durationMillis = 500)).value



    Box(modifier = Modifier.fillMaxSize()) {
        
        Icon(imageVector = if(icon1RotateAngle == 0f) Icons.Rounded.Create else Icons.Rounded.CheckCircle, contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .rotate(rotateIcon1.value)
                .alpha(icon1AlphaAnim)


                .clickable {
                    cScope.launch {
                        val angle = if (icon1RotateAngle == 0f) 180f else 0f

                        rotateIcon1.animateTo(
                            angle,
                            animationSpec = tween(durationMillis = 1000),
                            block = {

                                if (angle == 0f) {
                                    if (value < 60f)
                                        icon1RotateAngle = angle
                                } else {
                                    if (value > 60f)
                                        icon1RotateAngle = angle

                                    if (this.value > 80f) {

                                    }
                                }


                            }
                        )


                    }
                }
        )


    }

}

@Composable
fun AnimateScaleIcons() {

    var scale by remember {
        mutableStateOf(1f)
    }

    var scaleAnim =
        animateFloatAsState(targetValue = scale, animationSpec = tween(durationMillis = 1000), finishedListener = {

        }).value

    var scale2 by remember {
        mutableStateOf(0f)
    }

    var scaleAnim2 =
        animateFloatAsState(targetValue = scale2, animationSpec = tween(durationMillis = 1000), finishedListener = {

        }).value

    Box(modifier = Modifier.fillMaxSize().clickable {
        if(scale == 1f) {
            scale = 0f
            scale2 = 1f
        } else {
            scale = 1f
            scale2 = 0f
        }
    }) {

        Icon(imageVector = Icons.Rounded.LocationOn , contentDescription ="",
            modifier = Modifier.size(500.dp).align(Alignment.Center).scale(scaleAnim)
        )

        Icon(imageVector = Icons.Rounded.DateRange, contentDescription ="",
            modifier = Modifier.size(100.dp).align(Alignment.Center).scale(scaleAnim2)
        )


    }
}

@Preview
@Composable
fun previewAnimateIcons(){

}

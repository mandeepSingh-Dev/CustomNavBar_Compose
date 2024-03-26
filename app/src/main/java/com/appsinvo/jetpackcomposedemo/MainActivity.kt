@file:OptIn(ExperimentalMaterial3Api::class)

package com.appsinvo.jetpackcomposedemo

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.appsinvo.jetpackcomposedemo.ui.AnimBottomNavBar
import com.appsinvo.jetpackcomposedemo.ui.CustomBottomNavBar
import com.appsinvo.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            JetpackComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Green
                ) {
                    CustomBottomNavBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)
@Composable
fun Greeting(name: String) {

    val screenDensity = LocalContext.current.resources.displayMetrics.density




    var width by remember {
        mutableStateOf(10.dp)
    }
    var height by  remember {
        mutableStateOf(20.dp)
    }

    val animateWidth = animateDpAsState(targetValue = width).value
    val animatehHeight = animateDpAsState(targetValue = height).value


    var width2 by remember {
        mutableStateOf(200.dp)
    }
    var height2 by  remember {
        mutableStateOf(400.dp)
    }


    val animateWidth2 = animateDpAsState(targetValue = width2, tween(durationMillis = 2000)).value
    val animatehHeight2 = animateDpAsState(targetValue = height2, tween(durationMillis = 2000)).value

    var color by remember {
        mutableStateOf(0)
    }

    var animateColor = animateColorAsState(targetValue = if(color == 0) Color.Red else Color.Blue, animationSpec = infiniteRepeatable(animation = tween(400), repeatMode = RepeatMode.Restart)).value

    var isVisible by remember {
        mutableStateOf(false)
    }

    var animateSize = animateIntSizeAsState(targetValue = if(isVisible) IntSize(100,100) else IntSize(-1,-1))



    val rotateAnimatable = remember {
        Animatable(0f)
    }


    var scope = rememberCoroutineScope()


    var scrollableState = rememberScrollState()

    LaunchedEffect(key1 = true, block ={
        rotateAnimatable.animateTo(
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000), repeatMode = RepeatMode.Restart
            )
        ) {}
    } )

    var textSize by remember {
        mutableStateOf(30.sp)
    }

    var animateTextSize = animateFloatAsState(targetValue = textSize.value, animationSpec = spring()).value.sp


    var searchTextFieldValue by remember{ mutableStateOf("") }

    var interactionSource = remember {
        MutableInteractionSource()
    }

    val pressedState by interactionSource.collectIsPressedAsState()

    Column(modifier = Modifier.verticalScroll(scrollableState)) {


        Box(
            modifier = Modifier
                .clickable(interactionSource = interactionSource, indication = null) { }
                .graphicsLayer {
                    scaleX = if (pressedState) 0.6f else 1f
                    scaleY = if (pressedState) 0.6f else 1f
                }
                .background(brush = Brush.linearGradient(colors = listOf(Color.Yellow, Color.Blue)))) {

            Text(text = "Click Box Button")
        }


        Text(text = "Hello $name!")
        Button(onClick = {


                         isVisible = !isVisible

        },
            modifier = Modifier
                .rotate(rotateAnimatable.value)
                .onSizeChanged {
                    scope.launch {

                        width = (it.width / screenDensity).dp
                        height = (it.height / screenDensity).dp
                        Log.d("flvmkfmvf", it.width.toString())
                        Log.d("flvmkfmvf", it.width.dp.toString())
                    }
                }) {
            Text(text = "Click Button", fontSize = 20.sp)
        }
        AnimatedContent(targetState = width) {

            Button(onClick = {
                             color = if(color == 0) 1 else 0
            }, colors = ButtonDefaults.buttonColors(containerColor = animateColor), modifier = Modifier

                .size(animateWidth, animatehHeight)
                .onSizeChanged {
                    Log.d("fvlmkfvf", it.width.toString())
                }) {
                Text(text = "Hello")
            }
        }
        Text(
            text = "Mandeep",
            modifier = Modifier
                .size(animateSize.value.width.dp, animateSize.value.height.dp)
                .background(color = Color.Yellow)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            color = Color.Black,)

        Button(onClick = { width2 = 300.dp
                         height2 = 800.dp}, modifier = Modifier.size(animateWidth2,animatehHeight2)) {

        }

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Red)) {

            val (button1,text1) = createRefs()

            Button(onClick = {}, modifier = Modifier.constrainAs(button1){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
                Text(text = "Button")
            }
            Button(onClick = {}, modifier = Modifier.constrainAs(text1){
                top.linkTo(button1.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
                Text(text = "Button 2 ")
            }
        }

        Row(modifier = Modifier.background(color = Color.Cyan)) {
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text("ButtoButtonButtonButtonButtonButtonButtonButtonButtonn 1")
            }
            Button(onClick = {}, modifier = Modifier.weight(1f)) {
                Text("Button ButtonButtonButtonButtonButtonButtonButtonButtonButtonButton 2")
            }
            Button(onClick = {},modifier = Modifier.weight(1f)) {
                Text("ButtoButtonButtonButtonButtonButtonButtonButtonButtonButtonButtonButtonButtonButtonn 3")
            }
        }



        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier
                .width(120.dp)
                .height(50.dp)
                .background(Color.Yellow)
                .onSizeChanged {

                    val width = it.width / screenDensity
                    val height = it.height.dp.value / screenDensity

                    scope.launch {
                        delay(2000)
                        textSize = ((width.toFloat() / 100.0) * 10).sp


                    }

                    Log.d("vlkfkmvkfv", width.toString() + " width")
                    Log.d("vlkfkmvkfv", height.toString() + " height")
                    Log.d("vlkfkmvkfv", textSize.toString() + " textSize")

                }) {

                    Text(text = "Hello", fontSize = animateTextSize, color = Color.Black)


            }
        }





            BasicTextField(
                value = searchTextFieldValue,

                        onValueChange = { searchTextFieldValue = it },
                decorationBox = {
                    TextFieldDefaults.TextFieldDecorationBox(
                        value = searchTextFieldValue,
                        innerTextField = { it},
                        enabled = true,
                        singleLine = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = remember { MutableInteractionSource() },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            textColor = Color.White
                        )
                    )
                }

                    )
                }
/*
                singleLine = true,
*/
                /*colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    textColor = Color.Black
                ),*/

             /*decorationBox = {
                TextFieldDefaults.OutlinedTextFieldDecorationBox(
                    value = searchTextFieldValue,
                    innerTextField = it,
                    enabled = true,
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,

                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        textColor = Color.Black
                    ),
                    visualTransformation = VisualTransformation.None ,
                    interactionSource = remember { MutableInteractionSource() }
                )
                }*/












    }







@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeDemoTheme {
        Greeting("Android")
    }
}





@Composable
fun OutlinedTextFieldd(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
) {
    // If color is not provided via the text style, use content color as a default
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    @OptIn(ExperimentalMaterial3Api::class)
    BasicTextField(
        value = value,
        modifier =
        modifier

            .background(colors.containerColor(enabled).value)
            ,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,

        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = value,
                visualTransformation = visualTransformation,
                innerTextField = innerTextField,
                placeholder = placeholder,
                label = label,

                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                colors = colors,
                border = {
                    TextFieldDefaults.BorderBox(
                        enabled,
                        isError,
                        interactionSource,
                        colors,

                    )
                }
            )
        }
    )
}
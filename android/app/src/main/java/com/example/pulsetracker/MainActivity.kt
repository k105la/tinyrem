package com.example.pulsetracker

import android.content.Context
import android.os.Bundle
import android.renderscript.Element
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.pulsetracker.ml.SleepModel
import com.example.pulsetracker.ui.home.RemHomeScreen
import com.example.pulsetracker.ui.theme.PulsetrackerTheme
import com.example.pulsetracker.ui.views.login.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            PulsetrackerTheme {
                RemHomeScreen()
            }
        }
    }
}

fun testModel(context : Context) {
    //val context = LocalContext.current
    val model = SleepModel.newInstance(context)
    println(model)
    // Creates inputs for reference.
    //val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 1, 36), )
    //inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
    //val outputs = model.process(inputFeature0)
    //val outputFeature0 = outputs.outputFeature0AsTensorBuffer

// Releases model resources if no longer used.
    model.close()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PulsetrackerTheme { }
}
package com.gold.pdfmaker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gold.pdfmaker.ui.page.SamplePage
import com.gold.pdfmaker.ui.theme.PDFMakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDFMakerTheme {
                SamplePage()
            }
        }
    }
}
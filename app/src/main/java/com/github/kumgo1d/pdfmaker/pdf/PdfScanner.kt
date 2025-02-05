package com.github.kumgo1d.pdfmaker.pdf

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import com.github.kumgo1d.pdfmaker.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfScanner(
    fileName: String = "test.pdf",
    onClickSave: () -> Unit = {},
    dropDownActionsButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val composeView = remember { ComposeView(context) }

    Column {
        TopAppBar(
            title = {},
            actions = {
                IconButton(
                    onClick = {
                        generatePdfFile(
                            fileName = fileName,
                            composeView = composeView
                        )
                        onClickSave()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_picture_as_pdf),
                        contentDescription = "Save"
                    )
                }
                dropDownActionsButton()
            },
            colors = TopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                scrolledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.primary,
                actionIconContentColor = MaterialTheme.colorScheme.primary
            )
        )
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .horizontalScroll(rememberScrollState())
        ) {
            AndroidView(
                factory = {
                    composeView.apply {
                        setContent(content)
                    }
                }
            )
        }
    }
}
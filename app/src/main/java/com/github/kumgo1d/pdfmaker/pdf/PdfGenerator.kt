package com.github.kumgo1d.pdfmaker.pdf

import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.FileOutputStream


fun generatePdfFile(
    fileName: String,
    composeView: ComposeView
) {
    val pdfDocument = PdfDocument()

    composeView.measure(
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    )
    composeView.layout(0, 0, composeView.measuredWidth, composeView.measuredHeight)

    val bitmap = composeView.drawToBitmap()

    val pageInfo = PdfDocument.PageInfo.Builder(bitmap.width, bitmap.height, 1).create()
    val page = pdfDocument.startPage(pageInfo)
    page.canvas.drawBitmap(bitmap, 0f, 0f, null)

    pdfDocument.finishPage(page)

    val filePath = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
        fileName
    )

    try {
        FileOutputStream(filePath).use {
            pdfDocument.writeTo(it)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        pdfDocument.close()
    }
}
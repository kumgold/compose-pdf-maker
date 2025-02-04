package com.gold.pdfmaker.pdf

import android.graphics.Bitmap
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.drawToBitmap
import java.io.ByteArrayOutputStream
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

private fun scaledBitmap(originalBitmap: Bitmap): Bitmap {
    val width = originalBitmap.width
    val height = originalBitmap.height

    val ratio = Math.min(900.toFloat() / width, 1600.toFloat() / height)

    val newWidth = (width * ratio).toInt()
    val newHeight = (height * ratio).toInt()

    // Bitmap 크기 조정
    val resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true)

    return resizedBitmap
}

private fun resizeAndConvertToByteArray(
    originalBitmap: Bitmap,
    maxWidth: Int,
    maxHeight: Int
): ByteArray {
    val width = originalBitmap.width
    val height = originalBitmap.height

    // 비율 계산
    val ratio = Math.min(maxWidth.toFloat() / width, maxHeight.toFloat() / height)

    // 새로운 크기 계산
    val newWidth = (width * ratio).toInt()
    val newHeight = (height * ratio).toInt()

    // Bitmap 크기 조정
    val resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true)

    // ByteArray로 변환
    val byteArrayOutputStream = ByteArrayOutputStream()
    resizedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream) // JPEG 압축 사용
    val byteArray = byteArrayOutputStream.toByteArray()

    // 메모리 해제
    resizedBitmap.recycle()

    return byteArray
}
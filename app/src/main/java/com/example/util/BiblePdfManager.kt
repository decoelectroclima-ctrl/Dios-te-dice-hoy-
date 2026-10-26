package com.example.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import com.example.data.BibleData
import java.io.File
import java.io.FileOutputStream

object BiblePdfManager {

  private const val PDF_FILENAME = "sagrada_biblia_catolica.pdf"
  private const val PAGE_WIDTH = 595 // A4 standard width in points
  private const val PAGE_HEIGHT = 842 // A4 standard height in points
  private const val MARGIN = 48

  data class BookPageEntry(
    val book: String,
    val testament: String,
    val pageNumber: Int
  )

  // Cache in-memory page texts for immediate Text-To-Speech read-out
  private val pageTexts = mutableListOf<String>()
  private val tableOfContents = mutableListOf<BookPageEntry>()

  fun getBiblePdfFile(context: Context, version: String = "JERUSALEN"): File {
    val cleanVersion = version.lowercase().replace(" ", "_")
    return File(context.filesDir, "sagrada_biblia_$cleanVersion.pdf")
  }

  fun ensureBiblePdfExists(context: Context, version: String = "JERUSALEN"): File {
    val file = getBiblePdfFile(context, version)
    if (!file.exists() || file.length() < 1000) {
      generateBiblePdf(context, version)
    } else if (pageTexts.isEmpty()) {
      buildPageTextsInMemory(version)
    }
    return file
  }

  fun getTableOfContents(context: Context, version: String = "JERUSALEN"): List<BookPageEntry> {
    if (tableOfContents.isEmpty()) {
      ensureBiblePdfExists(context, version)
    }
    return tableOfContents
  }

  fun getPageText(pageIndex: Int): String {
    if (pageTexts.isEmpty()) {
      buildPageTextsInMemory()
    }
    return if (pageIndex in pageTexts.indices) {
      pageTexts[pageIndex]
    } else {
      "Página de la Sagrada Escritura"
    }
  }

  fun getTotalPages(context: Context, version: String = "JERUSALEN"): Int {
    ensureBiblePdfExists(context, version)
    return pageTexts.size.coerceAtLeast(1)
  }

  private fun buildPageTextsInMemory(version: String = "JERUSALEN") {
    pageTexts.clear()
    tableOfContents.clear()

    val vInfo = BibleData.getVersionInfo(version)

    // Page 1: Cover
    pageTexts.add("Sagrada Biblia Católica. Versión ${vInfo.name}. Antiguo y Nuevo Testamento. Lámpara es tu palabra para mis pasos, y una luz en mi camino.")
    // Page 2: Table of Contents
    pageTexts.add("Índice General de la Sagrada Biblia (${vInfo.name}). Libros del Antiguo y del Nuevo Testamento con los pasajes fundamentales de salvación.")

    // Chapter pages
    var currentPage = 3
    var lastBook = ""
    BibleData.chapters.forEach { ch ->
      if (ch.book != lastBook) {
        tableOfContents.add(BookPageEntry(ch.book, ch.testament, currentPage))
        lastBook = ch.book
      }

      val sb = java.lang.StringBuilder()
      sb.append("${ch.book}, capítulo ${ch.chapter}. ${ch.title}. Versión ${vInfo.shortName}. ")
      ch.verses.forEach { (num, text) ->
        sb.append("Versículo $num: $text ")
      }
      pageTexts.add(sb.toString())
      currentPage++
    }
  }

  fun generateBiblePdf(context: Context, version: String = "JERUSALEN"): File {
    buildPageTextsInMemory(version)
    val vInfo = BibleData.getVersionInfo(version)
    val document = PdfDocument()

    val paint = Paint().apply { isAntiAlias = true }
    val textPaint = TextPaint().apply {
      isAntiAlias = true
      textSize = 12f
      color = Color.rgb(35, 30, 30)
    }

    // --- PÁGINA 1: PORTADA SOLEMNE ---
    var pageInfo = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, 1).create()
    var page = document.startPage(pageInfo)
    var canvas = page.canvas

    // Warm parchment background
    canvas.drawColor(Color.rgb(253, 250, 244))

    // Decorative border
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 2f
    paint.color = Color.rgb(173, 39, 55) // Wine primary
    canvas.drawRect(MARGIN.toFloat(), MARGIN.toFloat(), (PAGE_WIDTH - MARGIN).toFloat(), (PAGE_HEIGHT - MARGIN).toFloat(), paint)

    paint.strokeWidth = 0.8f
    paint.color = Color.rgb(158, 120, 27) // Gold secondary
    canvas.drawRect((MARGIN + 5).toFloat(), (MARGIN + 5).toFloat(), (PAGE_WIDTH - MARGIN - 5).toFloat(), (PAGE_HEIGHT - MARGIN - 5).toFloat(), paint)

    // Gold Cross
    paint.style = Paint.Style.FILL
    paint.color = Color.rgb(158, 120, 27)
    paint.textSize = 46f
    paint.textAlign = Paint.Align.CENTER
    paint.typeface = Typeface.DEFAULT_BOLD
    canvas.drawText("✝", (PAGE_WIDTH / 2).toFloat(), 210f, paint)

    // Title
    paint.color = Color.rgb(173, 39, 55)
    paint.textSize = 28f
    paint.typeface = Typeface.SERIF
    canvas.drawText("SAGRADA BIBLIA", (PAGE_WIDTH / 2).toFloat(), 270f, paint)

    paint.textSize = 16f
    paint.color = Color.rgb(70, 30, 35)
    canvas.drawText(vInfo.name.uppercase(), (PAGE_WIDTH / 2).toFloat(), 305f, paint)

    paint.textSize = 12f
    paint.color = Color.rgb(120, 70, 30)
    canvas.drawText(vInfo.yearOrTradition, (PAGE_WIDTH / 2).toFloat(), 324f, paint)

    // Divider line
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 1.2f
    paint.color = Color.rgb(158, 120, 27)
    canvas.drawLine(150f, 340f, (PAGE_WIDTH - 150).toFloat(), 340f, paint)

    // Subtitle & Biblical motto
    paint.style = Paint.Style.FILL
    paint.textSize = 13f
    paint.typeface = Typeface.create(Typeface.SERIF, Typeface.ITALIC)
    paint.color = Color.rgb(85, 75, 75)
    canvas.drawText("«Lámpara es tu palabra para mis pasos,", (PAGE_WIDTH / 2).toFloat(), 400f, paint)
    canvas.drawText("y una luz en mi camino»", (PAGE_WIDTH / 2).toFloat(), 422f, paint)
    paint.textSize = 11f
    paint.typeface = Typeface.create(Typeface.SERIF, Typeface.NORMAL)
    canvas.drawText("(Salmo 119:105)", (PAGE_WIDTH / 2).toFloat(), 442f, paint)

    // Features notice
    paint.textSize = 12f
    paint.color = Color.rgb(110, 30, 40)
    paint.typeface = Typeface.DEFAULT_BOLD
    canvas.drawText("Antiguo y Nuevo Testamento", (PAGE_WIDTH / 2).toFloat(), 550f, paint)
    paint.textSize = 11f
    paint.typeface = Typeface.DEFAULT
    paint.color = Color.rgb(100, 90, 90)
    canvas.drawText("Con modo de lectura física y Voz Viva (Audiolibro)", (PAGE_WIDTH / 2).toFloat(), 575f, paint)

    // Publisher footer
    paint.textSize = 11f
    paint.typeface = Typeface.SERIF
    paint.color = Color.rgb(140, 110, 40)
    canvas.drawText("Dios Te Dice Hoy • Aplicación Católica", (PAGE_WIDTH / 2).toFloat(), (PAGE_HEIGHT - 80).toFloat(), paint)

    document.finishPage(page)

    // --- PÁGINA 2: ÍNDICE GENERAL ---
    pageInfo = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, 2).create()
    page = document.startPage(pageInfo)
    canvas = page.canvas
    canvas.drawColor(Color.rgb(255, 253, 249))

    // Top Header
    paint.color = Color.rgb(173, 39, 55)
    paint.textSize = 20f
    paint.textAlign = Paint.Align.CENTER
    paint.typeface = Typeface.SERIF
    canvas.drawText("ÍNDICE DE LIBROS SAGRADOS", (PAGE_WIDTH / 2).toFloat(), 70f, paint)

    paint.color = Color.rgb(158, 120, 27)
    canvas.drawLine(MARGIN.toFloat(), 85f, (PAGE_WIDTH - MARGIN).toFloat(), 85f, paint)

    // Table of contents rows
    var yPos = 120f
    var currentTestament = ""
    tableOfContents.forEach { entry ->
      if (entry.testament != currentTestament) {
        currentTestament = entry.testament
        yPos += 14f
        paint.color = Color.rgb(173, 39, 55)
        paint.textSize = 14f
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(currentTestament.uppercase(), MARGIN.toFloat(), yPos, paint)
        yPos += 18f
      }

      paint.color = Color.rgb(40, 35, 35)
      paint.textSize = 12f
      paint.typeface = Typeface.SERIF
      paint.textAlign = Paint.Align.LEFT
      canvas.drawText("• ${entry.book}", (MARGIN + 12).toFloat(), yPos, paint)

      paint.textAlign = Paint.Align.RIGHT
      paint.color = Color.rgb(158, 120, 27)
      canvas.drawText("Página ${entry.pageNumber}", (PAGE_WIDTH - MARGIN).toFloat(), yPos, paint)

      // Dotted line
      paint.color = Color.rgb(215, 205, 195)
      paint.style = Paint.Style.STROKE
      paint.strokeWidth = 0.5f
      canvas.drawLine((MARGIN + 150).toFloat(), yPos - 3, (PAGE_WIDTH - MARGIN - 65).toFloat(), yPos - 3, paint)
      paint.style = Paint.Style.FILL

      yPos += 24f
    }

    // Page footer
    paint.textAlign = Paint.Align.CENTER
    paint.color = Color.rgb(130, 120, 120)
    paint.textSize = 10f
    canvas.drawText("— Página 2 —", (PAGE_WIDTH / 2).toFloat(), (PAGE_HEIGHT - 35).toFloat(), paint)
    document.finishPage(page)

    // --- PÁGINAS DE CONTENIDO BÍBLICO (Páginas 3 en adelante) ---
    var pageNumber = 3
    BibleData.chapters.forEach { ch ->
      pageInfo = PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, pageNumber).create()
      page = document.startPage(pageInfo)
      canvas = page.canvas

      // Subtle book-paper background
      canvas.drawColor(Color.rgb(255, 254, 251))

      // Running Top Header
      paint.color = Color.rgb(173, 39, 55)
      paint.textSize = 10f
      paint.typeface = Typeface.DEFAULT_BOLD
      paint.textAlign = Paint.Align.LEFT
      canvas.drawText(ch.testament.uppercase(), MARGIN.toFloat(), 40f, paint)

      paint.textAlign = Paint.Align.RIGHT
      paint.color = Color.rgb(158, 120, 27)
      canvas.drawText("${ch.book.uppercase()} ${ch.chapter}", (PAGE_WIDTH - MARGIN).toFloat(), 40f, paint)

      paint.style = Paint.Style.STROKE
      paint.strokeWidth = 0.8f
      paint.color = Color.rgb(220, 210, 200)
      canvas.drawLine(MARGIN.toFloat(), 48f, (PAGE_WIDTH - MARGIN).toFloat(), 48f, paint)
      paint.style = Paint.Style.FILL

      // Book Title and Chapter Header
      var contentY = 80f
      paint.textAlign = Paint.Align.CENTER
      paint.color = Color.rgb(173, 39, 55)
      paint.textSize = 22f
      paint.typeface = Typeface.SERIF
      canvas.drawText(ch.book, (PAGE_WIDTH / 2).toFloat(), contentY, paint)

      contentY += 22f
      paint.color = Color.rgb(100, 80, 40)
      paint.textSize = 13f
      paint.typeface = Typeface.DEFAULT_BOLD
      canvas.drawText("Capítulo ${ch.chapter} • ${ch.title}", (PAGE_WIDTH / 2).toFloat(), contentY, paint)

      contentY += 12f
      paint.strokeWidth = 0.5f
      paint.color = Color.rgb(158, 120, 27)
      paint.style = Paint.Style.STROKE
      canvas.drawLine(200f, contentY, (PAGE_WIDTH - 200).toFloat(), contentY, paint)
      paint.style = Paint.Style.FILL

      contentY += 30f

      // Render verses with text wrapping
      val contentWidth = PAGE_WIDTH - (MARGIN * 2)
      ch.verses.forEach { (vNum, text) ->
        val verseText = "$vNum. $text"
        val staticLayout = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
          StaticLayout.Builder.obtain(verseText, 0, verseText.length, textPaint, contentWidth)
            .setAlignment(Layout.Alignment.ALIGN_NORMAL)
            .setLineSpacing(3f, 1.15f)
            .setIncludePad(false)
            .build()
        } else {
          @Suppress("DEPRECATION")
          StaticLayout(verseText, textPaint, contentWidth, Layout.Alignment.ALIGN_NORMAL, 1.15f, 3f, false)
        }

        canvas.save()
        canvas.translate(MARGIN.toFloat(), contentY)
        staticLayout.draw(canvas)
        canvas.restore()

        contentY += staticLayout.height + 12f
      }

      // Bottom Running Footer
      paint.textAlign = Paint.Align.CENTER
      paint.color = Color.rgb(130, 120, 120)
      paint.textSize = 10f
      paint.typeface = Typeface.SERIF
      canvas.drawText("— Página $pageNumber de ${pageTexts.size} —", (PAGE_WIDTH / 2).toFloat(), (PAGE_HEIGHT - 35).toFloat(), paint)

      document.finishPage(page)
      pageNumber++
    }

    val outputFile = getBiblePdfFile(context)
    val fos = FileOutputStream(outputFile)
    document.writeTo(fos)
    fos.flush()
    fos.close()
    document.close()

    return outputFile
  }
}

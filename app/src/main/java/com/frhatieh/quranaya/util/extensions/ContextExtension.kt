package com.frhatieh.quranaya.util.extensions

import android.content.Context
import android.content.Intent

fun Context.shareVerse(text: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, text)
    startActivity(Intent.createChooser(intent, "Ayah"))
}
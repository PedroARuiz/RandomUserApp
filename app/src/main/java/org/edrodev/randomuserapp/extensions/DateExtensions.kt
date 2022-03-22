package org.edrodev.randomuserapp.extensions

import java.text.SimpleDateFormat
import java.util.*

const val DD_MM_YYYY = "dd/MM/yyyy"

fun Date.format(pattern: String = DD_MM_YYYY): String =
    SimpleDateFormat(pattern, Locale.getDefault()).format(this)
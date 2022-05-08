package com.dandelion.gamereco.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getDateFromUnixTime(unixTime: Long): String? = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(unixTime * 1000))

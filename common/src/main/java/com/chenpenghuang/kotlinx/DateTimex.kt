package com.chenpenghuang.kotlinx

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author ChenPengHuang.
 * @date 2019/1/18.
 */
fun Long.formatToDate(pattern:String): String{
    val simpleDateFormat = SimpleDateFormat(pattern , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}


fun Long.yyyyMMddHHmmss(): String{
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.yyyyMMddHHmm(): String{
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.HHmmss(): String{
    val simpleDateFormat = SimpleDateFormat("HH:mm:ss" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.HHmm(): String{
    val simpleDateFormat = SimpleDateFormat("HH:mm" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.mmss(): String{
    val simpleDateFormat = SimpleDateFormat("mm:ss" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.yyyyMMdd(): String{
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.MMdd(): String{
    val simpleDateFormat = SimpleDateFormat("MM-dd" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.dd(): String{
    val simpleDateFormat = SimpleDateFormat("dd" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun Long.yyyyMM(): String{
    val simpleDateFormat = SimpleDateFormat("yyyy-MM" , Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun String.getTimestamp(pattern:String) : Long{
    val simpleDateFormat = SimpleDateFormat(pattern , Locale.getDefault())

    try {
        return simpleDateFormat.parse(this).time
    }catch (e: Exception){
        e.printStackTrace()
    }
    return System.currentTimeMillis()
}


/**
 * 计算相隔时间。一般计算相隔时间，要把时区设置成0
 * 默认格式化成HH:mm:ss
 * */
fun Long.intervalTime(otherTime:Long ,pattern:String = "HH:mm:ss") : String{
    val interval = Math.abs(this - otherTime)
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT+0")
    return simpleDateFormat.format(Date(interval))
}

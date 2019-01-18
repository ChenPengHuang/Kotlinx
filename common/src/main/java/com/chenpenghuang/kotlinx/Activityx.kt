package com.chenpenghuang.kotlinx

import android.app.Activity

/**
 * @author ChenPengHuang.
 * @date 2019/1/18.
 */
fun Activity.getStatusBarHeight(): Int{
    var statusBarHeight = 0
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        statusBarHeight = this.resources.getDimensionPixelSize(resourceId)
    }
    return statusBarHeight
}
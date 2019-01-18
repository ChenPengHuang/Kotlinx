package com.chenpenghuang.kotlinx

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import org.jetbrains.anko.internals.AnkoInternals

/**
 * @author ChenPengHuang.
 * @date 2019/1/18.
 */

inline fun <reified T: Activity> Fragment.startActivity(vararg params: Pair<String, Any?>) =
    AnkoInternals.internalStartActivity(activity!!, T::class.java, params)

inline fun <reified T: Activity> Fragment.startActivityForResult(requestCode: Int, vararg params: Pair<String, Any?>) =
    startActivityForResult(AnkoInternals.createIntent(activity!!, T::class.java, params), requestCode)

inline fun <reified T: Any> Fragment.intentFor(vararg params: Pair<String, Any?>): Intent =
    AnkoInternals.createIntent(activity!!, T::class.java, params)


fun Fragment.getStatusBarHeight(): Int{
    var statusBarHeight = 0
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        statusBarHeight = this.resources.getDimensionPixelSize(resourceId)
    }
    return statusBarHeight
}
package com.chenpenghuang.kotlinx

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * @author ChenPengHuang.
 * @date 2019/1/18.
 */
private var oldMessage: String = ""
private var time: Long = 0


fun Context.safeLongToast(message:String?) = showToast(this , message , Toast.LENGTH_LONG)
fun Context.safeLongToast(@StringRes stringRes:Int?) = showToast(this ,
    if(stringRes == null) "" else resources.getString(stringRes), Toast.LENGTH_LONG)
fun Context.safeShortToast(message:String?) = showToast(this , message , Toast.LENGTH_SHORT)
fun Context.safeShortToast(@StringRes stringRes:Int?) = showToast(this ,
    if(stringRes == null) "" else resources.getString(stringRes), Toast.LENGTH_SHORT)


fun Fragment.safeLongToast(message:String?) = showToast(this.activity , message , Toast.LENGTH_LONG)
fun Fragment.safeShortToast(message:String?) =showToast(this.activity , message , Toast.LENGTH_SHORT)

fun Fragment.safeLongToast(@StringRes stringRes:Int?) = showToast(this.activity ,
    if(stringRes == null) "" else resources.getString(stringRes) , Toast.LENGTH_LONG)
fun Fragment.safeShortToast(@StringRes stringRes:Int?) =showToast(this.activity ,
    if(stringRes == null) "" else resources.getString(stringRes) , Toast.LENGTH_SHORT)




private fun showToast(context: Context?, message:String?, duration:Int){

    if(context == null){
        return
    }
    if(message.isNullOrBlank()){
        return
    }

    if(context is LifecycleOwner && context.lifecycle.currentState == Lifecycle.State.DESTROYED){
        return
    }

    if (message != oldMessage) {
        Toast.makeText(context, message, duration).show()
        time = System.currentTimeMillis()
    } else {
        if (System.currentTimeMillis() - time > 3000) {
            Toast.makeText(context, message, duration).show()
            time = System.currentTimeMillis()
        }
    }
    oldMessage = message
}
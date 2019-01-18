package com.chenpenghuang.kotlinx

import android.view.View

/**
 * @author ChenPengHuang.
 * @date 2019/1/18.
 */
/**
 *  扩展属性 延时触发  即多少时间内重复点击无反应
 */
private var <T : View> T.triggerDelay: Long
    get() = if (getTag(1123461123) != null) getTag(1123461123) as Long else -1
    set(value) {
        setTag(1123461123, value)
    }
/**
 *  扩展属性 上次点击事件时间
 */
private var <T : View> T.triggerLastTime: Long
    get() = if (getTag(1123460103) != null) getTag(1123460103) as Long else 0
    set(value) {
        setTag(1123460103, value)
    }

/**
 * 私有扩展方法 计算是否过了延时期
 */
private fun <T : View> T.delayOver(): Boolean {
    var flag = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - triggerLastTime >= triggerDelay) {
        triggerLastTime = currentClickTime
        flag = true
    }
    return flag
}

//默认600ms内，重复点击不处理
fun <T : View> T.clickWithTrigger(time: Long = 600, block: (T) -> Unit) {
    triggerDelay = time
    setOnClickListener {
        if (delayOver()) {
            block(it as T)
        }
    }
}
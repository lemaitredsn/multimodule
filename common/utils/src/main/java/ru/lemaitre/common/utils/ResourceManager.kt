package ru.lemaitre.common.utils

import android.content.Context
import javax.inject.Inject

class ResourceManager @Inject constructor(private val context: Context) {

    fun getDrawable(resourceId: Int) = context.getDrawable(resourceId)
}
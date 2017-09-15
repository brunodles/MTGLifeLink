package com.brunodles.mtglifelink

import android.content.Context
import android.util.TypedValue

public fun Context.dp(size: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, getResources().getDisplayMetrics())
}
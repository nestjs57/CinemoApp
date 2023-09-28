package com.arnoract.cinemoapp.core.util

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.setValueIfNew(newValue: T) {
    if (this.value != newValue) this.value = newValue
}

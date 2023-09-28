package com.arnoract.cinemoapp.core.base

interface Mapper<in From, out To> {
    fun map(from: From): To
}
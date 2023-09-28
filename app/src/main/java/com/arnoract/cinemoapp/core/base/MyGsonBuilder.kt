package com.arnoract.cinemoapp.core.base

import com.google.gson.*
import com.google.gson.internal.bind.util.ISO8601Utils
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.lang.reflect.Type
import java.text.NumberFormat
import java.text.ParseException
import java.text.ParsePosition
import java.util.*

class MyGsonBuilder {
    fun build(): Gson {
        val b = GsonBuilder()
        b.serializeNulls()
        b.registerTypeAdapter(Date::class.java, DateDeserializer())
        b.registerTypeAdapter(Int::class.javaObjectType, IntObjectTypeAdapter())
        b.registerTypeAdapter(Int::class.javaPrimitiveType, IntPrimitiveDeserializer())
        b.registerTypeAdapter(Long::class.javaObjectType, LongObjectTypeAdapter())
        b.registerTypeAdapter(Long::class.javaPrimitiveType, LongPrimitiveDeserializer())
        b.registerTypeAdapter(Double::class.javaObjectType, DoubleObjectTypeAdapter())
        b.registerTypeAdapter(Double::class.javaPrimitiveType, DoublePrimitiveDeserializer())
        b.registerTypeAdapter(String::class.java, StringTypeAdapter())
        return b.create()
    }
}

private class DateDeserializer : JsonDeserializer<Date> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Date? {
        return if (json != null && !json.asString.isNullOrBlank()) {
            try {
                ISO8601Utils.parse(json.asString, ParsePosition(0))
            } catch (e: ParseException) {
                null
            }
        } else {
            null
        }
    }
}

class IntObjectTypeAdapter : TypeAdapter<Int?>() {
    override fun write(
        out: JsonWriter,
        value: Int?
    ) {
        out.value(value ?: 0)
    }

    override fun read(reader: JsonReader): Int? {
        if (reader.peek() === JsonToken.NULL) {
            reader.nextNull()
            return null
        }
        return try {
            NumberFormat.getInstance().parse(reader.nextString())?.toInt()
        } catch (e: ParseException) {
            null
        }
    }
}

class IntPrimitiveDeserializer : JsonDeserializer<Int> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Int {
        return if (json != null && !json.asString.isNullOrBlank()) {
            try {
                NumberFormat.getInstance().parse(json.asString)?.toInt() ?: 0
            } catch (e: ParseException) {
                0
            }
        } else {
            0
        }
    }
}

class LongObjectTypeAdapter : TypeAdapter<Long?>() {
    override fun write(
        out: JsonWriter,
        value: Long?
    ) {
        out.value(value ?: 0L)
    }

    override fun read(reader: JsonReader): Long? {
        if (reader.peek() === JsonToken.NULL) {
            reader.nextNull()
            return null
        }
        return try {
            NumberFormat.getInstance().parse(reader.nextString())?.toLong()
        } catch (e: ParseException) {
            null
        }
    }
}

class LongPrimitiveDeserializer : JsonDeserializer<Long> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Long {
        return if (json != null && !json.asString.isNullOrBlank()) {
            try {
                NumberFormat.getInstance().parse(json.asString)?.toLong() ?: 0L
            } catch (e: ParseException) {
                0L
            }
        } else {
            0L
        }
    }
}

private class DoubleObjectTypeAdapter : TypeAdapter<Double?>() {
    override fun write(
        out: JsonWriter,
        value: Double?
    ) {
        out.value(value ?: 0.0)
    }

    override fun read(reader: JsonReader): Double? {
        if (reader.peek() === JsonToken.NULL) {
            reader.nextNull()
            return null
        }
        return try {
            NumberFormat.getInstance().parse(reader.nextString())?.toDouble()
        } catch (e: ParseException) {
            null
        }
    }
}

private class DoublePrimitiveDeserializer : JsonDeserializer<Double> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Double {
        return if (json != null && !json.asString.isNullOrBlank()) {
            try {
                NumberFormat.getInstance().parse(json.asString)?.toDouble() ?: 0.0
            } catch (e: ParseException) {
                0.0
            }
        } else {
            0.0
        }
    }
}

private class StringTypeAdapter : TypeAdapter<String?>() {
    override fun write(
        out: JsonWriter,
        value: String?
    ) {
        out.value(value ?: "")
    }

    override fun read(reader: JsonReader): String? {
        if (reader.peek() === JsonToken.NULL) {
            reader.nextNull()
            return null
        }
        return reader.nextString()
    }
}
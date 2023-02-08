package de.masterthesis.shared

import java.util.*

actual fun randomUUID(): String =
    UUID.randomUUID().toString()


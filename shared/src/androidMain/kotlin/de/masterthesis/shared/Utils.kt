package de.masterthesis.shared

import java.util.UUID

actual fun randomUUID(): String =
    UUID.randomUUID().toString()



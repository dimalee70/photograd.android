package com.example.photograd.android.base.models

import photograd.kz.photograd.models.enums.SocketEventType

/**
 * Created by wokrey@gmail.com on 8/19/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */
class SocketBusEvent<T>(
    val value: T,
    val object_id: Int? = null,
    val field_name: String? = null,
    val field_value: String? = null,
    val type: SocketEventType
)
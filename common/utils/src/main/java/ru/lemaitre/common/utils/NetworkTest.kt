package ru.lemaitre.common.utils

sealed class NetworkTest {
    object OK: NetworkTest()
    object CLOSED: NetworkTest()
}
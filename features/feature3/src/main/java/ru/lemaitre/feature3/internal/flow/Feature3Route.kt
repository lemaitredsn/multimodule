package ru.lemaitre.feature3.internal.flow

internal sealed class Feature3Route {
    object List: Feature3Route()
    data class Success(val title: String, val descriptions: String, val button: String): Feature3Route()
    object Chat : Feature3Route()
}
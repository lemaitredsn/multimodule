package ru.lemaitre.common.utils

import dagger.MapKey
import ru.lemaitre.common.utils.Dependencies
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out ru.lemaitre.common.utils.Dependencies>)

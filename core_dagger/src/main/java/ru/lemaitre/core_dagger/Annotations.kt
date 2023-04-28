package ru.lemaitre.core_dagger

import dagger.MapKey
import ru.lemaitre.mymultymodule.core.Dependencies
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out Dependencies>)

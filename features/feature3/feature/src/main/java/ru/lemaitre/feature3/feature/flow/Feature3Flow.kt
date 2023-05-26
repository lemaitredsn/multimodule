package ru.lemaitre.feature3.feature.flow

import io.reactivex.subjects.BehaviorSubject
import ru.lemaitre.feature3.feature.di.Feature3Scope
import javax.inject.Inject

@Feature3Scope
internal class Feature3Flow @Inject constructor() {

    private val navigationIn =
        BehaviorSubject.createDefault<Feature3Route>(Feature3Route.List)

    fun navigation() = navigationIn

    fun toSuccessResult(title: String, descriptions: String, button: String) =
        navigationIn.onNext(Feature3Route.Success(title, descriptions, button))

    fun toChat() = navigationIn.onNext(Feature3Route.Chat)
}
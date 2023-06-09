package ru.lemaitre.account_details.data

import io.reactivex.Single
import java.time.LocalDateTime
import java.util.Calendar
import javax.inject.Inject
import kotlin.random.Random

class HistoryApi @Inject constructor() {

    fun loadHistory(): Single<List<HistoryModelApi>> {
        return Single.just(
            listOf(
                HistoryModelApi(getDate(), "p", "123.50"),
                HistoryModelApi(getDate(), "s", "1231233.53"),
                HistoryModelApi(getDate(), "p", "543.51"),
                HistoryModelApi(getDate(), "s", "653"),
                HistoryModelApi(getDate(), "p", "643.21"),
            )
        )
    }

    private fun getDate() = "${Random.nextInt(28)}-${Random.nextInt(12)}${Random.nextInt(2020, 2022)}"
}
package ru.lemaitre.feature3.internal.flow

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.shared.ui.BasePresenter
import javax.inject.Inject

class Feature3FlowPresenter @Inject constructor(
    private val flow: Feature3Flow,
) : BasePresenter<Feature3FlowView>() {

    override fun onFirstViewAttach() {
        flow
            .navigation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.navigate(it)
                }, {
                    Log.e("TAG", "Crash navigation ${it.localizedMessage}")
                }
            )
            .untilDestroy()

    }
}
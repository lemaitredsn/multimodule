package ru.lemaitre.products.flow

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

internal class ProductsFlowPresenter @Inject constructor(
    private val flow: ProductsFlow,
) : ru.lemaitre.architecture.BasePresenter<ProductsFlowView>() {

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
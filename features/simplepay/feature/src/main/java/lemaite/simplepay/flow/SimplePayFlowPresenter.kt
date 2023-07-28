package lemaite.simplepay.flow

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.lemaitre.architecture.BasePresenter
import javax.inject.Inject

class SimplePayFlowPresenter @Inject constructor(
    private val flow: SimplePayFlow
) : BasePresenter<SimplePayFlowView>() {

    override fun onFirstViewAttach() {
        flow.navigation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { it ->
                    viewState.navigate(it)
                },
                { Log.e("TAG", "${it.printStackTrace()}") }
            )
            .untilDestroy()
    }

}
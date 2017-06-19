package jp.cordea.rxlifecycledemo

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

/**
 * Created by Yoshihiro Tanaka on 2017/06/14.
 */
class MainPresenter(provider: LifecycleProvider<ActivityEvent>)
    : BasePresenter<MainViewModel>(provider) {

    override val viewModel: MainViewModel = MainViewModel()

    override fun onStart() {
        super.onStart()
        if (viewModel.isChecked) {
            subscribeWithRxLifecycle()
        } else {
            subscribe()
        }
    }

    override fun onStop() {
        super.onStop()
    }

    private fun subscribeWithRxLifecycle() {
        viewModel.count += 1
        observable
                .bindUntilEvent(ActivityEvent.STOP)
                .subscribe({
                    viewModel.text = it
                }, {
                    it.printStackTrace()
                }, {
                    viewModel.text = ""
                    viewModel.count -= 1
                })
    }

    private fun subscribe() {
        viewModel.count += 1
        observable
                .subscribe({
                    viewModel.text = it
                }, {
                    it.printStackTrace()
                }, {
                    viewModel.text = ""
                    viewModel.count -= 1
                })
    }

    private val observable =
            Observable
                    .fromIterable(1..11)
                    .zipWith(Observable.interval(1, TimeUnit.SECONDS),
                            BiFunction<Int, Long, Int> { t1, _ -> t1})
                    .map { it.toString() }
}

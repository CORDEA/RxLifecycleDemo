package jp.cordea.rxlifecycledemo

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.Observable

/**
 * Created by Yoshihiro Tanaka on 2017/06/14.
 */
abstract class BasePresenter<out T>(private val provider: LifecycleProvider<ActivityEvent>) {

    abstract val viewModel: T

    open fun onStart() {
    }

    open fun onStop() {
    }

    fun <T> Observable<T>.bindToLifecycle(): Observable<T> {
        return this.bindToLifecycle(provider)
    }

    fun <T> Observable<T>.bindUntilEvent(event: ActivityEvent): Observable<T> {
        return this.bindUntilEvent(provider, event)
    }
}

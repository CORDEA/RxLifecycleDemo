package jp.cordea.rxlifecycledemo

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.annotation.StringRes

/**
 * Created by Yoshihiro Tanaka on 2017/06/14.
 */
class MainViewModel : BaseObservable() {

    @Bindable
    @StringRes
    var title = R.string.main_state_no_lifecycle
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var text = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.text)
        }

    @Bindable
    var count = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.count)
        }

    @Bindable
    var isChecked = false
        set(value) {
            field = value
            title = if (value) R.string.main_state_with_lifecycle else R.string.main_state_no_lifecycle
        }

}

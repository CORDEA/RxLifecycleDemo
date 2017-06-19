package jp.cordea.rxlifecycledemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import jp.cordea.rxlifecycledemo.databinding.ActivityMainBinding

class MainActivity : RxAppCompatActivity() {

    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.pr = presenter
        binding.vm = presenter.viewModel

        setSupportActionBar(binding.toolbar)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}


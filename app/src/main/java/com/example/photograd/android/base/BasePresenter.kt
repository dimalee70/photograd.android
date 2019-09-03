package photograd.kz.photograd.presentation.presenter

import com.example.photograd.android.base.BaseView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter

/**
 * Created by wokrey@gmail.com on 7/4/19.
 * It's not wokrey, if the code smells bad. Somebody set me up.
 */

 abstract class BasePresenter<T: BaseView>(
    val disposables: CompositeDisposable = CompositeDisposable(),
    val background: Scheduler = Schedulers.io(),
    val mainThread: Scheduler = AndroidSchedulers.mainThread()
): MvpPresenter<T>() {

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
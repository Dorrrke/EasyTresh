package com.example.easytresh.repository.server

import com.example.easytresh.repository.database.pojo.OrdersPojoItem
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ServerCommunicator(private val api: ServerApi) {

    companion object {
        private val DEFAULT_TIMEOUT = 10
        private val DEFAULT_RETRY_ATTEMPTS = 4L
    }

    private val compositeDisposable = CompositeDisposable()



    fun <T> singleTransformer(): SingleTransformer<T, T> = SingleTransformer {
        it.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .timeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .retry(DEFAULT_RETRY_ATTEMPTS)
    }


}
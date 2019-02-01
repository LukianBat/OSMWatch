package com.memebattle.osmwatch.core.domain.interactor

import android.annotation.SuppressLint
import com.memebattle.osmwatch.core.data.CashDao
import com.memebattle.osmwatch.core.domain.BaseCallback
import com.memebattle.osmwatch.core.domain.model.CashEntity
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.SingleOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RoomCashService(val dao: CashDao) {
    fun addCurrent(point: Float, zone: String) {
        Single.create(SingleOnSubscribe<Any> {
            dao.addCurrent(CashEntity(point, zone))
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Any> {

                    override fun onSuccess(t: Any) {

                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }
    fun getAllCurrents(baseCallback: BaseCallback<List<CashEntity>>){
        dao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableSingleObserver<List<CashEntity>>() {
                    override fun onError(e: Throwable) {
                        baseCallback.onError(e)
                    }
                    override fun onSuccess(t: List<CashEntity>) {
                        baseCallback.onSuccess(t)
                    }
                })
    }
}
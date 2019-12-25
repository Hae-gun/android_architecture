package com.nanamare.mac.sample.vm

import androidx.databinding.ObservableField
import com.nanamare.mac.sample.api.upbit.CoinModel
import com.nanamare.mac.sample.base.BaseViewModel
import com.nanamare.mac.sample.data.coin.CoinRepository
import io.reactivex.subjects.PublishSubject

class CoinViewModel: BaseViewModel() {

    var coins = ObservableField<List<CoinModel>>(mutableListOf())

    fun getCoins(ticketList: MutableList<String>) {
        isLoadingObservable.onNext(true)
        CoinRepository.getCoins(ticketList, success = {
            coins.set(it)
            isLoadingObservable.onNext(false)
        }, failed = {
            isLoadingObservable.onNext(false)
        })
    }

    override fun close() {
        CoinRepository.close()
    }

}
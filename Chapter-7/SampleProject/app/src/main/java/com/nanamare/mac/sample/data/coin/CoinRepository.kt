package com.nanamare.mac.sample.data.coin

import com.nanamare.mac.sample.api.upbit.CoinModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinRepository @Inject constructor(
    private val coinRemoteDataSource: CoinRemoteDataSource
): CoinSource {

    override fun getCoins(ticketList: MutableList<String>, success: (List<CoinModel>) -> Unit, failed: () -> Unit) {
        coinRemoteDataSource.getCoins(ticketList, success, failed)
    }

    override fun close() {
        coinRemoteDataSource.close()
    }

}
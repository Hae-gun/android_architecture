package com.nanamare.mac.sample.ui

import android.os.Bundle
import com.google.gson.Gson
import com.nanamare.mac.sample.R
import com.nanamare.mac.sample.base.BaseActivity
import com.nanamare.mac.sample.ui.market.MarketContract
import com.nanamare.mac.sample.ui.market.MarketListFragment
import com.nanamare.mac.sample.ui.market.MarketPresenter

class MainActivity : BaseActivity(R.layout.activity_main), MarketContract.MarketView {

    override val presenter: MarketPresenter
        get() = MarketPresenter(this)

    override fun showMarketList(marketMap: LinkedHashMap<String, List<String>>) {
        val bundle = Bundle().apply {
            putString(KET_MARKET_LIST, Gson().toJson(marketMap))
        }
        goToFragment(MarketListFragment::class.java, bundle)
    }

}
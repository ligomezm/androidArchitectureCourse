package com.ligomezm.offersandcoupons.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.ligomezm.offersandcoupons.model.Coupon
import com.ligomezm.offersandcoupons.R
import com.ligomezm.offersandcoupons.model.ApiAdapter
import com.ligomezm.offersandcoupons.presenter.CouponPresenter
import com.ligomezm.offersandcoupons.presenter.CouponPresenterImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        //VIEW
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
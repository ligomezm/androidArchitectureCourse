package com.ligomezm.offersandcoupons.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ligomezm.offersandcoupons.R
import com.ligomezm.offersandcoupons.databinding.ActivityMainBinding
import com.ligomezm.offersandcoupons.model.Coupon
import com.ligomezm.offersandcoupons.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity() {

    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProvider.NewInstanceFactory().create(CouponViewModel::class.java)
        activityMainBinding.model = couponViewModel
        setUpListUpdate()
    }

    fun setUpListUpdate() {
        couponViewModel?.callCoupons()
        couponViewModel?.getCoupons()?.observe(this, Observer { coupons: List<Coupon> ->
            Log.w("COUPON", coupons.get(0).title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
        setUpListClick()

    }

    private fun setUpListClick() {
        couponViewModel?.getCouponSelected()?.observe(this, Observer { coupon: Coupon ->
            Log.i("CLICK", coupon.title)
        })
    }
}
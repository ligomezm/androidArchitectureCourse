package com.ligomezm.offersandcoupons.presenter

import com.ligomezm.offersandcoupons.model.Coupon

interface CouponPresenter {
    fun showCoupons(coupons: ArrayList<Coupon>?)

    fun getCoupons()
}
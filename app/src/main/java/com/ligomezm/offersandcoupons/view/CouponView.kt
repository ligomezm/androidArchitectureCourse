package com.ligomezm.offersandcoupons.view

import com.ligomezm.offersandcoupons.model.Coupon

interface CouponView {
    fun getCoupons()
    fun showCoupons(coupons: ArrayList<Coupon>?)
}
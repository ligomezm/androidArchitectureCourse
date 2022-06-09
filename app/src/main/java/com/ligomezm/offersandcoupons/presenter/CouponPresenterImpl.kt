package com.ligomezm.offersandcoupons.presenter

import com.ligomezm.offersandcoupons.model.Coupon
import com.ligomezm.offersandcoupons.model.CouponsInteractor
import com.ligomezm.offersandcoupons.model.CouponsInteractorImpl
import com.ligomezm.offersandcoupons.view.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponsInteractor = CouponsInteractorImpl(this)
    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}
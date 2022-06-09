package com.ligomezm.offersandcoupons.model

import com.ligomezm.offersandcoupons.presenter.CouponPresenter

class CouponsInteractorImpl(var couponPresenter: CouponPresenter): CouponsInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}
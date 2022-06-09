package com.ligomezm.offersandcoupons.viewmodel

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ligomezm.offersandcoupons.R
import com.ligomezm.offersandcoupons.model.Coupon
import com.ligomezm.offersandcoupons.model.CouponObservable
import com.ligomezm.offersandcoupons.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel : ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null
    var selected: MutableLiveData<Coupon> = MutableLiveData<Coupon>()

    fun callCoupons() {
        couponObservable.callCoupons()
    }

    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter?.setCouponsList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter? {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position: Int): Coupon? {
        var coupons: List<Coupon>? = couponObservable.getCoupons().value
        return coupons?.get(position)
    }


    fun getCouponSelected(): MutableLiveData<Coupon> {
        return selected
    }

    fun onItemClick(index: Int) {
        val coupon = getCouponAt(index)
        selected.value = coupon
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?) {
            imageUrl?.let {
                if (it.isNotEmpty())
                    Picasso.get().load(it).into(imageView)
            }
        }
    }
}
package com.ligomezm.offersandcoupons.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ligomezm.offersandcoupons.BR
import com.ligomezm.offersandcoupons.model.Coupon
import com.ligomezm.offersandcoupons.viewmodel.CouponViewModel

class RecyclerCouponsAdapter(var couponViewModel: CouponViewModel, var resource: Int) :
    RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    var coupons: List<Coupon>? = null

    fun setCouponsList(coupons: List<Coupon>?) {
        this.coupons = coupons
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(cardCouponHolder: CardCouponHolder, position: Int) {
        cardCouponHolder.setDataCard(couponViewModel, position)
        cardCouponHolder.itemView.setOnClickListener { view ->
            Log.w("COUPON P0", position.toString())
            val context = cardCouponHolder.itemView.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupons?.get(position))
            context.startActivity(showPhotoIntent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(couponViewModel: CouponViewModel, position: Int) {
            binding?.setVariable(BR.model, couponViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }
    }
}

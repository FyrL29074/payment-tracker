package com.fyrl29074.payment_tracker.app.features.payments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fyrl29074.payment_tracker.R
import com.fyrl29074.payment_tracker.app.formatter.AmountFormatter
import com.fyrl29074.payment_tracker.app.formatter.DateFormatter
import com.fyrl29074.payment_tracker.databinding.ItemPaymentBinding
import com.fyrl29074.payment_tracker.domain.model.Payment

class PaymentAdapter : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>() {

    private var payments = listOf<Payment>()

    @Suppress("NotifyDataSetChanged")
    fun setData(data: List<Payment>) {
        payments = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = ItemPaymentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PaymentViewHolder(binding)
    }

    override fun getItemCount(): Int = payments.size

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = payments[position]
        holder.bind(payment)
    }

    inner class PaymentViewHolder(private val binding: ItemPaymentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(payment: Payment) {
            binding.apply {
                title.text = payment.title ?: ""
                amount.text = root.context.getString(
                    R.string.payment_amount, AmountFormatter.format(payment.amount)
                )
                creationDate.text = root.context.getString(
                    R.string.payment_date, DateFormatter.format(payment.creationDate)
                )
            }
        }
    }
}


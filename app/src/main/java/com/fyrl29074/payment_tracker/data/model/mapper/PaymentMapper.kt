package com.fyrl29074.payment_tracker.data.model.mapper

import com.fyrl29074.payment_tracker.data.model.PaymentDto
import com.fyrl29074.payment_tracker.domain.model.Payment

object PaymentMapper {
    fun map(dto: PaymentDto): Payment {
        return Payment(
            id = dto.id,
            title =  dto.title,
            amount = dto.amount,
            created = dto.created,
        )
    }
}
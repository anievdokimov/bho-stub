package com.thomascook.integration.bho.stub.repository

import com.thomascook.integration.bho.stub.model.BookingData
import com.thomascook.integration.bho.stub.model.Provider
import org.springframework.data.repository.CrudRepository

interface BookingRepository : CrudRepository<BookingData, Long> {
    fun findByProviderAndBookingId(provider: Provider, bookingId: String): List<BookingData>
}
package com.thomascook.integration.bho.stub.model

import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*


enum class Provider {
    UK, NORDIC, REGIONAL
}

@Entity
@Table(name = "BOOKING_DATA")
data class BookingData(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long = -1,

        @CreatedDate
        @Temporal(TemporalType.TIMESTAMP)
        val createdAt: Date = Date(),

        @Column(name = "provider", nullable = false)
        val provider: Provider = Provider.UK,

        @Column(name = "payload", nullable = false)
        val payload: String = "",

        @Column(name = "bookingId", nullable = false)
        val bookingId: String = ""


) {
    companion object Factory {
        fun nordicBooking(payload: String): BookingData = BookingData(provider = Provider.NORDIC, bookingId = "1", payload = payload)
        fun ukBooking(payload: String): BookingData = BookingData(provider = Provider.UK, bookingId = "1", payload = payload)
        fun regionalBooking(payload: String): BookingData = BookingData(provider = Provider.REGIONAL, bookingId = "1", payload = payload)
    }
}

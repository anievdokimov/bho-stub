package com.thomascook.integration.bho.stub.controller

import com.thomascook.integration.bho.stub.model.BookingData
import com.thomascook.integration.bho.stub.model.Provider
import com.thomascook.integration.bho.stub.repository.BookingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class AdapterStubController {

    @Autowired
    lateinit var repository: BookingRepository

    @RequestMapping(value = ["/uk-adapter"], method = [RequestMethod.POST])
    fun ukAdaper(@RequestBody data: String) = repository.save(BookingData.ukBooking(data))


    @RequestMapping(value = ["/nordic-adapter"], method = [RequestMethod.POST])
    fun nordicAdaper(@RequestBody data: String) = repository.save(BookingData.nordicBooking(data))

    @RequestMapping(value = ["/regional-adapter"], method = [RequestMethod.POST])
    fun regionalAdaper(@RequestBody data: String) = repository.save(BookingData.regionalBooking(data))

    @RequestMapping("/get-booking")
    fun fetchBooking(@RequestParam("provider") provider: Provider,
                     @RequestParam("bookingId") bookingId: String) = repository.findByProviderAndBookingId(provider, bookingId)

    @RequestMapping("/get-all-bookings")
    fun fetchAllBookings(): List<BookingData> = repository.findAll().toList()
}

package org.unpredictableXpractice.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.unpredictableXpractice.room.RoomBookingServiceHelper;

@Component
public class BookingService
{

    private final RoomBookingServiceHelper roomBooking;

    @Autowired
    public BookingService(@Qualifier("Delux") RoomBookingServiceHelper roomBooking)
    {
        this.roomBooking = roomBooking;
    }

    public void bookHotelRoom(){
        roomBooking.bookRoom();
        System.out.println("At: "+roomBooking.calculatePrice(2));
    }
}

package org.unpredictableXpractice.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.unpredictableXpractice.notification.NotificationServiceHelper;
import org.unpredictableXpractice.payment.PaymentServiceHelper;
import org.unpredictableXpractice.room.RoomBookingServiceHelper;

@Component
public class BookingService
{

    private final RoomBookingServiceHelper roomBooking;
    private final PaymentServiceHelper payment;
    private final NotificationServiceHelper notification;

    @Autowired
    public BookingService(@Qualifier("Delux") RoomBookingServiceHelper roomBooking, PaymentServiceHelper payment,  NotificationServiceHelper notification)
    {
        this.roomBooking = roomBooking;
        this.payment = payment;
        this.notification = notification;
    }

    public void bookHotelRoom(){
        roomBooking.bookRoom();
        System.out.println("Total cost Rs."+roomBooking.calculatePrice(2)+" Payed by: "+ payment.pay());
        System.out.println("Notification sent via "+notification.sendNotification());
    }
}

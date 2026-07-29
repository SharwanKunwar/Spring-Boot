package org.unpredictableXpractice.room;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Standard")
public class StandardRoom implements RoomBookingServiceHelper{
    @Override
    public void bookRoom() {
        System.out.println("Standard room booked");
    }

    @Override
    public double calculatePrice(int nights) {
        return 50*nights;
    }
}

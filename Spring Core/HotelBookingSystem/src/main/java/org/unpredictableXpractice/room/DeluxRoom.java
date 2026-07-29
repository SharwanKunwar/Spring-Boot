package org.unpredictableXpractice.room;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Delux")
public class DeluxRoom implements RoomBookingServiceHelper{
    @Override
    public void bookRoom() {
        System.out.println("Delux room booked");
    }

    @Override
    public double calculatePrice(int nights) {
        return 100  * nights;
    }
}

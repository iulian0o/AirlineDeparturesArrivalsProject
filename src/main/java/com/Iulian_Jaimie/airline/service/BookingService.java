package com.Iulian_Jaimie.airline.service;

import com.Iulian_Jaimie.airline.entity.*;
import com.Iulian_Jaimie.airline.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class BookingService {
    private final BookingRepository bookingRepo;
    private final FlightRepository flightRepo;
    private final ClientRepository clientRepo;
    private final MilesRewardRepository rewardRepo;

    public BookingService(BookingRepository bookingRepo, FlightRepository flightRepo,
                          ClientRepository clientRepo, MilesRewardRepository rewardRepo) {
        this.bookingRepo = bookingRepo;
        this.flightRepo = flightRepo;
        this.clientRepo = clientRepo;
        this.rewardRepo = rewardRepo;
    }

    @Transactional
    public String createBooking(String lastname, String firstname, String passport,
                                String flightNumber, String seatType) {

        Flight flight = flightRepo.findById(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found: " + flightNumber));

        long currentBookings = bookingRepo.countByFlight_FlightNumber(flightNumber);
        if (currentBookings >= flight.getPlane().getCapacity()) {
            throw new RuntimeException("Flight is full!");
        }

        Client client = clientRepo.findByNumPassport(passport);
        if (client == null) {
            client = new Client();
            client.setNumPassport(passport);
            client.setLastname(lastname);
            client.setFirstname(firstname);
            client.setEmail(firstname + "." + lastname + "@email.com");
            clientRepo.save(client);
        }

        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setClient(client);
        booking.setSeatType(seatType);
        bookingRepo.save(booking);

        return checkAndGrantReward(client, flight);
    }

    private String checkAndGrantReward(Client client, Flight flight) {
        MilesReward history = new MilesReward();
        history.setClient(client);
        history.setFlight(flight);
        history.setDateRecorded(LocalDate.now());

        int currentYear = LocalDate.now().getYear();
        long flightCount = rewardRepo.countFlightsInYear(client.getIdUser(), currentYear);

        if ((flightCount + 1) % 3 == 0) {
            String code = "DISCOUNT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
            history.setGeneratedDiscountCode(code);
            rewardRepo.save(history);
            return "Booking Confirmed! You won a discount code: " + code;
        }

        rewardRepo.save(history);
        return "Booking Confirmed.";
    }
}
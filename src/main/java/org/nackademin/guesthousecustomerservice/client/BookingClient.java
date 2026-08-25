package org.nackademin.guesthousecustomerservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class BookingClient {

    private final RestClient restClient;

    @Value("${booking.service.url}")
    private String bookingServiceUrl;

    public boolean hasActiveBookings(Long customerId) {
        try {
            Boolean result = restClient.get()
                    .uri(bookingServiceUrl
                            + "/bookings/customer/"
                            + customerId
                            + "/exists")
                    .retrieve()
                    .body(Boolean.class);
            return Boolean.TRUE.equals(result);
        } catch (ResourceAccessException e) {
            throw new RuntimeException(
                    "Bokningstjänsten är inte tillgänglig just nu, försök igen senare");
        }
    }
}
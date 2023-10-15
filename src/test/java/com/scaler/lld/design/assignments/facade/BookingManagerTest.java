package com.scaler.lld.design.assignments.facade;

import com.scaler.lld.design.assignments.facade.models.PaymentStatus;
import com.scaler.lld.design.assignments.facade.services.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookingManagerTest {

    private static final Set<Class<?>> DEPENDENCIES = Set.of(AvailabilityService.class, PaymentService.class, NotificationService.class, LoyaltyService.class, AccommodationDetailsService.class);

    @Test
    public void testDependencies() {

        Class<?> bookingManagerClass = BookingManager.class;
        Field[] fields = bookingManagerClass.getDeclaredFields();

        Arrays.stream(fields).forEach(field -> field.setAccessible(true));


        boolean anyDependencyPresent = DEPENDENCIES.stream().anyMatch(dependency -> Arrays.stream(fields).anyMatch(field -> field.getType().equals(dependency)));

        assertFalse(anyDependencyPresent, "If the facade pattern is implemented correctly, the BookingManager class should not have any dependencies");
    }

    @Test
    public void testBookingProcess() {
        // Mock the dependencies
        AvailabilityService availabilityService = mock(AvailabilityService.class);
        Mockito.when(availabilityService.checkAvailability(Mockito.anyString(), Mockito.any(LocalDate.class), Mockito.any(LocalDate.class))).thenReturn(true);

        PaymentService paymentService = mock(PaymentService.class);
        Mockito.when(paymentService.makePayment(Mockito.anyString(), Mockito.anyString())).thenReturn(PaymentStatus.SUCCESS);

        NotificationService notificationService = mock(NotificationService.class);
        LoyaltyService loyaltyService = mock(LoyaltyService.class);
        AccommodationDetailsService accommodationDetailsService = mock(AccommodationDetailsService.class);

        // Create a BookingManager instance with mocked dependencies
        BookingManager bookingManager = new BookingManager(availabilityService, paymentService, notificationService, loyaltyService, accommodationDetailsService);

        // Define test data
        String userId = "123";
        String accommodationId = "456";
        LocalDate checkInDate = LocalDate.of(2023, 8, 1);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 5);

        // Perform the booking process
        bookingManager.bookAccommodation(userId, accommodationId, checkInDate, checkOutDate);
        
        String errorPattern = "If the facade pattern is implemented correctly, the %s method should not be called on the %s dependency";
        // Verify interactions with the dependencies
        verify(availabilityService, Mockito.description(String.format(errorPattern, "checkAvailability", "AvailabilityService"))).checkAvailability(accommodationId, checkInDate, checkOutDate);
        verify(paymentService).makePayment(userId, accommodationId);

        verify(notificationService, Mockito.description(String.format(errorPattern, "sendBookingConfirmation", "NotificationService"))).sendBookingConfirmation(
                argThat(bookingConfirmation ->
                        bookingConfirmation.getUserId().equals(userId) &&
                                bookingConfirmation.getAccommodationId().equals(accommodationId) &&
                                bookingConfirmation.getCheckInDate().equals(checkInDate) &&
                                bookingConfirmation.getCheckOutDate().equals(checkOutDate)
                )
        );
        verify(loyaltyService, Mockito.description(String.format(errorPattern, "updateLoyaltyPoints", "LoyaltyService"))).updateLoyaltyPoints(userId, 0);
        verify(accommodationDetailsService, Mockito.description(String.format(errorPattern, "updateAccommodationDetails", "AccommodationDetailsService"))).updateAccommodationDetails(accommodationId, checkInDate, checkOutDate);
    }
}

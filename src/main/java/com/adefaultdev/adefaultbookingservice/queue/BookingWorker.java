package com.adefaultdev.adefaultbookingservice.queue;


import com.adefaultdev.adefaultbookingservice.service.BookingService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingWorker {

    private final BookingQueue bookingQueue;
    private final BookingService bookingService;

    @PostConstruct
    public void start() {
        Thread.startVirtualThread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    BookingRequest request = bookingQueue.take();
                    bookingService.processBooking(request);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}
package com.adefaultdev.adefaultbookingservice.queue;

import com.adefaultdev.adefaultbookingservice.service.BookingService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookingWorker {

    private final BookingQueue bookingQueue;
    private final BookingService bookingService;

    private final ExecutorService executor =
            Executors.newSingleThreadExecutor();

    @PostConstruct
    public void start() {
        executor.submit(this::processQueue);
    }

    private void processQueue() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                BookingRequest request = bookingQueue.take();

                bookingService.processBooking(request);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Booking worker interrupted");
            } catch (Exception e) {
                log.error("Failed to process booking request", e);
            }
        }
    }

    @PreDestroy
    public void stop() {
        executor.shutdownNow();
    }
}
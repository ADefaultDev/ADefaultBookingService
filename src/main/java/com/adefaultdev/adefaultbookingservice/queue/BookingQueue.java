package com.adefaultdev.adefaultbookingservice.queue;

import org.springframework.stereotype.Component;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The queue for managing booking requests
 *
 * @author AdefaultDev
 * @since 1.0
 */
@Component
public class BookingQueue {

    private final BlockingQueue<BookingRequest> queue =
            new LinkedBlockingQueue<>(1000);

    public boolean add(BookingRequest request) {
        return queue.offer(request);
    }

    public BookingRequest take() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
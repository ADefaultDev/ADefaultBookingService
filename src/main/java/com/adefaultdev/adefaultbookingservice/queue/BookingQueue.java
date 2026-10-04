package com.adefaultdev.adefaultbookingservice.queue;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class BookingQueue {

    private final BlockingQueue<BookingRequest> queue =
            new LinkedBlockingQueue<>();

    public void add(BookingRequest request) {
        queue.add(request);
    }

    public BookingRequest take() throws InterruptedException {
        return queue.take();
    }
}
package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUnionImpl implements ThreadUnion {

    private final String name;
    private final AtomicInteger counter = new AtomicInteger(0);
    private final List<ThreadImpl> threads;
    private final List<FinishedThreadResult> results;
    private CountDownLatch latch;
    private volatile StatusOfThread status = StatusOfThread.RUNNING;

    enum StatusOfThread {RUNNING, SHUTDOWN}

    public ThreadUnionImpl(String name) {
        this.name = name;
        latch = new CountDownLatch(0);
        threads = Collections.synchronizedList(new ArrayList<>());
        results = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public int totalSize() {
        return threads.size();
    }

    @Override
    public int activeSize() {
        return (int) threads.stream().filter(Thread::isAlive).count();
    }

    @Override
    public void shutdown() {
        threads.forEach(Thread::interrupt);
        if (threads.stream().allMatch(Thread::isInterrupted)){
            awaitTermination();
        }
        else shutdown();
    }

    @Override
    public  boolean isShutdown() {
        return status.equals(StatusOfThread.SHUTDOWN);
    }

    @Override
    public void awaitTermination() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.currentThread().interrupt();
            if (Thread.currentThread().isInterrupted()) {
                status = StatusOfThread.SHUTDOWN;
            } else {
                shutdown();
            }
        }
    }

    @Override
    public boolean isFinished() {
        return status.equals(StatusOfThread.SHUTDOWN);
    }

    @Override
    public List<FinishedThreadResult> results() {
        return new ArrayList<>(results);
    }

    @Override
    public Thread newThread(Runnable r) {
        if (status.equals(StatusOfThread.SHUTDOWN)) {
            throw new IllegalStateException();
        }
        ThreadImpl thread = new ThreadImpl(r, name + "-worker-" + counter.getAndIncrement());
        threads.add(thread);
        latch = new CountDownLatch(threads.size());
        return thread;
    }

    private class ThreadImpl extends Thread {
        private Throwable e;

        public ThreadImpl(Runnable target, String name) {
            super(target, name);
        }

        @Override
        public void run() {
            try {
                super.run();
            } catch (Throwable throwable) {
                this.e = throwable;
            } finally {
                results.add(new FinishedThreadResult(this.getName(), e));
                latch.countDown();
                this.interrupt();
            }
        }
    }
}

package com.starlinks.core.api.commons;

public interface StarRunnable extends Runnable {

    @Override
    default void run() {
        try {
            catchRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void catchRun() throws Exception;
}

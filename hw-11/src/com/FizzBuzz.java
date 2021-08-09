package com;

public class FizzBuzz implements Runnable {
    private static final int FIZZ = 0;
    private static final int BUZZ = 1;
    private static final int FIZZ_BUZZ = 2;
    private static final int NUMBER = 3;

    private boolean isAlive = true;
    private final int number;
    private volatile int currentNumber = 1;

    public FizzBuzz(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Thread A = new Thread(new FizzBuzzThread(FIZZ));
        Thread B = new Thread(new FizzBuzzThread(BUZZ));
        Thread C = new Thread(new FizzBuzzThread(FIZZ_BUZZ));
        Thread D = new Thread(new FizzBuzzThread(NUMBER));

        A.start();
        B.start();
        C.start();
        D.start();
    }

    private synchronized void increment() {
        if (++currentNumber > number) isAlive = false;
    }

    private void fizz() {
        if (!isAlive) return;

        if (currentNumber % 3 == 0 && currentNumber % 5 > 0) {
            System.out.println("fizz");
            increment();
        }
    }

    private void buzz() {
        if (!isAlive) return;

        if (currentNumber % 3 > 0 && currentNumber % 5 == 0) {
            System.out.println("buzz");
            increment();
        }
    }

    private void fizzBuzz() {
        if (!isAlive) return;

        if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
            System.out.println("fizzbuzz");
            increment();
        }
    }

    private void number() {
        if (!isAlive) return;

        if (currentNumber % 3 > 0 && currentNumber % 5 > 0) {
            System.out.println(currentNumber);
            increment();
        }
    }


    private class FizzBuzzThread implements Runnable {
        private final int whatToDo;

        FizzBuzzThread(int whatToDo) {
            this.whatToDo = whatToDo;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) { /*IGNORE*/ }

            while (isAlive) {
                    switch (whatToDo) {
                        case FIZZ:
                            fizz();
                            break;
                        case BUZZ:
                            buzz();
                            break;
                        case FIZZ_BUZZ:
                            fizzBuzz();
                            break;
                        case NUMBER:
                            number();
                    }
            }
        }
    }
}

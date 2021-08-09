package com;

public class TimePrinter extends Thread {
//    private long startedTime = System.currentTimeMillis();
    public static final int COUNT_ELAPSED_SECONDS = 0;
    public static final int PRINT_ELAPSED_TIME = 1;
    public static final int COUNT_ELAPSED_SECONDS_AND_PRINT = 2;

    private final long millis;
    private final int whatToDo;

    public TimePrinter() {
        whatToDo = COUNT_ELAPSED_SECONDS;
        millis = 1000;
    }

    public TimePrinter(int whatToDo, long millis) {
        this.millis = millis;
        this.whatToDo = whatToDo;
    }

    @Override
    public void run() {
        double seconds = millis / 1000.0;

        if (whatToDo == COUNT_ELAPSED_SECONDS) {


            double countSeconds = seconds;
            while (!interrupted()) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    break;
                }
                print(countSeconds);
                countSeconds += seconds;
            }
        } else if (whatToDo == PRINT_ELAPSED_TIME) {


            while (!interrupted()) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    break;
                }
                print(seconds);
            }
        } else if (whatToDo == COUNT_ELAPSED_SECONDS_AND_PRINT) {


            double countSeconds = seconds;
            while (!interrupted()) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    break;
                }
                print(countSeconds);
                print(seconds);
                countSeconds += seconds;
            }
        } else {
            System.out.println("Invalid parameter in the constructor.");
        }
    }

    private void print(double seconds) {
        String number = String.valueOf(seconds);
        number = number.substring(0, number.indexOf(".") + 2);
        System.out.printf("Elapsed %s seconds\n", number);
    }
}

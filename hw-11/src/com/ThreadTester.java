package com;

public class ThreadTester {
    public static void main(String[] args) {
        try {
            doubleThreadTester();
        } catch (InterruptedException e) { /*IGNORE*/ }

        System.out.println("\n\n");


//      Как и положено потокам, непредсказуемая штука. Но чаще всего работает как и ожидается в условии задания.

//      Я конечно могу ошибаться, но вроде такое не делают в многопотоке,
//      ибо тут есть зависимость от уже выполненной работы каждого отдельного потока.

        Thread fizzBuzz = new Thread(new FizzBuzz(15));
        fizzBuzz.start();
    }

    private static void doubleThreadTester() throws InterruptedException {

//        Ну как-то так, поумолчанию отсчёт пройденого времени(в секундах) со старта работы программы,
//        с возможностью настройки интервала оповещения(Второй конструктор).

//        Если нужно, будет писать сообщение "Прошло N секунд".
//        Или же и 1-е и 2-е.

        TimePrinter d = new TimePrinter();
        d.start();
        Thread.sleep(3100);
        d.interrupt();

        System.out.println("\n\n");

        TimePrinter d1 = new TimePrinter(TimePrinter.COUNT_ELAPSED_SECONDS, 1500);
        d1.start();
        Thread.sleep(5100);
        d1.interrupt();

        System.out.println("\n\n");

        TimePrinter d2 = new TimePrinter(TimePrinter.PRINT_ELAPSED_TIME, 5000);
        d2.start();
        Thread.sleep(10100);
        d2.interrupt();

        System.out.println("\n\n");

        TimePrinter d3 = new TimePrinter(TimePrinter.COUNT_ELAPSED_SECONDS_AND_PRINT, 1000);
        d3.start();
        Thread.sleep(3100);
        d3.interrupt();
    }
}

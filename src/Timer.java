// import java.util.*;
// Таймер. Замедляет на 5 сек. возврат в меню ввода при успешном исполнении команд 4 и 5 главного меню, чтобы пользователь успел прочесть отчеты
// public class Timer {
//    public static void runTimerRun() {
//        TimerTask task = new TimerTask() {
//            public void run() {
//                System.out.println(".");
//            }
//       };
//        System.out.print("Возврат в меню через: ");
//        for (int i = 5; i > 0; --i) {
//            System.out.print(" " + i);
//           try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ie) {
//            }
//        }
//       System.out.println(" ");
//
//    }
// }
import java.util.List;
import java.util.Scanner;

public class Main {

    //объявляем рабочие классы:
    public static Downloader downloader = new Downloader(); // подгрузчик отчетов
    public static reportCalculator reportCalculator = new reportCalculator(); // проверка на разногласия в отчетах
    public static ShowMonth showMonth = new ShowMonth(); //Вывести информацию о месячных отчётах
    public static ShowYear showYear= new ShowYear(); // Вывести информацию о годовом отчёте
    public static Scanner scanner = new Scanner(System.in);
    static Timer Timer = new Timer(); // таймер 5 секунд на чтение отчетов

    public static String wrong1 = "Ошибка ввода. Неверная команда!";
    public static String wrong2 = "Ошибка ввода. Неполные данные по отчетам!";

    public static void main(String[] args) {

        String userInput = "999999";

        while (!userInput.equals("0")) { // обработка главного меню
            printMenu();
            userInput = scanner.nextLine();

            switch (userInput) {

                case "1":
                    downloader.readMonth();
                    break;

                case "2":
                    downloader.readYear();
                    break;

                case "3":
                    if (dataSearch()) {
                        checkList();
                    }
                    break;

                case "4":
                    if (downloader.isMonthlyMemoryOn) {
                        ShowMonth.showMonth(downloader.monthsList, downloader.monthMemories);
                        Timer.runTimerRun();
                    } else {
                        System.out.println(wrong2);
                    }
                    break;

                case "5":
                    if (downloader.isYearMemoryOn) {
                        ShowYear.showYear(downloader.monthsList, downloader.yearMemory.currentYear, downloader.yearMemory.incomeList, downloader.yearMemory.expensesList);
                        Timer.runTimerRun();
                    } else {
                        System.out.println(wrong2);
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println(wrong1);
                    break;
            }
        }
        System.out.println("Досвидули");
        return;

    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти из приложения");
    }

    private static boolean dataSearch() { // проверка на наличие отчетов
        if (downloader.isMonthlyMemoryOn && downloader.isYearMemoryOn) {
            return true;

        } else if (!downloader.isMonthlyMemoryOn || !downloader.isYearMemoryOn) {
            System.out.println(wrong2);
            return false;
        }
        return false;
    }

    private static void checkList() { // проверка на соответствия в отчетах
        List<String> concurrence = reportCalculator.coincidenceSerch(downloader.monthsList, downloader.monthMemories, downloader.yearMemory);

        if (concurrence.isEmpty()) {
            System.out.println("Сверка отчетов прошла успешно!");

        } else {
            System.out.print(wrong2);
        }
    }
}
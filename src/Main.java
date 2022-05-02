import java.util.Scanner;

public class Main {

    //объявляем рабочие классы:
    public static Downloader downloader = new Downloader(); // подгрузчик отчетов
    public static ReportCalculator reportCalculator = new ReportCalculator(); // проверка на разногласия в отчетах
    public static ShowMonth showMonth = new ShowMonth(); //Вывести информацию о месячных отчётах
    public static ShowYear showYear = new ShowYear(); // Вывести информацию о годовом отчёте
    public static Scanner scanner = new Scanner(System.in);
    public static ReconciliationOfReports reconciliationOfReports = new ReconciliationOfReports(); //класс для проверки на наличие и соответствие отчетов

    public static String wrongComand = "Ошибка ввода. Неверная команда!";
    public static String wrongReport = "Ошибка ввода. Неполные данные по отчетам!";

    public static void main(String[] args) {

        String userInput = "-0"; // Ввод пользователем значения по умолчанию не ломает цикл, пользователь может ввести -0 или 999999 и ничего не случится. А добавление числовой команды "-0" не планируется разработчиком)

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
                    if (reconciliationOfReports.dataSearch()) {
                        reconciliationOfReports.checkList();
                    }
                    break;

                case "4":
                    if (downloader.isMonthlyMemoryOn) {
                        ShowMonth.showMonth(downloader.monthsList, downloader.monthMemories);

                    } else {
                        System.out.println(wrongReport);
                    }
                    break;

                case "5":
                    if (downloader.isYearMemoryOn) {
                        ShowYear.showYear(downloader.monthsList, downloader.yearMemory.currentYear, downloader.yearMemory.incomeList, downloader.yearMemory.expensesList);

                    } else {
                        System.out.println(wrongReport);
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println(wrongComand);
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


}
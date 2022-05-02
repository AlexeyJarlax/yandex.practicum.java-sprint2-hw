import java.util.List;

public class ReconciliationOfReports { //класс для проверки на наличие и соответствие отчетов

    public boolean dataSearch() { // проверка на наличие отчетов

        boolean isYearMemoryOn = false;

        if (Main.downloader.isMonthlyMemoryOn && Main.downloader.isYearMemoryOn) { // заглядываем в загрузчик Downloader через объект в Мейне
            return true;

        } else if (!Main.downloader.isMonthlyMemoryOn || !Main.downloader.isYearMemoryOn) {
            System.out.println(Main.wrongReport + "ошибка в методе dataSearch");
            return false;
        }
        return false;
    }

    public void checkList() { // проверка на соответствия в отчетах
        List<String> concurrence = ReportCalculator.coincidenceSerch(Main.downloader.monthsList, Main.downloader.monthMemories, Main.downloader.yearMemory);

        if (concurrence.isEmpty()) {
            System.out.println("Сверка отчетов прошла успешно!");

        } else {
            System.out.print(Main.wrongReport);
        }
    }
}
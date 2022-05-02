
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


public class Downloader { // подгрузка и обработка отчетов
    private String currentYear;
    public Map<String, String> monthsList = new HashMap<>(); // вернул на HashMap, чтобы показать реализацию метода с добавленным декабрём и ноябрем

    public MonthMemory[] monthMemories; // перегрузчик данных в отдельный класс
    boolean isMonthlyMemoryOn = false;

    public YearMemory yearMemory; // перегрузчик данных в отдельный класс
    boolean isYearMemoryOn = false;

    Downloader() {
        currentYear = "2021";
        monthsList.put("01", "Январь");
        monthsList.put("02", "Февраль");
        monthsList.put("03", "Март");
        monthsList.put("04", "Апрель");
        monthsList.put("05", "Май");
        monthsList.put("06", "Июнь");
        monthsList.put("07", "Июль");
        monthsList.put("08", "Август");
        monthsList.put("09", "Сентябрь");
        monthsList.put("10", "Октябрь");
        monthsList.put("11", "Ноябрь");
        monthsList.put("12", "Декабрь");
        monthMemories = new MonthMemory[monthsList.size()];
    }

    public void readMonth() {
        int processedReports = 0;

        for (String monthNumber : monthsList.keySet()) {
            Path filePath = Path.of("./resources/" + "m." + currentYear + monthNumber + ".csv");

            if (Files.exists(filePath)) {
                try {
                    String rawData = Files.readString(filePath);
                    String[] lines = rawData.split("\\n");
                    Map<String, Integer> incomeList = new HashMap<>();
                    Map<String, Integer> expensesList = new HashMap<>();

                    for (int i = 1; i < lines.length; i++) {
                        String[] linesContent = lines[i].split(",");
                        String itemName = linesContent[0];
                        int itemSum = Integer.parseInt(linesContent[2]) * Integer.parseInt(linesContent[3]);

                        if (linesContent[1].equalsIgnoreCase("false")) {
                            incomeList.put(itemName, itemSum);
                        } else {
                            expensesList.put(itemName, itemSum);
                        }
                    }
                    monthMemories[Integer.parseInt(monthNumber) - 1] = new MonthMemory(monthsList.get(monthNumber), incomeList, expensesList);
                    processedReports++;

                } catch (IOException e) {
                    System.out.println(Main.wrongReport);
                    System.out.println("Не найден файл отчета " + "m." + currentYear + monthNumber + ".csv !");
                }
            }
        }

        if (processedReports == 0) {
            System.out.println(Main.wrongReport + "isMonthlyMemoryOn фэйл");
        } else {
            isMonthlyMemoryOn = true;
            System.out.println("Обработано месячных отчетов: " + processedReports);
        }

    }

    public void readYear() {
        Map<String, Integer> incomeList = new HashMap<>();
        Map<String, Integer> expensesList = new HashMap<>();
        Path filePath = Path.of("./resources/" + "y." + currentYear + ".csv");

        try {
            String rawData = Files.readString(filePath);
            String[] lines = rawData.split("\\n");

            for (int i = 1; i < lines.length; i++) {
                String[] linesContent = lines[i].split(",");
                String monthNumber = linesContent[0];
                int monthSum = Integer.parseInt(linesContent[1]);

                if (linesContent[2].equalsIgnoreCase("false")) {
                    incomeList.put(monthsList.get(monthNumber), monthSum);
                } else {
                    expensesList.put(monthsList.get(monthNumber), monthSum);
                }
            }
            yearMemory = new YearMemory(currentYear, incomeList, expensesList);
            isYearMemoryOn = true;
            System.out.println("Годовой отчет успешно считан!");

        } catch (IOException e) {
            System.out.println(Main.wrongReport);
        }

    }

}
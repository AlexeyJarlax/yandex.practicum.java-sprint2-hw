import java.util.Map;

public class ShowYear { // Вывести информацию о годовом отчёте

    public static void showYear(Map<String, String> monthsList, String currentYear, Map<String, Integer> incomeList, Map<String, Integer> expensesList) {
        float expensesSum = 0;
        float incomeSum = 0;

        System.out.println("Рассматриваемый год: " + currentYear);
        System.out.println();
        for (String monthName : monthsList.values()) {
            if ((expensesList.get(monthName) != null) && (expensesList.get(monthName) != null)) {
                System.out.println("Прибыль за " + monthName + " составила "
                        + (incomeList.get(monthName) - expensesList.get(monthName)) + ".");
            }
        }

        for (String monthName : monthsList.values()) {
            if ((expensesList.get(monthName) != null) && (expensesList.get(monthName) != null)) {
                expensesSum += expensesList.get(monthName);
                incomeSum += incomeList.get(monthName);
            }
        }

        System.out.println("Средний расход за все месяцы в году: " + expensesSum / expensesList.size() + ".");
        System.out.println("Средний доход за все месяцы в году: " + incomeSum / incomeList.size() + ".");
    }


}
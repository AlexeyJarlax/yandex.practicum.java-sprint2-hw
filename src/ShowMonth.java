import java.util.Map;

public class ShowMonth { //Вывести информацию о месячных отчётах

    public static void showMonth(Map<String, String> monthsList, MonthMemory[] monthMemories) {
        for (String monthNumber : monthsList.keySet()) {
            int monthIndex = (Integer.parseInt(monthNumber) - 1);

            if (monthMemories[monthIndex] != null) {
                Map<String, Integer> reviewedMonthIncome = monthMemories[monthIndex].incomeList;
                Map<String, Integer> reviewedMonthExpenses = monthMemories[monthIndex].expensesList;
                int maxIncome = 0;
                int maxExpense = 0;
                String maxIncomeItem = null;
                String maxExpenseItem = null;

                for (String item : reviewedMonthIncome.keySet()) {
                    int income = reviewedMonthIncome.get(item);

                    if (maxIncome < income) {
                        maxIncome = income;
                        maxIncomeItem = item;
                    }
                }
                for (String item : reviewedMonthExpenses.keySet()) {
                    int income = reviewedMonthExpenses.get(item);

                    if (maxExpense < income) {
                        maxExpense = income;
                        maxExpenseItem = item;
                    }
                }
                System.out.println("Месяц: " + monthsList.get(monthNumber));
                System.out.println("Самый прибыльный товар: " + maxIncomeItem + " на сумму " + maxIncome + ".");
                System.out.println("Самая большая трата: " + maxExpenseItem + " на сумму " + maxExpense + ".");
            }
        }
    }


}
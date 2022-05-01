import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class reportCalculator { // проверка на разногласия в отчетах

    public List<String> coincidenceSerch(Map<String, String> monthsList, MonthMemory[] monthMemories, YearMemory yearMemory) {
        List<String> concurrence = new ArrayList<>();

        for (String monthNumber : monthsList.keySet()) {
            int monthIndex = (Integer.parseInt(monthNumber) - 1);
            String monthName = monthsList.get(monthNumber);

            if ((monthMemories[monthIndex] != null) && (yearMemory.incomeList.get(monthName) != null)
                    && (yearMemory.expensesList.get(monthName) != null)) {
                if (checkIfMonthsMismatch(monthIndex, monthName, monthMemories, yearMemory)) {
                    concurrence.add(monthName);
                }

            } else if ((monthMemories[monthIndex] != null) || (yearMemory.incomeList.get(monthName) != null)
                    || (yearMemory.expensesList.get(monthName) != null)) {
                concurrence.add(monthName);
            }
        }
        return concurrence;
    }

    private boolean checkIfMonthsMismatch(int monthIndex, String monthName, MonthMemory[] monthMemories, YearMemory yearMemory) {

        Map<String, Integer> reviewedMonthIncome = monthMemories[monthIndex].incomeList;
        Map<String, Integer> reviewedMonthExpenses = monthMemories[monthIndex].expensesList;
        int monthTotalIncome = 0;
        int monthTotalExpenses = 0;
        boolean isIncomeMatching = true;
        boolean isExpensesMatching = true;

        for (int income : reviewedMonthIncome.values()) {
            monthTotalIncome += income;
        }
        for (int expenses : reviewedMonthExpenses.values()) {
            monthTotalExpenses += expenses;
        }

        if (monthTotalIncome != yearMemory.incomeList.get(monthName)) {
            isIncomeMatching = false;
        }
        if (monthTotalExpenses != yearMemory.expensesList.get(monthName)) {
            isExpensesMatching = false;
        }

        return !isIncomeMatching || !isExpensesMatching;
    }
}
import java.util.Map;
// хранилище для месяцев
public class MonthMemory {
    public String monthName;
    public Map<String, Integer> incomeList;
    public Map<String, Integer> expensesList;

    MonthMemory(String month, Map<String, Integer> income, Map<String, Integer> expenses) {
        monthName = month;
        incomeList = income;
        expensesList = expenses;
    }
}
import java.util.Map;
// хранилище для года
public class YearMemory {
    public String currentYear;
    public Map<String, Integer> incomeList;
    public Map<String, Integer> expensesList;

    YearMemory(String year, Map<String, Integer> income, Map<String, Integer> expenses) {
        currentYear = year;
        incomeList = income;
        expensesList = expenses;
    }
}
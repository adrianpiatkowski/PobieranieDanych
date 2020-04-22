import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp implements Runnable {

    /*
    Zadanie:
    1. Wykonać link w przeglądarce: http://dummy.restapiexample.com/api/v1/employees
    2. Otworzyć nowy projekt Mavenowy
    3. Skonfigurować oraz wrzucić na gita
    4. Napisać parser JSON-a który zrzuci listę pracowników, wyświetli ich w konsoli oraz wrzucić kommit ze zmianami na gita
    5. Utworzyć liste obiektów które zwraca powyższe api
    6. Utworzyć metody, które przerobią liste oraz wyświetlić pracowników których wiek jest większy niż 30
    7. Utworzyć metody, które przerobią liste oraz wyświetlić pracowników posortować rosnąco po pensji
    8. Utworzyć metody, które przerobią liste oraz wyświetlić pracowników posortować malejąco po wieku
    */

    @Override
    public void run() {
        try {
            String response = new HttpService().connect(Config.APP_URL);
            parseJson(response);
            powyzej30(response);
            sortowaniePensja(response);
            sortowanieWiekMalejąco(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Employee> parseJson(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArrayEmployees = jsonObject.getJSONArray("data");

        List<Employee> employeesList = new ArrayList<>();

        for (int i = 0; i < jsonArrayEmployees.length(); i++) {
            JSONObject one = (JSONObject) jsonArrayEmployees.get(i);
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(one.get("id").toString()));
            employee.setAge(Double.parseDouble(one.get("employee_age").toString()));
            employee.setName(one.get("employee_name").toString());
            employee.setSalary(Double.parseDouble(one.get("employee_salary").toString()));
            employeesList.add(employee);
        }

        System.out.println("Logs: ");
        System.out.println(employeesList);
        System.out.println(employeesList.size());
        System.out.println(jsonArrayEmployees.length());

        return employeesList;
    }

    private List<Employee> powyzej30(String json){
        JSONObject jsonObject30 = new JSONObject(json);
        JSONArray jsonArrayEmployees30 = jsonObject30.getJSONArray("data");

        List<Employee> employeesList30 = new ArrayList<>();

        for (int i = 0; i < jsonArrayEmployees30.length(); i++) {
            JSONObject one30 = (JSONObject) jsonArrayEmployees30.get(i);
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(one30.get("id").toString()));
            employee.setAge(Double.parseDouble(one30.get("employee_age").toString()));
            employee.setName(one30.get("employee_name").toString());
            employee.setSalary(Double.parseDouble(one30.get("employee_salary").toString()));
            if (employee.getAge()>30) {
                employeesList30.add(employee);
            }

        }
        System.out.println("Logs: ");
        System.out.println(employeesList30);
        System.out.println(employeesList30.size());
        System.out.println(jsonArrayEmployees30.length());
        return employeesList30;
    }
    private List<Employee> up30(List<Employee> lista){
        for (lista:)
    }

    private List<Employee> sortowaniePensja(String json){
        JSONObject jsonObjectPensja = new JSONObject(json);
        JSONArray jsonArrayEmployeesPensja = jsonObjectPensja.getJSONArray("data");

        List<Employee> employeesListPensja = new ArrayList<>();

        for (int i = 0; i < jsonArrayEmployeesPensja.length(); i++) {
            JSONObject onePensja = (JSONObject) jsonArrayEmployeesPensja.get(i);
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(onePensja.get("id").toString()));
            employee.setAge(Double.parseDouble(onePensja.get("employee_age").toString()));
            employee.setName(onePensja.get("employee_name").toString());
            employee.setSalary(Double.parseDouble(onePensja.get("employee_salary").toString()));
            employeesListPensja.add(employee);
        }
        employeesListPensja.sort(Comparator.comparing(Employee::getSalary));
        System.out.println("Logs: ");
        System.out.println(employeesListPensja);
        return employeesListPensja;
    }

    private List<Employee> sortowanieWiekMalejąco(String json){
        JSONObject jsonObjectWiek = new JSONObject(json);
        JSONArray jsonArrayEmployeesPensja = jsonObjectWiek.getJSONArray("data");

        List<Employee> employeesListWiek = new ArrayList<>();

        for (int i = 0; i < jsonArrayEmployeesPensja.length(); i++) {
            JSONObject oneWiek = (JSONObject) jsonArrayEmployeesPensja.get(i);
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(oneWiek.get("id").toString()));
            employee.setAge(Double.parseDouble(oneWiek.get("employee_age").toString()));
            employee.setName(oneWiek.get("employee_name").toString());
            employee.setSalary(Double.parseDouble(oneWiek.get("employee_salary").toString()));
            employeesListWiek.add(employee);
        }
        employeesListWiek.sort(Comparator.comparing(Employee::getAge).reversed());
        System.out.println("Logs: ");
        System.out.println(employeesListWiek);
        return employeesListWiek;
    }





}

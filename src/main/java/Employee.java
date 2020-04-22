import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(includeFieldNames=false)
public class Employee implements Comparable {

    @ToString.Exclude
    private int id;

    private String name;

    @ToString.Exclude
    private Double salary;

    @ToString.Exclude
    private Double age;

    @Override
    public int compareTo(Object o) {
        Employee a = new Employee();
        Employee b = new Employee();
        if (a.getSalary()>b.getSalary()) return -1;
        return 0;
    }
}

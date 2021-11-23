package scripts;

public class Employee
{
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String salary;

    public Employee(String id, String name, String address, String phoneNumber, String salary)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getId() { return id; }

    public void setId(String newID) { this.id = newID; }

    public String getName() { return name; }

    public void setName(String newName) { this.id = newName; }

    public String getAddress() { return address; }

    public void setAddress(String newAddress) { this.id = newAddress; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String newPN) { this.id = newPN; }

    public String getSalary() { return salary; }

    public void setSalary(String newSalary) { this.id = newSalary; }
}

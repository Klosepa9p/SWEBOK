public class Employee 
{
  public Employee(int type) 
  {
    this.type = type;
  }
  // ...
}

public class Employee
{
  public static Employee Create(int type)
  {
    employee = new Employee(type);
    // Do some heavy lifting.
    return employee;
  }
  // ...
}


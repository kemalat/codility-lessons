Work packages can be defined as below to modify tightly coupled class design to achieve loosely coupled classes ;

`Tightly Coupled Classes` -> 

Implementing IoC using Factory Pattern -> 

Implement DIP by defining Abstraction ->

Implement Dependency Injection ->

Use IoC Container ->

`Loosely Coupled Classes`

Typical n-tier architecture:

UI -> Service -> Business Logic -> Data Access 


In below design, CustomerBusinessLogic and DataAccess are tightly coupled classes because the CustomerBusinessLogic class includes 
the reference of the concrete DataAccess class. It also creates an object of DataAccess class and manages the lifetime of the object. 
It cannot be tested independently (TDD). The DataAccess class cannot be replaced with a mock class.

```java
public class CustomerBusinessLogic
{
  DataAccess dataAccess;

  public CustomerBusinessLogic()
  {
    dataAccess = new DataAccess();
  }

  public String GetCustomerName(int id)
  {
    return dataAccess.GetCustomerName(id);
  }
}

public class DataAccess
{
  public DataAccess()
  {
  }

  public String GetCustomerName(int id) {
    return "Dummy Customer Name"; // get it from DB in real app
  }
}
```

Start with creating a simple Factory class which returns an object of the DataAccess and use this DataAccessFactory class in the CustomerBusinessLogic class to get an object of DataAccess class.

```java
public class DataAccessFactory
{
    public static DataAccess GetDataAccessObj() 
    {
        return new DataAccess();
    }
}

public class CustomerBusinessLogic
{

  public CustomerBusinessLogic()
  {
  }

  public String GetCustomerName(int id)
  {
    DataAccess dataAccess =  DataAccessFactory.GetDataAccessObj();

    return dataAccess.GetCustomerName(id);
  }
}


```
CustomerBusinessLogic class uses the concrete DataAccess class. Therefore, it is still tightly coupled, even though we have inverted the dependent object creation to the factory class.
CustomerBusinessLogic and DataAccess are concrete classes because we can create objects of them. 
Abstraction is achieved by creating an interface or an abstract class which is non-concrete. 
This means we cannot create an object of an interface or an abstract class. As per DIP, CustomerBusinessLogic (high-level module) should not depend on the concrete DataAccess class (low-level module). Both classes should depend on abstractions, meaning both classes should depend on an interface or an abstract class.
CustomerBusinessLogic uses the GetCustomerName() method of the DataAccess class. Let's define CustomerDataAccess interface and have its implementation

```java
public interface ICustomerDataAccess
{
    string GetCustomerName(int id);
}

public class CustomerDataAccess implements ICustomerDataAccess
{
    public CustomerDataAccess()
    {
    }

    public String GetCustomerName(int id) {
        return "Dummy Customer Name";        
    }
}
```
Change our factory class which returns ICustomerDataAccess instead of the concrete DataAccess class

```java
public class DataAccessFactory
{
    public static ICustomerDataAccess GetCustomerDataAccessObj() 
    {
        return new CustomerDataAccess();
    }
}
```

Now, change the CustomerBusinessLogic class which uses ICustomerDataAccess instead of the concrete DataAccess
```java
public class CustomerBusinessLogic
{
    ICustomerDataAccess custDataAccess;

    public CustomerBusinessLogic()
    {
        custDataAccess = DataAccessFactory.GetCustomerDataAccessObj();
    }

    public String GetCustomerName(int id)
    {
        return custDataAccess.GetCustomerName(id);
    }
}
```


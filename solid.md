## Solid principles explained in practical way

* Single Responsibility Principle
* Open-Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle

### Single Responsibility Principle 
Everything in the class should be related to that single purpose. There can be a lot of members as long as they are related to the single task or in other words responsibility. Multiple members of the class may need modification for further changes.

```java
class Employee {
  public Pay getPaidVacationDays() {...}
  public void save() {...}
  public String calculatePension() {...}
}
```

Adding different responsibilities to same class makes the class harder to understand, update and test. We need to split the  class abov into three different classes, each having only one responsibility: database access, pension and vacation.

### Open-Closed Principle Example
Applying this principle to project limits the need to change the  code once it has been written, tested and deployed. This reduces the risk of introducing new bugs to existing code. if classes are correctly structured, you can add functionality without editing existing source code. It is achieved by using interfaces or abstract classes. New functionality can be added by creating new classes that implement the interfaces.

```java

public class Rectangle
{
    public double width;
    public double height;
}

public class AreaCalculator
{
    public double Area(Rectangle rectangle)
    {
        area rectangle.width*rectangle.height;
        return area;
    }
}

```
You are now asked to do calculation for Circle as well. You can pass Object as function parameter to Area and can perform isInstanceOf to understand if Object is Circle or Rectangle. But your actual solution should be

```java

public abstract class Shape
{
    public abstract double area();
}

public class Rectangle extends Shape
{
    public double width;
    public double height;

    public double area()
    {
        return width*height;
    }
}

public class Circle extends Shape
{
    public double area()
    {
        return radius*radius*Math.PI;
    }
}

public class AreaCalculator
{
    public double area(Shape shape)
    {
        return area;
    }
}

```

### The Liskov Substitution Principle (LSP)

All subclasses must, therefore, operate in the same manner as their base classes. The specific functionality of the subclass may be different but must conform to the expected behaviour of the base class. The subclass must not only implement the base class’s methods and properties, but also conform to its implied behaviour.  If you try to establish relationship between Square and Rectangle, you will need to have an assumption that “Square is a Rectangle and it causes several issues in your implementation

 - The Square class does not need methods like setBreadth or setLength, as the sides of a square are equal.
 - Class using Square class as derived class of Rectangle has to know details of Square to avoid throwing error.
 
Confirming design to Liskov Substitution Principle could be Bus and Car classes derived from Vehichle base class which having getSpeed() & getCubicCapacity() methods. This is exactly what the Liskov Substitution Principle also states – subtype objects can replace super type objects without affecting the functionality inherent in the super type.

### Interface Segregation Principle

The interface segregation principle (ISP) states that no client should be forced to depend on methods it does not use. In our interface we need to define only related methods. Having AthleteInterface with methods swim() and jump() is not good idea becase the class that would implement this interface has to swim and jump at the same time. 

### Dependency Inversion Principle

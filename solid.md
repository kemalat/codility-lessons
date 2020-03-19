## Solid principles explained in practical way

* Single Responsibility Principle
* Open-Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle

### Single Responsibility Principle 
Everything in the class should be related to that single purpose. There can be a lot of members as long as they relate to the single responsibility. Multiple members of the class may need modification for further changes.

```java
class Employee {
  public Pay getPaidVacationDays() {...}
  public void save() {...}
  public String calculatePension() {...}
}
```java

Mixing responsibilities makes the class harder to understand, update and test. We need to split this class into three different classes, with each having only one responsibility: database access, pension and vacation.

### Open-Closed Principle Example
Applying this principle to project limits the need to change the  code once it has been written, tested and deployed. This reduces the risk of introducing new bugs to existing code. if classes are correctly structured, you can add functionality without editing existing source code. It is achieved by using interfaces or abstract classes. New functionality can be added by creating new classes that implement the interfaces.

```java

void docheckOut(Receipt receipt, List<Items> items) {
  ...
acceptCash(total);

}
```
You asked to add payment with credit card support. Instead of adding if case to above function, you should better to write PaymentMethod interface and implement it as 

```java
public interface PaymentMethod {void acceptPayment(Money total);}
```java

### The Liskov Substitution Principle (LSP)

All subclasses must, therefore, operate in the same manner as their base classes. The specific functionality of the subclass may be different but must conform to the expected behaviour of the base class. To be a true behavioural subtype, the subclass must not only implement the base class’s methods and properties, but also conform to its implied behaviour.

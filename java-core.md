### equals() vs hashCode() 
equals() and hashCode() are different methods and hashCode method should not be used to check if two object references are same. Reason: hashCode just returns int value for an Object, even two different objects can have same hashCode integer. The value returned by hashCode() is the object's hash code, which is the object's memory address in hexadecimal. equals() checks if the two object references are same. If two objects are equal then their hashCode must be the same, but the reverse is not true.

### sleep() vs wait() 
sleep() is a method which is used to pause the process for few seconds or the time we want to. But in case of wait() method, thread goes in waiting state and it won’t come back automatically until we call the notify() or notifyAll(). 

- wait() is called an object; current thread must synchronize on the lock object.
- sleep() is called on currently executing thread.
- wait() – until call notify(), `notifyAll()` from object
- sleep() – until at least time expire or call `interrupt()`.

### fail-fast vs fail-safe iterators
- Fail-fast iterators operate directly on the collection itself. During iteration, fail-fast iterators fail as soon as they realize that the collection has been modified they will throw a `ConcurrentModificationException`. Some examples include `ArrayList, HashSet, and HashMap`

- Fail-safe iterates operate on a cloned copy of the collection and therefore do not throw an exception if the collection is modified during iteration. Examples would include iterators returned by `ConcurrentHashMap or CopyOnWriteArrayList`

### ArrayList vs LinkedList vs Vector
- `ArrayList` and `Vector` are implemented as a resizable array. Vector is similar with ArrayList, but it is synchronized. When an element is inserted into (or removed from) the middle of the list, the elements that follow must all be shifted accordingly.If a thread-safe implementation is not needed, would be better to use ArrayList rather than Vector.
se ArrayList rather than Vector.

- `LinkedList` is implemented using a doubly linked list. Inserting or removing an element only requires updating the links that immediately precede and follow the element being inserted or removed.

### HashMap vs Hashtable
Both Hashtable and HashMap are data-structure based upon hashing and implementation of Map interface, the main difference between them is that HashMap is not thread-safe but Hashtable is thread-safe.HashMap allows null values with one null key but as key and value whereas Hashtable doesn't allow nulls

### Checked vs Unchecked Exceptions
Java forces you to handle Checked Exceptions, once you start compiling your program. If you dont catch FileNotFoundException, you will get compile time error with message – Unhandled exception type FileNotFoundException. 

Java also provides UncheckedExceptions, the occurrences of which are not checked by the compiler. They will come into life/occur into your program, once any buggy code is executed.Unchecked Exceptions are subclasses of RuntimeException. Example of unchecked exceptions are : NullPointerException,ArrayIndexOutOfBoundsException, IllegalArgumentException,NumberFormatException

### Threadlocal
ThreadLocal instance can store different values for each thread independently. Each thread that accesses the get() or set() method of a ThreadLocal instance is accessing its own, independently initialized copy of the variable. Sample use case could be generating unique identifiers locally to each thread. A thread’s id might be assigned the first time when Thread invokes ThreadId.get() and remains unchanged on subsequent calls. Another use case is when you have some object that is not thread-safe, but you want to avoid synchronizing access to that object. Instead, give each thread its own instance of the object.

### How to make a variable shared in a synchronised block in Java?
Static variables might be shared between synchronised blocks. Static means shared across all the instances of that Class in a JVM. Shared resources are not thread-safe.Hence Static variables are not thread safe.So, if multiple threads tries to access a static variable, it may result in inconsistency.

### Collections Vs Streams
Collections are mainly used to store and group the data.Ex : List, Set, Ma
Streams are mainly used to perform operations on data.	Ex : filtering, mapping, matching
You can add or remove elements from collections.
You can’t add. modify or remove elements from streams.Stream consumes a source, performs operations on it and returns a result
Collections have to be iterated externally.
Streams are internally iterated.
Collections can be traversed multiple times.
Streams are traversable only once.
Collections are eagerly constructed.
Streams are lazily constructed.

### Static Class
Java does not allow making a top-level class static as option 
- Declaring class as final as it prevents extension of it
- Making the constructor private as it prevents instantiation
- Making all the members and functions of the class static. Since the class cannot be instantiated no instance methods can be called or instance fields accessed.

### Lambda expression and use cases
- Java 8 provide support for lambda expressions only with functional interfaces. 
- Any Interface with single abstract method is called Functional Interface.
- Easy distribution of processing of collection over multiple threads.
- With the introduction of Stream API, functions can be passed to collection methods and now it is the responsibility of collection to process the elements either in a sequential or parallel manner.

### Static Vs. Dynamic Binding in Java
Static binding uses Type(Class in Java) information for binding while Dynamic binding uses Object to resolve binding
Dynamic Binding example : 

```java
public class Animal {
    void eat() {
        System.out.println("animal is eating...");
    }
}

class Dog extends Animal {

    public static void main(String args[]) {
        Animal a = new Dog();
        a.eat(); // prints >> dog is eating...
    }

    @Override
    void eat() {
        System.out.println("dog is eating...");
    }
}
```
Static Binding example : 

```java
class Animal {
    static void eat() {
        System.out.println("animal is eating...");
    }
}

class Dog extends Animal {

    public static void main(String args[]) {

        Animal a = new Dog();
        a.eat(); // prints >> animal is eating...

    }

    static void eat() {
        System.out.println("dog is eating...");
    }
}
```

### Start N threads at “exactly” the same time

```java
import java.util.concurrent.CountDownLatch;


public class ThreadExample
{
    public static void main(String[] args) 
    {
        CountDownLatch latch = new CountDownLatch(1);
        MyThread t1 = new MyThread(latch);
        MyThread t2 = new MyThread(latch);
        new Thread(t1).start();
        new Thread(t2).start();
        //Do whatever you want
        latch.countDown();          //This will inform all the threads to start
        //Continue to do whatever
    }
}

class MyThread implements Runnable
{
    CountDownLatch latch;
    public MyThread(CountDownLatch latch) 
    {
        this.latch = latch;
    }
    @Override
    public void run() 
    {
        try 
        {
            latch.await();          //The thread keeps waiting till it is informed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Do the actual thing
    }
}
```
### 3-tier web application performance bottleneck analysis
- Network issues : Eliminate first that network connectivity and network devices are healthy( network interface card, firewall, cables, load balancer, routers etc)
- Test setup : Create near production setup, develop traffic generator and simulators, start performance tests
- Database Problems : Check On persistence configuration (lazy vs. eager loading), caching, and database connection pool configuration.
- Memory Problems: Check garbage collection configuration and memory leaks.
- Concurrency Problems: Check thread deadlocks, thread gridlocks, and thread pool configuration issues.

### Strategy Pattern
```java

public interface Strategy {
   public int doOperation(int num1, int num2);
}

public class OperationAdd implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 + num2;
   }
   
public class OperationSubstract implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 - num2;
   }
}

public class OperationMultiply implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 * num2;
   }
}

public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public int executeStrategy(int num1, int num2){
      return strategy.doOperation(num1, num2);
   }
}

public class StrategyPatternDemo {
   public static void main(String[] args) {
      Context context = new Context(new OperationAdd());		
      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationSubstract());		
      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationMultiply());		
      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
   }
}
}

```

### Factory Pattern

```java

public interface Shape {
   void draw();
}

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}

public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

public class ShapeFactory {
	
   //use getShape method to get object of type shape 
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
         
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
         
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      
      return null;
   }
}

public class FactoryPatternDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      shape1.draw();
   }
}

```

### Observer Pattern

```java

import java.util.ArrayList;
import java.util.List;

public class Subject {
	
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   } 	
}

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}

public class BinaryObserver extends Observer{

   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}

public class OctalObserver extends Observer{

   public OctalObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
     System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
   }
}


public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      new OctalObserver(subject);
      new BinaryObserver(subject);

      System.out.println("First state change: 15");	
      subject.setState(15);
      System.out.println("Second state change: 10");	
      subject.setState(10);
   }
}


```


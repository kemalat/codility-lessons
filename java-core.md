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

### Checked vs Unchecked Exceptions

Java forces you to handle Checked Exceptions, once you start compiling your program. If you dont catch FileNotFoundException, you will get compile time error with message – Unhandled exception type FileNotFoundException. 

Java also provides UncheckedExceptions, the occurrences of which are not checked by the compiler. They will come into life/occur into your program, once any buggy code is executed.Unchecked Exceptions are subclasses of RuntimeException. Example of unchecked exceptions are : NullPointerException,ArrayIndexOutOfBoundsException, IllegalArgumentException,NumberFormatException

### Threadlocal

ThreadLocal instance can store different values for each thread independently. Each thread that accesses the get() or set() method of a ThreadLocal instance is accessing its own, independently initialized copy of the variable. Sample use case could be generating unique identifiers locally to each thread. A thread’s id might be assigned the first time when Thread invokes ThreadId.get() and remains unchanged on subsequent calls. Another use case is when you have some object that is not thread-safe, but you want to avoid synchronizing access to that object. Instead, give each thread its own instance of the object.

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

### The Most Important Design Patterns
- The singleton pattern is used to limit creation of a class to only one object. This is beneficial when one (and only one) object is needed to coordinate actions across the system. (caches, thread pools, and registries)
- Factory Method. Objects are created by calling a factory method instead of calling a constructor. `SomeClass someClassObject = new SomeClass();` SomeClass’s object, suddenly now becomes dependent on the concrete implementation of SomeClass
- In Strategy pattern, we create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.
- Observer. This pattern is a one-to-many dependency between objects so that when one object changes state, all its dependents are notified. This is typically done by calling one of their methods.
- Builder. As the name implies, a builder pattern is used to build objects. Sometimes, the objects we create can be complex, made up of several sub-objects or
- Adapter. This allows incompatible classes to work together by converting the interface of one class into another.


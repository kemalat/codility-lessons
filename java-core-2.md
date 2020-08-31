### Covariant Return Type
Overriding method can return SubClass.

```java
class SuperClass{
    public SuperClass method() {
           return new SuperClass();
    }
}
 
class SubClass extends SuperClass{
    @Override
    public SuperClass method() {
           return new SubClass();
    }
}
```


### Hiding 
public data member with same name is provided in in base and derived class

```java
class Foo {
    public int a = 3;
    public void addFive() { a += 5; System.out.print("f "); }
}
class Bar extends Foo {
    public int a = 8;
    public void addFive() { this.a += 5; System.out.print("b " ); }
}
public class test {
    public static void main(String [] args){
        Foo f = new Bar();
        f.addFive();
        System.out.println(f.a);
    }
}
```
### How do threads communicate with each other?
The monitor methods (wait(), notify(), notifyAll()) of java.lang.Object class is the primary means of communicating between threads.

### Race Condition and how to avoid?
A race condition occurs when two or more threads can access shared data and they try to change it at the same time. The part of the program which accesses the shared resource is known as the critical section. So, to avoid a race condition, we need to synchronize access to the critical section. ReentrantLock can be used to avoid race condition.

```java
    try {
        mutex.lock();
        return super.getNextSequence();
    } finally {
        mutex.unlock();
    }
```    

### java pass by value or pass by reference
All object references in Java are passed by value. This means that a copy of the value will be passed to a method. But the trick is that passing a copy of the value also changes the real value of the object. Java object variables are simply references that point to real objects in the memory heap. Therefore, even though Java passes parameters to methods by value, if the variable points to an object reference, the real object will also be changed.

### ConcurrentHashMap vs Collections.synchronizedMap
ConcurrentHashMap
- It is thread safe without synchronizing the whole map.
- Reads can happen very fast while write is done with a lock.
- There is no locking at the object level.
- The locking is at a much finer granularity at a hashmap bucket level.
- ConcurrentHashMap doesn’t throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.

SynchronizedHashMap
- Synchronization at Object level.
- Every read/write operation needs to acquire lock.
- Locking the entire collection is a performance overhead.
- gives access to only one thread to the entire map & blocks all the other threads.
- returns Iterator, which fails-fast on concurrent modification.

### map() vs flatMap()
Converts stream of one type to other type of stream. Flatmap produces a stream of new values. 

```java
Stream.of('1', '2', '3')							
	.map(ch -> Integer.parseInt(ch.toString()));	
```

```java
List<Integer> a = Arrays.asList(1, 2, 3);
List<Integer> b = Arrays.asList(4, 5);
List<Integer> c = Arrays.asList(6, 7, 8);

List<List<Integer>> listOfListofInts = Arrays.asList(a, b, c);
List<Integer> listofInts = listOfListofInts.stream()
										.flatMap(list -> list.stream())
										.collect(Collectors.toList());
```


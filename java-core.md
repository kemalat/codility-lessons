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



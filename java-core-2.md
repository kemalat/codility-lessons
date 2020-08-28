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

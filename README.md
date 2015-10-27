# Conflict Serializability Algorithm

I developed this brute force algorithm during my masters studies. It's a great aid to quickly determine whether a schedule is serializable and draw a precendence graph.  

**Features:**

* Can handle any size schedule
* Can test for **conflict Serializability** 
* Can draw a simple **precedence graph**
* Provides some feedback and basic explanation about the schedule
* It will specify iff it is **view serializable** (will only mention if it knows, but there are no set methods) 


Usage (from IDE)
------

1. Create a schedule: ```String[] schedule = {"r1x", "r2z", "r1z", "r3y", "r3y", "w1x", "w3y", "r2y", "w2z", "w2y"};```
2. Create an instance of Schedule (passing in schedule as parameter): ```Schedule s = new Schedule(schedule);```
3. Can call one of three methods:
    * ```s.getSchedule()```: returns the schedule 
    * ```s.precedenceGraph()```: returns a graphical representation of the precedence graph
    * ```s.conflictSerializableSolution()```: returns information on the schedule
    
    
**Input:**
```java
  String[] schedule = {"r1x", "r2z", "r1z", "r3y", "r3y", "w1x", "w3y", "r2y", "w2z", "w2y"};
  Schedule s = new Schedule(schedule);
  
  System.out.println(s.getSchedule());
  System.out.println(s.precedenceGraph());
  System.out.println(s.conflictSerializableSolution());
```

**Output:**
```java
  //getSchedule()
  r1x, r2z, r1z, r3y, r3y, w1x, w3y, r2y, w2z, w2y, 
  
  //precedenceGraph()
  3 -> 2
  1 -> 2

  //conflictSerializableSolution()
  Is Schedule Conflict-Serializable: True
  Schedule is acyclic, thus it's serializable.
  The schedule is also View-Serializable (Every conflict serializable schedule is also view serializable)
```

Usage (from Console):
------
**Input:**

 ```java 
 
 //run a sample program
 java -jar serializability.jar test
 
 //test with user-specified schedule
 java -jar serializability.jar "r1x", "r2z", "r1z", "r3y", "r3y", "w1x", "w3y", "r2y", "w2z", "w2y"
  ```
  
  **Output:**
```java

//java -jar serializability.jar test
To use the app, simple open command-prompt in the location of the serializability.jar file and add a schedule like shown below: 
  ...
  ...

//java -jar serializability.jar "r1x", "r2z", "r1z", "r3y", "r3y", "w1x", "w3y", "r2y", "w2z", "w2y"
The schedule: r1x, r2z, r1z, r3y, r3y, w1x, w3y, r2y, w2z, w2y,

Precedence Graph:
3 -> 2
1 -> 2

Is Schedule Conflict-Serializable: True
Schedule is acyclic, thus it's serializable.
The schedule is also View-Serializable (Every conflict serializable schedule is
also view serializable)


```
  
  

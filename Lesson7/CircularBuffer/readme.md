# Circular Buffer

## Tasks

The code
from [Java Interthread Communication Tutorial 3.htm](https://e-learn.sdu.dk/bbcswebdav/pid-5500815-dt-content-rid-9484374_2/xid-9484374_2)
shall be changed: Instead of the class Q, you must implement a `CircularBuffer`. The code for Producer, Consumer and
PCFixed have been included in this exercise.

### Task 1 - Implementation of CircularBuffer.java

- Data shall be in an array of Integer (the wrapper class) with a fixed size, e.g. `5`
- At start, all values must be `null`.
- The `Producers` try to put in values starting at `index = 0`. There can only be inserted a value if the place is empty (null). Else wait for a Consumer to empty the place.
- When a `Producer` has inserted a value on the last place, it should try to insert next value on `index = 0`.
- The `Consumers` takes the values starting on `index = 0`. If there is no value on the place, wait for a `Producer` to put in a value.
- When a value is taken, set the place to `null`.
- When the value on the last place is taken, start at `index = 0` again

### Task 2
Experiment with different numbers of `Producers` and `Consumers` in `PCFixed.java`

### Task 3
Experiment with different sleep-times in `Producer` and `Consumer`
# StackMachine

StackMachine is built using Java 8, StackMachine can be treated as a simple computer that has infinite memory and a stack that puts all information to be processed.

## Memory Model : 

This has 4 types of memory : 
1. Floating point common memory - Stores all numeric values in float 32 format.
2. Array Memory : A storage space that stores arrays.
3. String Memory : A constant string pool that stores all string variables.
4. A variable regisrty : A HashMap memory that stores all variables and its types.

#Instruction set : 
More instructions are yet to be added, you can check out availabe instructions at : architecture/InstructionSet.java. 
As of now, the machine can perfrom PUSH, POP, STORE, Store string, all arithmetic and bitwise operations, control and looping structures will be implemented later.

Example program :
```
VAR A=10.0
VAR B=20.0
PUSH A
PUSH B
ADD
STORE C
PRINT C
```

The above program, creates 2 variables A = 10 and B = 20, the next 2 instructions are used to push A and B onto stack. All arithmetic operations operate on elements on top of stack, by default we pop contents and push the result. You can use NADD, NSUB, NDIV, NMUL, NMOD to retain the contents of stack, (avoid pop).

STORE will store content on top of stack to a new variable C
PRINT C will print the content of variable C

Example program 2  : Arrays 

```
VARA A=10,20,30,40,
PUSH A:1
PUSH A:2
AND
STORE C
PRINT C
```

The above program, decalres an array A = 10, 20, 30, 40
PUSH instructions are used to push 20 i.e index 1 and 30 i.e index 2 into CPU Stack
AND Will perform bitwise AND
SOTRE and PRINT are explained in previous example.


Example program 3 : Strings
```
VARS S="Hello"
PRINT S
```

The above program creates a string "Hello" with label S
Prints "Hello"

# BlocksWorld-AI
Search Algorithms and Heuristics to solve the classic AI Problem- Blocksworld


Instructions on how to run the program: 
1.	Put the StackingBlocksProblem.jar at an appropriate location. Open command prompt and navigate to the location.
2.	Type the command: “java -cp StackingBlocksProblem.jar main.Main”.
3.	You will now see instructions on the screen on how to execute the program. These are also listed below for convenience.
a.	You can do a BFS or use any of the 5 heuristics for A* Search. The 5 heuristics are in the increasing order of quality. 
b.	Select the appropriate choice from the choices listed on the screen. 
c.	Choose 5 for the best solution.
d.	Next, if you want to run the search on a randomly generated start state, key in “Y”. If you want to create your own state, key in “N”.
e.	If you choose Y, you will be prompted for the number of stacks and number of blocks. Entering those will give you the solution.
f.	If you choose N, you will be prompted for the number of stacks and number of blocks. Entering these will prompt you to create your stacks.
i.	Enter the number of blocks in the first stack. Then enter the values of these blocks. 
ii.	Repeat for all the stacks.
iii.	Please be sure to enter all the numbers from 1 through n across the stacks. Any duplicate value entered, or any value entered that is above or below this range will exit the process and you will have to restart again.
4.	Right click and extract the JAR file. In the folder, you would contain both .class files and .java source files. 
5.	Optionally, extracting the zip file and importing in eclipse helps you open the project directly in eclipse.
6.	Sample outputs are provided below.


Sample Outputs:

Sample 1:

Enter 0 to perform BFS.
Enter 1 to perform A* Search using Heuristic 1.
Enter 2 to perform A* Search using Heuristic 2.
Enter 3 to perform A* Search using Heuristic 3.
Enter 4 to perform A* Search using Heuristic 4.
Enter 5 to perform A* Search using Heuristic 5.
Enter 6 to perform A* Search using only the two best Heuristics: 4 & 5.
Enter 7 to perform A* Search using all the 5 Heuristics
Your choice: 5
Do you want us to operate on a randomly generated start state?
Enter Y/N: Y
Enter Number of stacks: 3
Enter number of blocks: 5
Initializing A* Search using Heuristic Heuristic5 on:
1-> 3
2-> 2 5 4
3-> 1
**********************************************************************
The algorithm executed successfully.
The end state achieved is:
1-> 1 2 3 4 5
2->
3->

The maximum queue size reached: 230
The number of goal tests conducted: 102
The number of moves taken to reach goal: 11
**********************************************************************
**********************************************************************
Tracing the steps followed by the algorithm:
1-> 3
2-> 2 5 4
3-> 1

1-> 3 4
2-> 2 5
3-> 1

1-> 3 4 5
2-> 2
3-> 1

1-> 3 4 5
2-> 2 1
3->

1-> 3 4
2-> 2 1
3-> 5

1-> 3
2-> 2 1
3-> 5 4

1->
2-> 2 1
3-> 5 4 3

1-> 1
2-> 2
3-> 5 4 3

1-> 1 2
2->
3-> 5 4 3

1-> 1 2 3
2->
3-> 5 4

1-> 1 2 3 4
2->
3-> 5

1-> 1 2 3 4 5
2->
3->

********************************************************************** 

Sample 2: 

Enter 0 to perform BFS.
Enter 1 to perform A* Search using Heuristic 1.
Enter 2 to perform A* Search using Heuristic 2.
Enter 3 to perform A* Search using Heuristic 3.
Enter 4 to perform A* Search using Heuristic 4.
Enter 5 to perform A* Search using Heuristic 5.
Enter 6 to perform A* Search using only the two best Heuristics: 4 & 5.
Enter 7 to perform A* Search using all the 5 Heuristics
Your choice: 5
Do you want us to operate on a randomly generated start state?
Enter Y/N: N
Enter Number of stacks: 3
Enter number of blocks: 5
Enter number of blocks in Stack1: 2
Enter 2 values. Only enter numbers less than or equal to 5 and don't repeat the block numbers.
3
4
Enter number of blocks in Stack2: 2
Enter 2 values. Only enter numbers less than or equal to 5 and don't repeat the block numbers.
1
5
Enter number of blocks in Stack3: 1
Enter 1 values. Only enter numbers less than or equal to 5 and don't repeat the block numbers.
2
Initializing A* Search using Heuristic Heuristic5 on:
1-> 3 4
2-> 1 5
3-> 2
**********************************************************************
The algorithm executed successfully.
The end state achieved is:
1-> 1 2 3 4 5
2->
3->

The maximum queue size reached: 103
The number of goal tests conducted: 36
The number of moves taken to reach goal: 10
**********************************************************************
**********************************************************************
Tracing the steps followed by the algorithm:
1-> 3 4
2-> 1 5
3-> 2

1-> 3 4 5
2-> 1
3-> 2

1-> 3 4 5
2->
3-> 2 1

1-> 3 4
2-> 5
3-> 2 1

1-> 3
2-> 5 4
3-> 2 1

1->
2-> 5 4 3
3-> 2 1

1-> 1
2-> 5 4 3
3-> 2

1-> 1 2
2-> 5 4 3
3->

1-> 1 2 3
2-> 5 4
3->

1-> 1 2 3 4
2-> 5
3->

1-> 1 2 3 4 5
2->
3->

**********************************************************************


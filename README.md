#SafeCracker 50 Solver
A brute force solution for the SafeCracker 50 Puzzle.

The starting point it uses begins with the outer dial column of 1 in the order [1, 6, 0, 3, 19].

The output solution will always have 0 for the first array index since the outermost dial cannot be turned.
The number indicates how many places clockwise the dial should turn.
For example:

Solution: [0, 1, 1, 3, 15]

would mean

* Outer most dial clockwise turn: 0
* Second most outer dial clockwise turn: 1
* Middle dial clockwise turn: 1
* Second most inner dial clockwise turn: 3
* Inner most dial clockwise turn: 15

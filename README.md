# SafeCracker 50 Solver
A brute force solution for the SafeCracker 50 Puzzle.

The starting point it uses begins with the outer dial column of 1 in the order [1, 6, 0, 3, 19].

The output solution will always have 0 for the first array index since the outermost dial cannot be turned.
The number indicates how many places clockwise the dial should turn (negative for counterclockwise).
For example:

Solution: [0, 4, -4, -5, 3]

* Outermost dial does not turn: 0
* Second most outer dial clockwise turn: 4
* Middle dial counter-clockwise turn: 4
* Second most inner dial counter-clockwise turn: 5
* Innermost dial clockwise turn: 3

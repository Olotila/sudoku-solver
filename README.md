# sudoku-solver

This project is to showcase a recursive algorithm used to solve sudoku puzzles.

The algorithm is a *depth-first* approach meaning that it will keep trying the first subnode of the current node until it reaches a solution which will end the search, or hits a terminating condition which will backtrace to the last valid node then start a new branch.

The project also showcases principles of test driven development or TDD by using tests against every method to make sure it behaves as expected, rather than writing a main method and spot checking to make sure the results seem right. 

Test are written _before_ the implemented code. 
boggle
======

given an boggle grid of 16 letters, find all possible words

1. Dictionary :  N-ary tree structure to store all the sow pods words. provides loadFromFile() and contains() methods.
2. Dice : Represent dices. roll(), getTop() behaviour.
3. GridGenerator : Creates and rolls the dices. getGrid() returns the grid in an 2D array.
4. WordsGenerator : moves through the grid, creates possible sequences if dictionary contains any word starting with current sequence.
5. Boggle : The implementation (test) class.

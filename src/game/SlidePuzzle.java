package game;

import java.util.ArrayList;
import java.util.List;

import static game.ColorEnums.*;

class SlidePuzzle extends Puzzle {
    private final List<Integer> grid;
    private final int gridSize = 9;
    private boolean solved = false;

    public SlidePuzzle() {
        grid = new ArrayList<>(gridSize);

        for (int i = 0; i < gridSize; i++) {
            grid.add(i + 1);
            grid.sort(null);
        }

        this.puzzleAction(6);
        this.puzzleAction(5);
        this.puzzleAction(4);
        this.puzzleAction(1);
    }

    public SlidePuzzle(int moves) {
        grid = new ArrayList<>(gridSize);

        for (int i = 0; i < gridSize; i++) {
            grid.add(i + 1);
            grid.sort(null);
        }

        shuffle(moves);
    }

    private void shuffle(int count) {
        int start = 0;
        while (start < count) {
            int rand = (int)(Math.random() * 8) + 1;
            if (puzzleAction(rand)) {
                start++;
            }
        }
    }

    public boolean puzzleAction(int target) {
        boolean successResult = false;
        if (target < 0 || target > 9) {
            return false;
        }

        if (target == 0) {
            target = 9;
        }

        if (checkAdjacent(grid.indexOf(gridSize), grid.indexOf(target))) {
            int targetIndex = grid.indexOf(target);
            grid.set(grid.indexOf(gridSize), grid.get(targetIndex));
            grid.set(targetIndex, gridSize);
            successResult = true;
        }

        solved = checkSolved();
        return successResult;
    }

    private boolean checkAdjacent(int current, int target) {
        boolean isAdjacent = false;

        switch (current) {
            case 0:
                if (target == 1 || target == 3)
                    isAdjacent = true;
                break;
            case 1:
                if (target == 0 || target == 2 || target == 4)
                    isAdjacent = true;
                break;
            case 2:
                if (target == 1 || target == 5)
                    isAdjacent = true;
                break;
            case 3:
                if (target == 0 || target == 4 || target == 6)
                    isAdjacent = true;
                break;
            case 4:
                if (target == 1 || target == 3 || target == 5 || target == 7)
                    isAdjacent = true;
                break;
            case 5:
                if (target == 2 || target == 4 || target == 8)
                    isAdjacent = true;
                break;
            case 6:
                if (target == 3 || target == 7)
                    isAdjacent = true;
                break;
            case 7:
                if (target == 4 || target == 6 || target == 8)
                    isAdjacent = true;
                break;
            case 8:
                if (target == 5 || target == 7)
                    isAdjacent = true;
                break;
        }

        return isAdjacent;
    }

    @Override
    public boolean isSolved() {
        return solved;
    }

    private boolean checkSolved() {
        boolean isSolved = true;

        for (int i = 0; i < gridSize; i++) {
            if (grid.get(i) != i + 1) {
                isSolved = false;
            }
        }

        return isSolved;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        String color = null;

        for (int i = 0; i < gridSize; i++) {
            if (grid.get(i) == 9) {
                str.append("  ");
            }
            else {
                if (grid.get(i) == i + 1) {
                    color = GREEN_FONT;
                }
                else {
                    color = RED_FONT;
                }
                str.append(color).append(grid.get(i)).append(" ").append(RESET_TEXT);
            }

            if (i > 0 && i % 3 == 2) {
                str.append("\n");
            }

        }

        return str.toString();
    }

    @Override
    public String description() {
        return CYAN_FONT + "\nSLIDE" + RESET_TEXT + " or " + CYAN_FONT + "PUSH" + RESET_TEXT  + " a number [push 1] to push it into the open space. " +
                "You will receive a key once all of the numbers are in the" + GREEN_FONT + " correct position.\n" + RESET_TEXT;
    }
}
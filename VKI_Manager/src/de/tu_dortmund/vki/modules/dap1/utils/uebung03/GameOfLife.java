package de.tu_dortmund.vki.modules.dap1.utils.uebung03;

import java.util.Arrays;

public class GameOfLife {
    private boolean[][] population;
    private int size;

    public GameOfLife(int size) {
        this.size = size;
        this.population = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.population[i][j] = false;
            }
        }
    }

    public void nextState(int i, int j) {
        int neightbours = countLivingNeightbours(i, j);
        if(!this.population[i][j]) {
            if(neightbours >= 2 && neightbours <= 3) {
                this.population[i][j] = true;
            }
        }

        if(neightbours > 3) {
            this.population[i][j] = false;
        }
        if(neightbours < 2) {
            this.population[i][j] = false;
        }

    }

    private int countLivingNeightbours(int i, int j) {
        // i-1 i i+1
        // [] [] []  j-1
        // [] [] []  j
        // [] [] []  j+1
        int count = 0;
        if(i-1 > 0) {
            // First column
            if(j-1 > 0) {
                // First row
                if(i + 1 < this.population.length) {
                    for(int x = i - 1; x < i + 1; x++) {
                        if(this.population[i][j-1]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public void futureGeneration(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < this.population.length; j++) {
                for(int y = 0; y < this.population[j].length; y++) {
                    this.nextState(j, y);
                }
            }
        }
    }

    public void inject() {
        int i = size / 2;
        this.population[i][i] = true;
        this.population[i+1][i] = true;
        this.population[i][i+1] = true;
        this.population[i+1][i+1] = true;
    }
    public void injectSpaceship() {
        this.population[1][1] = true;
        this.population[2][2] = true;
        this.population[2][3] = true;
    }

    public void show() {
        System.out.print("\n\n");
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                System.out.print((this.population[i][j] ? "1" : "0") + " ");
            }
            System.out.print("\n");
        }
    }
}

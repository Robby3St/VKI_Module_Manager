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
            if(neightbours == 3) {
                this.population[i][j] = true;
            }
        } else {
            if(neightbours > 3) {
                this.population[i][j] = false;
            }
            if(neightbours < 2) {
                this.population[i][j] = false;
            }
        }


    }

    private int countLivingNeightbours(int i, int j) {
        // i-1 i i+1
        // [] [] []  j-1
        // [] [] []  j
        // [] [] []  j+1
        int count = 0;

        for (int row = -1; row<2; row++) {
            if (i+row >0 && i + row < population.length) {
                for (int column = -1; column < 2; column++) {
                    if(j+column > 0 && j+column < population[i+row].length) {
                        count += (population[i+row][j+column]) ? 1 : 0;
                    }
                }
            }
        }

        if (population[i][j]) {
            count-=1;
        }
        /*if (i>0) {
            count += (population[i-1][j])? 1 : 0;
        }
        if (j>0) {
            count += (population[i][j-1])? 1 : 0;
        }
        if (i+1 < population.length) {
            count += (population[i+1][j])? 1 : 0;
        }
        if (j+1 < population[i].length) {
            count += (population[i][j+1])? 1 : 0;
        }*/
        System.out.println("Count for i: " + i + " j: " + j + " is: " + count);
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
        this.population[2][2] = true;
        this.population[3][3] = true;
        this.population[3][4] = true;
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

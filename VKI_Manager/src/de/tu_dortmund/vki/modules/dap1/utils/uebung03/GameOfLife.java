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
        this.population = population;
    }

    public GameOfLife(boolean[][] population) {
        for(int i = 0; i < population.length; i++) {
            for(int j = 0; j < population[i].length; j++) {
                if(population[i].length != population.length) {
                    throw new RuntimeException(); // No square field
                }
            }
        }
    }

    public boolean nextState(int i, int j) {
        int neightbours = countLivingNeightbours(i, j);
        if(this.population[i][j]) {
            return neightbours >= 2 && neightbours <= 3;
        }
        return neightbours == 3;
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

        return count;
    }

    public void futureGeneration(int n) {
        boolean[][]temp_population = new boolean[population.length][population.length];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < temp_population.length; j++) {
                for(int y = 0; y < temp_population[j].length; y++) {
                    temp_population[j][y] = this.nextState(j, y);
                }
            }
        }
        this.population = temp_population;
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

    public void injectRandom() {
        for(int i = 0; i < this.population.length; i++) {
            for(int j = 0; j < this.population.length; j++) {
                if(Math.random() <= 0.3) {
                    this.population[i][j] = true;
                }
            }
        }
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

package org.algebra_3.LinearEquationSystems;

import java.util.Arrays;
import java.util.Iterator;

public class noPivot {
    private int[][] equations;
    private int[] xn;


    public noPivot(int[][] equations){
        this.equations = equations;
        this.xn = new int[equations.length];
    }

    public Iterator<Integer> solve(){
        descendent(equations,0);
        this.ascendant();
        return Arrays.stream(xn).iterator();
    }
    public int[] array(){
        for (int j : xn) {
            System.out.println(j);
        }
        return xn;
    }
    private int[][] descendent(int[][] equations, int step) {
        if (step == equations.length) return equations;

        for (int i = step + 1; i < equations.length; i++) {
            int factor = equations[i][step] / equations[step][step];
            for (int j = step; j < equations.length + 1; j++) {
                equations[i][j] -= factor * equations[step][j];
            }
        }

        return descendent(equations, step + 1);
    }
    private void ascendant() {
        xn[equations.length - 1] = equations[equations.length - 1][equations.length] / equations[equations.length - 1][equations.length - 1];

        for (int i = equations.length - 2; i >= 0; i--) {
            int sum = 0;
            for (int j = i + 1; j < equations.length; j++) {
                sum += equations[i][j] * xn[j];
            }
            xn[i] = (equations[i][equations.length] - sum) / equations[i][i];
        }
    }
}

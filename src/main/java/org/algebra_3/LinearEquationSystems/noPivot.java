package org.algebra_3.LinearEquationSystems;

import java.util.Arrays;
import java.util.Iterator;

public class noPivot {
    private float[][] equations;
    private float[] xn;


    public noPivot(float[][] equations){
        this.equations = equations;
        this.xn = new float[equations.length];
    }

    public void solve(){
        descendent(equations,0);
        this.ascendant();

    }
    public float[] array(){
        for (float j : xn) {
            System.out.println(j);
        }
        return xn;
    }
    private float[][] descendent(float[][] equations, int step) {
        if (step == equations.length) {return equations;}
        float division = equations[step][step];
        for (int j = step; j < equations.length+1 ; j++) {
            equations[step][j] =  equations[step][j]/division;
        }
        for (int i = step+1 ; i < equations.length; i++) {
            float factor = equations[i][step];

            for (int j = step; j < equations.length+1 ; j++) {
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

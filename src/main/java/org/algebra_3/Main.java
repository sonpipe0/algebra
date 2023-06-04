package org.algebra_3;

import org.algebra_3.LinearEquationSystems.noPivot;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[][] array =  {{1,2,3,1},{2,3,4,-1},{3,4,6,2}};
        noPivot equations = new noPivot(array);
        equations.solve();
        equations.array();

}}
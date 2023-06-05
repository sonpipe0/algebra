package org.algebra_3;

import org.algebra_3.LinearEquationSystems.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        float[][] array =  {{1,2,3,1},{2,3,4,-1},{3,4,6,2}};
        noPivot equations = new noPivot(array);
        equations.solve();
        System.out.println("\n");
        equations.array();
        float[][] array_2 =  {{1,2,3},{7,5,6},{9,13,1}};
        inverseMatrix matrix = new inverseMatrix(array_2);
        matrix.solve();

}}
package org.algebra_3.LinearEquationSystems;

public class inverseMatrix {
    private float[][] equations;




    public inverseMatrix(float[][] equations){
        this.equations = equations;
        this.reSize();
    }


    private void reSize(){
        float[][] temp = new float[equations.length][equations.length*2];
        for(int i=0;i< equations.length;i++){
            for(int j = 0; j< equations.length;j++){
                temp[i][j] = equations[i][j];
            }
        }
        for (int i= equations.length;i<2* equations.length;i++){
            temp[i- equations.length][i] = 1;
        }

        equations = temp;
    }

    private float[][] descendent(float[][] matrix, int step) {
        if (step == matrix.length) {return matrix;}
        float division = matrix[step][step];
        for (int j = step; j < 2* equations.length ; j++) {
            matrix[step][j] =  matrix[step][j]/division;
        }
        for (int i = step+1 ; i < equations.length; i++) {
            float factor = matrix[i][step];

            for (int j = step; j < 2* equations.length ; j++) {
                matrix[i][j] -= factor * matrix[step][j];
            }
        }

        return descendent(matrix, step + 1);
    }

    private float[][] ascendent(float[][] matrix, int step) {
        if (step == 0) return matrix;

        for (int i = step-1; i >=0; i--) {
            float factor = matrix[i][step] ;
            for (int j = step; j < matrix[i].length; j++) {
                matrix[i][j] -= factor * matrix[step][j];
            }
        }

        return ascendent(matrix, step-1);
    }

    public void solve(){
        descendent(equations,0);
        this.ascendent(equations, equations.length-1);
        for(int i= equations.length - 1; i >= 0; i--){
        this.iterate(i);
        }
    }

    public void iterate(int level){
        for(int i = equations[level].length/2 ; i < equations[level].length; i++){
            System.out.println(equations[level][i]);
        }
    }
}

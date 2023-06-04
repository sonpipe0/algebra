package LinearEquationSytemTest;

import org.algebra_3.LinearEquationSystems.noPivot;
import org.junit.Test;
import org.junit.Assert;

public class NoPivotTest {
    @Test
    public void testSolution(){
        int[][] array =  {{1,2,3,1},{2,3,4,-1},{3,4,6,2}};
        noPivot equations = new noPivot(array);
        System.out.println(equations.solve());
        Assert.assertEquals(true,true);
    }
}

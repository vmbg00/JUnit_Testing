package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    @Test
    public void testDurabilityLossAfterAttackShouldLoseExact1Point(){
        Axe axe = new Axe(0,1);
        Dummy dummy = new Dummy(100,100);

        axe.attack(dummy);

        int expectedPoints = 0;
        int actualPoints = axe.getDurabilityPoints();

        Assert.assertEquals(expectedPoints, actualPoints);
    }

    @Test (expected = IllegalStateException.class)
    public void testAttackWithDurability0(){
        Axe axe = new Axe(10,0);
        Dummy dummy = new Dummy(100,100);
        axe.attack(dummy);

    }

}

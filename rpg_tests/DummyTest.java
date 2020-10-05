package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTest {

    @Test
    public void testDummyLossesHealthIfAttacked(){
        Dummy dummy = new Dummy(10,10);
        dummy.takeAttack(5);
        Assert.assertEquals(5,dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testDeadDummyThrowsIfAttacked(){
        new Dummy(0,10).takeAttack(10);
    }

    @Test (expected = IllegalStateException.class)
    public void testIfHealthIsBelow0(){
        new Dummy(-1,10).takeAttack(10);
    }

    @Test
    public void testDeadDummyCanGiveXP(){
        int expected = 10;
        int actual = new Dummy(0,10).giveExperience();
        Assert.assertEquals(expected,actual);
    }

    @Test (expected = IllegalStateException.class)
    public void testAliveDummyWontGiveXP(){
        new Dummy(1,10).giveExperience();
    }
}

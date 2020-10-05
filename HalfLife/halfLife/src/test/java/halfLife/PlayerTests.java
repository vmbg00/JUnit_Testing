package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {

    @Test (expected = NullPointerException.class)
    public void test_usernameShouldThrow(){
        Player player = new Player(null,100);

        Assert.assertNull(player.getUsername());
    }

    @Test
    public void test_usernameShouldWork(){
        Player player = new Player("Pesho",100);

        Assert.assertEquals("Pesho",player.getUsername());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setHealthShouldThrow(){
        Player player = new Player("Pesho",-10);

        Assert.assertTrue(player.getHealth() > 0);
    }

    @Test
    public void test_setHealthShouldWork(){
        Player player = new Player("Pesho",10);

        Assert.assertTrue(player.getHealth() > 0);
    }

    @Test (expected = IllegalStateException.class)
    public void test_takeDamageShouldThrow(){
        Player player = new Player("Pesho",0);
        player.takeDamage(100);
    }

    @Test
    public void test_takeDamageShouldWork(){
        Player player = new Player("Pesho",50);
        player.takeDamage(5);
        Assert.assertEquals(45,player.getHealth());
    }

    @Test
    public void test_takeDamageShouldWorkV2(){
        Player player = new Player("Pesho",5);
        player.takeDamage(5);
        Assert.assertEquals(0,player.getHealth());
    }

    @Test
    public void test_removeGunShouldWork(){
        Player player = new Player("Pesho",5);
        Gun gun = new Gun("Opa",10);
        player.addGun(gun);

        Assert.assertTrue(player.removeGun(gun));
    }

    @Test (expected = NullPointerException.class)
    public void test_addGunShouldThrow(){
        Player player = new Player("Pesho",100);
        player.addGun(null);
    }


    @Test
    public void test_addGunShouldWork(){
        Player player = new Player("Pesho",100);
        Gun gun = new Gun("Pecata",100);
        player.addGun(gun);

        Assert.assertEquals(gun,player.getGun("Pecata"));
    }

    @Test
    public void test_addGunShouldReturnNull(){
        Player player = new Player("Pesho",100);
        Gun gun = new Gun("Pecata",100);
        player.addGun(gun);

        Assert.assertNull(player.getGun("Gego"));
    }

}

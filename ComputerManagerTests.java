package computers;

import org.junit.Assert;
import org.junit.Test;

public class ComputerManagerTests {
    // TODO: Test ComputerManager


    @Test(expected = UnsupportedOperationException.class)
    public void test_getComputersShouldThrow(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputers().add(new Computer("Opi","tata",500));
    }

    @Test
    public void test_getComputersShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputers();
    }

    @Test
    public void test_getCountMethodShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Opi","tata",500));
        int count = computerManager.getCount();

        Assert.assertEquals(1,count);
    }


    @Test (expected = IllegalArgumentException.class)
    public void test_addMethodShouldThrow(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Opi","tata",500));
        computerManager.addComputer(new Computer("Opi","tata",500));
    }

    @Test
    public void test_addMethodShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer("Opi","tata",500));
        computerManager.addComputer(new Computer("Opio","fefe",444));

    }

    @Test (expected = IllegalArgumentException.class)
    public void test_addMethodShouldThrowV2(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }

    @Test
    public void test_addMethodShouldWork2(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(new Computer(null,null,500));

        Assert.assertNotNull(computerManager.getComputers());
    }

    @Test
    public void test_removeMethodShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Opi", "tata", 500);
        computerManager.addComputer(computer);
        computerManager.removeComputer(computer.getManufacturer(),computer.getModel());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_removeMethodShouldThrow(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Opi", "tata", 500);
        computerManager.removeComputer("Opi","tata");
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_getComputerShouldThrow(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer(null,null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_getComputerShouldThrowV2(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer("Pepo",null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_getComputerShouldThrowV3(){
        ComputerManager computerManager = new ComputerManager();
        computerManager.getComputer(null,"Pesho");
    }

    @Test
    public void test_getComputerShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Opi", "tata", 500);
        computerManager.addComputer(computer);
        Computer computer1 = computerManager.getComputer("Opi", "tata");

        Assert.assertNotNull(computer1);
    }

    @Test
    public void test_getComputersManufacturerMethodShouldWork(){
        ComputerManager computerManager = new ComputerManager();
        Computer computer = new Computer("Opi", "tata", 500);
        Computer computer1 = new Computer("Opipa", "tatara", 333);
        Computer computer2 = new Computer("Opi", "tatava", 111);

        computerManager.addComputer(computer);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);

        Assert.assertNotNull(computerManager.getComputersByManufacturer("Opi"));
    }



    @Test (expected = IllegalArgumentException.class)
    public void test_getComputersManufacturerMethodShouldThrow(){
        ComputerManager computerManager = new ComputerManager();

        computerManager.getComputersByManufacturer(null);
    }
}
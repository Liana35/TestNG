package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGannotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("i am before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("i am after Method");
    }
    @Test
    public void aFirstTestCase(){
        System.out.println("i am the first text case");

    }

    @Test
    public void bSecondTestCase(){
        System.out.println("i am the second test case");
    }

    @Test
    public  void cThirdTestCase(){
        System.out.println("i am third test case");
    }
}

package class04;

import org.testng.annotations.*;

public class Annotations02 {
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before Test");
    }
    @BeforeClass
    public static void beforeClass(){
        System.out.println("I am before class");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("I am after class");
    }

    @BeforeMethod
    public void before(){
        System.out.println("i am before Method");
    }
    @AfterMethod
    public void after(){
        System.out.println("i am after Method");
    }
    @Test
    public void TestA(){
        System.out.println("i am test A");
    }
    @Test
    public void TestB(){
        System.out.println("i am test B");
    }
}

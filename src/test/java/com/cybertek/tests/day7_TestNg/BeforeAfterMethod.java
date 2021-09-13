package com.cybertek.tests.day7_TestNg;

import org.testng.annotations.*;

public class BeforeAfterMethod {

@Test    //need to put before every single method
    public void Test1(){

    System.out.println("my test");
}

  @Test
  public void Test2(){

      System.out.println("my second test");
  }

  //if u wana run a method BEFORE all other class...u can write it middle last anywhere but it will run before all

    @BeforeClass
    public void BeforeAll(){

        System.out.println("it will run BEFORE all methods in class but for one time only");
    }

    //if u wana run a method AFTER all other class...u can write it middle last anywhere but it will run before all

    @AfterClass

    public void AfterAll(){

        System.out.println("it will run AFTER all methods in class but for one time only");
    }

    @BeforeMethod   //will run before every single @test method
    public void testBefore(){
        System.out.println("-----before every method----");
    }

    @AfterMethod    //will run after  every single @test method
    public void testAfter(){
        System.out.println("-----after every method----");
    }

}

package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {


    @DataProvider
    public Object[][] testData(){//its returning array etc...object can return string array whatever

        String[][] data={               //{},{}represents two arrays     [][] two d array means more than one parameter in {}


                {"Person of Interest","10"},//for each of data in{} there is separate test anotation
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"The Office","8"},
                {"Friends","7"},
                {"Westworld","10"},
                {"Gotham","9"},
                {"Dark","8"},
                {"Titans","6"}




        };
        return data;
    }


    @Test(dataProvider ="testData") //to get the data fro test from data provider name
    public void test1(String tvshow,String rating){  //test one and gv parameters tv show and rating as in this class
        System.out.println("Tv show: "+tvshow +" has rating "+rating);

    }
}



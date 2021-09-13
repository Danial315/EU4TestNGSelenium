package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //Create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that wew want to open(sheetName)

        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //how may rows in sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());
        //how many columns in sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all data in List of Maps  (from collections list maps etc)
        //each row represents one mao(K,V) through key n value structure coz paswrd username surname etc are keys
        //n values are their values eg whts password
        List<Map<String, String>> dataList = qa3short.getDataList();//like we stores multiple webelements in
        //list<webelemnts> same like that we habe one row is one map as i explained in line 29 so we need list of Map
        // qa3short accepts two string parameters that why we have this structure List<Map<String, String>>

       // get all the key nd values ..string key other string value..v  can all using loop cz there r so many key n values n data
        for (Map<String, String> onerow : dataList) {//for beter understanding we can write onerow to understand btr that data is for
            //row by row

           // System.out.println(onerow);//gives all the key n values row by row (for each row)

        }

        //get Nona as a value
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));//first name of list to get the map
        // nd to reach the row through index(rmemebr frst row doesnt count cz it has no values only general info)
        //index is list mthod n gv u all the info of that row..frst get list method nd second get map method
        //then .get again to acces methods of map . this get method will accept key and gives u value

        //to print herber
        System.out.println("dataList.get(9).get(\"lastname\") = " + dataList.get(8).get("lastname"));//cz no couting frst row



        //get all data in 2d array
        String [][] dataArray = qa3short.getDataArray();

        //print 2d array
        System.out.println(Arrays.deepToString(dataArray));

    }

}

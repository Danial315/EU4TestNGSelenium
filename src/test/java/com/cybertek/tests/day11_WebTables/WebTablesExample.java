package com.cybertek.tests.day11_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable(){

        WebElement table=driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());//to print all the contents of table
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));


    }
    @Test
    public void test(){
      //how many columns we have//so need elements not element

        List<WebElement> headers =driver.findElements(By.xpath("//table[@id='table1']//th"));
        //get size/num of columns
        System.out.println("headers.size() = " + headers.size());

        //to print every column name one by one
        for (WebElement header : headers) {

            System.out.println(header.getText());
        }

    }

    @Test
    public void printTbaleSize(){
        //how many columns
        List<WebElement> headers =driver.findElements(By.xpath("//table[@id='table1']//th"));
        //get size/num of columns
        System.out.println("headers.size() = " + headers.size());

        //how manuy rows we have?

        //xpath without heading=//table[@id='table1']/tbody/tr
        //xpath with heading===//table[@id='table1']/tr
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
       //numof rows without header
        System.out.println("rows.size() = " + rows.size());

        //get rows content one by one for each row
        for (WebElement row : rows) {

            System.out.println(row.getText());;
        }


    }
    @Test
    public void printTableSize2(){
        //how many columns we have ?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
    }
    @Test
    public void getRow(){
        //print the second row information
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        //System.out.println(row2.getText());

        //get all rows dynamically
        //1.find number of rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2.iterate one by one
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println("row "+i+"= " +row.getText());
        }
    }
    @Test
    public void getAllCellInOneRow(){

        //all cells one by one of row2
        List<WebElement> allCellsRow2 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));

        for (WebElement rowCellsOneByOne : allCellsRow2) {

            System.out.println(rowCellsOneByOne.getText());

        }
    }

    @Test
    public void getASingleCellByIndex(){

        //get n print row2cell3
        WebElement singleCellOfRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));

        System.out.println("singleCellOfRow = " + singleCellOfRow.getText());

    }
    @Test
    public void printAllCellsByIndex(){
        //creatinf methods with shortcuts ..just write name of method u want and then hover over it n select
        //create method

        int rowNumber = getNumberOfRows();  //method assinged to int variable..line150
        int colNumber = getNumberOfColumns();



        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table
        //means for each row= i whole all coulmn=j will run cz j loop is in i loop so will run all
        for (int i = 1; i <= rowNumber; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <= colNumber; j++) {

                String cellXpath = "//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);


                //it will print for every row and column ony by one..means what is the text at i=1 and j=3..like this
                //every elemnt of every row

                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());
            }
        }
    }

    private int getNumberOfColumns() {

        List<WebElement> allColumns =driver.findElements(By.xpath("//table[@id='table1']//th"));
        return allColumns.size();

    }

    private int getNumberOfRows() {

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();

    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){


        String firstName="Jason";

        //instead of jason put first name so whenever u chnge first naem it will find email of that name

        String xpath ="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        //"//table[@id='table1']=table locatore....//td[.='"+firstName+"']=locator of name jason coz it can change psotion
        //so need to find a locator which works even the location is changed..    /../td[3]"= from finding name we went back ti parent
        // with /../ and then selected td[3] which is locator of email

        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }



}

package com.letskodeit.testclasses;

import com.letskodeit.BaseTest.BaseTest;
import com.letskodeit.Utilitiles.Constants;
import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.SearchBarPage;
import com.letskodeit.Utilitiles.Constants;
import com.letskodeit.Utilitiles.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllCoursesTests extends BaseTest {

    @DataProvider(name = "verifySearchCourseData")
    public Object[][] getVerifySearchCourseData(){
        Object[][] testData = ExcelUtility.getTestData("verify_search_course");
        return testData;
    }

    @BeforeClass
    public void setUp() {
        nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");
    }

    @Test(dataProvider = "verifySearchCourseData")
    public void verifySearchCourse(String courseName) {
        nav.allCourses();
        search = new SearchBarPage(driver);
        result = search.course(courseName);
        boolean searchResult = result.verifySearchResult();
        Assert.assertTrue(searchResult);
    }

    @Test(enabled = false)
    public void filterByCategory() {
        nav.allCourses();
        category = new CategoryFilterPage(driver);
        result = category.select("Software IT");
        int count = category.findCoursesCount("Software IT");
        boolean filterResult = result.verifyFilterCourseCount(count);
        Assert.assertTrue(filterResult);
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}

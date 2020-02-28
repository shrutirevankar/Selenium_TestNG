package com.letskodeit.testclasses;

import com.letskodeit.BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @BeforeClass
    public void setUp() {




    }

    @AfterMethod
    public void afterMethod()
    {
        if(nav.isUserLoggedIn())
        {
            nav.logout();
            nav.login();
        }
    }

    @Test
    public void testLogin() {
        nav = login.signInWith("shruti.revankar1993@gmail.com", "azuruk@123");
        boolean result = nav.verifyHeader();
        //boolean result = nav.isUserLoggedIn();
        Assert.assertTrue(result);
    }

    @Test(enabled=false)
    public void testInvalidLogin() {
        nav = login.signInWith("test@e", "abcbc");
        boolean result = nav.isUserLoggedIn();
        Assert.assertTrue(result);
    }
}

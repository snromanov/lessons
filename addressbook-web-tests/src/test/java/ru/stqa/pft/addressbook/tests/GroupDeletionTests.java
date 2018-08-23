package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


    
    @Test
    public void testGroupDeletionTests() {
        app.getNaviationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
        app.getGroupHelper().returnToGroupPage();
    }

    @AfterMethod
    public void tearDown() {
        app.getGroupHelper().wd.quit();
    }


}

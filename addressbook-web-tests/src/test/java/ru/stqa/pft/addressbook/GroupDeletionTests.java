package ru.stqa.pft.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


    
    @Test
    public void testGroupDeletionTests() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteGroup();
        app.returnToGroupPage();
    }

    @AfterMethod
    public void tearDown() {
        app.wd.quit();
    }


}

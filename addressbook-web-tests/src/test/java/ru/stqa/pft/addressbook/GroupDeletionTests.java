package ru.stqa.pft.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


    
    @Test
    public void testGroupDeletionTests() {
        gotoGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupPage();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }


}

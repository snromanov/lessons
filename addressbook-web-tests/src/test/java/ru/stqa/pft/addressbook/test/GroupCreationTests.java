package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        groupHelper.initGroupCreation();
        groupHelper.fillGroupForm(new GroupData("test2", "test3", "test4"));
        groupHelper.submitGroupCreation();
        groupHelper.returnToGroupPage();
    }
}


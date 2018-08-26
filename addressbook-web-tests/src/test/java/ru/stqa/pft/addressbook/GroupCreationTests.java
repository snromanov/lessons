package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test2", "test3", "test4"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}

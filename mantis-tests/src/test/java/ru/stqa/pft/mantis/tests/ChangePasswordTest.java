package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.models.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTest extends  TestBase{
  @BeforeMethod
  public  void startMailServer() {
    app.mail().start();
  }
  @Test
  public void testChangePassword() throws IOException, MessagingException {

    String user = "user1";
    String passwordNew = "password2";
    String email = user+"@localhost.localdomain";
    app.webHelper().loginOnWeb("administrator", "root");
    app.webHelper().tapForLink("Manage");
    app.webHelper().tapForLink("Manage Users");
    app.webHelper().tapForLink(user);
    app.webHelper().click(By.xpath("//input[@value = 'Reset Password']"));
    List<MailMessage> mailMessages = app.mail().waitFromMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, passwordNew );
    assertTrue(app.newSession().login(user, passwordNew));

  }

  @AfterMethod(alwaysRun = true)
  public  void  stopMailServer(){
    app.mail().stop();
  }



  private String  findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);

  }

}
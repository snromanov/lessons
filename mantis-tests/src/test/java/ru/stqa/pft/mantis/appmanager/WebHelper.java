package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class WebHelper extends  HelperBase {

  public WebHelper(ApplicationManager app) {
    super(app);
  }

  public void loginOnWeb(String username, String password) {
    wd.get(app.getProperty("web.baseURL")+ "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.xpath("//input[@type = 'submit']"));
  }

  public void tapForLink(String text) {
    wd.findElement(By.xpath("//a[text() ='"+text+"']")).click();
  }

  public void click(By locator) {
    super.click(locator);
  }

}
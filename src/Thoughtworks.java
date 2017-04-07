import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ranchanarajasekaran on 06/04/17.
 */
public class Thoughtworks {
   FirefoxDriver driver = new FirefoxDriver();
   @After
   public void afterTest(){
      driver.close();
   }

   @Test
   public void testVerifyChennaiOfficeAddress() {

      driver.get("https://www.thoughtworks.com");
      driver.findElement(By.cssSelector("#main-menu > li:nth-child(3) > a")).click();
      assertThat(driver.getCurrentUrl(),is("https://www.thoughtworks.com/products"));
      driver.findElement(By.cssSelector("#util-menu > li:nth-child(3) > a")).click();
      driver.findElement(By.cssSelector("#office-india")).click();
      driver.findElement(By.xpath("//*[@id=\"desktop-office-list\"]/a[22]")).click();
      assertThat(driver.findElement(By.cssSelector("#vertical-offices > div:nth-child(6) > div.grid__cell.office.active > div > div.grid__cell.grid__cell--no-bottom-margin.unit-1-2--portable.office-address")).getText(),is(
              "ThoughtWorks Technologies (India) Pvt Ltd.\nAscendas International Tech Park\nZenith - 9th Floor\nTharamani Road\nTharamani\nChennai - 600 113, India"));

   }

}
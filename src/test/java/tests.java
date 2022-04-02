import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class tests {

//    @Test
//    public void checkHead(){
//        Configuration.pageLoadStrategy = "eager";
//        Selenide.open("https://www.mvideo.ru/");
//
//
////        .shouldBe(Condition.visible).isDisplayed();
//        element(By.xpath("//div[contains(@class, 'tab-profile')]")).shouldBe(Condition.visible).find(By.xpath("//*[contains(@class, 'disabled')]"));
//        element(By.xpath("//div[contains(@class, 'tab-compare')]")).shouldBe(Condition.visible).find(By.xpath("//*[contains(@class, 'disabled')]"));
//        element(By.xpath("//div[contains(@class, 'tab-personal')]")).shouldBe(Condition.visible).find(By.xpath("//*[contains(@class, 'disabled')]"));
//        element(By.xpath("//div[contains(@class, 'tab-cart')]")).shouldBe(Condition.visible).find(By.xpath("//*[contains(@class, 'disabled')]"));
//    }
//    //mvid-bubble class="bubble ng-star-inserted" _nghost-serverapp-c199 1
//    @Test
//    public void activeCart(){
//        Configuration.holdBrowserOpen = true;
//        Selenide.open("https://www.mvideo.ru/");
//        Selenide.sleep(2000 );
//        element(By.xpath("//mvid-day-products-block")).shouldBe(visible);
//        element(By.xpath("(//mvid-icon[contains(@class, 'cart_icon')])[2]")).shouldBe(visible).click();
//        Selenide.sleep(5000);
//        element(By.xpath("//div[contains(@class, 'tab-cart')]//mvid-bubble")).shouldBe(visible);
//    }
    @Test
    public void test (){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().checkButtonHeader();
    }
    @Test
    public void test1 (){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().checkAddProduct();
    }
    @Test
    public void test2(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().checkAddProductInProductPageFavoriteProductDay();
}
    @Test
    public void test3(){
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().checkAdd2ProductMostlySeen();
}
@Test
    public void test4(){
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().searchApple();
}@Test
    public void test5(){
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().searchAppleForFilter();
}
@Test
    public void test6(){
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(5000 );
        new Steps().productComparison();
}
    @Test
    public void test7(){
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(2000 );
        new Steps().productPersonal();
}

}
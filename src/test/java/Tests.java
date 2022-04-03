import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
    @BeforeMethod
    public void openMvideo(){
        Selenide.open("https://www.mvideo.ru/");
        Selenide.sleep(2000 );

    }
    @Test(description = "Проверка шапки главной страницы mvideo", priority = 1)
    public void test1 (){
        new Steps().checkButtonHeader();
    }
    @Test(description = "Проверка активации кнопки корзины", priority = 2)
    public void test2 (){
        new Steps().checkAddProduct();
    }
    @Test(description = "Переход в корзину", priority = 3)
    public void test3(){
        new Steps().checkAddProductInProductPageFavoriteProductDay();
}
    @Test(description = "Добавление в корзину два товара", priority = 4)
    public void test4(){
        new Steps().checkAdd2ProductMostlySeen();
    }
    @Test(description = "Поиск товаров", priority = 5)
    public void test5(){
        new Steps().searchApple();
    }

    @Test(description = "Сортировка товаров в листинге", priority = 6)
    public void test6(){
        new Steps().searchAppleForFilter();
    }

    @Test(description = "Проверка модального окна авторизации клиента", priority = 7)
    public void test7(){
        new Steps().checkProfile();
    }

    @Test(description = "Проверка добавления товаров в список сравнения", priority = 8)
    public void test8(){
        new Steps().productComparison();
    }
    @Test(description = "Проверка добавления товара в список избранного", priority = 9)
    public void test9(){
        new Steps().productPersonal();
    }
    @Test(description = "Проверка изменения города", priority = 10)
    public void test10(){
        new Steps().locationCheck();
    }

}
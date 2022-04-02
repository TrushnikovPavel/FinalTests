import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.parseInt;

public class MvideoPage {
    private static SelenideElement selenideElement;

    private static MvideoPage mvideoPage;

    private final String containerHeadButton = "//div[contains(@class, 'nav-tabs')].//a[text() = ' %s ']";

    @FindBy(xpath = "//div[contains(@class, 'tab-profile')]")
    public SelenideElement buttonProfile;

    @FindBy(xpath = "//div[contains(@class, 'tab-compare')]")
    public SelenideElement buttonCompare;

    @FindBy(xpath = "//div[contains(@class, 'tab-personal')]")
    public SelenideElement buttonPersonal;

    @FindBy(xpath = "//div[contains(@class, 'tab-cart')]")
    public SelenideElement buttonCart;

    @FindBy(xpath = "//mvid-header-icon[contains(@class, 'tab-status-order')]")
    public SelenideElement buttonStatusOrder;

    @FindBy(xpath = "//mvid-day-products-block")
    public SelenideElement productsDayBlock;

    @FindBy(xpath = "(//mvid-day-products-block//div[contains(@class, 'title')])[2]/a")
    public SelenideElement productsDayBlockName;

    @FindBy(xpath = "(//mvid-day-products-block//span[contains(@class, 'price__main-value')])[2]")
    public SelenideElement productsDayBlockPrice;

    @FindBy(xpath = "(//mvid-icon[contains(@class, 'cart_icon')])[2]")
    public SelenideElement buttonAddProductDay;

    @FindBy(xpath = "//div[contains(@class, 'tab-cart')]//mvid-bubble")
    public SelenideElement bubbbleInCartButton;

    @FindBy(xpath = "//span[contains(@class, 'c-header-checkout__logo')]")
    public SelenideElement headerLogo;

    @FindBy(xpath = "//div[contains(@class, 'o-checkout__block_left')]//a[contains(@class, 'c-cart-item__title')]")
    public SelenideElement productCardNameInCart;

    @FindBy(xpath = "//span[contains(@class, 'c-cart-item__price')]")
    public SelenideElement productCardPriceInCart;

    @FindBy(xpath = "//span[contains(@class, 'c-cost-line__text')]")
    public SelenideElement finalPriceInCart;

    @FindBy(xpath = "//div[contains(@class, 'c-cost-line__title-wrap')]//span[contains(@class, 'c-cost-line__title')]")
    public SelenideElement productQuantityInCart;

    @FindBy(xpath = "//input[contains(@class, 'sel-common-button-create-order')]")
    public SelenideElement buttonGoToTheDesign;

    public String productCardNameInFavorite;
    public Integer productCardPriceInFavoriteInt;
    public Integer productCardPriceInCartInt;


    public void buttonStatusOrderIsActive() {
        buttonStatusOrder.shouldBe(visible).isDisplayed();
    }

    public void buttonProfileIsActive() {
        buttonProfile.shouldBe(visible).isDisplayed();
    }

    public void buttonCompareIsNotActive() {
        buttonCompare.shouldBe(visible).find(By.xpath(".//*[contains(@class, 'disabled')]"));
    }

    public void buttonPersonalIsNotActive() {
        buttonPersonal.shouldBe(visible).find(By.xpath(".//*[contains(@class, 'disabled')]"));
    }

    public void buttonCartIsNotActive() {
        buttonCart.find(By.xpath(".//*[contains(@class, 'disabled')]")).shouldBe(visible);
    }

    public void blockDayProductIsVisible() {
        productsDayBlock.shouldBe(visible);
    }

    public void clickAddInCart() {
        buttonAddProductDay.click();
    }

    public void cartIsActive() {
        buttonCart.shouldBe(visible).isDisplayed();
    }

    public void cartBubbleNumber() {
        Integer bubbleNumberFact = parseInt(bubbbleInCartButton.getText());
        Integer bubbleNumberExp = 1;
        assert (bubbleNumberFact.equals(bubbleNumberExp));
    }

    public void clickOnButtonCart() {
        buttonCart.shouldBe(visible).click();
    }

    public void urlEqualsUrlCart() {
        String actualUrl = WebDriverRunner.url();
        String expectedUrl = "https://www.mvideo.ru/cart";
        assert (actualUrl.equals(expectedUrl));
    }


    public void headerLogoVisible() {
        headerLogo.shouldBe(visible).isDisplayed();
    }

    public String getProductNameFavorite() {

        productCardNameInFavorite = productsDayBlockName.getText();
        return productCardNameInFavorite;
    }

    public Integer getProductPriceFavorite() {
        productCardPriceInFavoriteInt = parseInt(productsDayBlockPrice.getText().replaceAll("\\s+", ""));
        return productCardPriceInFavoriteInt;
    }

    public void checkProductCardName() {
        productCardNameInCart.shouldBe(visible).isDisplayed();
        String productCardNameInCartFor = productCardNameInCart.getText();
        assert productCardNameInCartFor.equals(productCardNameInFavorite);
    }

    public Integer getProductCardPrice() {
        productCardPriceInCartInt = parseInt(productCardPriceInCart.getText().replaceAll("\\s+", "").replaceAll("¤", ""));
        return productCardPriceInCartInt;
    }

    public void favoritePriceEqualsCartPrice() {
        assert productCardPriceInCartInt.equals(productCardPriceInFavoriteInt);
    }

    public void cartPriceEqualsFinalPriceWithOneProduct() {
        assert productCardPriceInCart.getText().equals(finalPriceInCart.getText());
    }

    public void buttonGoToTheDesignNormal() {
        buttonGoToTheDesign.shouldBe(visible).isDisplayed();
        assert buttonGoToTheDesign.getValue().equals("Перейти к оформлению");
    }

    public void productQuantityInCartNormal() {
        productQuantityInCart.shouldBe(visible).isDisplayed();
        productQuantityInCart.getText().equals("В корзине 1 товар");
    }

    public static MvideoPage getMvideoPage() {
        if (Objects.isNull(mvideoPage)) mvideoPage = Selenide.page(new MvideoPage());
        return mvideoPage;
    }

    //Для теста 4
//    *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//mvid-simple-product-collection-mp[2]")
    public SelenideElement mostlySeenCategory;

    @FindBy(xpath = "(//mvid-simple-product-collection-mp[2]//button[contains(@class, 'actions__cart')])[1]")
    public SelenideElement addToCartMostlySeenProductFirst;

    @FindBy(xpath = "(//mvid-simple-product-collection-mp[2]//button[contains(@class, 'actions__cart')])[2]")
    public SelenideElement addToCartMostlySeenProductSecond;

    @FindBy(xpath = "(//mvid-simple-product-collection-mp[2]//span[contains(@class, 'price__main-value')])[1]")
    public SelenideElement priceMostlySeenProductFirst;

    @FindBy(xpath = "(//mvid-simple-product-collection-mp[2]//span[contains(@class, 'price__main-value')])[2]")
    public SelenideElement priceMostlySeenProductSecond;

    @FindBy(xpath = "//mvid-simple-product-collection-mp[2]//div[contains(@class, 'product-mini-card__name')][1]")
    public SelenideElement nameMostlySeenProductFirst;

    @FindBy(xpath = "//mvid-simple-product-collection-mp[2]//div[contains(@class, 'product-mini-card__name')][2]")
    public SelenideElement nameMostlySeenProductSecond;

    @FindBy(xpath = "(//div[contains(@class, 'c-cart__order')])[1]//a[contains(@class, 'c-cart-item__title')]")
    public SelenideElement nameMostlySeenProductFirstInCart;

    @FindBy(xpath = "(//div[contains(@class, 'c-cart__order')])[2]//a[contains(@class, 'c-cart-item__title')]")
    public SelenideElement nameMostlySeenProductSecondInCart;

//    @FindBy(xpath = "(//div[contains(@class, 'c-cart__order')])[2]//a[contains(@class, 'c-cart-item__title')]")
//    public SelenideElement finalPriceInCart;

    String productNameMostlySeenFirstStr;

    String productNameMostlySeenSecondStr;

    Integer productPriceMostlySeenFirstInt;

    Integer productPriceMostlySeenSecondInt;

//    Integer productPriceMostlySeenFinalPrice = productPriceMostlySeenFirstInt+productPriceMostlySeenFirstInt;

    public void scrollInToViewMostlySeenCategory() {
        mostlySeenCategory.scrollIntoView(true);
    }

    public void mostlySeenCategoryVisible() {
        mostlySeenCategory.find(By.xpath(".//h2[(text() ='Самые просматриваемые')]")).shouldBe(visible).isDisplayed();
    }

    public void mostlySeenAdd2ProductInCart() {
        addToCartMostlySeenProductFirst.click();
        addToCartMostlySeenProductSecond.click();
    }

    public Integer getProductPriceMostlySeenFirst() {
        productPriceMostlySeenFirstInt = parseInt(priceMostlySeenProductFirst.getText().replaceAll("\\s+", ""));
        return productCardPriceInFavoriteInt;
    }

    public String getProductNameMostlySeenFirst() {
        productNameMostlySeenFirstStr = nameMostlySeenProductFirst.getText();
        return productNameMostlySeenFirstStr;
    }

    public String getProductNameMostlySeenSecond() {
        productNameMostlySeenSecondStr = nameMostlySeenProductSecond.getText();
        return productNameMostlySeenSecondStr;
    }

    public Integer getProductPriceMostlySeenSecond() {
        productPriceMostlySeenSecondInt = parseInt(priceMostlySeenProductSecond.getText().replaceAll("\\s+", ""));
        return productCardPriceInFavoriteInt;
    }

    public void correctNameProductsInCart() {
        assert productNameMostlySeenFirstStr.equals(nameMostlySeenProductFirstInCart.getText());
        assert productNameMostlySeenSecondStr.equals(nameMostlySeenProductSecondInCart.getText());
    }

    public void correctPriceProductsInCart() {
        int mathFinalPrice = productPriceMostlySeenFirstInt + productPriceMostlySeenSecondInt;
        assert mathFinalPrice == (parseInt(finalPriceInCart.getText().replaceAll("\\s+", "").replaceAll("¤", "")));
    }

    //Для теста 5 и 6
//    *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //div[contains(@class, 'search-container')]
    @FindBy(xpath = "//input[contains(@class, 'input__field')]")
    public SelenideElement searherField;

    @FindBy(xpath = "//div[contains(@class, 'search-icon-wrap')]")
    public SelenideElement searherFieldButton;

    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')][1]")
    public SelenideElement productRow1;

    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')][2]")
    public SelenideElement productRow2;

    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')][3]")
    public SelenideElement productRow3;

    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')][4]")
    public SelenideElement productRow4;

    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')][5]")
    public SelenideElement productRow5;

    @FindBy(xpath = "//div[contains(@class, 'product-cards-row')][6]")
    public SelenideElement productRow6;

    @FindBy(xpath = "//mvid-product-list-controls//div[contains(@class, 'dropdown__title')]")
    public SelenideElement dropDownButton;

    @FindBy(xpath = "//div[contains(@class, 'dropdown__options')]")
    public SelenideElement dropDownButtonMenu;


    ElementsCollection productNamesContainsApple;

    public void searherFieldIsVisible() {
        searherField.shouldBe(visible).isDisplayed();
    }

    public void searchApple() {
        searherField.setValue("Apple");
        searherFieldButton.click();
    }

    public void urlEqualsUrlForApple() {
        String actualUrl = WebDriverRunner.url();
        String expectedUrl = "https://www.mvideo.ru/product-list-page";
        assert (actualUrl.contains(expectedUrl));
        assert (actualUrl.contains("apple"));
    }

    public void allProductsContainsApple() {
        Integer productNamesContainsApple = Selenide.$$x("//a[contains(@class, 'product-title__text')]").filterBy(text("apple")).size();
        assert productNamesContainsApple == 24;
    }

    public void scrollAll() {
        productRow1.scrollIntoView(true);
        productRow2.scrollIntoView(true);
        productRow3.scrollIntoView(true);
        productRow4.scrollIntoView(true);
        productRow5.scrollIntoView(true);
        productRow6.scrollIntoView(true);
        productRow1.scrollIntoView(false);
    }

    public void checkDropDown() {
        dropDownButton.shouldBe(visible).isDisplayed();
        dropDownButton.find(By.xpath(".//span[(text() ='Сначала популярные')]")).shouldBe(visible);
    }

    public void openDropDownMenu() {
        dropDownButton.click();
        Selenide.sleep(1000);
    }
    public void clickInDropDownMenuMoreExpensive() {
        dropDownButtonMenu.find(By.xpath(".//div[text() = ' Сначала дороже ']")).click();
    }

    public void getCollectionPriceAndConwert(){
        Iterable<SelenideElement> productPriceContainsApple = Selenide.$$x("//span[contains(@class, 'price__main-value')]").asFixedIterable();

    }

//Для теста 5 и 6
//    *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//h2[contains(@class, 'login-form__header')]")
    public SelenideElement loginFormHeader;

    @FindBy(xpath = "//div[contains(@class, 'form-field__input-container')]")
    public SelenideElement loginFieldEnter;

    @FindBy(xpath = "//button[contains(@class, 'login-form__button')]")
    public SelenideElement buttonContinue;

    @FindBy(xpath = "//button[contains(@class, 'login-form__link_sz_sm')]")
    public SelenideElement forLegalPerson;


    public void clickProfile(){
        buttonProfile.click();
    }
    public void loginFormHeaderNormal(){
        loginFormHeader.shouldBe(visible).isDisplayed();
        assert loginFormHeader.getText().equals("Вход или регистрация");
    }
    public void loginFieldNormal(){
        loginFieldEnter.shouldBe(visible).isDisplayed();
        assert loginFieldEnter.find(By.xpath(".//span")).getText().equals("Телефон");
    }
    public void buttonContinueNormal(){
        buttonContinue.shouldBe(visible);
        buttonContinue.find(By.xpath("//@disabled"));
        assert buttonContinue.getText().equals("Продолжить");
    }
    public void forLegalPersonNormal(){
        forLegalPerson.shouldBe(visible);
        assert forLegalPerson.getText().equals("Для юридических лиц");
    }
    //Для теста 7 и 8
//    *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FindBy(xpath = "(//div[contains(@class, 'compare-button-block')] //button)[1]")
    public SelenideElement buttonCompareFirstProduct;

    @FindBy(xpath = "(//div[contains(@class, 'compare-button-block')] //button)[2]")
    public SelenideElement buttonCompareSecondProduct;

    @FindBy(xpath = "(//div[contains(@class, 'compare-button-block')] //button)[3]")
    public SelenideElement buttonCompareThirdProduct;

    @FindBy(xpath = "//div[contains(@class, 'c-compare-head')]/h1")
    public SelenideElement compareHead;

    @FindBy(xpath = "(//a[contains(@class, 'product-title')])[1]")
    public SelenideElement firstCompareProductNameInSearch;

    @FindBy(xpath = "(//a[contains(@class, 'product-title')])[2]")
    public SelenideElement secondCompareProductNameInSearch;

    @FindBy(xpath = "(//a[contains(@class, 'product-title')])[3]")
    public SelenideElement thirdCompareProductNameInSearch;

    @FindBy(xpath = "(//a[contains(@class, 'sel-product-tile-title')])[1]")
    public SelenideElement firstNameProductInCompare;

    @FindBy(xpath = "(//a[contains(@class, 'sel-product-tile-title')])[2]")
    public SelenideElement secondNameProductInCompare;

    @FindBy(xpath = "(//a[contains(@class, 'sel-product-tile-title')])[3]")
    public SelenideElement thirdNameProductInCompare;

    @FindBy(xpath = "(//div[contains(@class, 'wishlist-button-block ng-star-inserted')])[1]")
    public SelenideElement buttonPersonalFirstProduct;

    @FindBy(xpath = "(//div[contains(@class, 'wishlist-button-block ng-star-inserted')])[2]")
    public SelenideElement buttonPersonalSecondProduct;

    @FindBy(xpath = "(//div[contains(@class, 'wishlist-button-block ng-star-inserted')])[3]")
    public SelenideElement buttonPersonalThirdProduct;



    String firstAppleProductName;

    String secondAppleProductName;

    String thirdAppleProductName;

    public void addCompareProduct(){
        buttonCompareFirstProduct.click();
        Selenide.sleep(2000);
        buttonCompareSecondProduct.click();
        Selenide.sleep(2000);
        buttonCompareThirdProduct.click();
        Selenide.sleep(2000);
    }
    public void compareClick(){
        buttonCompare.click();
    }
    public void urlEqualsUrlCompare(){
        String actualUrl = WebDriverRunner.url();
        String expectedUrl = "https://www.mvideo.ru/product-comparison";
        assert (actualUrl.contains(expectedUrl));
    }
    public void compareHeadNormal(){
        compareHead.shouldBe(visible).isDisplayed();
//        assert compareHead.getText().equals("Сравнение товаров");
        compareHead.shouldHave(text("Сравнение товаров"));
    }
    public String getFirstCompareProductName() {
        firstAppleProductName = firstCompareProductNameInSearch.getText();
        return firstAppleProductName;
    }
    public String getSecondCompareProductName() {
        secondAppleProductName = secondCompareProductNameInSearch.getText();
        return secondAppleProductName;
    }
    public String getThirdCompareProductName() {
        thirdAppleProductName = thirdCompareProductNameInSearch.getText();
        return thirdAppleProductName;
    }

    public void rightAddProductName(){
//        assert firstNameProductInCompare.getText().equals(firstAppleProductName);
//        assert secondNameProductInCompare.getText().equals(secondAppleProductName);
//        assert thirdNameProductInCompare.getText().equals(thirdAppleProductName);
        ElementsCollection nameCompareProduct = Selenide.$$x("//a[contains(@class, 'sel-product-tile-title')]");
        nameCompareProduct.shouldHave(CollectionCondition.itemWithText(firstAppleProductName));
        nameCompareProduct.shouldHave(CollectionCondition.itemWithText(secondAppleProductName));
        nameCompareProduct.shouldHave(CollectionCondition.itemWithText(thirdAppleProductName));
    }
    public void clickOnPersonal(){
        buttonPersonal.click();
    }
    public void addAppleInPersonal(){
        buttonPersonalFirstProduct.click();
        Selenide.sleep(2000);
        buttonPersonalSecondProduct.click();
        Selenide.sleep(2000);
        buttonPersonalThirdProduct.click();
        Selenide.sleep(2000);

    }

}


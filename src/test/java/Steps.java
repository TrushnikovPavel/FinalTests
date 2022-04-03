import PageObject.MvideoPage;
import com.codeborne.selenide.Selenide;

public class Steps {
        private MvideoPage mvideoPage;
        public Steps(){
            mvideoPage=MvideoPage.getMvideoPage();
        }
        public void checkButtonHeader(){
                mvideoPage.buttonCompareIsNotActive();
                mvideoPage.buttonProfileIsActive();
                mvideoPage.buttonStatusOrderIsActive();
                mvideoPage.buttonPersonalIsNotActive();
                mvideoPage.buttonCartIsNotActive();
        }
        public void checkAddProduct(){
                mvideoPage.blockDayProductIsVisible();
                mvideoPage.clickAddInCart();
                mvideoPage.cartIsActive();
                mvideoPage.cartBubbleNumber();
        }
        public void checkAddProductInProductPageFavoriteProductDay(){
                mvideoPage.blockDayProductIsVisible();
                Selenide.sleep(3000);
                mvideoPage.getProductNameFavorite();
                mvideoPage.getProductPriceFavorite();
                mvideoPage.clickAddInCart();
                Selenide.sleep(3000);
                mvideoPage.cartIsActive();
                mvideoPage.clickOnButtonCart();
                Selenide.sleep(3000);
                mvideoPage.urlEqualsUrlCart();
                mvideoPage.headerLogoVisible();
                Selenide.sleep(3000);
                mvideoPage.getProductCardPrice();
                mvideoPage.checkProductCardName();
                mvideoPage.favoritePriceEqualsCartPrice();
                mvideoPage.buttonGoToTheDesignNormal();
                mvideoPage.cartPriceEqualsFinalPriceWithOneProduct();
                mvideoPage.productQuantityInCartNormal();
}
        public void checkAdd2ProductMostlySeen(){
                mvideoPage.scrollInToViewMostlySeenCategory();
                mvideoPage.mostlySeenCategoryVisible();
                mvideoPage.getProductPriceMostlySeenFirst();
                mvideoPage.getProductPriceMostlySeenSecond();
                mvideoPage.getProductNameMostlySeenFirst();
                mvideoPage.getProductNameMostlySeenSecond();
                mvideoPage.mostlySeenAdd2ProductInCart();
                Selenide.sleep(3000);
                mvideoPage.clickOnButtonCart();
                Selenide.sleep(3000);
                mvideoPage.correctNameProductsInCart();
                mvideoPage.correctPriceProductsInCart();

        }
        public void searchApple(){
                mvideoPage.searherFieldIsVisible();
                mvideoPage.searchApple();
                Selenide.sleep(5000);
                mvideoPage.urlEqualsUrlForApple();
                mvideoPage.scrollAll();
                Selenide.sleep(2000);
                mvideoPage.allProductsContainsApple();
        }
        public void searchAppleForFilter(){
                mvideoPage.searherFieldIsVisible();
                mvideoPage.searchApple();
                Selenide.sleep(5000);
                mvideoPage.urlEqualsUrlForApple();
                mvideoPage.scrollAll();
                Selenide.sleep(2000);
                mvideoPage.allProductsContainsApple();
                mvideoPage.checkDropDown();
                mvideoPage.openDropDownMenu();
                mvideoPage.clickInDropDownMenuMoreExpensive();
                Selenide.sleep(2000);
                mvideoPage.scrollAll();
                mvideoPage.allProductsContainsApple();
                mvideoPage.getCollectionPriceAndConvertAndValidate();
        }
        public void checkProfile(){
                mvideoPage.clickProfile();
                mvideoPage.loginFormHeaderNormal();
                mvideoPage.loginFieldNormal();
                mvideoPage.buttonContinueNormal();
                mvideoPage.forLegalPersonNormal();
        }

        public void productComparison(){
                mvideoPage.searherFieldIsVisible();
                mvideoPage.searchApple();
                Selenide.sleep(5000);
                mvideoPage.urlEqualsUrlForApple();
                mvideoPage.scrollAll();
                Selenide.sleep(2000);
                mvideoPage.getFirstCompareProductName();
                mvideoPage.getSecondCompareProductName();
                mvideoPage.getThirdCompareProductName();
                mvideoPage.addCompareProduct();
                mvideoPage.compareClick();
                mvideoPage.urlEqualsUrlCompare();
                mvideoPage.compareHeadNormal();
                mvideoPage.rightAddProductNameComparison();
        }
        public void productPersonal(){
                mvideoPage.searherFieldIsVisible();
                mvideoPage.searchApple();
                Selenide.sleep(5000);
                mvideoPage.urlEqualsUrlForApple();
                mvideoPage.scrollAll();
                Selenide.sleep(2000);
                mvideoPage.getFirstCompareProductName();
                mvideoPage.getSecondCompareProductName();
                mvideoPage.getThirdCompareProductName();
                mvideoPage.addAppleInPersonal();
                mvideoPage.clickOnPersonal();
                mvideoPage.urlEqualsUrlPersonal();
                mvideoPage.personalHeadNormal();
                mvideoPage.rightAddProductNameInPersonal();

}
        public void locationCheck(){
                mvideoPage.clickButtonLocation();
                mvideoPage.checkLocationLayout();
                mvideoPage.checkLocationLayoutHead();
                mvideoPage.clickKrasnodar();
                Selenide.sleep(2000);
                mvideoPage.checkLocationLayoutNotVisible();
                mvideoPage.checkLocationLayoutHeadNotVisible();
                mvideoPage.checkYouLocation();

        }
}
package ru.kazanexpress.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.kazanexpress.enams.Catalog;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainKazanexpressPage {
	SelenideElement
			loginButton = $("div[data-test-id='button__auth']"),
			catalogButton = $("button[class='ui-component ui-button mark-accent show-catalog small']"),
			selectCityButton = $("p[class='region regular hug']"),
			category = $(".desktop-wrapper");

	ElementsCollection catalogProducts = $$("ul[class='parent-categories smart-hover'] span");
	ElementsCollection cityList = $$(".city div");

	public void clickLoginButton() {
		loginButton.shouldHave(visible).click();
	}

	public void clickCatalogButton() {
		catalogButton.click();
	}

	public void clickCatalogProduct(String product) {
		catalogProducts.shouldBe(CollectionCondition.sizeGreaterThan(1)).find(text(product)).click();
	}

	public void clickCity() {
		selectCityButton.click();
	}

	public void clickNewCity(String city) {
		cityList.find(text(city)).click();
	}

	public void checkCity(String city) {
		selectCityButton.shouldHave(text(city));
	}

	public void checkCubCategory(String cubCategory) {
		category.shouldHave(text(cubCategory));
	}
}

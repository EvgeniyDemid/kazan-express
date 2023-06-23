package ru.kazanexpress.pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.lang.module.Configuration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainKazanexpressPage {
	SelenideElement
			loginButton = $("div[data-test-id='button__auth']"),
			catalogButton = $("button[class='ui-component ui-button mark-accent show-catalog small']"),
			selectcityButton = $("p[class='region regular hug']"),
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
		catalogProducts.shouldBe(sizeGreaterThan(1)).find(text(product)).click();
	}

	public void clickCity() {
		selectcityButton.click();
	}

	public void clickNewCity(String city) {
		cityList.find(text(city)).click();
	}

	public void checkCity(String city) {
		selectcityButton.shouldHave(text(city));
	}
	public void checkCubCategory(String cubCategory){
		category.shouldHave(text(cubCategory));
	}
}

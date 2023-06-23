package ru.kazanexpress.pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductstPage {
	SelenideElement
			title = $("div[class='title title-bold']");
	public void checkTitel(String catalog){
		title.shouldBe(visible).shouldHave(Condition.text(catalog));
	}
}

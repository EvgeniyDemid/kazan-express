package ru.kazanexpress.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.kazanexpress.enams.Catalog;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
	SelenideElement
			title = $("div[class='title title-bold']");

	public void checkTitle(String catalog) {
		title.shouldBe(Condition.visible).shouldHave(Condition.text(catalog));
	}
}

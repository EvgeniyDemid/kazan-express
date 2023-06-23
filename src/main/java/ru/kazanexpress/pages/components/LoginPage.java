package ru.kazanexpress.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
	SelenideElement phoneNumberInput = $("div[class='ui-component ui-input'] input");
	SelenideElement getCodeButton = $(".form button");
	SelenideElement errorIncorrectPhone = $(byText("Неверный формат номера"));

	public void setPhoneNumber(String num) {
		phoneNumberInput.shouldHave(visible).setValue(num);
	}

	public void clickgetCodeButton() {
		getCodeButton.click();
	}

	public void checkErrorIncorrectPhone() {
		errorIncorrectPhone.shouldBe(visible);
	}
}

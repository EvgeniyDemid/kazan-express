package ru.kazanexpress.tests;

import com.codeborne.selenide.Configuration;
import ru.kazanexpress.enams.Catalog;
import ru.kazanexpress.pages.LoginPage;
import ru.kazanexpress.pages.MainKazanexpressPage;
import ru.kazanexpress.pages.ProductPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class KazanExpressTests {
	MainKazanexpressPage mainKazanexpressPage = new MainKazanexpressPage();
	LoginPage loginPage = new LoginPage();
	ProductPage productPage = new ProductPage();

	@BeforeAll
	static void beforeAll() {
		Configuration.baseUrl = "https://kazanexpress.ru/";
		Configuration.pageLoadStrategy = "eager";
		Configuration.browserSize = "1280x1024";
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789"})
	public void userCannotRegisterWithInvalidPhoneNumber(String phone) {
		open("");
		mainKazanexpressPage.clickLoginButton();
		loginPage.setPhoneNumber(phone);
		loginPage.clickgetCodeButton();
		loginPage.checkErrorIncorrectPhone();

	}

	@EnumSource(Catalog.class)
	@ParameterizedTest
	public void displayingNameCatalogWhenGoIt(Catalog product) {
		open("");
		mainKazanexpressPage.clickCatalogButton();
		mainKazanexpressPage.clickCatalogProduct(product.getValue());
		productPage.checkTitle(product.getValue());
	}

	@ParameterizedTest
	@MethodSource("stringCity")
	public void userCanChangeCity(String city) {
		open("");
		mainKazanexpressPage.clickCity();
		mainKazanexpressPage.clickNewCity(city);
		mainKazanexpressPage.checkCity(city);
	}

	static Stream<String> stringCity() {
		return Stream.of("Агрыз", "Азнакаево", "Альметьевск", "Арзамас", "Арск", "Аша", "Балаково", "Балашов");
	}

	@ParameterizedTest
	@CsvSource({
			"Бытовая техника, Климатическая техника",
			"Одежда,Детская одежда",
			"Одежда,Женская одежда",
			"Обувь,Аксессуары для обуви"
	})
	public void displayingNameCubCatalogWhenGoIt(String category, String cubCategory) {
		open("");
		mainKazanexpressPage.clickCatalogButton();
		mainKazanexpressPage.clickCatalogProduct(category);
		mainKazanexpressPage.checkCubCategory(cubCategory);
	}
}

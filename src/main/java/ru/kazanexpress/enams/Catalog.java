package ru.kazanexpress.enams;

public enum Catalog {
	ELECTRONICS("Электроника"),

	APPLIANCES("Бытовая техника"),

	CLOTH("Одежда"),

	SHOES("Обувь"),

	ACCESSORIES("Аксессуары"),

	BEAUTY("Красота"),

	HEALTH("Здоровье");

	Catalog(String value) {
		this.value = value;
	}
	public String value;

	public String getValue() {
		return value;
	}
}

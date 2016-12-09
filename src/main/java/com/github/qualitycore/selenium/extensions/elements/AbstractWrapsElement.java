package com.github.qualitycore.selenium.extensions.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsDriver;

import com.github.qualitycore.selenium.extensions.elements.contracts.IWrapsElement;

public class AbstractWrapsElement implements IWrapsElement {

	private WebElement wrappedElement;

	public AbstractWrapsElement(WebElement wrappedElement) {
		if (wrappedElement == null)
			throw new IllegalArgumentException("The wrapped element can't be null.", new NullPointerException("wrappedElement"));

		this.wrappedElement = wrappedElement;
	}

	public AbstractWrapsElement(WebDriver webDriver, By locator) {
		if (webDriver == null)
			throw new IllegalArgumentException("The web driver can't be null.", new NullPointerException("webDriver"));

		if (locator == null)
			throw new IllegalArgumentException("The locator can't be null.", new NullPointerException("locator"));

		this.wrappedElement = webDriver.findElement(locator);
	}

	protected AbstractWrapsElement() {
		super();
	}

	@Override
	public WebElement getWrappedElement() {
		return wrappedElement;
	}

	protected void setWrappedElement(WebElement wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	protected WebDriver getWrappedDriver() {
		return ((WrapsDriver) this.getWrappedElement()).getWrappedDriver();
	}

	@Override
	public Coordinates getCoordinates() {
		return ((Locatable) this.getWrappedElement()).getCoordinates();
	}

	@Override
	public String toString() {
		return "Wrapped Element -> " + this.getWrappedElement();
	}

}

package com.github.qualitycore.selenium.extensions.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.qualitycore.selenium.extensions.elements.contracts.IVerificationElement;

public class VerificationElement extends AbstractWrapsElement implements IVerificationElement {

	public VerificationElement(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public VerificationElement(WebDriver webDriver, By locator) {
		super(webDriver, locator);
	}

	protected VerificationElement() {
		super();
	}

	@Override
	public boolean isPresent() {
		try {
			this.getWrappedElement().isEnabled();

			return true;
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	@Override
	public boolean isDisplayed() {
		return this.getWrappedElement().isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled();
	}

	@Override
	public boolean isClicable() {
		return this.isDisplayed() && this.isEnabled();
	}

	@Override
	public boolean isSelected() {
		return this.getWrappedElement().isSelected();
	}

	@Override
	public boolean textEquals(String expectedText) {
		return this.getWrappedElement().getText().equals(expectedText);
	}

	@Override
	public boolean tagNameEquals(String expectedTagName) {
		return this.getWrappedElement().getTagName().equals(expectedTagName);
	}

	@Override
	public boolean attributeEquals(String attributeName, String expectedAttributeValue) {
		final String attribute = this.getWrappedElement().getAttribute(attributeName);

		return attribute != null ? attribute.equals(expectedAttributeValue) : expectedAttributeValue == null;
	}

	@Override
	public boolean cssValueEquals(String propertyName, String expectedCssValue) {
		return this.getWrappedElement().getCssValue(propertyName).equals(expectedCssValue);
	}

	@Override
	public boolean locationEquals(Point expectedLocation) {
		return this.getWrappedElement().getLocation().equals(expectedLocation);
	}

	@Override
	public boolean sizeEquals(Dimension expectedSize) {
		return this.getWrappedElement().getSize().equals(expectedSize);
	}

	@Override
	public boolean rectEquals(Rectangle expectedRect) {
		return this.getWrappedElement().getRect().equals(expectedRect);
	}

}

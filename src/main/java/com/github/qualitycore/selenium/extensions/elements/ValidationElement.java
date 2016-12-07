package com.github.qualitycore.selenium.extensions.elements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.qualitycore.selenium.extensions.elements.contracts.IValidationElement;

public class ValidationElement extends AbstractWrapsElement implements IValidationElement {

	public ValidationElement(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public ValidationElement(WebDriver webDriver, By locator) {
		super(webDriver, locator);
	}

	protected ValidationElement() {
		super();
	}

	@Override
	public void isPresent(boolean isPresent) {
		boolean _isPresent;

		try {
			this.getWrappedElement().isEnabled();

			_isPresent = true;
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			_isPresent = false;
		}

		assertEquals(isPresent, _isPresent);
	}

	@Override
	public void isDisplayed(boolean isDisplayed) {
		assertEquals(isDisplayed, this.getWrappedElement().isDisplayed());
	}

	@Override
	public void isEnabled(boolean isEnabled) {
		assertEquals(isEnabled, this.getWrappedElement().isEnabled());
	}

	@Override
	public void isClicable(boolean isClicable) {
		assertEquals(isClicable, this.getWrappedElement().isDisplayed() && this.getWrappedElement().isEnabled());
	}

	@Override
	public void isSelected(boolean isSelected) {
		assertEquals(isSelected, this.getWrappedElement().isSelected());
	}

	@Override
	public void textEquals(String expectedText) {
		assertEquals(expectedText, this.getWrappedElement().getText());
	}

	@Override
	public void textNotEquals(String notExpectedText) {
		assertNotEquals(notExpectedText, this.getWrappedElement().getText());
	}

	@Override
	public void tagNameEquals(String expectedTagName) {
		assertEquals(expectedTagName, this.getWrappedElement().getTagName());
	}

	@Override
	public void tagNameNotEquals(String notExpectedTagName) {
		assertNotEquals(notExpectedTagName, this.getWrappedElement().getTagName());
	}

	@Override
	public void attributeEquals(String attributeName, String expectedAttributeValue) {
		assertEquals(expectedAttributeValue, this.getWrappedElement().getAttribute(attributeName));
	}

	@Override
	public void attributeNotEquals(String attributeName, String notExpectedAttributeValue) {
		assertNotEquals(notExpectedAttributeValue, this.getWrappedElement().getAttribute(attributeName));
	}

	@Override
	public void cssValueEquals(String propertyName, String expectedCssValue) {
		assertEquals(expectedCssValue, this.getWrappedElement().getCssValue(propertyName));
	}

	@Override
	public void cssValueNotEquals(String propertyName, String notExpectedCssValue) {
		assertNotEquals(notExpectedCssValue, this.getWrappedElement().getCssValue(propertyName));
	}

	@Override
	public void locationEquals(Point expectedLocation) {
		assertEquals(expectedLocation, this.getWrappedElement().getLocation());
	}

	@Override
	public void locationNotEquals(Point notExpectedLocation) {
		assertNotEquals(notExpectedLocation, this.getWrappedElement().getLocation());
	}

	@Override
	public void sizeEquals(Dimension expectedSize) {
		assertEquals(expectedSize, this.getWrappedElement().getSize());
	}

	@Override
	public void sizeNotEquals(Dimension notExpectedSize) {
		assertNotEquals(notExpectedSize, this.getWrappedElement().getSize());
	}

	@Override
	public void rectEquals(Rectangle expectedRect) {
		assertEquals(expectedRect, this.getWrappedElement().getRect());
	}

	@Override
	public void rectNotEquals(Rectangle notExpectedRect) {
		assertNotEquals(notExpectedRect, this.getWrappedElement().getRect());
	}

	@Override
	public String toString() {
		return "Validation Element -> " + this.getWrappedElement();
	}

}

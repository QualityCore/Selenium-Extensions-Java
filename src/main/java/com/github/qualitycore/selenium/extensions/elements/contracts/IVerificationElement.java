package com.github.qualitycore.selenium.extensions.elements.contracts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;

public interface IVerificationElement extends WrapsElement {

	public boolean isPresent(boolean isPresent);

	public boolean isDisplayed(boolean isDisplayed);

	public boolean isEnabled(boolean isEnabled);

	public boolean isClicable(boolean isClicable);

	public boolean isSelected(boolean isSelected);

	public boolean textEquals(String expectedText);

	public boolean textNotEquals(String notExpectedText);

	public boolean tagNameEquals(String expectedTagName);

	public boolean tagNameNotEquals(String notExpectedTagName);

	public boolean attributeEquals(String attributeName, String expectedAttributeValue);

	public boolean attributeNotEquals(String attributeName, String notexpectedAttributeValue);

	public boolean cssValueEquals(String propertyName, String expectedCssValue);

	public boolean cssValueNotEquals(String propertyName, String notExpectedCssValue);

	public boolean locationEquals(Point expectedLocation);

	public boolean locationNotEquals(Point notExpectedLocation);

	public boolean sizeEquals(Dimension expectedSize);

	public boolean sizeNotEquals(Dimension notExpectedSize);

	public boolean rectEquals(Rectangle expectedRect);

	public boolean rectNotEquals(Rectangle notExpectedRect);

	public WebElement getWrappedElement();
	
}

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

	public boolean tagNameEquals(String expectedTagName);

	public boolean attributeEquals(String attributeName, String expectedAttributeValue);

	public boolean cssValueEquals(String propertyName, String expectedCssValue);

	public boolean locationEquals(Point expectedLocation);

	public boolean sizeEquals(Dimension expectedSize);

	public boolean rectEquals(Rectangle expectedRect);

	public WebElement getWrappedElement();
	
}

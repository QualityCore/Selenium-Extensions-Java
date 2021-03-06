package com.github.qualitycore.selenium.extensions.elements.contracts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

public interface IValidationElement extends IWrapsElement {

	public void isPresent(boolean isPresent);

	public void isDisplayed(boolean isDisplayed);

	public void isEnabled(boolean isEnabled);

	public void isClicable(boolean isClicable);

	public void isSelected(boolean isSelected);

	public void textEquals(String expectedText);

	public void textNotEquals(String notExpectedText);

	public void tagNameEquals(String expectedTagName);

	public void tagNameNotEquals(String notExpectedTagName);

	public void attributeEquals(String attributeName, String expectedAttributeValue);

	public void attributeNotEquals(String attributeName, String notExpectedAttributeValue);

	public void cssValueEquals(String propertyName, String expectedCssValue);

	public void cssValueNotEquals(String propertyName, String notExpectedCssValue);

	public void locationEquals(Point expectedLocation);

	public void locationNotEquals(Point notExpectedLocation);

	public void sizeEquals(Dimension expectedSize);

	public void sizeNotEquals(Dimension notExpectedSize);

	public void rectEquals(Rectangle expectedRect);

	public void rectNotEquals(Rectangle notExpectedRect);

}

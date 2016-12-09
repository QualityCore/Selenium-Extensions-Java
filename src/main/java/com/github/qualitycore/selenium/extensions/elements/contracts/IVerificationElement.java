package com.github.qualitycore.selenium.extensions.elements.contracts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

public interface IVerificationElement extends IWrapsElement {

	public boolean isPresent();

	public boolean isDisplayed();

	public boolean isEnabled();

	public boolean isClicable();

	public boolean isSelected();

	public boolean textEquals(String expectedText);

	public boolean tagNameEquals(String expectedTagName);

	public boolean attributeEquals(String attributeName, String expectedAttributeValue);

	public boolean cssValueEquals(String propertyName, String expectedCssValue);

	public boolean locationEquals(Point expectedLocation);

	public boolean sizeEquals(Dimension expectedSize);

	public boolean rectEquals(Rectangle expectedRect);

}

package com.github.qualitycore.selenium.extensions.elements.contracts;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

public interface IWaitElement extends IWrapsElement {
	
	public void isPresent();

	public void isNotPresent();

	public void isDisplayed();

	public void isNotDisplayed();

	public void isEnabled();

	public void isNotEnabled();

	public void isClicable();

	public void isNotClicable();

	public void isSelected();

	public void isNotSelected();

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

	public long getTimeoutInMilliseconds();

	public void setTimeoutInMilliseconds(long timeoutInMilliseconds);
	
	public long getWaitInMilliseconds();

	public void setWaitInMilliseconds(long waitInMilliseconds);

}

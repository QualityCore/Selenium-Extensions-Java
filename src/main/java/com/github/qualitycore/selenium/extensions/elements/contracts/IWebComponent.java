package com.github.qualitycore.selenium.extensions.elements.contracts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;

public interface IWebComponent extends WebElement, IWrapsValidationElement, IWrapsVerificationElement, WrapsElement {

	public boolean isPresent();

	public boolean isClicable();

	public void moveToElement();

	public void moveToElement(int xOffset, int yOffset);

	public void clickAndHold();

	public void release();

	public void doubleClick();

	public void contextClick();

	public void dragAndDrop(WebElement target);
	
	public void dragAndDropBy(int xOffset, int yOffset);

}

package com.github.qualitycore.selenium.extensions.elements.contracts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IWebComponent extends WebElement, IWrapsValidationElement, IWrapsVerificationElement, IWrapsElement {

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

	public List<? extends IWebComponent> findElementsAsComponent(By by);

	public IWebComponent findElementAsComponent(By by);

}

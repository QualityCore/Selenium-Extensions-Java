package com.github.qualitycore.selenium.extensions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.qualitycore.selenium.extensions.elements.AbstractWebElementDecorator;
import com.github.qualitycore.selenium.extensions.elements.ValidationElement;
import com.github.qualitycore.selenium.extensions.elements.VerificationElement;
import com.github.qualitycore.selenium.extensions.elements.contracts.IValidationElement;
import com.github.qualitycore.selenium.extensions.elements.contracts.IVerificationElement;
import com.github.qualitycore.selenium.extensions.elements.contracts.IWebComponent;

public class WebComponent extends AbstractWebElementDecorator implements IWebComponent {

	public WebComponent(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public WebComponent(WebDriver webDriver, By locator) {
		super(webDriver, locator);
	}

	protected WebComponent() {
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
	public boolean isClicable() {
		return this.isDisplayed() && this.isEnabled();
	}

	@Override
	public void moveToElement() {
		this.getActions().moveToElement(this.getWrappedElement()).perform();
	}

	@Override
	public void moveToElement(int xOffset, int yOffset) {
		this.getActions().moveToElement(this.getWrappedElement(), xOffset, yOffset).perform();
	}

	@Override
	public void clickAndHold() {
		this.getActions().clickAndHold(this.getWrappedElement()).perform();
	}

	@Override
	public void release() {
		this.getActions().release(this.getWrappedElement()).perform();
	}

	@Override
	public void doubleClick() {
		this.getActions().doubleClick(this.getWrappedElement()).perform();
	}

	@Override
	public void contextClick() {
		this.getActions().contextClick(this.getWrappedElement()).perform();
	}

	@Override
	public void dragAndDrop(WebElement target) {
		this.getActions().dragAndDrop(this.getWrappedElement(), target).perform();
	}

	@Override
	public void dragAndDropBy(int xOffset, int yOffset) {
		this.getActions().dragAndDropBy(this.getWrappedElement(), xOffset, yOffset).perform();
	}

	@Override
	public IValidationElement validate() {
		return new ValidationElement(this.getWrappedElement());
	}

	@Override
	public IVerificationElement verify() {
		return new VerificationElement(this.getWrappedElement());
	}

	@Override
	public List<IWebComponent> findElementsAsComponent(By by) {
		List<WebElement> webElements = this.findElements(by);
		List<IWebComponent> webComponents = new ArrayList<>(webElements.size());

		for (WebElement webElement : webElements)
			webComponents.add(new WebComponent(webElement));

		return webComponents;
	}

	@Override
	public IWebComponent findElementAsComponent(By by) {
		return new WebComponent(this.findElement(by));
	}
	
	protected Actions getActions() {
		return new Actions(this.getWrappedDriver());
	}

}

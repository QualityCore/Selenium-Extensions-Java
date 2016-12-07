package com.github.qualitycore.selenium.extensions.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class AbstractWebElementDecorator extends AbstractWrapsElement implements WebElement {

	public AbstractWebElementDecorator(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public AbstractWebElementDecorator(WebDriver webDriver, By locator) {
		super(webDriver, locator);
	}

	protected AbstractWebElementDecorator() {
		super();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return this.getWrappedElement().getScreenshotAs(target);
	}

	@Override
	public void click() {
		this.getWrappedElement().click();
	}

	@Override
	public void submit() {
		this.getWrappedElement().submit();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		this.getWrappedElement().sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		this.getWrappedElement().clear();
	}

	@Override
	public String getTagName() {
		return this.getWrappedElement().getTagName();
	}

	@Override
	public String getAttribute(String name) {
		return this.getWrappedElement().getAttribute(name);
	}

	@Override
	public boolean isSelected() {
		return this.getWrappedElement().isSelected();
	}

	@Override
	public boolean isEnabled() {
		return this.getWrappedElement().isEnabled();
	}

	@Override
	public String getText() {
		return this.getWrappedElement().getText();
	}

	@Override
	public List<WebElement> findElements(By by) {
		return this.getWrappedElement().findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		return this.getWrappedElement().findElement(by);
	}

	@Override
	public boolean isDisplayed() {
		return this.getWrappedElement().isDisplayed();
	}

	@Override
	public Point getLocation() {
		return this.getWrappedElement().getLocation();
	}

	@Override
	public Dimension getSize() {
		return this.getWrappedElement().getSize();
	}

	@Override
	public Rectangle getRect() {
		return this.getWrappedElement().getRect();
	}

	@Override
	public String getCssValue(String propertyName) {
		return this.getWrappedElement().getCssValue(propertyName);
	}

}

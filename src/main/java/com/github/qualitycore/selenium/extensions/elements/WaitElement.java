package com.github.qualitycore.selenium.extensions.elements;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.qualitycore.selenium.extensions.elements.contracts.IWaitElement;

public class WaitElement extends AbstractWrapsElement implements IWaitElement {

	private long	timeoutInMilliseconds;
	private long	waitInMilliseconds;

	public WaitElement(WebElement wrappedElement, long timeoutInMilliseconds, long waitInMilliseconds) {
		super(wrappedElement);

		this.timeoutInMilliseconds = timeoutInMilliseconds;
		this.waitInMilliseconds = waitInMilliseconds;
	}

	public WaitElement(WebElement wrappedElement, long timeoutInMilliseconds) {
		this(wrappedElement, timeoutInMilliseconds, DEFAULT_WAIT_IN_MILLISECONDS);
	}

	public WaitElement(WebElement wrappedElement) {
		this(wrappedElement, DEFAULT_TIMEOUT_IN_MILLISECONDS, DEFAULT_WAIT_IN_MILLISECONDS);
	}

	public WaitElement(WebDriver webDriver, By locator, long timeoutInMilliseconds, long waitInMilliseconds) {
		super(webDriver, locator);

		this.timeoutInMilliseconds = timeoutInMilliseconds;
		this.waitInMilliseconds = waitInMilliseconds;
	}

	public WaitElement(WebDriver webDriver, By locator, long timeoutInMilliseconds) {
		this(webDriver, locator, timeoutInMilliseconds, DEFAULT_WAIT_IN_MILLISECONDS);
	}

	public WaitElement(WebDriver webDriver, By locator) {
		this(webDriver, locator, DEFAULT_TIMEOUT_IN_MILLISECONDS, DEFAULT_WAIT_IN_MILLISECONDS);
	}

	protected WaitElement() {
		super();

		this.timeoutInMilliseconds = DEFAULT_TIMEOUT_IN_MILLISECONDS;
		this.waitInMilliseconds = DEFAULT_WAIT_IN_MILLISECONDS;
	}

	@Override
	public void isPresent() {
		runUntil(() -> {
			try {
				this.getWrappedElement().isEnabled();

				return true;
			} catch (NoSuchElementException | StaleElementReferenceException e) {
				return false;
			}
		}, true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isNotPresent() {
		runUntil(() -> {
			try {
				this.getWrappedElement().isEnabled();

				return true;
			} catch (NoSuchElementException | StaleElementReferenceException e) {
				return false;
			}
		}, false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isDisplayed() {
		runUntil(() -> this.getWrappedElement().isDisplayed(), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isNotDisplayed() {
		runUntil(() -> this.getWrappedElement().isDisplayed(), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isEnabled() {
		runUntil(() -> this.getWrappedElement().isEnabled(), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isNotEnabled() {
		runUntil(() -> this.getWrappedElement().isEnabled(), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isClicable() {
		runUntil(() -> this.getWrappedElement().isDisplayed() && this.getWrappedElement().isEnabled(), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isNotClicable() {
		runUntil(() -> this.getWrappedElement().isDisplayed() && this.getWrappedElement().isEnabled(), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isSelected() {
		runUntil(() -> this.getWrappedElement().isSelected(), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void isNotSelected() {
		runUntil(() -> this.getWrappedElement().isSelected(), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void textEquals(String expectedText) {
		runUntil(() -> this.getWrappedElement().getText().equals(expectedText), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void textNotEquals(String notExpectedText) {
		runUntil(() -> this.getWrappedElement().getText().equals(notExpectedText), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void tagNameEquals(String expectedTagName) {
		runUntil(() -> this.getWrappedElement().getTagName().equals(expectedTagName), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void tagNameNotEquals(String notExpectedTagName) {
		runUntil(() -> this.getWrappedElement().getTagName().equals(notExpectedTagName), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void attributeEquals(String attributeName, String expectedAttributeValue) {
		runUntil(() -> this.getWrappedElement().getAttribute(attributeName).equals(expectedAttributeValue), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void attributeNotEquals(String attributeName, String notExpectedAttributeValue) {
		runUntil(() -> this.getWrappedElement().getAttribute(attributeName).equals(notExpectedAttributeValue), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void cssValueEquals(String propertyName, String expectedCssValue) {
		runUntil(() -> this.getWrappedElement().getCssValue(propertyName).equals(expectedCssValue), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void cssValueNotEquals(String propertyName, String notExpectedCssValue) {
		runUntil(() -> this.getWrappedElement().getCssValue(propertyName).equals(notExpectedCssValue), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void locationEquals(Point expectedLocation) {
		runUntil(() -> this.getWrappedElement().getLocation().equals(expectedLocation), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void locationNotEquals(Point notExpectedLocation) {
		runUntil(() -> this.getWrappedElement().getLocation().equals(notExpectedLocation), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void sizeEquals(Dimension expectedSize) {
		runUntil(() -> this.getWrappedElement().getSize().equals(expectedSize), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void sizeNotEquals(Dimension notExpectedSize) {
		runUntil(() -> this.getWrappedElement().getSize().equals(notExpectedSize), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void rectEquals(Rectangle expectedRect) {
		runUntil(() -> this.getWrappedElement().getRect().equals(expectedRect), true, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public void rectNotEquals(Rectangle notExpectedRect) {
		runUntil(() -> this.getWrappedElement().getRect().equals(notExpectedRect), false, this.getTimeoutInMilliseconds(), this.getWaitInMilliseconds());
	}

	@Override
	public long getTimeoutInMilliseconds() {
		return timeoutInMilliseconds;
	}

	@Override
	public void setTimeoutInMilliseconds(long timeoutInMilliseconds) {
		this.timeoutInMilliseconds = timeoutInMilliseconds;
	}

	@Override
	public long getWaitInMilliseconds() {
		return waitInMilliseconds;
	}

	@Override
	public void setWaitInMilliseconds(long waitInMilliseconds) {
		this.waitInMilliseconds = waitInMilliseconds;
	}

	protected void runUntil(Callable<Boolean> callable, boolean until, long timeoutInMilliseconds, long waitInMilliseconds) {
		final ExecutorService executor = Executors.newSingleThreadExecutor();

		Runnable condition = new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						if (callable.call() == until)
							return;

						Thread.sleep(waitInMilliseconds);
					} catch (Throwable e) {

					}
				}
			}
		};

		final Future<?> future = executor.submit(condition);

		executor.shutdown();

		try {
			future.get(timeoutInMilliseconds, TimeUnit.MILLISECONDS);
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

}

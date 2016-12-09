package com.github.qualitycore.selenium.extensions.elements.contracts;

public interface IWrapsWaitElement {

	public IWaitElement waitUntil(long timeoutInMilliseconds, long waitInMilliseconds);

	public IWaitElement waitUntil(long timeoutInMilliseconds);

	public IWaitElement waitUntil();

}

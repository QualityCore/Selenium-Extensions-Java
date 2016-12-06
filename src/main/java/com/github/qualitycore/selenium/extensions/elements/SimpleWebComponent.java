package com.github.qualitycore.selenium.extensions.elements;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.pagefactory.ByChained;

/**
 * Classe responsável por fornecer as ações do {@link WebElement} a partir do padrão Proxy.
 * 
 * @author Leonardo Carmona da Silva<br>
 *         <a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a><br>
 *         <a href="https://github.com/QualityCore/Selenium-Extensions-Java">https://github.com/QualityCore/Selenium-Extensions-Java</a><br>
 *         <a href="https://github.com/leocarmona">https://github.com/leocarmona</a>
 *
 */
public class SimpleWebComponent implements WebElement, WrapsDriver, WrapsElement, Cloneable {

	private WebElement	wrappedElement;
	private WebDriver	wrappedDriver;
	private By			locator;

	/**
	 * Construtor de inicialização <b>não auto-atualizável</b> do {@link SimpleWebComponent}.
	 * 
	 * @param wrappedElement
	 *            Elemento a ser utilizado no Proxy.
	 * 
	 * @throws IllegalArgumentException
	 *             O <b>{@code wrappedElement}</b> não pode ser nulo.
	 * 
	 * @see #SimpleWebComponent(WebDriver, By)
	 * @see SimpleWebComponent#isRefreshable()
	 * 
	 */
	public SimpleWebComponent(WebElement wrappedElement) throws IllegalArgumentException {
		if (wrappedElement == null)
			throw new IllegalArgumentException("O elemento anexado não pode ser nulo!", new NullPointerException("wrappedElement"));

		this.wrappedElement = wrappedElement;
	}

	/**
	 * Construtor de inicialização <b>auto-atualizável</b> do {@link SimpleWebComponent}.
	 * 
	 * @param wrappedDriver
	 *            Driver a ser utilizado no Proxy.
	 * 
	 * @param locator
	 *            Localizador a ser utilizado no Proxy.
	 * 
	 * @throws IllegalArgumentException
	 *             O <b>{@code wrappedDriver}</b> e o <b>{@code locator}</b> não podem ser nulos.
	 * 
	 * @see #SimpleWebComponent(WebElement)
	 * @see SimpleWebComponent#isRefreshable()
	 */
	public SimpleWebComponent(WebDriver wrappedDriver, By locator) {
		if (wrappedDriver == null)
			throw new IllegalArgumentException("O driver anexado não pode ser nulo!", new NullPointerException("wrappedDriver"));

		if (locator == null)
			throw new IllegalArgumentException("O localizador anexado não pode ser nulo!", new NullPointerException("locator"));

		this.wrappedDriver = wrappedDriver;
		this.locator = locator;
	}

	/**
	 * Construtor de inicialização protegido.
	 */
	protected SimpleWebComponent() {

	}

	/**
	 * Método responsável por retirar um screenshot do componente.
	 * 
	 * @param <X>
	 *            Retorna o tipo do retorno do screenshot. Veja {@link OutputType}.
	 * 
	 * @param target
	 *            Tipo de retorno do screenshot. Veja {@link OutputType}.
	 * 
	 * @return Retorna o screenshot conforme o {@link OutputType} desejado.
	 * 
	 * @throws WebDriverException
	 *             É lançado caso ocorra alguma exceção.
	 * 
	 * @see OutputType#BASE64
	 * @see OutputType#BYTES
	 * @see OutputType#FILE
	 * 
	 */
	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return this.getWrappedElement().getScreenshotAs(target);
	}

	/**
	 * Método responsável por clicar no elemento.
	 */
	@Override
	public void click() {
		this.getWrappedElement().click();
	}

	/**
	 * Método responsável por enviar as informações do formulário. Se o elemento está dentro de um formulário, ele enviará os dados.
	 */
	@Override
	public void submit() {
		this.getWrappedElement().submit();
	}

	/**
	 * Método responsável por escrever uma sequência de caracteres.
	 */
	@Override
	public void sendKeys(CharSequence... keysToSend) {
		if (keysToSend != null)
			this.getWrappedElement().sendKeys(keysToSend);
	}

	/**
	 * Método responsável por limpar o elemento.
	 */
	@Override
	public void clear() {
		this.getWrappedElement().clear();
	}

	/**
	 * Método responsável por retornar a tag do componente.<br>
	 * Por exemplo: Retorna <code>"input"</code> para o elemento <code>&lt;input name="foo"/&gt;</code>.
	 * 
	 * @return Retorna a tag do componente.
	 */
	@Override
	public String getTagName() {
		return this.getWrappedElement().getTagName();
	}

	/**
	 * Método responsável por retornar o valor do atributo do componente.
	 * 
	 * @return Retorna o valor do atributo do componente. Se o atributo não existir, retorna {@code null}.
	 */
	@Override
	public String getAttribute(String name) {
		return this.getWrappedElement().getAttribute(name);
	}

	/**
	 * Método responsável por indicar se o componente está visível.
	 * 
	 * @return Retorna {@code true} se o componente estiver visível. Caso contrário, {@code false}.
	 */
	@Override
	public boolean isDisplayed() {
		return this.getWrappedElement().isDisplayed();
	}

	/**
	 * Método responsável por indicar se o componente está habilitado.
	 * 
	 * @return Retorna {@code true} se o componente estiver habilitado. Caso contrário, {@code false}.
	 */
	@Override
	public boolean isEnabled() {
		return this.getWrappedElement().isEnabled();
	}

	/**
	 * Método responsável por indicar se o componente está selecionado.
	 * 
	 * @return Retorna {@code true} se o componente estiver selecionado. Caso contrário, {@code false}.
	 */
	@Override
	public boolean isSelected() {
		return this.getWrappedElement().isSelected();
	}

	/**
	 * Método responsável por resgatar o texto do componente e de seus filhos.
	 * 
	 * @return Retorna o texto do componente e de seus filhos.
	 */
	@Override
	public String getText() {
		return this.getWrappedElement().getText();
	}

	/**
	 * Método responsável por retornar uma lista com todos os elementos que estão dentro do componente atual que satisfaça a condição de localização.
	 * 
	 * @return Retorna uma lista com todos os elementos que estão dentro do componente atual que satisfaça a condição de localização.
	 */
	public List<? extends SimpleWebComponent> findElementsAsWebComponent(By by) {
		final List<WebElement> webElements = this.getWrappedElement().findElements(by);

		SimpleWebComponent[] simpleWebComponents = new SimpleWebComponent[webElements.size()];

		for (int i = 0; i < simpleWebComponents.length; i++)
			simpleWebComponents[i] = new SimpleWebComponent(webElements.get(i));

		return Arrays.asList(simpleWebComponents);
	}

	/**
	 * Método responsável por retornar uma lista com todos os elementos que estão dentro do componente atual que satisfaça a condição de localização.
	 * 
	 * @return Retorna uma lista com todos os elementos que estão dentro do componente atual que satisfaça a condição de localização.
	 */
	@Override
	public List<WebElement> findElements(By by) {
		@SuppressWarnings("unchecked")
		final List<WebElement> webElements = (List<WebElement>) (Object) this.findElementsAsWebComponent(this.getLocator());

		return webElements;
	}

	/**
	 * Método responsável por retornar o elemento que está dentro do componente atual que satisfaça a condição de localização.
	 * 
	 * @return Retorna o elemento que está dentro do componente atual que satisfaça a condição de localização.
	 */
	@Override
	public SimpleWebComponent findElement(By by) {
		return this.isRefreshable() ? new SimpleWebComponent(this.getWrappedDriver(), new ByChained(this.getLocator(), by)) : new SimpleWebComponent(this.getWrappedElement().findElement(by));
	}

	/**
	 * Método responsável por retornar a localização do vértice superior esquerdo do componente.
	 * 
	 * @return Retorna a localização do vértice superior esquerdo do componente.
	 */
	@Override
	public Point getLocation() {
		return this.getWrappedElement().getLocation();
	}

	/**
	 * Método responsável por retornar o tamanho do componente.
	 * 
	 * @return Retorna o tamanho do componente.
	 */
	@Override
	public Dimension getSize() {
		return this.getWrappedElement().getSize();
	}

	/**
	 * Método responsável por retornar a localização do vértice superior esquerdo e o tamanho do componente.
	 * 
	 * @return Retorna a localização do vértice superior esquerdo e o tamanho do componente.
	 * 
	 * @see SimpleWebComponent#getLocation()
	 * @see SimpleWebComponent#getSize()
	 */
	@Override
	public Rectangle getRect() {
		return this.getWrappedElement().getRect();
	}

	/**
	 * Método responsável por retornar o valor do Css da propriedade desejada.
	 * 
	 * @return Retorna o valor do Css da propriedade desejada.
	 */
	@Override
	public String getCssValue(String propertyName) {
		return this.getWrappedElement().getCssValue(propertyName);
	}

	/**
	 * Método responsável por retornar o {@link WebDriver} anexado no componente.
	 * 
	 * @return Retorna o {@link WebDriver} anexado no componente.
	 */
	@Override
	public WebDriver getWrappedDriver() {
		return this.wrappedDriver != null ? this.wrappedDriver : ((WrapsDriver) this.getWrappedElement()).getWrappedDriver();
	}

	/**
	 * Método responsável por alterar o {@link WebDriver} do componente.
	 * 
	 * @param wrappedDriver
	 *            {@link WebDriver} desejado.
	 */
	protected void setWrappedDriver(WebDriver wrappedDriver) {
		this.wrappedDriver = wrappedDriver;
	}

	/**
	 * Método responsável por resgatar o elemento do componente.
	 * 
	 * @return Retorna o elemento do componente.
	 * 
	 * @throws NoSuchElementException
	 *             Lança a exceção caso o elemento não seja encontrado.
	 */
	@Override
	public WebElement getWrappedElement() throws NoSuchElementException {
		return this.isRefreshable() ? this.getWrappedDriver().findElement(this.getLocator()) : this.wrappedElement;
	}

	/**
	 * Método responsável por alterar o {@link WebElement} do componente.
	 * 
	 * @param wrappedElement
	 *            {@link WebElement} desejado.
	 */
	protected void setWrappedElement(WebElement wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	/**
	 * Método responsável por retornar o localizador do componente.
	 * 
	 * @return Retorna o localizador do componente.
	 */
	public By getLocator() {
		return locator;
	}

	/**
	 * Método responsável por alterar o localizador do componente.
	 * 
	 * @param locator
	 *            Localizador do componente desejado.
	 */
	protected void setLocator(By locator) {
		this.locator = locator;
	}

	/**
	 * Método responsável por indicar se o {@link SimpleWebComponent} é auto-atualizável, reduzindo a probabilidade de lançar uma {@link StaleElementReferenceException}.
	 * <p>
	 * Um componente pode ser considerado auto-atualizável caso possua um {@link WebDriver} e um {@link By} anexado.
	 * </p>
	 * 
	 * @see #SimpleWebComponent(WebDriver, By)
	 * 
	 * @return Retorna true caso seja auto-atualizável. Caso contrário, false.
	 */
	public boolean isRefreshable() {
		return this.wrappedDriver != null && this.getLocator() != null;
	}

	/**
	 * Método responsável por retornar um clone do {@link SimpleWebComponent}.
	 * 
	 * @return Retorna um clone do {@link SimpleWebComponent}.
	 */
	@Override
	public SimpleWebComponent clone() {
		return this.isRefreshable() ? new SimpleWebComponent(this.getWrappedDriver(), this.getLocator()) : new SimpleWebComponent(this.getWrappedElement());
	}

	/**
	 * Método responsável por retornar uma representação em {@link String} do {@link SimpleWebComponent}.
	 * 
	 * @return Retorna uma representação em {@link String} do {@link SimpleWebComponent}.
	 */
	@Override
	public String toString() {
		return this.isRefreshable() ? "[" + this.getWrappedDriver() + " -> " + this.getLocator() + "]" : String.valueOf(this.getWrappedElement());
	}
}

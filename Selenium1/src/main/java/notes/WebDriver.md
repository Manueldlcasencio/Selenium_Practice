## WebDriver test cases
We are going to use TestNG and Maven. Test cases for Selenium
practice are inside the Selenium folder. Selenium works with different
browsers, depending on which one are the texts supposed to be executed
you have to change the driver. Every driver class has a lot of methods,
but the methods are the same between classes (they all inherit from
the driver class).

`driver.get()` => URL to open the browser in.

In previous version of Selenium you needed to download a specific 
exe for each browser, right now it gets downloaded with Selenium itself
and it's not necessary in most cases. When it is necessary just 
link the correspondent exe file with `System.setProperty 
("webdriver.BROWSER.driver", file direction);`.

There are operations on the browser itself and in the different elements 
of the webpage you are testing. It is important to differentiate both, as 
some are more pre-requirements or post-test scenarios rather than a test
in itself.

---
### Browser operations
`.get()` `navigate().to()` => Both redirects you to a specific url.

`manage().window().maximize()` => It maximizes duh.

`.navigate().back()` `.navigate().forward()` => Back and forward.

`.navigate().refresh()` => Refresh the page.

`.close()` `.quit()` => Close is for current view, quit is everything.

---
### Web Elements operations
In textbox or textarea elements:
`.sendKeys("")` `.clear()` => Input and clear data.

`.click()` => Click on things...

For dropdowns and lists there is a class called "Select", the constructor
of such class ask for the element (put here the findElement).
There is different methods to choose a specific option.

`selectByIndex()` `selectByValue()` `selectByVisibleText()`

---
### Waits
`.Thread.sleep()` => Java approach in milliseconds. Only for 
situations where there is a very specific time to wait.

Some methods have an automatic wait in them, for example, the `.get()`
that send you to the url has an automatic wait of 60 seconds reading "page",
so it waits until the page is loaded or 60 seconds passed.

`driver.manage().timeouts().pageLoadTimeout()` => Modifies the 
default wait for loading page.

`driver.manage().timeouts().implicitlyWait()` => Manages the 
default wait for finding elements. Default is 0.

Explicit wait is a bit more difficult, as it applies for element, and
not as a general configuration. You have to write it every time before
the statement you want to wait for. Below you have an example
waiting 20s for a certain text to be present in an element, like a 
dropdown. 

```
WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.textToBePresentInElement(element));
```

---
## Fetch Data
`.getCurrentUrl()` `.getTitle()` `getPageSource()`

It would give us the current url, title, and full html of the page. For
specific elements we have different commands related to the findElement
associated to the element itself.

`.getText()` `.getAttribute()` `.getLocation()`

Inner text of any element, or the value of a type (for example, style or id),
and the exact coordinates of the item inside the page (X, Y axis).

`.isEnabled()` `.isDisplayed()` `isSelected()`

This three check if the item is enabled or not (can be clicked in a button,
for example), if it has display none, and, in the case of checkbox
or similar, if it has been selected. All of them returns a boolean.

---
## Methods to find stuff
`driver.findElement(By())` => This looks for the first element that
matches the requirements between brackets.

`driver.findElements(By())` => Similar to the above, but it returns
a list of all webElements, or empty if nothing.

- By.id( )
- By.name( )
- By.className( )
- By.tagName( )
- By.linkText( )
- By.partialLinkText( )
- By.cssSelector( )
- By. xpath( )
- executeScript( js )

---
Examples of complex queries could be:

`driver.findElement(By.linkTex("Return to home page"))`

`driver.findElement(By.cssSelector(input[value='Register']))`

---
## J-Unit
It's less advanced than TestNG, but it can be used too. It's treated
as a dependency for Maven, and it seems it's available in all Maven
projects. To use it, you just need to apply certain tags and actions.

`@Test` => Marks a method as a test.

`@Before` => Implies it's a requirement and it's run first.

`@After` => Implies it's post execution and it's run last.

`@Ignore` => Ignores the test in this run.

The order of the tags doesn't change the results, but @Test is
mandatory, the others are optional. You can have multiple tests in
the same class, and JUnit will order them by name. Before and after
are executed for each test. Class tags requires the methods to be static.

`@BeforeClass`=> Does the same as @Before but regarding the class,
executing just once.

`@AfterClass` => Same case as with @BeforeClass.

To compare the expected result and the real one, you can use the
Assert method. There is several ways of using it.

`Assert.assertEquals()`

`Assert.assertTrue()`

---
## Keyboard and mouse Operations
Those operations are done through the Actions class. Don't forget
to instance it `Actions act = new Actions()`. In general all actions
require to end with `.perform()` unless said otherwise. You can combine
both, keyboard and mouse, to perform more complex actions.

### Keyboard operation
`.sendKeys()` => Simple or complex keys. Complex, like tab, use `keys.`
inside the sendKeys brackets.

`.keyDown().sendKeys()` => For combination, like Ctrl + X. It
works similar to above with brackets.

---
### Mouse operation
`.click()` `.click(WebElement)` => It left-click somewhere, or in the element
depending on which one you selected.

`.contextClick()` `.contextClick(WebElement)` => Related to right-click.

`.doubleClick()`

`.moveToElement()` => Moves the mouse over something.

---
## TestNG
It's more advanced than JUnit, and usually we will be using this one.
You can treat it as a Maven dependency too, so it's easy to install.
Similar to JUnit, it uses the `@Test` annotation to recognize the
method as a test case. Although there is a few differences in other
tags.

`@BeforeMethod` => Applies before other tests.

`@AfterMethod` => Applies after other tests.

`@AfterClass`=> Exists too here.

The `@Test` annotation is mandatory, and same as in JUnit the order
doesn't alter the results. TestNG accepts several test cases in
the same class, just add the tag to more methods, and it will
accept it. Same as in JUnit it will order the methods by name.

`@Test(enabled=False)` => Ignores a test (it won't get executed).

`@Test(priority=1)` => It orders the execution by priority. No
priority is highest priority.

`@Test(dependsOnMethods="X")` => It won't get executed if X fails.

`@Test(groups={"Group"}` => Assign it to a group (like smoke testing).

`@BeforeMethod(alwausRun=true)` => Will always run, no matter the groups.

---

### TestNG.xml
This file acts as a sort of Test Suite, allowing you to configure and
execute multiple tests at the same time without going class by class.
To create the xml file follow the instructions:

- Right click on project root - new file - (name).xml
- Fill the info of the test suite
```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >

<suite name="Suite1" verbose="1" >
  <test name="Nopackage" >
    <classes>
       <class name="NoPackageTest" />
    </classes>
  </test>

  <test name="Regression1">
    <classes>
      <class name="test.sample.ParameterSample"/>
      <class name="test.sample.ParameterTest"/>
    </classes>
  </test>
</suite>
```
Instead of classes you can call packages directly. In IntelliJ you have
to go to Run | Edit configurations and add the suite in TestNG
configuration. The output directory is the xml file you just
created.

You can execute tests by groups too.
```
<groups>
    <run>
        <include name="Smoke"></include>
    </run>
</groups>
```





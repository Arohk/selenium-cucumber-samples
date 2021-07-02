# CucumberProject
Sample project with Cucumber Java and Selenium

### Installation (pre-requisites)

1. JDK 11 
2. Maven 
3. IntelliJ
5. Browser driver is included

### Framework set up
Fork / Clone repository from [here](https://github.com/Arohk/CucumberProject.git) or download zip and set
it up in your local workspace.

### The Page Object Design Pattern

Within your web app's UI there are areas that your tests interact with. A Page Object simply models these as objects
within the test code. This reduces the amount of duplicated code and means that if the UI changes, the fix need only be
applied in one place. In other wards one of the challenges of writing test automation is keeping your selectors (
classes, id's, or xpath' etc.) up to date with the latest version of your code. The next challenge is to keep the code
you write nice and `DRY (Don't Repeat Yourself)`. The page object pattern helps us accomplish this in one solution.
Instead of including our selectors in our step definitions(in cucumber) we instead place them in a <pagename>.java file
where we can manage all these selectors and methods together. Your test file should only call the test methods.

You can also place reusable methods or logic inside of these pages and call them from your step java files. The page
object serves as a layer of abstraction between tests and code. When A test fails, it fails on a individual step. That
step may call a selector that is no longer valid, but that selector may be used by many other steps. By having a single
source of truth of what the selector is supposed to be, fixing one selector on the page object could repair a number of
failing tests that were affected by the same selector.
  
### Fluent Design Pattern

In software engineering, a fluent Design Pattern is an implementation of an object-oriented API that aims to provide the most readable code.A fluent pattern is typically implemented by using method cascading (concretely method chaining) to relay the instruction context of a subsequent call (but a fluent interface entails more than just method chaining).
The context is defined through the return value of a called method-self-referential, where the new context is equivalent to the last context.
Self-referential, where the new context is equivalent to the last contest terminated by the return of a void context.
Terminated by the return of a void context.

### Run The Sample Test

The test can be executed from the cucumber test runner: OpenAndPlayGameSampleTest.java,
from the cucumber Feature File OpenAndPlayGameSampleTest.feature
or from the maven test phase.


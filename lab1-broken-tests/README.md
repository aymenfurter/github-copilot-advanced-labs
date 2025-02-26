# Lab 1: Fixing Broken Tests with GitHub Copilot Agent Mode

This lab demonstrates how GitHub Copilot's Agent Mode can help identify, fix, and rerun tests directly from your IDE. You'll work with a Java application that has several test failures due to bugs in the implementation code.

## Prerequisites

- Java JDK 17 installed
- Maven installed
- Visual Studio Code with GitHub Copilot extension and Java Test Runner extension
- GitHub Copilot subscription activated
- Basic understanding of Java and JUnit testing

## Lab Overview

In this lab, you'll work with a Java implementation of a ProductService with failing tests. The service manages product inventory with operations like adding products, updating quantity, applying discounts, and calculating inventory value.

The `ProductServiceTest` class contains tests that are currently failing due to bugs in the `ProductService` implementation. Your task is to identify and fix these issues using GitHub Copilot.

## Exercise: Analyzing and Fixing Failing Tests

In this exercise, you'll use GitHub Copilot's Agent Mode to analyze and fix multiple failing tests in a single workflow:

1. Run the tests using VS Code Test Explorer:
   - Open the Test Explorer panel
   - Click the "Run All Tests" button
   - Review the failing tests and their error messages

2. Ask GitHub Copilot Agent Mode to analyze and fix all the failing tests:

```
copilot> 
#testfailure
[ERROR] Tests run: 8, Failures: 4, Errors: 0, Skipped: 0
[ERROR] Failed tests:
[ERROR]   ProductServiceTest.testUpdateQuantity:31 expected:<false> but was:<true>
[ERROR]   ProductServiceTest.testSearchProducts:65 expected:<1> but was:<0>
[ERROR]   ProductServiceTest.testGetLowStockProducts:78 expected:<true> but was:<false>
[ERROR]   ProductServiceTest.testGetTotalInventoryValue:85 expected:<32345.95> but was:<2349.49>

I need help analyzing these test failures and fixing the ProductService implementation. Can you explain what's wrong in each case and suggest fixes?

copilot>
Can you implement these fixes and then run the tests again to verify they pass?
```

3. Apply the suggested fixes to the ProductService class.

4. Have Copilot verify that your changes fixed the issues.

## Success Criteria

✅ All tests pass after your fixes  
✅ You can explain how each fix addresses the underlying issue  
✅ You understand how Copilot Agent Mode helped you analyze test failures  
✅ You've experienced how Copilot can assist with running tests directly from VS Code

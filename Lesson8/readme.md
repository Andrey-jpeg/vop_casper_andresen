# Tasks

## Task 1

- Use the method in the Assertion class to validate that the final dice values are equal to six. Use the already created
  façade.FacadeWithCallbackTest class in the Test Packages folder to write your test.
- Use the `public void setup()` method to instantiate the `CallBackInterface` and the
  `FaçadeWithCallback` Class.
- Use the public void `teardown()` method to interrupt the _FaçadeWithCallback Thread_.

## Task 2

Package binary_search_test contains BinarySearch in both a recursive- and an iterative- version. Write Junit methods to
test them both:
 - `shouldFindIndexOfNumber()` // Find present number - `shouldReturnNegativeInsertionPointWhenNotFound()` //Find not-present
number
- Use this array as test input:
`private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};`
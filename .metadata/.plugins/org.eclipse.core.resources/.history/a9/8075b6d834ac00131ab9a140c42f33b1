package com.example.tests;

import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToMainPage();
  }
}

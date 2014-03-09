package com.example.tests;

import org.testng.annotations.Test;

public class EmptyGroupCreation extends TestBase {

	@Test
	  public void testEmptyGroupCreation() throws Exception {
	    openMainPage();
	    openGroupsPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupCreation();
	    returnToGroupsPage();
	  }

}

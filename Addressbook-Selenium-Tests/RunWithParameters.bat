java -cp %1\bin;%2\xstream-1.4.7.jar;%2\xpp3_min-1.1.4c.jar;%2\xmlpull-1.1.3.1.jar;%2\selenium-2.40.0\selenium-server-standalone-2.40.0.jar -DconfigFile=%1\firefox.properties org.testng.TestNG %1\AllTestsSuite.xml
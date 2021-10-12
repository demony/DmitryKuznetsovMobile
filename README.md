# Mobile app testing.

This project demonstrates the use of an appium driver to test applications 
on mobile devices running Android and iOS.

### For device connected to local PC  
mvn clean test -P native   
mvn clean test -P web

### For device in EPAM cloud
  
Native application should be installed on device by hand before staring "native" tests:  

src/main/java/resources/EPAMTestApp.apk - for android  
src/main/java/resources/EPAMTestApp.apk - for iOS  

In pom.xml file place your EPAM cloud token:
````
<properties>
    <token><!-- your token from epam cloud --></token>
</properties>
````

You can set various device criteria in xml files located in directory  
src/test/resources/

#### Test application
mvn clean test -P native-cloud-android  
mvn clean test -P native-cloud-ios

mvn clean test -P web-cloud-android  
mvn clean test -P web-cloud-ios




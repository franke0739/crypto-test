# Java BDD Framework with cucumber, appium, selenium and rest-assured
### Before execute test
#### 1) Launch Appium by execute command (Make sure Appium installed)
````
appium
````
#### 2) Launch Android Emulator
##### Step 1: Launch Android Studio
##### Step 2: In Android Studio, launch Android Virtual Device Manager
##### Step 3: Create a virtual device: 
###### Android Version: 11.0
###### Resolution: 1080x2560
###### AVD Name: Pixel_4_XL
##### Step 4: Launch this AVD in the emulator 
### Command to execute test (Launch CMD in the repository folder)
#### MacOS
```
mvn test
```
#### Windows
```
mvn test
```

### Report location:
###### {repository}/test-output/HtmlReport/ExtentHtml.html


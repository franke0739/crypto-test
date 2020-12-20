# Java BDD Framework with cucumber, appium, selenium and rest-assured
### Before execute test
#### 1) Launch Appium with the config:
###### Host: 0.0.0.0
###### Port: 4723
#### 2) Launch Android Emulator
##### Step 1: Launch Android Studio
##### Step 2: In Android Studio, launch Android Virtual Device Manager
##### Step 3: Create a virtual device: 
###### Android Version: 11.0
###### Resolution: 1080x2560
###### AVD Name: Frank
##### Step 4: Launch this AVD in the emulator 
### Command to execute test (Launch cmd/Terminal in the project root directory)
#### MacOS
```
mvn test
```
#### Windows
```
mvn test
```

### Report location:
###### {project_root}/test-output/HtmlReport/ExtentHtml.html


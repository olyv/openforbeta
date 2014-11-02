To run the tests you need to have java 7 and maven 3 installed. Copy (clone project), switch to the directory where pom.xml is and run the tests using command 'mvn test'.

It is possible to run the tests across two browsers: Firefox or Chrome. To run the the tests in specific browser use next command 'mvn test -Dwebbrowser=firefox'. Option -Dwebbrowser describes the browser to be used. Two option are currently possible: firefox and chrome. If this option is missing then default browser Firefox is used. It also possible to run Chrome if you use Linux or Windows 7.

After tests are executed you can find reports in ./target/index.html file. 

Java Programming Test
========

This is a dummy application to be used as part of a software development interview.

Instructions
--------

* Treat this code as if you owned this application, do whatever you feel is necessary to make this your own.
* There are several deliberate design, code quality and test issues that should be identified and resolved.
* The project uses maven to resolve dependencies however if you want to avoid maven configuration the only external JAR that's required is junit-4.11.
* Refactor and add features (from the below list) as you see fit. Keep in mind that code quality is the critical measure and there should be an obvious focus on testing.


CSV to XML converter
--------

A dummy application for a CSV to XML convertor JAR.

### Current Features

* Fixed number of fields can be converted from the CSV file: FIRST_NAME, LAST_NAME, ROLE.
* The application is dependent of the input CSV file format.
* There are no unit tests.


### Additional Features

* Change the application to make it independent of the CSV file format: header fields and entry records.
* Make changes to support dynamic XML elements.
* Write a batch command file.
* Add unit tests.

## Run command
``` >java -jar target\csv-converter.jar ```
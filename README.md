# GoldenEye Project 

This web-form allows users to obtain an email address. Client-side and server-side validation is provided to ensure valid data entry.

## Form Behavior

The form consists of the following fields:

- **Name:** User's first name.
- **Surname:** User's last name.
- **Office:** Selection of user's workplace between Milan, New York, and Spain.
- **Department:** Selection of user's department between Design, Business, Research & Development, and Advertising.

The form is submitted to the server when the "Submit" button is clicked. Prior to form submission, client-side validation is performed to ensure all fields are filled out. If any field is empty, an alert is displayed prompting the user to complete all fields.

On the server, additional validation is performed to ensure the received data is valid. If the data is valid, it is processed and the user's email address is displayed. If any errors occur during processing, an error message is displayed to the user.

## Technologies Used

- HTML: For the structure and elements of the form.
- CSS: For the visual styling of the form.
- JavaScript: For client-side validation.
- Spring Boot: For handling requests on the server side.

## Using the Form

1. Enter your first name, last name, select your workplace, and department.
2. Click the "Submit" button.
3. Your email address will be displayed on the screen if the data is valid. If there are any errors, an error message will be displayed.

## API integration  

For the integration of the API, I have built a class that helps to solve this problem, which is located at ./goldeneye-master/src/main/java/com/codebay/goldeneye/adapter/http/ApiIntegration.

In this class, you will find the function responsible for establishing the connection. In this file, developers should set the URI of the API to be queried.

Additionally, they should use this module in the file ./goldeneye-master/src/main/java/com/codebay/goldeneye/domain/entity/Email.java. In this file, developers can find commented code responsible for establishing the connection with the ApiIntegration module. Once the URI has been set (previous step), they should uncomment this part to achieve implementation.


## Run de application

    mvn spring-boot:run


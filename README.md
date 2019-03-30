# sparkjava-shiro-authentication
SparkJava and Shiro-based authentication.


This project provides an example for integrating Shiro authentication module with SparkJava framework. The application is running on jetty.

The outstnading problem is that after logging in, Shiro reports the user authentication and then unauthenticated on subsequent page reload. This issues seems to be due to Shiro subject properly set as authenticated on a given thread. However, other threads report unauthenticated status. 



Build the project:

mvn package



Run the server:

./start.sh


As soon as the application starts, please visit:

http://localhost:8080

That will present a login form. Just click on the Submit button. (Default values are already pre-populated.)

After you submit the form, the login status page will be presented. Please reload repeated to see logged in and NOT logged in behavior.

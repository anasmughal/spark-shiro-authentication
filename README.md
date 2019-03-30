# spark-shiro-authentication
SparkJava and Shiro-based authentication.


This project provides an example for integrating Shiro authentication module with SparkJava framework. The applicatoin is running on jetty.

The outstnading problem is that after logging in, Shiro reports the user authentication and then unauthenticated on subsequent page reload. 

This issues seems to be due to that Shiro subject is properly set as authenticated on a given thread. However, other threads report unauthenticated status. 



Build the project:

mvn package



Run the server:

./start.sh

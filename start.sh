export MAVEN_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=9000,server=y,suspend=n"

mvn jetty:run

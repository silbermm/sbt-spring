name := "spring-sbt"

version := "1.0"

scalaVersion := "2.10.2"

val springVersion = "3.2.4.RELEASE"

val hibernateVersion = "4.1.9.Final"

seq(webSettings :_*)

libraryDependencies ++= Seq(
	"org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
	"javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided",
	"javax.servlet" % "jstl" % "1.1.2",
	"taglibs" % "standard" % "1.1.2",
	"org.springframework" % "spring-core" % springVersion,
	"org.springframework" % "spring-context" % springVersion,
	"org.springframework" % "spring-web" % springVersion,
	"org.springframework" % "spring-webmvc" % springVersion,
	"org.springframework" % "spring-orm" % springVersion,
	"org.springframework" % "spring-test" % springVersion % "test",
	"org.springframework.amqp" % "spring-rabbit" % "1.1.4.RELEASE",
	"org.hibernate" % "hibernate-entitymanager" % hibernateVersion,
	"org.hibernate" % "hibernate-validator" % "4.1.0.Final",
	"org.hibernate.javax.persistence" % "hibernate-jpa-2.0-api" % "1.0.1.Final",
	"com.fasterxml.jackson.datatype" % "jackson-datatype-hibernate4" % "2.1.1",
	"commons-pool" %  "commons-pool" % "1.6",
	"commons-dbcp" % "commons-dbcp" % "1.4",
	"commons-collections" % "commons-collections" % "3.2.1",
	"javassist" % "javassist" % "3.3",
	"com.typesafe" % "config" % "1.0.0",
	"junit" % "junit" % "4.10" % "test",
	"ch.qos.logback" % "logback-classic" % "0.9.18",
	"ch.qos.logback" % "logback-core" % "0.9.18",
	"org.slf4j" % "slf4j-api" % "1.5.8",
	"org.slf4j" % "jcl-over-slf4j" % "1.5.8"
)


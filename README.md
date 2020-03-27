# Java Web Application using Embedded Tomcat

* 

## EQUIPE N°8 : PDB
Il n'y a que la branche Master, c'est donc celle qu'il faut utiliser.

* 

## SEE THE DEMO : 
https://youtu.be/jaXPGZ_pKLQ

* 

## Prerequisites

* Download Maven : 
http://mirrors.standaloneinstaller.com/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip

* Add to the path environement :

Linux : export PATH=$PATH:<path_to_maven>/bin
Windows : Setting global environment variables add the "<path_to_maven>\bin" to the variable "Path"

## Once it's done


* On linux, go into your project directory and run : 

* Go into your project directory and run :
> ./run.sh

* Then to start the server :
> sh target/bin/webapp (on Linux)

OR 

* On windows, go into tour projet directory and run :
> mvn package
> target/bin/webapp.bat (on Windows)

## Reference
https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat
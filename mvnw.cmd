@echo off
rem Usa JDK 22 so neste projeto (spotless/google-java-format nao suporta o JDK 25 da maquina).
set "JAVA_HOME=C:\Program Files\Java\jdk-22"
set "PATH=%JAVA_HOME%\bin;%PATH%"
"C:\maven\bin\mvn.cmd" %*

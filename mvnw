#!/bin/sh
# Usa JDK 22 so neste projeto (spotless/google-java-format nao suporta o JDK 25 da maquina).
export JAVA_HOME="/c/Program Files/Java/jdk-22"
export PATH="$JAVA_HOME/bin:$PATH"
exec mvn "$@"

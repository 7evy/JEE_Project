#!/bin/bash

echo "Compilation des modules"
javac --module-path ../../../lib tools/*.java
javac --module-path ../../../lib user/*.java

echo "run test"
java --module-path ../../../lib tools.TestSQL
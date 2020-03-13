#!/bin/bash

export PATH=$PATH:./apache-maven-3.6.3/bin

mvn package
sh target/bin/webapp
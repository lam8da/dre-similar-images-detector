#!/bin/bash
set -x

DIR=distribution/dre-1.0.2-macosx
BINARY=dre.app.macosx.x64.jar 

build() {
  ant make-macosx-distribution
  ant clean
}
run() {
  cd $DIR
  rm stdout stderr
  java -d64 -XstartOnFirstThread -jar $BINARY
}

# if ! test -e $DIR/$BINARY; then
#   build
# fi
build
run

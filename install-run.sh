#!/bin/bash
set -ex

DIR=distribution/dre-1.0.2-macosx
BINARY=dre.app.macosx.x64.jar 

build() {
  # if test -e $DIR/$BINARY; then return; fi
  ant make-all-distribution
  # ant clean
}
run() {
  cd $DIR
  rm stdout stderr
  java -d64 -XstartOnFirstThread -jar $BINARY
}

build
run

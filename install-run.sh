#!/bin/bash
set -ex

DIR=distribution/dre-1.0.2-macosx
BINARY=dre.app.macosx.x64.jar 

rebuild=''

build() {
  if [[ -e $DIR/$BINARY ]] && [[ "$rebuild" != 'yes' ]]; then
    return
  fi
  ant make-all-distribution
  # ant clean
}
run() {
  cd $DIR
  rm -f stdout stderr
  # java -d64 -XstartOnFirstThread -jar $BINARY
  java -XstartOnFirstThread -jar $BINARY
}

if [[ "$1" == '-f' ]]; then
  rebuild=yes
fi
build
run

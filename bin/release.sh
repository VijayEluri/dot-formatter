#!/bin/bash

VERSION=$1

fail()
{
    echo "$1" >&2
    exit 1
}

if [ -z "$VERSION" ]
then
    fail "Usage: $0 [version]"
fi

echo "Have you manually set the artifact version in the POM?"

read

echo "Have you commited all your stuff to the repo?"

git status || fail "Can't show repo status"

read

mvn clean deploy || fail "Can't deploy"

git add maven_repo || fail "Can't add"

git commit -a || fail "Can't commit"

git tag "v$VERSION" || fail "Can't tag version"

#!/bin/bash

echo "Enter Commit Info: "
read name

git add .
git commit -m "$name"
git push
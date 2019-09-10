#!/bin/bash
# Authors: Team TBD - Ryan Wade, Sam Lemon, and Wright Ledbetter
# CSCI 362 Fall 2019
# Displays a list of the top-level contents of the current directory in a browser

# Creates new html file containing the files and folders of the top-level directory
ls -x -lh > "list.html" 

# Edits and adds HTML tags
# http://askubuntu.com/questions/76808/how-do-i-use-variables-in-a-sed-command
sed -i "1 iListing folders and files of $PWD" list.html
sed -i '1 i<html>' list.html
sed -i '$ a</html>' list.html
sed -i '1~2a<p>' list.html
sed -i '2~1a</p>' list.html

# Open file in browser
# http://stackoverflow.com/questions/3124556/clean-way-to-launch-the-web-browser-from-shell-script
if which xdg-open > /dev/null
then
  xdg-open "list.html" 
elif which gnome-open > /dev/null
then
  gnome-open URL
fi

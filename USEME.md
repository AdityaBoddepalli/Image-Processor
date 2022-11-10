## Commands
**Note:-** if using relative paths all file paths are relative to the jar location which is in res.

### Our script that should be given as an input is name script.txt 
### Do not provide scriptTest.txt as input to the jar(it only exists to test the main method)

| To do this      | Type this                          |
|-----------------|------------------------------------|
| Loading Image   | load filepath imagename            |
| Red Component   | red-component imagename destname   |
| Green Component | green-component imagename destname |
| Blue Component  | blue-component imagename destname  |
| Value           | value imagename destname           |
| Intensity       | intensity imagename destname       |
| Luma            | luma imagename destname            |
| Vertical Flip   | flip-vertical imagename destname   |
| Horizontal Flip | flip-horizontal imagename destname |
| Brighten Image  | brighten imagename destname factor |
| Darken Image    | darken imagename destname factor   |
| Blur Image      | blur imagename destname            |
| Sharpen Image   | sharpen imagename destname         |
| Greyscale Image | greyscale imagename destname       |
| Sepia Image     | sepia imagename destname           |
| Save Image      | save filepath imagename            |

---
The commands can be entered via an interactive terminal (on default, when run with no cmd line arguments),
or via a script file with the filePath as a string in the first cmd line argument.

To quit the image processor type 'q' or 'quit' irrespective of the case. The process also quits at the end of
file when given a script as a command line argument.
---
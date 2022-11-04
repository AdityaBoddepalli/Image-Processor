Model:-
Interfaces:
Pixel - represents a single pixel in an image.
PixelImage - an 2D image of pixels that can be interacted with in the processor.
ImageProcessor - The main model of this project where images can be loaded and processed.

Classes:
StdPixel - implements the Pixel interface and represents pixels as rgb values
GridPixelImage - implements the PixelImage interface and represents an image as a 2D array.
BasicImageProcessor - implements the ImageProcessor and represents the loaded images and processed images as 
                      a hashmap of strings and PixelImages.
--------------------------------------------------------------------------------------------------------------

View:-
Interfaces:
PixelImageView - so far only purpose of view in this processor is to transmit messages to the user, so this
                 interface is fairly simple with just one method.
Classes:
TerminalView - implements PixelImageView, transmits messages to the user via the terminal by defualt or
               any output provided to it.
--------------------------------------------------------------------------------------------------------------

Controller:-
Interfaces:
ImageProcessorController - A controller that starts the image processor and conveys the user commands to 
                           the model.
Classes:
ImageProcessorControllerImpl - implements ImageProcessorController, a non GUI type based controller that accepts 
                         input via a readable.

--------------------------------------------------------------------------------------------------------------

Command Design Pattern

Interface: ImageProcessorCmds - Commands on the ImageProcessorController that execute on the given model.
Classes: A command class for every command listed below and an abstract class that they inherit from
         which implements ImageProcessorCmds.

--------------------------------------------------------------------------------------------------------------

Commands(all filepaths are relative to the project directory):

To do this                                     - Type this

Loading Image                                  - load filepath imagename
Red Component                                  - red-component imagename destname
Green Component                                - green-component imagename destname
Blue Component                                 - blue-component imagename destname
Grayscale(type is one of value,intensity,luma) - greyscale imagename destname type
Vertical Flip                                  - flip-vertical imagename destname
Horizontal Flip                                - flip-horizontal imagename destname
Brighten Image                                 - brighten imagename destname factor
Darken Image                                   - darken imagename destname factor
Save Image                                     - save filepath imagename
--------------------------------------------------------------------------------------------------------------
The commands can be entered via an interactive terminal (on default, when run with no cmd line arguments),
or via a script file with the filePath as a string in the first cmd line argument.

To quit the image processor type 'q' or 'quit' irrespective of the case. The process also quits at the end of
file when given a script as a command line argument.
--------------------------------------------------------------------------------------------------------------

All the ppm files in the res folder have been created by the authors, and they are authorizing its use
in this project.
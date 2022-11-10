## Model
### Interfaces:
Pixel - represents a single pixel in an image.
PixelImage - an 2D image of pixels that can be interacted with in the processor.
ImageProcessor - The main model of this project where images can be loaded and processed.

### Classes:
StdPixel - implements the Pixel interface and represents pixels as rgb values
GridPixelImage - implements the PixelImage interface and represents an image as a 2D array.
BasicImageProcessor - implements the ImageProcessor and represents the loaded images and processed images as
a hashmap of strings and PixelImages.

### Filters:
This folder is a new addition to HW5. It contains different kinds of filter matrices that can be
applied to the image.

---

## View
### Interfaces:
PixelImageView - so far only purpose of view in this processor is to transmit messages to the user, so this
interface is fairly simple with just one method.
### Classes:
TerminalView - implements PixelImageView, transmits messages to the user via the terminal by defualt or
any output provided to it.
---
## Controller
### Interfaces:
ImageProcessorController - A controller that starts the image processor and conveys the user commands to
the model.
### Classes:
ImageProcessorControllerImpl - implements ImageProcessorController, a non GUI type based controller that accepts
input via a readable.

---
## Command Design Pattern

### Interface: 
ImageProcessorCmds - Commands on the ImageProcessorController that execute on the given model.
### Classes: 
A command class for every command listed below and an abstract class that they inherit from
which implements ImageProcessorCmds.

---

### All specification in the "What to do" section of the assignment description have been completed.

---

## Design Changes

- The previous greyscale command was split into value, intensity and luma to account for the new greyscale command.
- Changed the script file to work with the jar in the res folder.
- Abstracted the component extracting methods in the Image Processor model as they had similar signatures.
- Added a helper function to the main so the main has a single purpose and the input parsing is testable.
---
## Citation Note
All the ppm files in the res folder have been created by the authors, and they are authorizing its use
in this project.
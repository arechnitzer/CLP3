# CLP-3 PreTexT source files
* The text and problem sets were originally written as separate texts in latex.
* In order to provide a good online text we translated the latex into  [pretext](https://pretextbook.org/) xml.
* The resulting pretext sources compile into a combined text with exercises.

## Figure files
* In order to compile the pretext into both html and pdf, the figures have been saved as both svg and pdf.
* See the latex sources for information on how they were produced.

### New html build instructions August 2024

* First install the new python pretext package
```
pip3 install pretext
```

* Then build using the pretext-cli (much easier)
```
pretext build html -g 
```
  * this can take some time - its a big document.
  * the `-g` tells pretext to also build all the extra (latex encoded) images.

#### Some notes
* At this point I don't have CLP-styling for the latex build working. 
* Images have been moved into the `assets` subdirectory which the pretext-cli expects them
* To get google-analytics working you have to comment out the associated line in the publication.ptx file

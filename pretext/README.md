# CLP-3 PreTexT source files
* The text and problem sets were originally written as separate texts in latex.
* In order to provide a good online text we translated the latex into  [pretext](https://pretextbook.org/) xml.
* The resulting pretext sources compile into a combined text with exercises.

## Figure files
* In order to compile the pretext into both html and pdf, the figures have been saved as both svg and pdf.
* See the latex sources for information on how they were produced.

## Minimal PreTexT installation
* You do not need to install all of [PreTexT](https://pretextbook.org/) to build CLP-3.
* We include here the minimum necessary pretext XSL files needed.
* Minor changes have been made to allow for CLP styling - those changes are tagged in the source.
* In time those styling options will be absorbed into the standard PreTexT code base.

## Compilation instructions
* The pretext source files can be compiled into html and PDF.
* The user does not  need to install pretext, but will need a working python3 install.
* Additionally the user will need to install python3-lxml either through the Python package installer pip or your package manager.

### Compiling to LaTeX and PDF
* Move into the directory containing `clp_3_mc.ptx`
* Run the following command:
`./buildLatex.py`
* This command takes a few minutes to run.
* This will produce a (large) latex file `clp_3_mc.tex`
* Compile this with `pdflatex clp_3_mc.tex`
* This will also take a few minutes to run and you'll have to run it a few times to get all the internal references right.

### Compiling to HTML
* Move into the directory containing `clp_3_mc.ptx`
* We will build the website in a subdirectory of the current directory; that subdirectory should then be uploaded to its final hosting location.
* Run the following command
`./buildHTML.py`
* This will take a few minutes to run and produce a large number of html files.
* Finally copy the non-tikz figures into place by copying the `figs/*.svg` files to `site/figs` and copying the `pfigs/*.svg` files to `site/pfigs`.
* Now the html is ready and you can upload the entire `site` directory to the webserver of your choice.

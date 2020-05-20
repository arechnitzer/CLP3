                  /*  File:  detij.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class detij extends Template {

     static {templateClass = new detij() ; }

     public void setup() {
          filePrefix = "detij" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.1*1.2 ;      // in inches
          ysize = 0.9 ;   // in inches. 
          xmin =  0 ;
          xmax = 535*1.2 ;
          ymin = -50 ;
          ymax =  40 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
         fEnv("lineWidth", 1.0) ;
         fTeXlabel( -50, 0, "lc", "$\\hi\\times\\hj=\\det \\left[\\begin{matrix}\\hi&\\hj &\\hk\\\\ 1&0&0\\\\ 0&1&0\\end{matrix}\\right]$") ;
         fTeXlabel( 110, 0, "lc", "$\\ =\\ \\hi\\det \\left[\\begin{matrix}\\hi& \\hj &\\hk\\\\ 1&0&0\\\\ 0&1&0\\end{matrix}\\right]$") ;
         fTeXlabel( 260, 0, "lc", "$\\ -\\ \\hj\\det \\left[\\begin{matrix}\\hi&\\hj &\\hk\\\\ 1&0&0\\\\ 0&1&0\\end{matrix}\\right]$") ;
         fTeXlabel( 405, 0, "lc", "$\\ +\\ \\hk\\det \\left[\\begin{matrix}\\hi&\\hj & \\hk\\\\ 1&0&0\\\\ 0&1&0\\end{matrix}\\right]$") ;

         fTeXlabel( 110, -48, "lc", "$\\ =\\ \\hi\\,(0\\times 0-0\\times 1)$") ;
         fTeXlabel( 258, -48, "lc", "$\\,-\\,\\hj\\,(1\\times 0-0\\times 0)$") ;
         fTeXlabel( 398, -48, "lc", "$\\,+\\,\\hk\\,(1\\times 1-0\\times 0)\\ =\\ \\hk$") ;

         fLine( 184, 19,  247, 19) ;
         fLine( 192, 27,  192, -30) ;

         fLine( 334, 19,  397, 19) ;
         fLine( 362, 27,  362, -30) ;

         fLine( 481, 20,  543, 20) ;
         fLine( 534, 27,  534, -30) ;

     }
}

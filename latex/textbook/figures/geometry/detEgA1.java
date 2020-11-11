                  /*  File:  detEgA1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class detEgA1 extends Template {

     static {templateClass = new detEgA1() ; }

     public void setup() {
          filePrefix = "detEgA1" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.1*1.2 ;      // in inches
          ysize = 1.15 ;   // in inches. 
          xmin =  0 ;
          xmax = 535*1.2 ;
          ymin = -75 ;
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
         fTeXlabel( -50, 0, "lc", "$\\va\\times\\vb=\\det \\left[\\begin{matrix}\\hi&\\hj &\\hk\\\\ 1&2&3\\\\ 1&\\!-1&2\\end{matrix}\\right]$") ;
         fTeXlabel( 130, 0, "lc", "$\\ =\\ \\hi\\det \\left[\\begin{matrix}\\hi& \\hj &\\hk\\\\ 1&2&3\\\\ 1&\\!-1&2\\end{matrix}\\right]$") ;
         fTeXlabel( 285, 0, "lc", "$\\ -\\ \\hj\\det \\left[\\begin{matrix}\\hi&\\hj &\\hk\\\\ 1&2&3\\\\ 1&\\!-1&2\\end{matrix}\\right]$") ;
         fTeXlabel( 435, 0, "lc", "$\\ +\\ \\hk\\det \\left[\\begin{matrix}\\hi&\\hj & \\hk\\\\ 1&2&3\\\\ 1&\\!-1&2\\end{matrix}\\right]$") ;

         fTeXlabel( -8, -48, "lc", "$\\ =\\ \\hi\\,\\{2\\times 2-3\\times(- 1)\\}$") ;
         fTeXlabel( 170, -48, "lc", "$\\,-\\,\\hj\\,\\{1\\times 2-3\\times 1\\}$") ;
         fTeXlabel( 310, -48, "lc", "$\\,+\\,\\hk\\,\\{1\\times(-1)-2\\times 1\\}$") ;

         fTeXlabel( -8, -70, "lc", "$\\ =\\ 7\\,\\hi+\\hj-3\\,\\hk$") ;


         fLine( 204, 19,  277, 19) ;
         fLine( 211, 27,  211, -30) ;

         fLine( 357, 19,  427, 19) ;
         fLine( 392, 27,  392, -30) ;

         fLine( 511, 20,  583, 20) ;
         fLine( 574, 27,  574, -30) ;

     }
}

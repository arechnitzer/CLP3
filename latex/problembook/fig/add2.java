                  /*  File:  add2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class add2 extends Template {

     static {templateClass = new add2() ; }

     public void setup() {
          filePrefix = "add2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.4*0.5 ;      // in inches
          ysize = 2.4*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  4.2 ;
          ymin = -0.2 ;
          ymax =  2.2 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.2) ;
         fEnv("headLength", 6*1.2) ;
         double ax = 2 ; double ay = 0 ;
         double bx = 1 ; double by = 1 ;
         fArrow(0, 0,   ax, ay ) ;
         fArrow(ax, ay,    ax+2*bx, ay+2*by ) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
         fArrow(0, 0,    ax+2*bx, ay+2*by ) ;

         fTeXlabel(ax/2, -0.05, "tc", "$ \\va$" ) ;
         fTeXlabel(ax+bx, by-0.05, "tl", "$ 2\\vb$" ) ;
         fTeXlabel( ax/2+bx, by, "rb", "$ \\va+ 2\\vb$" ) ;
     }
}

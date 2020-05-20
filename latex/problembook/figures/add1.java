                  /*  File:  add1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class add1 extends Template {

     static {templateClass = new add1() ; }

     public void setup() {
          filePrefix = "add1" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.4*0.5 ;      // in inches
          ysize = 1.4*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  3.2 ;
          ymin = -0.2 ;
          ymax =  1.2 ;
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
         fArrow(ax, ay,    ax+bx, ay+by ) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
         fArrow(0, 0,    ax+bx, ay+by ) ;

         fTeXlabel(ax/2, -0.05, "tc", "$ \\va$" ) ;
         fTeXlabel(ax+bx/2, by/2-0.05, "tl", "$ \\vb$" ) ;
         fTeXlabel( (ax+bx)/2, by/2, "rb", "$ \\va+ \\vb$" ) ;
     }
}

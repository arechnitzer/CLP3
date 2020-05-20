                  /*  File:  projA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class projA extends Template {

     static {templateClass = new projA() ; }

     public void setup() {
          filePrefix = "projA" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 100 ;
          ymin = -25 ;
          ymax = 75 ;
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
         fRotate( 30*Math.PI/180.0) ;
         fArrow( 0, 0, 75, 0) ;
         fArrow( 0, 0, 50, 50) ;
         fLine( 50, 50,  50, 0) ;
         fDisk(0,0, 2, 2, FILLED) ;

         fLine( 50, 5,  55, 5) ;
         fLine( 55, 5, 55, 0) ;

         fEnv("lineWidth", 1) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("psFillColor", Red) ;
         fEnv("useColorPs", "true") ;
         fArrow( 0, 0, 50, 0) ;

         fTeXlabel(   41, 45,  "br",  "$\\va$") ;
         fTeXlabel(   79,  -5,  "tr",  "$\\vb$") ;
         fTeXlabel(   30,   0,  "tl",  "$\\text{proj}_{\\vb}\\,\\va$"  ) ;
         fTeXlabel(   15,  7,  "cc",  "$\\theta$") ;
     }
}

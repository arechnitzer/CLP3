                  /*  File:  dotAngle.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dotAngle extends Template {

     static {templateClass = new dotAngle() ; }

     public void setup() {
          filePrefix = "dotAngle" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
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
         fEnv("lineWidth", 1) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         fArrow( 0, 0, 75, 0) ;
         fArrow( 0, 0, 50, 50) ;
         fDisk(0,0, 3, 3, FILLED) ;

//         String Red = "0 1 1 0 setcmykcolor  " ;
//         canvas.append( new fPsWrite(Red+"\n")) ;
//         fEnv("psFillColor", Red) ;
//         fEnv("useColorPs", "true") ;

         fTeXlabel(   37, 45,  "br",  "$\\va$") ;
         fTeXlabel(   79,  -9,  "tr",  "$\\vb$") ;
         fTeXlabel(   15*1.3,  7*1.3,  "cc",  "$\\theta$") ;
     }
}

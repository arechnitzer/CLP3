                  /*  File:  scalmul.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class scalmul extends Template {

     static {templateClass = new scalmul() ; }

     public void setup() {
          filePrefix = "scalmul" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -10 ;
          xmax = 90 ;
          ymin = -10 ;
          ymax = 90 ;
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
          fLine( -5, 0, 90, 0) ;
          fLine( 0, -5, 0, 90) ;
          fLine( -5, 45, 0, 45) ;
          fLine( -5, 90, 0, 90) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk( 0, 0,  3, 3, FILLED) ;
          fArrow( 0, 0, 45, 45) ;
          fArrow( 0, 0, 90, 90) ;
          fTeXlabel( -5, 45, "rc", "$a_2$") ;
          fTeXlabel( -5, 90, "rc", "$2a_2$") ;
          fTeXlabel( 50, 41, "tc", "$\\va$") ;
          fTeXlabel( 97, 85, "tc", "$2\\va$") ;
     }
}

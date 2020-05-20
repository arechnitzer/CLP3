                  /*  File:  addvec.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class addvec extends Template {

     static {templateClass = new addvec() ; }

     public void setup() {
          filePrefix = "addvec" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.05 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -10 ;
          xmax = 95 ;
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
          fLine( -5, 30, 0, 30) ;
          fLine( -5, 90, 0, 90) ;
          fBracket( -2, 32,  -2, 88 ) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk( 0, 0,  3, 3, FILLED) ;
          fDisk( 90, 30,  3, 3, FILLED) ;
          fArrow( 0, 0,   90, 30) ;
          fArrow( 90, 30, 70, 90) ;
          fArrow( 0, 0,   70, 90) ;
          fTeXlabel( -10, 30, "rc", "$a_2$") ;
          fTeXlabel( -10, 90, "rc", "$a_2+b_2$") ;
          fTeXlabel( -12, 60, "rc", "$b_2$") ;
          fTeXlabel( 55, 15, "tc", "$\\va$") ;
          fTeXlabel( 88, 68, "tc", "$\\vb$") ;
          fTeXlabel( 78, 90, "lc", "$\\va+\\vb$") ;
     }
}

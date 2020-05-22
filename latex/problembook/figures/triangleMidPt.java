                  /*  File:  triangleMidPt.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleMidPt extends Template {

     static {templateClass = new triangleMidPt() ; }

     public void setup() {
          filePrefix = "triangleMidPt" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 0.6 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -50 ;
          ymax = 10 ;
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
          double a1 = -50 ;
          double a2 = -30 ;
          double b1 = 70 ;
          double b2 = -40 ;
          fArrow(0, 0, 0.98*a1, 0.98*a2) ;
          fArrow(0, 0, 0.98*b1, 0.98*b2) ;
          fLine(a1, a2, b1, b2) ;
          fDisk(0, 0, 2, 2, FILLED) ;
          fTeXlabel (0,4, "bc", "$C$") ;
          fTeXlabel (a1+2,a2-3, "tr", "$A$") ;
          fTeXlabel (b1+2,b2-2, "tl", "$B$") ;
          fTeXlabel (a1+5,a2+10, "br", "$\\va$") ;
          fTeXlabel (b1-10,b2+10, "bl", "$\\vb$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(0.5*a1, 0.5*a2, 2, 2, FILLED) ;
          fDisk(0.5*b1, 0.5*b2, 2, 2, FILLED) ;
          fLine(0.5*a1, 0.5*a2, 0.5*b1, 0.5*b2) ;
          fDisk(a1, a2, 2, 2, FILLED) ;
          fDisk(b1, b2, 2, 2, FILLED) ;
          fLine(a1, a2, b1, b2) ;

     }
}

                  /*  File:  polar3A.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar3A extends Template {

     static {templateClass = new polar3A() ; }

     public void setup() {
          filePrefix = "polar3A" ;  // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.0*0.7 ;      // in inches
          ysize = 1.6*0.7 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 3.5 ;
          ymin = -0.1 ;
          ymax =  1.5 ;
          topmargin = 0.0 ;   // in inches
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
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax,-0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          double x1 = 3  ; double y1 = 0 ;
          double xa1 = 1  ; double ya1 = 0 ;
          double x2 = 0 ; double y2 = 1 ;
          double xa2 = 0  ; double ya2 = 1 ;
          double x3 = -2 ; double y3 = 0 ;
          double xa3 = -1 ; double ya3 = 0 ;

          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double r1 = 0.4 ;
          double r2 = 0.3 ;

          fEllipticalArc(0, 0, r1, r1, 0, 90, OPEN) ;
          fTeXlabel(0.6*r1, 0.8*r1, "bl", "$\\frac{\\pi}{2}$") ;
          fEllipticalArc(0, 0, r2, r2, 0, 180, OPEN) ;
          fTeXlabel(-0.65*r2, 0.85*r2, "br", "$\\pi$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          double rr = 0.05 ;

          fLine(0, 0,  x1, y1) ;
          fDisk(x1,y1, rr, rr, FILLED) ;
          fTeXlabel(x1,y1+0.1, "bc", "$(3,0)$") ;

          fLine(0, 0,  x2, y2) ;
          fDisk(x2,y2, rr, rr, FILLED) ;
          fTeXlabel(x2+0.1,y2, "cl", "$(0,1)$") ;

          fLine(0, 0,  x3, y3) ;
          fDisk(x3,y3, rr, rr, FILLED) ;
          fTeXlabel(x3-0.1,y3+0.1, "bc", "$(-2,0)$") ;

     }
}

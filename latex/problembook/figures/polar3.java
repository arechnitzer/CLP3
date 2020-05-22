                  /*  File:  polar3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar3 extends Template {

     static {templateClass = new polar3() ; }

     public void setup() {
          filePrefix = "polar3" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 9.0*0.5 ;      // in inches
          ysize = 4.0*0.5 ;   // in inches. 
          xmin = -4 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax =  3 ;
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
          fTeXlabel(xmax,-0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

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

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          double rr = 0.07 ;

          fLine(0, 0,  x1, y1) ;
          fDisk(x1,y1, rr, rr, FILLED) ;
          fTeXlabel(x1+0.1,y1-0.1, "tc", "$(3,0)$") ;

          fLine(0, 0,  x2, y2) ;
          fDisk(x2,y2, rr, rr, FILLED) ;
          fTeXlabel(x2+0.1,y2, "cl", "$(0,1)$") ;

          fLine(0, 0,  x3, y3) ;
          fDisk(x3,y3, rr, rr, FILLED) ;
          fTeXlabel(x3-0.3,y3+0.1, "bl", "$(-2,0)$") ;


   
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("lineWidth", 1.0) ;

          fArrow(x1, y1,  x1+xa1, y1+ya1) ;
          fTeXlabel(x1+xa1+0.02,y1+ya1+0.1, "bc", "$e_r(0)$") ;
          fArrow(x1, y1,  x1-ya1, y1+xa1) ;
          fTeXlabel(x1-ya1+0.1,y1+xa1+0.03, "bc", "$e_\\theta(0)$") ;

          fArrow(x2, y2,  x2+xa2, y2+ya2) ;
          fTeXlabel(x2+xa2+0.1,y2+ya2, "cl", "$e_r(\\frac{\\pi}{2})$") ;
          fArrow(x2, y2,  x2-ya2, y2+xa2) ;
          fTeXlabel(x2-ya2-0.2,y2+xa2+0.15, "bc", "$e_\\theta(\\frac{\\pi}{2})$") ;

          fArrow(x3, y3,  x3+xa3, y3+ya3) ;
          fTeXlabel(x3+xa3-0.2,y3+ya3+0.12, "bc", "$e_r(\\pi)$") ;
          fArrow(x3, y3,  x3-ya3, y3+xa3) ;
          fTeXlabel(x3-ya3+0.1,y3+xa3-0.05, "tc", "$e_\\theta(\\pi)$") ;


     }
}

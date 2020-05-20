                  /*  File:  polar2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar2 extends Template {

     static {templateClass = new polar2() ; }

     public void setup() {
          filePrefix = "polar2" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.7 ;      // in inches
          ysize = 2.1*0.7 ;   // in inches. 
          xmin = -2.0 ;
          xmax = 2.0 ;
          ymin = -0.1 ;
          ymax =  2.0 ;
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

          double x1 = 1  ; double y1 = 1 ;
          double xa1 = 1/Math.sqrt(2)  ; double ya1 = 1/Math.sqrt(2)  ;
          double th1 = 45 ; double thrad1=th1*Math.PI/180.0 ;
          double x2 = -1 ; double y2 = 1 ;
          double th2 = 135 ; double thrad2=th2*Math.PI/180.0 ;
          double xa2 = -1/Math.sqrt(2)  ; double ya2 = 1/Math.sqrt(2)  ;

          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          double rr = 0.05 ;
          double r1 = 0.4 ;
          double r2 = 0.3 ;
          fLine(0, 0,  x1, y1) ;
          fDisk(x1,y1, rr, rr, FILLED) ;
          fTeXlabel(x1+0.1,y1, "cl", "$(1,1)$") ;
          fTeXlabel(0.6*x1,0.6*y1, "br", "$\\sqrt{2}$") ;

          fLine(0, 0,  x2, y2) ;
          fDisk(x2,y2, rr, rr, FILLED) ;
          fTeXlabel(x2-0.1,y2, "cr", "$(-1,1)$") ;


          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Pink) ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fEnv("lineWidth", 1.0) ;
          fArrow(x1, y1,  x1+xa1, y1+ya1) ;
          fTeXlabel(x1+xa1+0.02,y1+ya1+0.03, "bc", "$e_r(\\frac{\\pi}{4})$") ;
          fArrow(x1, y1,  x1-ya1, y1+xa1) ;
          fTeXlabel(x1-ya1+0.1,y1+xa1+0.03, "bc", "$e_\\theta(\\frac{\\pi}{4})$") ;
          fArrow(x2, y2,  x2+xa2, y2+ya2) ;
          fTeXlabel(x2+xa2-0.02,y2+ya2+0.03, "bc", "$e_r(\\frac{3\\pi}{4})$") ;
          fArrow(x2, y2,  x2-ya2, y2+xa2) ;
          fTeXlabel(x2-ya2-0.05,y2+xa2+0.02, "cr", "$e_\\theta(\\frac{3\\pi}{4})$") ;



          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEllipticalArc(0, 0, r1, r1, 0, th1, OPEN) ;
          fTeXlabel(r1, 0.07, "bl", "$\\frac{\\pi}{4}$") ;
          fEllipticalArc(0, 0, r2, r2, 0, th2, OPEN) ;
          fTeXlabel(-0.05, r2, "br", "$\\frac{3\\pi}{4}$") ;

//          fTeXlabel(x+0.2,y, "bl", "$(x,y)$") ;
//          fTeXlabel(0.6*x,0.6*y+0.2, "br", "$r$") ;
//          fTeXlabel(1.5,0.3, "bl", "$\\theta$") ;

     }
}

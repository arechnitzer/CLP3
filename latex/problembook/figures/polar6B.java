                  /*  File:  polar6B.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar6B extends Template {

     static {templateClass = new polar6B() ; }

     public void setup() {
          filePrefix = "polar6B" ;  // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.4 ;      // in inches
          ysize = 2.0*0.4 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -1.0 ;
          ymax =  1.0 ;
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
          fTeXlabel(xmax,-0.07, "tr", "$x$") ;
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

          canvas.append( new fPsWrite(Black+"\n")) ;
          double r1 = 0.4 ;
          double r2 = 0.3 ;

          fEllipticalArc(0, 0, r2, r2, 0, 180, OPEN) ;
          fTeXlabel(-0.65*r2, 0.85*r2, "br", "$\\pi$") ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0,  xmin, 0) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fLine(0, 0,  xmax, 0) ;

          fEnv("psFillColor", Black) ;
          double rr = 0.08 ;
          fDisk(x3,y3, rr, rr, FILLED) ;
          fTeXlabel(x3-0.1,y3+0.1, "bc", "$(-2,0)$") ;

     }
}

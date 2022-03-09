                  /*  File:  polar6AA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar6AA extends Template {

     static {templateClass = new polar6AA() ; }

     public void setup() {
          filePrefix = "polar6AA" ;  // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.5*0.4 ;      // in inches
          ysize = 2.0*0.4 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 3.0 ;
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
          fTeXlabel(xmax+0.07,0, "cl", "$x$") ;
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
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          double r1 = 0.4 ;
          double r2 = 0.3 ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Orange+"\n")) ;
          fLine(0, 0,  xmin, 0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0,  xmax, 0) ;

          fEnv("psFillColor", Black) ;
          double rr = 0.08 ;
          fDisk(x3,y3, rr, rr, FILLED) ;
          fTeXlabel(x3-0.1,y3+0.1, "bc", "$(-2,0)$") ;
          fTeXlabel(x3,y3-0.15, "tc", "$r=-2,\\ \\theta=0$") ;
          fDisk(-x3,y3, rr, rr, FILLED) ;
          fTeXlabel(-x3,y3+0.1, "bc", "$(2,0)$") ;
          fTeXlabel(-x3,y3-0.15, "tc", "$r=2,\\ \\theta=0$") ;
     }
}

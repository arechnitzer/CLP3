                  /*  File:  pressureB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pressureB extends Template {

     static {templateClass = new pressureB() ; }

     public void setup() {
          filePrefix = "pressureB" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 15*0.15 ;      // in inches
          ysize = 14*0.15 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -5 ;
          xmax = 10 ;
          ymin = -7 ;
          ymax = 7 ;
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
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.2, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 1.5) ;
          double c = 0 ; double R = Math.sqrt(1+c*c) ;
          fDisk(c,0, 0.2,0.2, FILLED) ;
          fTeXlabel(0.2, 0.2, "bl", "$\\scriptstyle p=0$") ;

          c = 1 ; R = 2*c ;
          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          fTeXlabel(R+c+0.1, 1, "tl", "$\\scriptstyle p=1$") ;

          c = 2 ; R = 2*c ;
          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          fTeXlabel(R+c+0.1, 1.3, "tl", "$\\scriptstyle p=2$") ;

          c = 3 ; R = 2*c ;
          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          fTeXlabel(R+c+0.1, 1.6, "tl", "$\\scriptstyle p=3$") ;

     }
}

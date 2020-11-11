                  /*  File:  parEllipse.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class parEllipse extends Template {

     static {templateClass = new parEllipse() ; }

     public void setup() {
          filePrefix = "parEllipse" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double a = 80 ;
          double b = 60 ;
          double r = 3 ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -6, "tr", "$x$") ;
          fTeXlabel(-1.5, ymax, "tr", "$y$") ;
          fTeXlabel(-48, 45, "br", "$\\frac{x^2}{a^2}+\\frac{y^2}{b^2}=1$") ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[80*cos(t) , 60*sin(t)]", 1, 0, 2*Math.PI,  OPEN) ;

          fEnv("useColorPs", "true") ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("psFillColor", Blue) ;

          fDisk(a,0,r,r, FILLED) ;
          fDisk(-a,0,r,r, FILLED) ;
          fDisk(0,b,r,r, FILLED) ;
          fDisk(0,-b,r,r, FILLED) ;

          fTeXlabel(a+3, 3, "bl", "$t=0$") ;
          fTeXlabel(-a-2, -2, "tr", "$t=\\pi$") ;
          fTeXlabel(2, b+2, "bl", "$t=\\pi/2$") ;
          fTeXlabel(2, -b-2, "tl", "$t=3\\pi/2$") ;



     }
}

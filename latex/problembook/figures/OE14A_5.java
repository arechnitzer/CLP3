                  /*  File:  OE14A_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14A_5 extends Template {

     static {templateClass = new OE14A_5() ; }

     public void setup() {
          filePrefix = "OE14A_5" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
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
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0,4,4,-60,60, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.1, "bc", "$y$") ;

          fEllipticalArc(0,0,4,4, 0,360, OPEN) ;
          fTeXlabel(-3, 3.5, "tr", "$x^2+y^2=16$") ;
          double X=2 ;
          double Y=Math.sqrt(16-X*X) ;
          double r = 0.5 ;
          fLine(0, 0, X, Y) ;
          fEllipticalArc(0,0,r,r, 0,60, OPEN) ;
          fTeXlabel(1.2*r, 0.2, "bl", "$\\scriptstyle \\pi/3$") ;
          fTeXlabel(1, -0.2, "tc", "$\\scriptstyle 2$") ;
          fTeXlabel(0.7, 1.8, "bc", "$\\scriptstyle 4$") ;
          fTeXlabel(2.8, 1.5, "cc", "$D$") ;
          fLine(X, ymin, X, ymax) ;
          fTeXlabel(X+0.1, ymax, "tl", "$x=2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0,4,4,-60,60, OPEN) ;
          fLine(X, -Y, X, Y) ;
          
     }
}

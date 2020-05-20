                  /*  File: localMaxA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class localMaxA extends Template {

     static {templateClass = new localMaxA() ; }

     public void setup() {
          filePrefix = "localMaxA" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.75;   
          ysize = 2.0*0.75 ;   
          xmin = -2.5 ;
          xmax = 3.5 ;
          ymax = 7 ;
          ymin = -7 ;
          topmargin = 0.1 ;
          bottommargin = 0.1 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fTeXlabel(xmax, -0.3, "tr", "$x$", "x") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$", "y") ;
          
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("y=-x*x*x+6*x", 0, -1, 2.8, OPEN) ;
          double x = 2.75 ; double y = -x*x*x+6*x ;
          fTeXlabel(x+0.2, y, "tl", "$y=f(x)$") ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          x = Math.sqrt(2) ; y = -x*x*x+6*x ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(x-1,y, x+1,y) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ;
          double r = 0.07 ;
          fDisk(x,y, r,r*aspect, FILLED) ;



     }
}

                  /*  File:  parCurve.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class parCurve extends Template {

     static {templateClass = new parCurve() ; }

     public void setup() {
          filePrefix = "parCurve" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;   
          ysize = 1.3 ;   
          xmin = 0  ;
          xmax = 6 ;
          ymin = 0 ;
          ymax = 1.3 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {

          fEnv("lineWidth", 1.0) ;
          fCurve("y = 2/(2+x)", 0, -0.2, xmax, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.13 ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          double x = 1 ; double y = 2/(2+x) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(0)$") ;
          x = 3 ;  y = 2/(2+x) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(1)$") ;
          x = 5 ;  y = 2/(2+x) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fTeXlabel(x+0.05, y+0.03, "bl", "$\\vr(2)$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;


     }
}

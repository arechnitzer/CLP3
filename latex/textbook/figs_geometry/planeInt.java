                  /*  File:  planeInt.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class planeInt extends Template {

     static {templateClass = new planeInt() ; }

     public void setup() {
          filePrefix = "planeInt" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*1.3 ;   
          ysize = 1.6*1.3 ;   
          xmin = -40.0*1.1 ;
          xmax = 60.0*1.1 ;
          ymin = -40.0*1.1 ;
          ymax = 40.0*1.1 ;
          topmargin = .2 ;
          bottommargin = -.2 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(0.0, 0.0, 0.0, 44.0) ;
          fLine(0.0, 0.0, 44.0, 0.0) ;
          fLine(0.0, 0.0, -22.0, -22.0) ;
          fLine(-20.0, -20.0, 40.0, 0.0) ;
          fLine(0.0, 40.0, 40.0, 0.0) ;
          fLine(0.0, 40.0, -20.0, -20.0) ;
          double t = 0.7 ; 
          double x = 0.82*((1-t)*(-35)+t*40) ; double y = 0.82*(1-t)*(-35) ;
          fLine(0,  0, x, y) ;
          fArrow( -15, 18 , 5, 10) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0, 40, x, y) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          fArrow(x,y, 0.5*x, 0.5*y+20) ;

          fTeXlabel(40.0, 1.5, "bl", "$(0,2,0)$") ;
          fTeXlabel(-1.0, 40.0, "br", "$(0,0,2)$") ;
          fTeXlabel(-21.5, -21, "br", "$(2,0,0)$") ;
          fTeXlabel(x, y-1, "tl", "$(1,1,0)$") ;
          fTeXlabel(20, 21, "bl", "$x+y+z=2$") ;
          fTeXlabel(-16, 20, "cr", "$x-y=0$") ;
          fTeXlabel(0.5*x+5, 0.5*y+20, "tl", "$\\vd$") ;
     }
}

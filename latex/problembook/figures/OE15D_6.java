                  /*  File:  OE15D_6.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE15D_6 extends Template {

     static {templateClass = new OE15D_6() ; }

     public void setup() {
          filePrefix = "OE15D_6" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*0.75 ;   
          ysize = 1.7*0.75 ;   
          xmin = -1.2  ;
          xmax = 1.5 ;
          ymin = -0.2 ;
          ymax = 1.5 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fCurve("[t,1-t*t]", 1, -1, 1, FILLED) ;
          fCurve("[t,1-t*t]", 1, xmin, xmax, OPEN) ;
    

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[t,1-t*t]", 1, -1, 1, OPEN) ;
          fLine(-1, 0, 1, 0) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double r = 0.05 ;
          fDisk(-1,0,r,r*aspect,FILLED) ;
          fDisk(1,0,r,r*aspect,FILLED) ;
          fDisk(0,1,r,r*aspect,FILLED) ;
          fTeXlabel(-1.05,0.05, "br", "$(-1,0)$") ;
          fTeXlabel(-0.05,1.05, "br", "$(0,1)$") ;
          fTeXlabel( 1.05,0.05, "bl", "$(1,0)$") ;

          double xl = 0.3 ;  double xr = 0.45 ; 
          double yt = 1-xl*xl ;  double yb = 0 ;
          double ytt = 0.7 ;  double ybb = 0.55 ;




          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(-0.7, 0.5,"rb", "$y=1-x^2$") ;
          fTeXlabel(-0.3, 0.5,"cc", "$D$") ;

     }
}

                  /*  File:  hiddenB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hiddenB extends Template {

     static {templateClass = new hiddenB() ; }

     public void setup() {
          filePrefix = "hiddenB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 20*0.15 ;   
          ysize = 14*0.15 ;   
          xmin = -10  ;
          xmax = 10 ;
          ymin = -7 ;
          ymax = 7 ;
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
          double r = 0.2 ;
          double OX = 5 ; double OY = 3 ;
          double IX = 2 ; double IY = 1 ;
          double SX = 1.0 ; double SY = 0.5 ;
          double x1 = 2.5 ; double y1 = 1.8;
          double x2 = -1 ; double y2 = -2;
 

          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.6) ;
          fDisk(0,0, OX,OY, CLOSED+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(SX,SY, IX,IY, CLOSED+FILLED) ;

          fEnv("psFillGray", 0.0) ;
          fDisk(x1,y1, r,r, CLOSED+FILLED) ;
          fDisk(x2,y2, r,r, CLOSED+FILLED) ;
          fLine(x1,y1, x2,y2) ;
          fTeXlabel(0, -3.5, "tc", "not convex") ;

     }
}

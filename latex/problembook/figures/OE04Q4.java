                  /*  File:  OE04Q4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE04Q4 extends Template {

     static {templateClass = new OE04Q4() ; }

     public void setup() {
          filePrefix = "OE04Q4" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;  
          ysize = 1.5 ;   
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
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
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.04, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          fEnv("psFillGray", 0.7) ;
          double[] x = {0, 1, 1} ;
          double[] y = {1, 1, 0} ;
          fPolygon(x, y, 3, FILLED) ;

          fEnv("lineWidth", 1.0) ;
          fPolygon(x, y, 3, CLOSED) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(0,1, r, r, FILLED) ;
          fDisk(1,1, r, r, FILLED) ;
          fDisk(1,0, r, r, FILLED) ;
          fTeXlabel(1.05,1.0, "bl", "$(1,1)$") ;
          fTeXlabel(-0.05,1.0, "tr", "$(0,1)$") ;
          fTeXlabel(1.05,.05, "bl", "$(1,0)$") ;

          
     }
}

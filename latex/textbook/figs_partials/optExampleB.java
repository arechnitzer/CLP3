                  /*  File:  optExampleB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class optExampleB extends Template {

     static {templateClass = new optExampleB() ; }

     public void setup() {
          filePrefix = "optExampleB" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4 ;      // in inches
          ysize = 1.2 ;   // in inches. 
          xmin = -1.7 ;
          xmax = 2.7 ;
          ymin = -1.1 ;
          ymax = 1.1 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.4) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "lb", "$x$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fEnv("lineWidth", 0.8) ;
          fDisk(0, 0, 1, 1, CLOSED) ;
          fEnv("psFillGray", 0.6) ;
          double r = 0.06 ;
          fDisk(0, 0, r, r, FILLED) ;
          fTeXlabel(r, r, "bl", "$(0,0)$") ;
          fDisk(2, 0, r, r, FILLED) ;
          fTeXlabel(2+r, r, "bl", "$(2,0)$") ;
          fDisk(1, 0, r, r, FILLED) ;
          fTeXlabel(1+r, r, "bl", "$(1,0)$") ;
          fDisk(-1, 0, r, r, FILLED) ;
          fTeXlabel(-1-r, r, "br", "$(-1,0)$") ;
          double x = -0.5 ;
          double y = Math.sqrt(1-x*x) ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x-r, y+r, "br", "$(-\\half,\\tfrac{\\sqrt{3}}{2})$") ;
          fDisk(x, -y, r, r, FILLED) ;
          fTeXlabel(x-r, -y-r, "tr", "$(-\\half,-\\tfrac{\\sqrt{3}}{2})$") ;


     }
}

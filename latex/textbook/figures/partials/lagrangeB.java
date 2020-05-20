                  /*  File:  lagrangeB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class lagrangeB extends Template {

     static {templateClass = new lagrangeB() ; }

     public void setup() {
          filePrefix = "lagrangeB" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2*1.5 ;      // in inches
          ysize = 1*1.5 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2 ;
          ymin = -1 ;
          ymax = 1 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "lb", "$x$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fEnv("lineWidth", 0.8) ;
          fDisk(0, 0, 1, 1/Math.sqrt(2), CLOSED) ;
          fEnv("psFillGray", 0.6) ;
          double r = 0.05 ;
          double x = 0.75 ; double y = Math.sqrt( (1-x*x)/2 ) ;
          {double[] xlist = {-x, x, x, -x} ;
           double[] ylist = {-y, -y, y, y} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;}
          fDisk(x, y, r, r, FILLED) ;
          fDisk(x, -y, r, r, FILLED) ;
          fDisk(-x, -y, r, r, FILLED) ;
          fDisk(-x, y, r, r, FILLED) ;
          fTeXlabel(x+0.02, y+0.05, "bl", "$(x,y)$") ;
          fTeXlabel(x+0.02, -y-0.05, "tl", "$(x,-y)$") ;
          fTeXlabel(-x-0.02, -y-0.05, "tr", "$(-x,-y)$") ;
          fTeXlabel(-0.2, 1/Math.sqrt(2), "br", "$x^2+2y^2=1$") ;

     }
}

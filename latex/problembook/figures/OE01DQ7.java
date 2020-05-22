                  /*  File:  OE01DQ7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ7 extends Template {

     static {templateClass = new OE01DQ7() ; }

     public void setup() {
          filePrefix = "OE01DQ7" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 *2;      // in inches
          ysize = 1.2/2.2*2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.1 ;
          xmax = 2.1 ;
          ymin = -0.1 ;
          ymax = 1.1 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(1,0, 1, 1, 0, 180, FILLED) ;
          fEnv("psFillGray", 0.4) ;
          double th1 = 30 ;
          double th2 = 40 ;
          double th1rad = th1*Math.PI/180.0;
          double th2rad = th2*Math.PI/180.0;
          double x1 = 1+Math.cos(th1rad) ;
          double y1 = Math.sin(th1rad) ;
          double x2 = 1+Math.cos(th2rad) ;
          double y2 = Math.sin(th2rad) ;
          double[] xlist = {0, x1, x2} ;
          double[] ylist = {0, y1, y2} ;
          fPolygon(xlist, ylist, 3, FILLED) ;
          fEllipticalArc(1,0, 1, 1, th1, th2, FILLED) ;
          fEnv("psFillGray", 0) ;
          double r = 0.04 ;
          fDisk(1, 0, r, r, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;

          fTeXlabel(xmax+0.07, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.07, "bc", "$y$") ;          
          fTeXlabel(1, -0.1, "tc", "$(a/2,0)$") ;          
          fTeXlabel(x2, y2+0.05, "bl", "$r=a\\cos\\theta$") ;          
     }
}

                  /*  File:  OE01DQ8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ8 extends Template {

     static {templateClass = new OE01DQ8() ; }

     public void setup() {
          filePrefix = "OE01DQ8" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.1 ;
          xmax = 1.1 ;
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
          double z = 0.8 ;

          fEnv("psFillGray", 0.8) ;
          double[] xlist = {1, 1, 1-z} ;
          double[] ylist = {1, 1-z, 1} ;
          fPolygon(xlist, ylist, 3, FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(1-z, 1, 0.025, 0.025, FILLED) ;
          fTeXlabel(0.98-z,1.04, "bl", "$(1-z,1)$") ;

          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          double x = 0.85 ;
          fLine(x, 2-z-x, x, 1) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;

          fEnv("lineWidth", 1.0) ;
          fPolygon(xlist, ylist, 3, CLOSED) ;


          fEnv("lineWidth", 0.4) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fLine(1, ymin, 1, ymax) ;
          fTeXlabel(1, ymax+0.03, "bl", "$x=1$") ;
          fLine(xmin, 1, xmax, 1) ;
          fTeXlabel(xmin-0.03, 1, "rc", "$y=1$") ;
          fLine(2-z-ymin, ymin, 2-z-ymax, ymax) ;
          fTeXlabel(xmax+0.03, 2-z-xmax, "cl", "$x+y=2-z$") ;
          fTeXlabel(0.7, 0.8, "cc", "$T_z$") ;



          fTeXlabel(xmax+0.03, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.03, "bc", "$y$") ;          
     }
}

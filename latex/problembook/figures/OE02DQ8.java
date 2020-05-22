                  /*  File:  OE02DQ8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE02DQ8 extends Template {

     static {templateClass = new OE02DQ8() ; }

     public void setup() {
          filePrefix = "OE02DQ8" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.5 ;
          xmax = 2.5 ;
          ymin = -0.5 ;
          ymax = 2.5 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double s2 = Math.sqrt(2) ;
          fEnv("psFillGray", 0.8) ;
          fEnv("lineWidth", 1.0) ;
          double[] xlist = {0, 2, 1, 0} ;
          double[] ylist = {0, 0, 1, 1} ;
          fPolygon(xlist, ylist, 4, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fLine(xmin, 1, xmax, 1) ;
          fLine(xmin, 2-xmin, 2-ymin, ymin) ;

          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          double y = 0.3 ;
          fLine(2-y, y, 0, y) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 1.0) ;
          fPolygon(xlist, ylist, 4, CLOSED) ;


          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;          
          fTeXlabel(2-ymin+0.1, ymin, "lc", "$x+y=2$") ;          
          fTeXlabel(xmax+0.1, 1, "lc", "$y=1$") ;          
     }
}

                  /*  File:  xzplane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xzplane extends Template {

     static {templateClass = new xzplane() ; }

     public void setup() {
          filePrefix = "xzplane" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.75 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -50 ;
          xmax = 100 ;
          ymin = -75 ;
          ymax = 100 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double b=60 ;
          double by1=-50+b ;
          double by2=b ;

          fEnv("psFillGray", 0.8) ;
          {
           double[] xlist = {b, -50+b, -50+b,   b} ;
           double[] ylist = {0,   -70, 30, 100} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,  0, 100) ;
          fLine(0,0,  by1, 0) ;
          fLine(by2,0,  100, 0) ;
          fLine(0,0,  -50, -70) ;

          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(by1,0,  by2,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("lineWidth", 1.4) ;
          fLine(b,0,     b, 100) ;
          fLine(b,0, -50+b, -70) ;
          fTeXlabel(b+5, 50, "cl", "$y=b$") ;


          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}

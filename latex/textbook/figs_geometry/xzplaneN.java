                  /*  File:  xzplaneN.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xzplaneN extends Template {

     static {templateClass = new xzplaneN() ; }

     public void setup() {
          filePrefix = "xzplaneN" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 2.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -50 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax =  130 ;
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
          double n = 20 ;
          double r = 70/50.0 ;


          fEnv("psFillGray", 0.8) ;
          {
           double[] xlist = {b+n, -50+b, -50+b,   b+n} ;
           double[] ylist = {0+n*r-1.6*n, -70-1.6*n, 30, 100+n*r} ;
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
          fTeXlabel(b+5+n, 50, "cl", "$y=b$") ;


          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}

                  /*  File:  xyplaneN.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xyplaneN extends Template {

     static {templateClass = new xyplaneN() ; }

     public void setup() {
          filePrefix = "xyplaneN" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.85 ;      // in inches
          ysize = 2.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -70 ;
          xmax = 115 ;
          ymin = -100 ;
          ymax = 130 ;
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
          double c=60 ;
          double cy = 50 + 50*(70-c)/70.0 ;
          double cxx = 5*(-70+c)/7.0 ;
          double cxy = -70+c;
          double n = 20 ;
          double r = 50/70.0 ;

          fEnv("psFillGray", 0.8) ;
          {
           double[] xlist = {0-n+n*r, -50-n  , 50  , 100+n*r} ;
           double[] ylist = {c+n, -70+c, -70+c,   c+n} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }

          fEnv("lineWidth", 0.5) ;
          fLine(0,c,  0, 100) ;
          fLine(cy,0,  100, 0) ;
          fLine(cxx,cxy,  -50, -70) ;

          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(0,0,   0,c) ;
          fLine(0,0,  cy,0) ;
          fLine(0,0,  cxx,cxy) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("lineWidth", 1.4) ;
          fLine(0,c,  -50, -70+c) ;
          fLine(0,c,  100, c) ;
          fTeXlabel(50, c+5+n, "bc", "$z=c$") ;




          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}

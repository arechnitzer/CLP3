                  /*  File:  xyplane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xyplane extends Template {

     static {templateClass = new xyplane() ; }

     public void setup() {
          filePrefix = "xyplane" ;    // used as the prefix for any ps or lbl files written
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
          double c=60 ;
          double cy = 50 + 50*(70-c)/70.0 ;
          double cxx = 5*(-70+c)/7.0 ;
          double cxy = -70+c;

          fEnv("psFillGray", 0.8) ;
          {
           double[] xlist = {0, -50  , 50  , 100} ;
           double[] ylist = {c, -70+c, -70+c,   c} ;
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
          fTeXlabel(50, c+5, "bc", "$z=c$") ;




          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}

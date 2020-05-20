                  /*  File:  yzplaneN.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class yzplaneN extends Template {

     static {templateClass = new yzplaneN() ; }

     public void setup() {
          filePrefix = "yzplaneN" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 2.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -50 ;
          xmax = 100 ;
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
          double ax=0.6*(-50) ; double ay=0.6*(-70) ;

          double cz=100+ay ;
          double cy = 100+ax ;
          double cxx = 5*ay/7.0 ;
          double cxy = ay;
          double n = 20 ;



          fEnv("psFillGray", 0.8) ;
          {
           double[] xlist = {ax-n, 100+ax, 100+ax,  ax-n} ;
           double[] ylist = {ay-n,     ay-n, 100+ay, 100+ay} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }

          fEnv("lineWidth", 0.5) ;
          fLine(0,cz,  0, 100) ;
          fLine(cy,0,  100, 0) ;
          fLine(cxx,cxy,  -50, -70) ;

          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(0,0,   0,cz) ;
          fLine(0,0,  cy,0) ;
          fLine(0,0,  cxx,cxy) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("lineWidth", 1.4) ;
          fLine(ax,ay,  ax, 100+ay) ;
          fLine(ax,ay,  100+ax, ay) ;
          fTeXlabel(ax+50, ay-5-n, "ct", "$x=a$") ;


          fTeXlabel(-53, -75, "rt", "$x$") ;
          fTeXlabel(105, 0, "lc", "$y$") ;
          fTeXlabel(0, 105, "bc", "$z$") ;

     }
}

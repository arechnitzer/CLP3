                  /*  File:  dblIntAa.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class dblIntAa extends Template {

     static {templateClass = new dblIntAa() ; }

     public void setup() {
          filePrefix = "dblIntAa" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*1.0 ;   
          ysize = 1.6*1.0 ;   
          xmin = -0.8  ;
          xmax = 2.2 ;
          ymin = -0.4 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fCurve("[2*t*t,t]", 1, 0, 1, FILLED) ;
          fCurve("[t,t*t/4]", 1, 0, 2, FILLED) ;
          { 
            double[] xlist = { 0, 1,    2, 0.5} ;
            double[] ylist = { 0, 0.25, 1, 0.5} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }         
          fCurve("[2*t*t,t]", 1, ymin, ymax, OPEN) ;
          fCurve("[t,t*t/4]", 1, xmin, xmax, OPEN) ;
    

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[2*t*t,t]", 1, 0, 1, OPEN) ;
          fCurve("[t,t*t/4]", 1, 0, 2, OPEN) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double r = 0.04 ;
          fDisk(2,1,r,r,FILLED) ;
          fDisk(0,0,r,r,FILLED) ;


          fTeXlabel(xmax+0.03, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.03, "cb", "$y$") ;
          fTeXlabel(xmax, xmax*xmax/4.0,"cb",
                                  "$y=\\frac{x^2}{4\\nu}$") ;
          fTeXlabel(2*ymin*ymin+0.03, ymin, "cl", "$x=\\frac{2y^2}{\\nu}$") ;
          fTeXlabel(2, 0.95, "tl", "$(2\\nu,\\nu)$") ;
          fTeXlabel(1, 0.5, "cc", "$\\cR$") ;
     }
}

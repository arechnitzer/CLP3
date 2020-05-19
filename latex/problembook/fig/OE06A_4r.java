                  /*  File:  OE06A_4r.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_4r extends Template {

     static {templateClass = new OE06A_4r() ; }

     public void setup() {
          filePrefix = "OE06A_4r" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.6 ;      // in inches
          ysize = 2.6*0.6 ;   // in inches. 
          xmin = -1.3 ;
          xmax = 1.3 ;
          ymin = -1.3 ;
          ymax =  1.3 ;
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
          fEnv("psFillGray", 0.8) ;
          double x = 0.7 ; double y = Math.sqrt(1-x*x) ;
          { 
            double[] xlist = { x, -0.4, -0.4,  x} ;
            double[] ylist = { y,    y,   -y, -y} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;

          fEnv("lineWidth", 1.0) ;
          fDisk(0,0, 1,1, CLOSED) ;
          
     }
}

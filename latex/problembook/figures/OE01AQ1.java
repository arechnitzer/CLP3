                  /*  File:  OE01AQ1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01AQ1 extends Template {

     static {templateClass = new OE01AQ1() ; }

     public void setup() {
          filePrefix = "OE01AQ1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -60 ;
          xmax = 60 ;
          ymin = -40 ;
          ymax =  80 ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0, 40, 40, 15, FILLED+CLOSED) ;

          {
             double[] xlist = { -40, 0, 40} ;
             double[] ylist = { 40,  0, 40} ;
             fBezier bez = new fBezier(xlist, ylist, 3, OPEN) ;
             bez.configure("vertex0outAngle", -70) ;
//             bez.configure("vertex0scale", 3) ;
             bez.configure("vertex2inAngle", 70) ;
//             bez.configure("vertex2scale", 3) ;
             canvas.append(bez) ;
          }
          fEnv("lineWidth", 0.5) ;
          fLine(0, 40, 0, 70) ;
          fTeXlabel(0, 73, "bc", "$z$") ;
          fLine(0, 0, 60, 0) ;
          fTeXlabel(62, 0, "lc", "$y$") ;
          fLine(0, 0, -15, -30) ;
          fTeXlabel(-15, -33, "tc", "$x$") ;
          
     }
}

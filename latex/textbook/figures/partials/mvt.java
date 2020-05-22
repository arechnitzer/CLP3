                  /*  File:  mvt.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class mvt extends Template {

     static {templateClass = new mvt() ; }

     public void setup() {
          filePrefix = "mvt" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5*12.0/15.0 ;   // in inches. 
          xmin = -1 ;
          xmax = 14 ;
          ymin = -1 ;
          ymax = 11 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fEnv("lineWidth", 1.0) ;
          fCurve("(20*x-x*x)/10", 0, xmin, xmax, OPEN) ;
          fTeXlabel(xmax+0.5, 2*xmax-xmax*xmax/10.0, "lc", "$y=\\varphi(x)$") ;
          double x1 = 2 ;
          double y1 = (20*x1-x1*x1)/10.0 ;
          double x2 = 12 ;
          double y2 = (20*x2-x2*x2)/10.0 ;
          double slope = (y2-y1)/(x2-x1) ;
          double x3 = 5*(2-slope) ;
          double y3 = (20*x3-x3*x3)/10.0 ;
          fEnv("lineWidth", 0.5) ;
          fLine(x1,y1, x2,y2) ;
          fLine(x3-5, y3-slope*5, x3+5, y3+slope*5) ;
          fLine(x1,0, x1,-0.5) ;
          fTeXlabel(x1, -0.6, "tc", "${\\scriptstyle x_0}$") ;
          fLine(x2,0, x2,-0.5) ;
          fTeXlabel(x2, -0.6, "tc", "${\\scriptstyle x_0+k}$") ;
          fLine(x3,0, x3,-0.5) ;
          fTeXlabel(x3, -0.6, "tc", "${\\scriptstyle x_0+\\theta_1\\hskip-0.5pt k}$") ;

          
     }
}

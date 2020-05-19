                  /*  File:  fubini.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class fubini extends Template {

     static {templateClass = new fubini() ; }

     public void setup() {
          filePrefix = "fubini" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*4*12/15 ;      // in inches
          ysize = 1.4*4*12/15 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.1 ;
          ymin = -0.1 ;
          ymax = 1.1 ;
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
          fEnv("psFillGray", 0.6) ;
          for (int i=1; i<=14 ; i++) {
             { double[] xlist = {1.0/i, 1.0/i, 1.0/(i+1), 1.0/(i+1)} ;
               double[] ylist = {1.0/i, 1.0/(i+1), 1.0/(i+1), 1.0/i} ;
               fPolygon(xlist, ylist, 4, FILLED) ; }
          }
          fEnv("psFillGray", 0.8) ;
          for (int i=1; i<=13 ; i++) {
             { double[] xlist = {1.0/(i+1), 1.0/(i+1), 1.0/(i+2), 1.0/(i+2)} ;
               double[] ylist = {1.0/i, 1.0/(i+1), 1.0/(i+1), 1.0/i} ;
               fPolygon(xlist, ylist, 4, FILLED) ; }
          }

          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth", 0.8) ;
        { double[] xlist = {0, 0, 1, 1, 0} ;
          double[] ylist = {0, 1, 1, 0, 0} ;
          fPolygon(xlist, ylist, 5, CLOSED) ; }

          fEnv("lineWidth", 0.2) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax ) ;
          
          for (int i=1; i<=15 ; i++) {
               fLine(0, 1.0/i, 1, 1.0/i) ;
               fLine(1.0/i, 0, 1.0/i, 1) ;
          }
          for (int i=1; i<=5 ; i++) {
               fLine(0, 1.0/i, -0.02, 1.0/i) ;
               fLine(1.0/i, 0, 1.0/i, -0.02) ;
               fTeXlabel(1.0/i, -0.06, "tc", "$\\de_"+i+"$") ;
               fTeXlabel(-0.05, 1.0/i, "rc", "$\\de_"+i+"$") ;
          }

          for (int i=1; i<=4 ; i++) {
                fTeXlabel(-0.01, (1.0/i+1.0/(i+1))/2, "rc", "$I_"+i+"$") ;
                fTeXlabel((1.0/i+1.0/(i+1))/2, -0.01, "tc", "$I_"+i+"$") ;
          }

          for (int i=1; i<=5 ; i++) {
                fTeXlabel((1.0/i+1.0/(i+1))/2, (1.0/i+1.0/(i+1))/2, "cc", "$+$") ;
                fTeXlabel((1.0/(i+1)+1.0/(i+2))/2, (1.0/i+1.0/(i+1))/2, "cc", "$-$");
          }
          fTeXlabel(xmax, -0.01, "tr", "$x$") ;
          fTeXlabel(-0.01, ymax, "tr", "$y$") ;


          
          
     }
}

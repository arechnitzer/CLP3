                  /*  File:  polarTh.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarTh extends Template {

     static {templateClass = new polarTh() ; }

     public void setup() {
          filePrefix = "polarTh" ;   // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 1 ;
          ymin = -0.5 ;
          ymax = 1 ;
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
          double th_start = 0 ;
          double th_end = 2*Math.PI ;

          fEnv("lineWidth", 1.0) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ;
          fTeXlabel(0.25, ymin-0.05 , "tc", "lines of constant $\\phi$") ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fEnv("useColorPs", "true") ;
//          fEnv("psFillColor", Red) ;


          fEnv("lineWidth", 0.5) ;
          double n = 20 ;
          double dth = (th_end-th_start)/n  ;
          double th = th_start ;
          for (int i=1; i<n ; i++) {
               th += dth ;
               fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          }
          
     }
}

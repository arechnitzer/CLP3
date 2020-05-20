                  /*  File:  polarRTh.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarRTh extends Template {

     static {templateClass = new polarRTh() ; }

     public void setup() {
          filePrefix = "polarRTh" ;  // used as the prefix for any ps or lbl files written
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
          double r_start = 0 ;
          double r_end = 0.85 ;

          fEnv("lineWidth", 1.0) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ;
//          fTeXlabel(0.25, ymin-0.05 , "tc", "curves of constant $r$") ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
//          fEnv("useColorPs", "true") ;
//          fEnv("psFillColor", Red) ;



          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double n = 6 ;
          double dr = (r_end-r_start)/n  ;
          double r = dr ;
          for (int i=1; i<=n ; i++) {
               fDisk(0, 0, r, r, CLOSED) ;
               r += dr ;
          }

          canvas.append( new fPsWrite(Red+"\n")) ;
          n = 20 ;
          double th_start = 0 ;
          double th_end = 2*Math.PI ;
          double dth = (th_end-th_start)/n  ;
          double th = th_start ;
          for (int i=1; i<n ; i++) {
               th += dth ;
               fLine(0, 0, Math.cos(th), Math.sin(th)) ;
          }

          
     }
}

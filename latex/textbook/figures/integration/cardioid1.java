                  /*  File:  cardioid1.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cardioid1 extends Template {

     static {templateClass = new cardioid1() ; }

     public void setup() {
          filePrefix = "cardioid1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 2.5 ;
          ymin = -1.5 ;
          ymax = 1.5 ;
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

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax,-0.1, "tr", "$x$") ;
          fTeXlabel(-0.06, ymax, "tr", "$y$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          double th_start = 0 ;
          double th_end = 2*Math.PI ;


          fEnv("lineWidth", 0.5) ;
          double n = 16 ;
          double dth = 2*Math.PI/n  ;
          double th = 0 ;
          double x, y ;
          for (int i=0; i<1 ; i++) {
               x = (1+Math.cos(th))*Math.cos(th)  ;
               y = (1+Math.cos(th))*Math.sin(th)  ;
               fEnv("lineWidth", 1.5) ;
//               fEnv("useColorPs", "false") ;
               canvas.append( new fPsWrite("0.8 setgray\n")) ;
               fLine(0, 0, 10*x, 10*y) ;
               fEnv("lineWidth", 0.5) ;
//               fEnv("useColorPs", "true") ;
               fDisk(x, y, 0.05, 0.05, FILLED) ;
               th += dth ;
          }
          fTeXlabel(0.1, -1.2, "cl", "$\\theta=0$") ;                     
     }
}

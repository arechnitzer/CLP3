                  /*  File:  cardioidF.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cardioidF extends Template {

     static {templateClass = new cardioidF() ; }

     public void setup() {
          filePrefix = "cardioidF" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
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
          fTeXlabel(xmax,-0.07, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          double th_start = 0 ;
          double th_end = 2*Math.PI ;
          fEnv("lineWidth", 1.5) ;
          fCurve("[(1+cos(t))*cos(t), (1+cos(t))*sin(t)]", 1, th_start, th_end, CLOSED) ;


          fEnv("lineWidth", 0.5) ;
          double n = 12 ;
          double dth = 2*Math.PI/n  ;
          double th = 0 ;
          double x, y ;
          for (int i=0; i<n ; i++) {
               th += dth ;
               x = (1+Math.cos(th))*Math.cos(th)  ;
               y = (1+Math.cos(th))*Math.sin(th)  ;
//               fLine(0, 0, x, y) ;
               fDisk(x, y, 0.05, 0.05, FILLED) ;
          }

           
//      fTeXlabel(1.0, ymin-0.1, "tc", "$r=1+\\cos(\\theta),\\ 0\\le\\theta\\le2\\pi$") ;
          fTeXlabel(1.0, ymin-0.1, "tc", "$r=1+\\cos(\\theta)$") ;
          
     }
}

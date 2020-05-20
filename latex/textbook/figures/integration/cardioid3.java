                  /*  File:  cardioid3.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cardioid3 extends Template {

     static {templateClass = new cardioid3() ; }

     public void setup() {
          filePrefix = "cardioid3" ;    // used as the prefix for any ps or lbl files written
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
          double n = 12 ;
          double dth = 2*Math.PI/n  ;
          double th = 0 ;
          double x, y ;
          for (int i=0; i<2 ; i++) {
               x = (1+Math.cos(th))*Math.cos(th)  ;
               y = (1+Math.cos(th))*Math.sin(th)  ;
//               fEnv("lineWidth", 1.5) ;
//               canvas.append( new fPsWrite("0.8 setgray\n")) ;
//               fLine(0, 0, 2.5*Math.cos(th), 2.5*Math.sin(th)) ;
//               fEnv("lineWidth", 0.5) ;
               fDisk(x, y, 0.05, 0.05, FILLED) ;
               th += dth ;
          }
          for (int i=2; i<7 ; i++) {
               x = (1+Math.cos(th))*Math.cos(th)  ;
               y = (1+Math.cos(th))*Math.sin(th)  ;
               fEnv("lineWidth", 1.5) ;
               canvas.append( new fPsWrite("0.8 setgray\n")) ;
               fLine(0, 0, 2.5*Math.cos(th), 2.5*Math.sin(th)) ;
               fEnv("lineWidth", 0.5) ;
               fDisk(x, y, 0.05, 0.05, FILLED) ;
               th += dth ;
          }

          fTeXlabel(0.1, -1.2, "cl", 
            "$\\theta=0,\\,\\nicefrac{\\pi}{6},\\,\\nicefrac{\\pi}{3},\\,\\cdots$") ;
                    
     }
}

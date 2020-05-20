                  /*  File:  cardioidI.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cardioidI extends Template {

     static {templateClass = new cardioidI() ; }

     public void setup() {
          filePrefix = "cardioidI" ;    // used as the prefix for any ps or lbl files written
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
          double th_start = 0 ;
          double th_end = 2*Math.PI ;



          fEnv("psFillGray", 0.9) ;
          fCurve("[(1+cos(t))*cos(t), (1+cos(t))*sin(t)]", 1, th_start, th_end, FILLED) ;
          fTeXlabel(0.7,0.5, "cl", "$\\cR$") ;

          fEnv("lineWidth", 0.5) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;


          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fCurve("[(1+cos(t))*cos(t), (1+cos(t))*sin(t)]", 1, th_start, th_end, CLOSED) ;


          fEnv("lineWidth", 0.5) ;
          double n = 12 ;
          double dth = 2*Math.PI/n  ;
          double th = 0 ;
          double x, y ;
//          for (int i=0; i<n ; i++) {
//               th += dth ;
//               x = (1+Math.cos(th))*Math.cos(th)  ;
//               y = (1+Math.cos(th))*Math.sin(th)  ;
////               fLine(0, 0, x, y) ;
//               fDisk(x, y, 0.05, 0.05, FILLED) ;
//          }
           x = 1.0 ; y=-0.8 ;
           fLine(x,y, x,0) ;
           fDisk(x,y, 0.06, 0.06, FILLED) ;
           fTeXlabel(x+0.07,0.5*y, "cl", "$|y|$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(xmin, 0, xmax, 0) ;
          fTeXlabel(xmax,-0.07, "tr", "$x$") ;


           
//      fTeXlabel(1.0, ymin-0.1, "tc", "$r=1+\\cos(\\theta),\\ 0\\le\\theta\\le2\\pi$") ;
          fTeXlabel(1.0, ymin-0.1, "tc", "$r=a(1+\\cos\\theta)$") ;
          
     }
}

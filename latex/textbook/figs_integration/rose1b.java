                  /*  File:  rose1b.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class rose1b extends Template {

     static {templateClass = new rose1b() ; }

     public void setup() {
          filePrefix = "rose1b" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1 ;
          ymin = -0.1 ;
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
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;

          double th_start = 0 ;
          double th_end = Math.PI/3 ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax,-0.04, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;
           
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite("0.8 setgray\n")) ;
          double n = 4 ;
          double dth = (th_end-th_start)/n  ;
          double th = th_start ;
          double x, y ;
          for (int i=0; i<=n ; i++) {
               x = Math.sin(3*th)*Math.cos(th)  ;
               y = Math.sin(3*th)*Math.sin(th)  ;
//               fLine(0, 0, 1.1*Math.cos(th), 1.1*Math.sin(th)) ;
//               canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
//               fLine(-1.1*Math.cos(th), -1.1*Math.sin(th), 0, 0) ;
//               canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
               fDisk(x, y, 0.025, 0.025, FILLED) ;
               th += dth ;
          }
//          fTeXlabel(0.3, ymin-0.1, "tc", "$r=\\sin(3\\theta)$") ;
//          fTeXlabel(0.3, ymin-0.25, "tc", "$0\\le\\theta\\le\\frac{\\pi}{3}$") ;
           th = Math.PI/3 ;
           x = Math.sin(3*th)*Math.cos(th)  ;
           y = Math.sin(3*th)*Math.sin(th)  ;
           fLine(1.1*Math.cos(th), 1.1*Math.sin(th), 0, 0) ;
           fTeXlabel(1.1*Math.cos(th), 1.1*Math.sin(th), "bc", 
                                    "$\\scriptstyle\\theta=\\nicefrac{\\pi}{3}$") ;
//           th = Math.PI/6 ;
//           x = Math.sin(3*th)*Math.cos(th)  ;
//           y = Math.sin(3*th)*Math.sin(th)  ;
//           fTeXlabel(1.1*Math.cos(th), 1.1*Math.sin(th), "bc", 
//                                    "$\\scriptstyle\\theta=\\nicefrac{\\pi}{6}$") ;

          fEnv("lineWidth", 1) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[sin(3*t)*cos(t), sin(3*t)*sin(t)]", 1, th_start, th_end, OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;


          
     }
}

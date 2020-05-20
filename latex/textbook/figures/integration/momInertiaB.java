                  /*  File:  momInertiaB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class momInertiaB extends Template {

     static {templateClass = new momInertiaB() ; }

     public void setup() {
          filePrefix = "momInertiaB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.8*2 ;   
          ysize = 0.8*2 ;   
          xmin = -4.0 ;
          xmax = 4.0;
          ymin = -2.0 ;
          ymax = 6.0 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          double x = 3 ;
          double XMAX = 4.5 ;
          double th=30 ; double thRad = th*Math.PI/180 ;
          double om=30 ; double omRad = om*Math.PI/180 ;
          

          fEnv("lineWidth", 0.5) ;
//          fLine(0,ymin, 0,ymax) ;
//          fEnv("psDash", "[3 3] 1.5") ;
//          fLine(xmin, 2, 0, 2) ;
//          fTeXlabel(xmin-0.1, 2-0.05, "cr", "$y=2$") ;
//          fLine(xmin, 3, 0, 3) ;
//          fTeXlabel(xmin-0.1, 3-0.05, "cr", "$y=3$") ;
//          fLine(xmin, 5, 0, 5) ;
//          fTeXlabel(xmin-0.1, 5-0.05, "cr", "$y=5$") ;
//          fEnv("psDash", "clear") ;

          fDisk(0,2, 3, 3, CLOSED) ;
          fDisk(0,2, 0.15, 0.15, FILLED) ;
          double a = 0.5 ; // double b=0.4 ;
          fEllipticalArc (0,2, a, a, th, th+om, OPEN) ;
          fTeXlabel(0.65,2.6, "cc", "$\\scriptstyle\\om$") ;


          
          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,2, 3,3, th, th+om, OPEN) ;
          
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,2, 3*Math.cos(thRad), 2+3*Math.sin(thRad)) ;
          fLine(0,2, 3*Math.cos(thRad+omRad), 2+3*Math.sin(thRad+omRad)) ;
          fDisk(3*Math.cos(thRad), 2+3*Math.sin(thRad), 0.15,0.15, FILLED) ;
          fTeXlabel(0.5*3*Math.cos(thRad), 2+0.5*3*Math.sin(thRad),  "tl", 
                                       "$D$") ;
          fEnv("psFillColor", Black) ;
          th = 135*Math.PI/180.0 ;
          fArrowhead(3*Math.cos(th),  2 + 3*Math.sin(th), 225) ;

     }
}

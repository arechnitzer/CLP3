                  /*  File:  torusSection.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class torusSection extends Template {

     static {templateClass = new torusSection() ; }

     public void setup() {
          filePrefix = "torusSection" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.8 ;   
          ysize = 2.0*0.8 ;   
          xmin = -0.1  ;
          xmax = 2.9 ;
          ymin = -1.0 ;
          ymax = 1.0 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(0,0, xmax, 0) ;
          fTeXlabel(xmax,-0.03, "tr", "$x$") ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(-0.05,ymax, "tr", "$z$") ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double rr = 0.05 ;
          double rrr = 0.15 ;
          double r = 0.7 ;
          double R = 2.0 ;
          double th = 120 ; double thRad = th*Math.PI/180 ;
          double x = R+ r*Math.cos(thRad) ; double y = r*Math.sin(thRad) ;
          fLine(R,0, x, y) ;
          fLine(0,y, x, y) ;
          fTeXlabel(R + (x-R)/2-0.03, 0.5*y,"tr", "$a$") ;
          fTeXlabel(x/2, y+0.05,"bc", "$r$") ;
//          fEllipticalArc(R, 0, rrr,  rrr, 0, th, OPEN) ;
//          fTeXlabel(R + 1.2*rrr, 0.06,"bl", "$\\theta$") ;

          fEnv("useColorPs", "true") ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
//          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(R, 0, r, r, CLOSED) ;
          fDisk(x, y, rr, rr, FILLED) ;
          fEnv("psFillColor", Blue) ;
          fDisk(R, 0, rr, rr, FILLED) ;
          fTeXlabel(R,-0.1, "tc", "$\\scriptstyle (b,0,0)$") ;

     }
}

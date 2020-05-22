                  /*  File:  parCircleS.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class parCircleS extends Template {

     static {templateClass = new parCircleS() ; }

     public void setup() {
          filePrefix = "parCircleS" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;   
          ysize = 1.8 ;   
          xmin = -1.3  ;
          xmax = 1.3 ;
          ymin = -1.3 ;
          ymax = 1.3 ;
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
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.04, ymax, "tr", "$y$") ;
          fTeXlabel(0.85, -0.5, "lt", "$x^2+y^2=a^2$") ;


          fEnv("lineWidth", 1.0) ;
          fCurve("[cos(t), sin(t)]", 1, 0, 2*Math.PI, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;

          fEnv("useColorPs", "true") ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          double th = 45*Math.PI/180.0 ; double R=0.2 ;
          double x = Math.cos(th) ; double y = Math.sin(th) ;
          double Th = 65*Math.PI/180.0 ; 
          double X = Math.cos(Th) ; double Y = Math.sin(Th) ;
          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, x, y) ;
          fEllipticalArc(0, 0, R, R, 0, 45, OPEN) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fTeXlabel(x+0.03, y+0.03, "bl",
                    "$\\big(a\\cos\\theta\\,,\\,a\\sin\\theta\\big)$") ;
          fEllipticalArc(0, 0, 1, 1, 45, 90, OPEN) ;
          fTeXlabel(R+0.1, 0.05, "cb", "$\\theta$") ;
          fEnv("lineWidth", 0.5) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("headHalfWidth", 2.0*1.4) ;
          fEnv("headLength", 6.0*1.4) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fDisk(0, 1, r, r*aspect, FILLED) ;
          fTeXlabel(0.03, 1.03, "bl", "$(0,a)$") ;
          fTeXlabel(0.95*X, 0.95*Y, "tr", "$s$") ;

     }
}

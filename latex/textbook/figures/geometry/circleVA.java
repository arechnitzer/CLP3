                  /*  File:  circleVA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class circleVA extends Template {

     static {templateClass = new circleVA() ; }

     public void setup() {
          filePrefix = "circleVA" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;   
          ysize = 1.8 ;   
          xmin = -1.5  ;
          xmax = 1.5 ;
          ymin = -1.5 ;
          ymax = 1.5 ;
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
          fLine(xmin,-1.4, xmax, -1.4) ;
//          fLine(-1, 0, 1, 0) ;
          fLine(-1.4, ymin,-1.4, ymax) ;
          fTeXlabel(xmax, -1.47, "tr", "$x$") ;
          fTeXlabel(-1.44, ymax, "tr", "$y$") ;
//          fTeXlabel( 0.85, -0.5, "tl", "$(x-h)^2+(y-k)^2=a^2$") ;


          fEnv("lineWidth", 1.0) ;
          fCurve("[cos(t), sin(t)]", 1, 0, 2*Math.PI, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;

          fEnv("useColorPs", "true") ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ; ;
          double th = 50*Math.PI/180.0 ; double R=0.2 ;
          double x = Math.cos(th) ; double y = Math.sin(th) ;
          double xp = -Math.sin(th) ; double yp = Math.cos(th) ;
          double RV = 0.85 ; double RA = 0.6 ;
          fEnv("lineWidth", 0.5) ;
//          fEllipticalArc(0, 0, R, R, 0, 45, OPEN) ;
//          fEnv("psDash", "[2 2] 1.0") ;
//               fLine(x, 0, x, y) ;
//          fEnv("psDash", "clear") ;
//          fArrow(x+0.5,0.5*y, x,0.5*y) ;
//          fTeXlabel(x+0.53, 0.5*y+0.05, "cl", "$a\\sin\\theta$") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fLine(0, 0, x, y) ;
          fDisk(0, 0, r, r*aspect, FILLED) ;
          fEnv("psFillColor", Blue) ;
          fDisk(x, y, r, r*aspect, FILLED) ;
          fTeXlabel(x+0.07, y+0.03, "bl", "$\\vr(t)$") ;

          fEnv("headHalfWidth", 2*1.5) ;
          fEnv("headLength", 6*1.5) ;
          fArrow(x,y, x+RV*xp, y+RV*yp) ;
          fTeXlabel(x+RV*xp, y+RV*yp+0.05, "bc", "$\\vr'(t)$") ;
          fArrow(x,y, x-RA*x, y-RA*y) ;
          fTeXlabel(x-RA*x, y-RA*y, "br", "$\\vr''(t)$") ;
          fArrowhead(0,1,180) ;

//          fTeXlabel(0.5*x-0.02, 0.5*y+0.02, "br", "$a$") ;
          fTeXlabel(0.0, -0.1, "tc", "$(h,k)$") ;
//          fTeXlabel(x+0.07, y+0.03, "bl", "$\\big(h+a\\cos\\theta\\,,\\,k+a\\sin\\theta\\big)$") ;
//          fTeXlabel(R+0.1, 0.05, "cb", "$\\theta$") ;

     }
}

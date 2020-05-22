                  /*  File:  parCirclePhi.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class parCirclePhi extends Template {

     static {templateClass = new parCirclePhi() ; }

     public void setup() {
          filePrefix = "parCirclePhi" ;
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
          fTeXlabel(-0.85, 0.5, "br", "$x^2+y^2=a^2$") ;


          fEnv("lineWidth", 1.0) ;
          fCurve("[cos(t), sin(t)]", 1, 0, 2*Math.PI, OPEN) ;

          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          double r = 0.07 ;

          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          double th = 45*Math.PI/180.0 ; double R=0.2 ;
          double x = Math.cos(th) ; double y = Math.sin(th) ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(0, 0, R, R, 0, 45, OPEN) ;
//          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0, x, y) ;
//          fTeXlabel(x+0.15, y-0.03, "tl", "$\\big(a\\cos\\theta\\,,\\,a\\sin\\theta\\big)$") ;
          fTeXlabel(R+0.1, 0.05, "cb", "$\\theta$") ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          double xT = -Math.sin(th) ; double yT = Math.cos(th) ; double f = 0.7 ; 
          fLine(x,y, x+f*xT,y+f*yT) ;
          fLine(x,y, x+f,y) ;
          fEllipticalArc(x, y, R, R, 0, 45+90, OPEN) ;
          fTeXlabel(x+R*Math.cos(67*Math.PI/180.0), y+R*Math.sin(67*Math.PI/180.0), "bl", "$\\phi$") ;
         double s = 0.13 ;
         fLine(x-s*x, y-s*y,   x-s*x+s*xT, y-s*y+s*yT) ;          
         fLine(x+s*xT, y+s*yT,   x-s*x+s*xT, y-s*y+s*yT) ;  

          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(1.2, 0.4, x+0.07,y-0.025) ;
          fTeXlabel(1.25, 0.47, "tl", "$(a\\cos\\theta,a\\sin\\theta)$") ;
        

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fDisk(x, y, r, r*aspect, FILLED) ;



     }
}

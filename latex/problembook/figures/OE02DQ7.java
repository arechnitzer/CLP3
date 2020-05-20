                  /*  File:  OE02DQ7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE02DQ7 extends Template {

     static {templateClass = new OE02DQ7() ; }

     public void setup() {
          filePrefix = "OE02DQ7" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2.0 ;
          xmax = 2.0 ;
          ymin = -1.5 ;
          ymax = 2.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double s2 = Math.sqrt(2) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0, 1, 1, 1, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0, 0, s2, s2, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fDisk(0, 1, 1, 1, CLOSED) ;
          fDisk(0, 0, s2, s2, CLOSED) ;
          fEnv("lineWidth", 3.0) ;
          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          double th = 1.5*Math.PI/4.0 ;
          double cth = Math.cos(th) ;
          double sth = Math.sin(th) ;
          fLine(s2*cth,  s2*sth , 2*sth*cth, 2*sth*sth) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 1.0) ;
          fEllipticalArc(0, 1, 1, 1, 0, 180, OPEN) ;
          fEllipticalArc(0, 0, s2, s2, 45, 135, OPEN) ;

          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.15, "bc", "$y$") ;          
          fTeXlabel(0.75, 1.75, "bl", "$x^2+(y-1)^2=1$") ;          
          fTeXlabel(1.05, -1, "tl", "$x^2+y^2=2$") ;          
     }
}

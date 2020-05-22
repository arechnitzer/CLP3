                  /*  File:  centroidQuarterCirclev.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class centroidQuarterCirclev extends Template {

     static {templateClass = new centroidQuarterCirclev() ; }

     public void setup() {
          filePrefix = "centroidQuarterCirclev" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*0.4 ;      // in inches
          ysize = 2.7*0.4 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.2 ;
          xmax = 2.5 ;
          ymin = -0.2 ;
          ymax = 2.5 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {

          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0, 0, 2, 2, 0, 90, WEDGE+FILLED) ;
          fEllipticalArc(0, 0, 2, 2, 0, 90, OPEN) ;
          fLine(0,0,  2,0) ;
          fLine(0,0,  0,2) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.1, "cb", "$y$") ;
          fTeXlabel(1.1, 1.8, "bl", "$y=\\sqrt{r^2-x^2}$") ;
          
          double r = 0.1 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(2,0, r,r, FILLED) ;
          fTeXlabel(2,-0.15, "tc", "$(r,0)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 1.0 ;
          double YT = Math.sqrt(4-X*X) ;
          double YB = 0 ;
          fEnv("lineWidth", 6.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YT = 1.2 ;
          YB = 1.0 ;
          fLine(X,YB, X,YT) ;


     }
}

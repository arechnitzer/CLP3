                  /*  File:  polar2BB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar2BB extends Template {

     static {templateClass = new polar2BB() ; }

     public void setup() {
          filePrefix = "polar2BB" ;  // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.66 ;      // in inches
          ysize = 3.0*0.66 ;   // in inches. 
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -1.5 ;
          ymax =  1.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double R = 0.3 ;
          double r = 0.07 ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05,0.0, "lc", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEllipticalArc(0, 0, R, R, 0, 90, OPEN) ;
          fTeXlabel(0.65*R, 0.85*R, "bl", "$\\tfrac{\\pi}{2}$") ;

          double x1 = 0  ; double y1 = 1 ;
          double x2 = -x1  ; double y2 = -y1 ;
 
          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fLine(0, 0,  0, ymax) ;
          fDisk(x1,y1, r, r, FILLED) ;
          fTeXlabel(x1-0.15,y1, "cr", "$(0,1)$") ;
          fTeXlabel(x1+0.15,y1, "cl", "$r=1,\\ \\theta=\\tfrac{\\pi}{2}$") ;

          canvas.append( new fPsWrite(Orange+"\n")) ;

          fLine(0, 0,  0, ymin) ;
          fDisk(x2,y2, r, r, FILLED) ;
          fTeXlabel(x2+0.15,y2, "cl", "$(0,-1)$") ;
          fTeXlabel(x2-0.1,y2, "cr", "$r=-1,\\ \\theta=\\tfrac{\\pi}{2}$") ;

     }
}

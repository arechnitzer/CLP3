                  /*  File:  polar.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar extends Template {

     static {templateClass = new polar() ; }

     public void setup() {
          filePrefix = "polar" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;      // in inches
          ysize = 1.2 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1 ;
          ymin = -0.2 ;
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
          fEnv("lineWidth", 1) ;
          double th = 45 ; double thRad = th*Math.PI/180.0 ;
          double r = 1 ;
          double x = r*Math.cos(thRad) ; double  y = r*Math.sin(thRad) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          fLine(0,0, x,y) ;
          fTeXlabel(0.5*x-0.03, 0.5*y , "br", "$r$") ;
          fTeXlabel(x+0.03, y , "cl", "$(x,y)$") ;
          fDisk(x, y, 0.02, 0.02, FILLED) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03 , "tr", "$x$") ;
          fTeXlabel(-0.02, ymax , "tr", "$y$") ;

          double rr = 0.15 ;
          fEllipticalArc(0,0, rr, rr, 0,th, OPEN) ;
          fTeXlabel(1.1*rr, 0.035 , "bl", "$\\theta$") ;          
     }
}

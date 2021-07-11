                  /*  File:  refl2dXY.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class refl2dXY extends Template {

     static {templateClass = new refl2dXY() ; }

     public void setup() {
          filePrefix = "refl2dXY" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -120 ;
          xmax = 120 ;
          ymin = -75 ;
          ymax = 75 ;
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
          String White  = "1 1 1 setrgbcolor  " ;
          String Black  = "0 0 0 setrgbcolor  " ;
          String Yellow = "0.86667 0.66667 0.2 setrgbcolor  " ;
          String Red    = "0.73333 0.33333 0.4 setrgbcolor  " ;
          String Blue   = "      0 0.26667 0.53333 setrgbcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          double OneDegRad = Math.PI/180.0 ; 
     
          double x1 = 30 ;  
          double y1 = 60 ;  
          double x2 = 60 ;  
          double y2 = 60 ;  
          double x3 = 70 ;  
          double y3 = 20 ;  

          double r = 2.5 ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(x1, y1, r, r, FILLED) ;
          fTeXlabel(x1, y1+3, "bc", "$\\scriptstyle(3,6)$") ;
          fDisk(-x1, -y1, r, r, FILLED) ;
          fTeXlabel(-x1, -y1-3, "tc", "$\\scriptstyle(-3,-6)$") ;
          fArrow(0.97*x1,0.97*y1, -0.97*x1,-0.97*y1) ;


          fEnv("psFillColor", Red) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(x2, y2, r, r, FILLED) ;
          fTeXlabel(x2+1, y2+1, "bl", "$\\scriptstyle(6,6)$") ;
          fDisk(-x2, -y2, r, r, FILLED) ;
          fTeXlabel(-x2-1, -y2-1, "tr", "$\\scriptstyle(-6,-6)$") ;
          fArrow(0.97*x2,0.97*y2, -0.97*x2,-0.97*y2) ;

          fEnv("psFillColor", Yellow) ;
          canvas.append( new fPsWrite(Yellow+"\n")) ;
          fDisk(x3, y3, r, r, FILLED) ;
          fTeXlabel(x3+3, y3, "cl", "$\\scriptstyle(7,2)$") ;
          fDisk(-x3, -y3, r, r, FILLED) ;
          fTeXlabel(-x3-3, -y3, "cr", "$\\scriptstyle(-7,-2)$") ;
          fArrow(0.97*x3,0.97*y3, -0.97*x3,-0.97*y3) ;

          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;
          fTeXlabel(0, ymin-3, "tc", "reflection across the origin") ;

     }
}

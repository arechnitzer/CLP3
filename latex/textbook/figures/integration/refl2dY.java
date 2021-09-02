                  /*  File:  refl2dY.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class refl2dY extends Template {

     static {templateClass = new refl2dY() ; }

     public void setup() {
          filePrefix = "refl2dY" ; // used as the prefix for any ps or lbl files written
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
          String LtBlue   = "0.2     0.6     0.8 setrgbcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          double y = 40 ;  
          double x1 = 90 ;
          double x2 = 30 ;
          double x3 = -30 ;
          double x4 = -90 ;
          double r = 2.5 ;

          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(x1, y, r, r, FILLED) ;
          fDisk(x1, -y, r, r, FILLED) ;
          fArrow(x1,y-r, x1,-y+r) ;
          fTeXlabel(x1, y+3, "bc", "$(6,4)$") ;
          fTeXlabel(x1, -y-3, "tc", "$(6,-4)$") ;

          fEnv("psFillColor", Yellow) ;
          canvas.append( new fPsWrite(Yellow+"\n")) ;
          fDisk(x2, y, r, r, FILLED) ;
          fDisk(x2, -y, r, r, FILLED) ;
          fArrow(x2,y-r, x2,-y+r) ;
          fTeXlabel(x2, y+3, "bc", "$(2,4)$") ;
          fTeXlabel(x2, -y-3, "tc", "$(2,-4)$") ;

          fEnv("psFillColor", Red) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(x3, y, r, r, FILLED) ;
          fDisk(x3, -y, r, r, FILLED) ;
          fArrow(x3,y-r, x3,-y+r) ;
          fTeXlabel(x3, y+3, "bc", "$(-2,4)$") ;
          fTeXlabel(x3-2, -y-3, "tc", "$(-2,-4)$") ;

          fEnv("psFillColor", LtBlue) ;
          canvas.append( new fPsWrite(LtBlue+"\n")) ;
          fDisk(x4, y, r, r, FILLED) ;
          fDisk(x4, -y, r, r, FILLED) ;
          fArrow(x4,y-r, x4,-y+r) ;
          fTeXlabel(x4, y+3, "bc", "$(-6,4)$") ;
          fTeXlabel(x4-6, -y-3, "tc", "$(-6,-4)$") ;

          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;
          fTeXlabel(0, ymin-3, "tc", "reflection across the $x$-axis") ;




     }
}

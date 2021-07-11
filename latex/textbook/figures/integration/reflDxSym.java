                  /*  File:  reflDxSym.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class reflDxSym extends Template {

     static {templateClass = new reflDxSym() ; }

     public void setup() {
          filePrefix = "reflDxSym" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4 ;      // in inches
          ysize = 1.0 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -120 ;
          xmax = 120 ;
          ymin = -50 ;
          ymax =  50 ;
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

          double xr = 50 ; double xl = -50 ; double yt =  30 ; double yb = -30 ;
          double r = 2.5 ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -5, "tr", "$x$") ;
          fTeXlabel(-3, ymax, "tr", "$y$") ;

          fEnv("psFillGray", 0.8) ;
          { 
            double[] xlist = { xl, xr, xr} ;
            double[] ylist = {  0, yt, yb} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }     
          fTeXlabel(20, 0, "cc", "$\\cR$") ;
       
 

          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(xr, yt, r, r, FILLED) ;
          fDisk(xr, yb, r, r, FILLED) ;
          fTeXlabel(xr+5, yt, "lc", "$(5,3)$") ;
          fTeXlabel(xr+5, yb, "lc", "$(5,-3)$") ;
          fLine(xr,yt, xl,0) ;
          fLine(xr,yb, xl,0) ;

          fEnv("psFillColor", Red) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(xl, 0, r, r, FILLED) ;
          fTeXlabel(xl-3, 3, "rb", "$(-5,0)$") ;
          fLine(xr,yt, xr,yb) ;

     }
}

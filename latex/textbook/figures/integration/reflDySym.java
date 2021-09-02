                  /*  File:  reflDySym.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class reflDySym extends Template {

     static {templateClass = new reflDySym() ; }

     public void setup() {
          filePrefix = "reflDySym" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*1.3 ;      // in inches
          ysize = 1.0*1.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -75 ;
          xmax =  75 ;
          ymin = -25 ;
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
          double xr = 50 ; double yt =  50 ; double yb = -10 ;
          double r = 2.5 ;

          fEnv("psFillGray", 0.8) ;
          { 
            double[] xlist = { xr, xr, -xr,-xr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }     

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
 

          fEnv("lineWidth", 1.5) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-xr,yt, xr,yt) ;
          canvas.append( new fPsWrite(Yellow+"\n")) ;
          fLine(-xr,yb, xr,yb) ;

          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(xr, yt, r, r, FILLED) ;
          fDisk(xr, yb, r, r, FILLED) ;
          fLine(xr,yt, xr,yb) ;
          fTeXlabel(xr+2, yt+1, "bl", "$(5,5)$") ;
          fTeXlabel(xr+2, yb-1, "tl", "$(5,-1)$") ;

          fDisk(-xr, yt, r, r, FILLED) ;
          fDisk(-xr, yb, r, r, FILLED) ;
          fLine(-xr,yt, -xr,yb) ;
          fTeXlabel(-xr-2, yt+1, "br", "$(-5,5)$") ;
          fTeXlabel(-xr-2, yb-1, "tr", "$(-5,-1)$") ;

          fTeXlabel(xmax, -2, "tr", "$x$") ;
          fTeXlabel(-1, ymax, "tr", "$y$") ;
          fTeXlabel(0, ymin-3, "tc", "symmetric about the $y$-axis") ;




     }
}

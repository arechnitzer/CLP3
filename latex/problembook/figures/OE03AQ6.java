                  /*  File:  OE03AQ6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE03AQ6 extends Template {

     static {templateClass = new OE03AQ6() ; }

     public void setup() {
          filePrefix = "OE03AQ6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1*2.0 ;      // in inches
          ysize = 20.0/35.0*2.0 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -15 ;
          xmax = 20 ;
          ymin = -3 ;
          ymax = 17 ;
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
          double a= 10 ;
          double b= 15 ;
          double c= 12 ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(-a,0, b/2.0,c/2.0) ;
          fLine(b,0, -a/2.0,c/2.0) ;
          fLine(0,c, (b-a)/2.0,0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
         
          fEnv("lineWidth", 1.0) ;
          fLine(-a,0, b,0) ;
          fLine(b,0, 0,c) ;
          fLine(-a,0, 0, c) ;
          fTeXlabel(-a,-1, "tc", "$(-a,0)$") ;
          fTeXlabel(b,-1, "tc", "$(b,0)$") ;
          fTeXlabel(b/2.0+1,c/2.0, "bl", "$(b/2,c/2)$") ;
          fTeXlabel(0.5,c+0.5, "bl", "$(0,c)$") ;
          double r = 0.5 ;
          fDisk(-a,0, r,r, FILLED) ;
          fDisk(b,0, r,r, FILLED) ;
          fDisk(0,c, r,r, FILLED) ;
          fDisk(-a/2,c/2, r,r, FILLED) ;
          fDisk(b/2,c/2, r,r, FILLED) ;
          fDisk((b-a)/2,0, r,r, FILLED) ;


          fTeXlabel(xmax+0.5, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.5, "bc", "$y$") ;
          
     }
}

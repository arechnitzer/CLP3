                  /*  File:  OE00AQ7.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE00AQ7 extends Template {

     static {templateClass = new OE00AQ7() ; }

     public void setup() {
          filePrefix = "OE00AQ7" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;   
          ysize = 1.5 ;   
          xmin = -4 ;
          xmax = 6 ;
          ymin = -4 ;
          ymax = 6 ;
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
          fEnv("lineWidth", 4) ;
          double y = 2 ;
          fEnv("psFillGray", 0.8) ;
          fCurve("[t*t/2-3, t]",1, -2, 4, FILLED);
          fEnv("psFillGray", 0.0) ;

          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          fLine(y*y/2-3, y, y+1, y) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("[t*t/2-3, t]",1, -2, 4, OPEN) ;
          fLine(-1,-2, 5,4) ;
          double r = 0.2 ;
          fDisk(-1,-2, r,r, FILLED) ;
          fDisk(5,4, r, r, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fCurve("[t*t/2-3, t]",1, ymin, ymax, OPEN);
          fLine(xmin, xmin-1, xmax, xmax-1) ;


          fTeXlabel(xmax+0.2, 0.0, "lc", "$x$") ;
          fTeXlabel(0.0, ymax+0.2, "bc", "$y$") ;

          fTeXlabel(-1.8,-2.2, "rc", "$(-1,-2)$") ;
          fTeXlabel(5.0, 4.1, "br", "$(5,4)$") ;

          fTeXlabel(xmax+0.3, xmax-1, "bl", "$y=x-1$") ;
          fTeXlabel(xmax-0.6, -Math.sqrt(2*xmax+6)+0.2, "lc", "$y^2=2x+6$") ;

     }
}

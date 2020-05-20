                  /*  File:  positions.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class positions extends Template {

     static {templateClass = new positions() ; }

     public void setup() {
          filePrefix = "positions" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -1 ;
          xmax = 11 ;
          ymin = -1 ;
          ymax = 3 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(-1, 0,   11, 0);
          fLine(0, -1,    0, 3);

          fDisk(0, 0,  .1, .1, FILLED);
          fDisk(2, 1,  .1, .1, FILLED);
          fDisk(8, 0,  .1, .1, FILLED);
          fDisk(10, 1,  .1, .1, FILLED);
          fDisk(4, 2,  .1, .1, FILLED);
          fDisk(6, 3,  .1, .1, FILLED);

          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fEnv("headLength", 6*1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fArrow(0, 0, 2, 1);
          fArrow(8, 0, 10, 1);
          fArrow(4, 2, 6, 3);

          fTeXlabel(11, -.2, "tc", "$x$");
          fTeXlabel(-.2, 3, "rc", "$y$");

          fTeXlabel(-.1, -.1, "tr", "$(0,0)$");
          fTeXlabel(2, 1.2, "bc", "$(2,1)$");
          fTeXlabel(8.1, -.1, "tl", "$(8,0)$");
          fTeXlabel(10.1, 1.1, "bl", "$(10,1)$");
          fTeXlabel(4.1, 1.9, "tl", "$(4,2)$");
          fTeXlabel(6.1, 3.1, "bl", "$(6,3)$");
          fTeXlabel(5.3, 2.8, "br", "$\\llt 2,1\\rgt$");
          fTeXlabel(9.3, .8, "br", "$\\llt 2,1\\rgt$");
          
     }
}

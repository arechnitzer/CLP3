                  /*  File:  closest.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class closest extends Template {

     static {templateClass = new closest() ; }

     public void setup() {
          filePrefix = "closest" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4 ;      // in inches
          ysize = 1.4 ;   // in inches. 
          xmin = -1 ;
          xmax =  9 ;
          ymin = -1 ;
          ymax =  9 ;
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
          double r = 0.2 ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fEnv("lineWidth", 0.6) ;
          fLine(xmin, 6-3*xmin, (6-ymin)/3, ymin) ; 
          fTeXlabel((6-ymax)/3-0.1, ymax , "tr", "$L$") ;
          fDisk(0, 6, r, r, FILLED) ;  fTeXlabel(-0.1, 6, "tr", "$(0,6)$") ;
          fDisk(2, 0, r, r, FILLED) ;  fTeXlabel(2.5, -0.1, "tl", "$(2,0)$") ;
          fDisk(7, 5, r, r, FILLED) ;  fTeXlabel(7.3, 4.9, "tl", "$(7,5)$") ;
          double tm = (xmin-7)/3 ;
          double tM = (xmax-7)/3 ;
          fLine(7+3*tm, 5+tm, 7+3*tM, 5+tM) ;
          fDisk(1, 3, r, r, FILLED) ;  fTeXlabel(1.4, 3.0, "tl", "$P$") ;
          fTeXlabel(7+3*tM+0.1, 5+tM+0.2 , "br", "$N$") ;
          fDisk(5.5, 4.5, r, r, FILLED) ; fTeXlabel(5.8, 4.2, "tc", "$(x,y)$") ;
          double h = 0.2 ;
          fLine(1+h*3, 3+h, 1+2*h , 3+4*h) ;
          fLine(1-h, 3+3*h, 1+2*h , 3+4*h) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.3) ;
          fEnv("headLength", 6*1.3) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fArrow(1,3, 4,4) ;  fTeXlabel(3.0, 4.2, "bc", "$\\llt 3,1\\rgt$") ;

          fTeXlabel(xmax, -0.5, "tc", "$x$") ;
          fTeXlabel(0.5, ymax, "cl", "$y$") ;

     }
}

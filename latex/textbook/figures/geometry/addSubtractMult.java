                  /*  File:  addSubtractMult.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class addSubtractMult extends Template {

     static {templateClass = new addSubtractMult() ; }

     public void setup() {
          filePrefix = "addSubtractMult" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.5 ;      // in inches
          ysize = 1.4*1.5 ;   // in inches. 
          xmin = -1 ;
          xmax = 13 ;
          ymin = -1 ;
          ymax = 13 ;
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
         double x1 = 4 ; double y1 = 0 ;
         double x2 = 9 ; double y2 = 5 ;
         double x3 = 6 ; double y3 = 7 ;
         double x4 = 0 ; double y4 = 11 ;
         double xc = 11 ; double yc = 11 ; double l = 1.5 ;
         double r = 0.25 ;
         fEnv("psFillGray", 0.6) ;
         fDisk(x1,y1, r, r, FILLED) ;
         fTeXlabel(x1-0.2,y1-0.3, "tl", "$(4,0)$") ;
         fDisk(x2,y2, r, r, FILLED) ;
         fTeXlabel(x2+0.2,y2, "cl", "$(9,5)$") ;
         fDisk(x3,y3, r, r, FILLED) ;
         fTeXlabel(x3+0.2,y3+0.2, "bl", "$(6,7)$") ;
         fDisk(x4,y4, r, r, FILLED) ;
         fTeXlabel(x4-0.2,y4, "cr", "$(0,11)$") ;


         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0 ) ;
         fLine(0, ymin, 0, ymax ) ;
         fTeXlabel(xmax, -0.2, "tr", "$x$") ;
         fTeXlabel(-0.2, ymax, "tr", "$y$") ;
         fArrow(xc, yc, xc+l, yc) ; fTeXlabel(xc+l+0.2, yc, "cl", "$E$") ;
         fArrow(xc, yc, xc, yc+l) ; fTeXlabel(xc, yc+l+0.2, "cb", "$N$") ;
         fArrow(xc, yc, xc-l, yc) ; fTeXlabel(xc-l, yc, "cr", "$W$") ;
         fArrow(xc, yc, xc, yc-l) ; fTeXlabel(xc, yc-l-0.2, "ct", "$S$") ;

         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         fArrow(0, 0,   x1, y1 ) ;
         fTeXlabel(0.5*x1,0.5*y1+0.2, "bc", "$\\llt 4,0 \\rgt$") ;
         fArrow(x1, y1,   x2, y2 ) ;
         fTeXlabel(0.5*(x1+x2)+0.5,0.5*(y1+y2), "cl", "$\\llt 5,5 \\rgt$") ;
         canvas.append( new fPsWrite("[2 2] 0 setdash\n")) ;
//         fLine(x2, y2,   x4, y4 ) ;
         fArrow(x2, y2,   x4, y4 ) ;
         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
         fTeXlabel(x3+0.75*(x4-x3)+0.3,y3+0.75*(y4-y3)+0.2, "cl", "$\\llt -9,6 \\rgt$") ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         fEnv("useColorPs", "true") ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("psFillColor", Blue) ;
         fArrow(x2, y2,    x3, y3 ) ;
         fTeXlabel(0.5*(x2+x3)+0.2,0.5*(y2+y3)-0.2, "tr", "\\textcolor{blue}{$\\llt -3,2 \\rgt$}") ;
     }
}

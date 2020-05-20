                  /*  File:  decTreeTT.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class decTreeTT extends Template {

     static {templateClass = new decTreeTT() ; }

     public void setup() {
          filePrefix = "decTreeTT" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*1.0 ;      // in inches
          ysize = 3.0*1.0 ;   // in inches. 
          xmin = -50 ;
          xmax =  50 ;
          ymin =   0 ;
          ymax = 100 ;
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
           double DY = 22 ;
           double BX = 18 ;
           double y1 = 80 ;
           double x1 =  0 ;
           double y2 = y1 - DY ;
           double x2l =-BX ;  double x2r = BX ; double x2c = 0 ;
           double y3 = y2 - DY ;
           double x3l = x2l ;  double x3r = x2r ; double x3c = x2c ;
           double Y1C = 0.5*(y1+y2) ; double X1LC = 0.5*(0+x2l) ;
                         double X1CC = 0 ; 
                         double X1RC = 0.5*(0+x2r) ;
           double dY1 = 0.5*(y1-y2) ; double dX1L = 0.5*(0-x2l) ;
                         double dX1R = 0.5*(x2r-0) ;
           double Y2C = 0.5*(y2+y3) ; 
           double dY2 = 0.5*(y2-y3) ; 
           
           fTeXlabel(x1, y1, "cc", "$f$") ;
           fTeXlabel(x2l, y2, "cc", "$x$") ;
           fTeXlabel(x2c, y2, "cc", "$y$") ;
           fTeXlabel(x2r, y2, "cc", "$z$") ;
           fTeXlabel(x3l, y3, "cc", "$t$") ;
           fTeXlabel(x3c, y3, "cc", "$t$") ;
           fTeXlabel(x3r, y3, "cc", "$t$") ;

         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;


           fEnv("lineWidth", 0.5) ;
           fLine(X1LC+0.7*dX1L,Y1C+0.7*dY1, X1LC-0.8*dX1L,Y1C-0.8*dY1) ;
           fTeXlabel(X1LC-0.5, Y1C, "br", "$\\pdiff{f}{x}$") ;
           fLine(X1CC,Y1C+0.7*dY1, X1CC,Y1C-0.7*dY1) ;
           fTeXlabel(X1CC, Y1C-2, "cr", "$\\pdiff{f}{y}$") ;
           fLine(X1RC-0.7*dX1R,Y1C+0.7*dY1, X1RC+0.8*dX1R,Y1C-0.8*dY1) ;
           fTeXlabel(X1RC, Y1C, "bl", "$\\pdiff{f}{z}$") ;

           fLine(x2l,Y2C+0.75*dY2, x2l,Y2C-0.7*dY2) ;
           fTeXlabel(x2l, Y2C, "cr", "$\\diff{x}{t}$") ;
           fLine(x2c,Y2C+0.75*dY2, x2c,Y2C-0.7*dY2) ;
           fTeXlabel(x2c, Y2C, "cr", "$\\diff{y}{t}$") ;
           fLine(x2r,Y2C+0.75*dY2, x2r,Y2C-0.7*dY2) ;
           fTeXlabel(x2r+0.2, Y2C, "cl", "$\\diff{z}{t}$") ;

          
     }
}

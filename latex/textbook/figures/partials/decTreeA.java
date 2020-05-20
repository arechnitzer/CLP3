                  /*  File:  decTreeA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class decTreeA extends Template {

     static {templateClass = new decTreeA() ; }

     public void setup() {
          filePrefix = "decTreeA" ;   
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
           double SX = 10 ; double BX = 15 ;
           double y1 = 80 ;
           double x1 =  0 ;
           double y2 = y1 - DY ;
           double x2l =-BX ;  double x2r = BX ;
           double y3 = y2 - DY ;
           double x3ll = x2l - SX ;  double x3lr = x2l + SX ;
           double x3rl = x2r - SX ;  double x3rr = x2r + SX ;
           double Y1C = 0.5*(y1+y2) ; double X1LC = 0.5*(0+x2l) ; 
                         double X1RC = 0.5*(0+x2r) ;
           double dY1 = 0.5*(y1-y2) ; double dX1L = 0.5*(0-x2l) ;
                         double dX1R = 0.5*(x2r-0) ;
           double Y2C = 0.5*(y2+y3) ; 
                         double X2LLC = 0.5*(x2l+x3ll) ; 
                         double X2LRC = 0.5*(x2l+x3lr) ; 
                         double X2RLC = 0.5*(x2r+x3rl) ;
                         double X2RRC = 0.5*(x2r+x3rr) ;
           double dY2 = 0.5*(y2-y3) ; 
                         double dX2LL = 0.5*(x2l-x3ll) ;
                         double dX2LR = 0.5*(x2l-x3lr) ;
                         double dX2RL = 0.5*(x2r-x3rl) ;
                         double dX2RR = 0.5*(x2r-x3rr) ;
           
           fTeXlabel(x1, y1, "cc", "$f$") ;
           fTeXlabel(x2l, y2, "cc", "$x$") ;
           fTeXlabel(x2r, y2, "cc", "$y$") ;
           fTeXlabel(x3ll, y3, "cc", "$s$") ;
           fTeXlabel(x3lr, y3, "cc", "$t$") ;
           fTeXlabel(x3rl, y3, "cc", "$s$") ;
           fTeXlabel(x3rr, y3, "cc", "$t$") ;

         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;


//           fEnv("lineWidth", 2.0) ;
           fEnv("lineWidth", 0.5) ;
//           canvas.append( new fPsWrite(Orange+"\n")) ;
           fLine(X1LC+0.7*dX1L,Y1C+0.7*dY1, X1LC-0.7*dX1L,Y1C-0.7*dY1) ;
//           fTeXlabel(X1LC-0.5, Y1C, "br", "$\\pdiff{f}{x}$") ;
           fLine(X1RC-0.7*dX1R,Y1C+0.7*dY1, X1RC+0.7*dX1R,Y1C-0.7*dY1) ;
//           fTeXlabel(X1RC, Y1C, "bl", "$\\pdiff{f}{y}$") ;

           fLine(X2LRC+0.7*dX2LR,Y2C+0.7*dY2, X2LRC-0.7*dX2LR,Y2C-0.7*dY2) ;
//           fTeXlabel(X2LRC, Y2C, "bl", "$\\pdiff{x}{t}$") ;
           fLine(X2RRC+0.7*dX2RR,Y2C+0.7*dY2, X2RRC-0.7*dX2RR,Y2C-0.7*dY2) ;
//           fTeXlabel(X2RRC, Y2C, "bl", "$\\pdiff{y}{t}$") ;


           fEnv("lineWidth", 0.5) ;
           canvas.append( new fPsWrite(Black+"\n")) ;
           fLine(X2LLC+0.7*dX2LL,Y2C+0.7*dY2, X2LLC-0.7*dX2LL,Y2C-0.7*dY2) ;
//           fTeXlabel(X2LLC, Y2C, "br", "$\\pdiff{x}{s}$") ;
           fLine(X2RLC+0.7*dX2RL,Y2C+0.7*dY2, X2RLC-0.7*dX2RL,Y2C-0.7*dY2) ;
//           fTeXlabel(X2RLC-0.5, Y2C, "br", "$\\pdiff{y}{s}$") ;


          
     }
}

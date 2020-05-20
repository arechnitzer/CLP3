                  /*  File: regression.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class regression extends Template {

     static {templateClass = new regression() ; }

     public void setup() {
          filePrefix = "regression" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0;   
          ysize = 2.0 ;   
          xmin = -10 ;
          xmax = 90 ;
          ymin = -10 ;
          ymax = 90 ;
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
          double r = 1 ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -1, "tr", "$x$", "x") ;
          fTeXlabel(-1, ymax, "tr", "$y$", "y") ;
          
          int n = 8 ;
          double[] x = {12,     23,    32,   40,  50,   60,   70, 80} ;
          double[] y = {27+5, 21+5,  29+5, 46+5, 54+5, 50+5, 70+5, 65+5} ;

          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          for ( int i=0; i < n; i++ ) {
               fDisk(x[i],y[i],r,r, FILLED) ;
          }
          fTeXlabel(x[0], y[0]+1.5, "bc", "$\\scriptstyle (x_1,y_1)$") ;
          fTeXlabel(x[1]+2, y[1], "cl", "$\\scriptstyle (x_2,y_2)$") ;
          fTeXlabel(x[2]+2, y[2], "cl", "$\\scriptstyle (x_3,y_3)$") ;
          fTeXlabel(x[7]+2, y[7], "cl", "$\\scriptstyle (x_n,y_n)$") ;


          double Sx=0 ;
          double Sy=0 ;
          double Sxx=0 ;
          double Sxy=0 ;

          for ( int i=0; i < n; i++ ) {
               Sx += x[i] ;
               Sy += y[i] ;
               Sxx += x[i]*x[i] ;
               Sxy += x[i]*y[i] ;
          }

          double m =  (n*Sxy - Sx*Sy)/(n*Sxx -Sx*Sx) ;
          double b = -(Sx*Sxy-Sy*Sxx)/(n*Sxx -Sx*Sx) ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(xmin, m*xmin+b,   xmax,m*xmax+b) ;
//          fTeXlabel(xmax+2, m*xmax+b, "cl", "$y=mx+b$") ;
          fTeXlabel(xmin-2, m*xmin+b, "cr", "$y=mx+b$") ;



//          double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ;
//          fDisk(x,y, r,r*aspect, FILLED) ;



     }
}

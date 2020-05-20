                  /*  File:  bigSmall.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class bigSmall extends Template {

     static {templateClass = new bigSmall() ; }

     public void setup() {
          filePrefix = "bigSmall" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.8*2.5 ;      // in inches
          ysize = 0.6*2.5 ;   // in inches. 
          xmin = -4 ;
          xmax = 4 ;
          ymin = -3 ;
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
         fEnv("headHalfWidth", 2*1.2) ;
         fEnv("headLength", 6*1.2) ;
         double K, x, y ;
         double r = 0.15 ;
         double a = Math.sqrt(6) ;
         double b = Math.sqrt(3) ;
         double L = 1 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
//         fTeXlabel(xmax, -0.07, "tr", "$y$") ;
//         fTeXlabel(-0.03, ymax, "tr", "$z$") ;

         
         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 2.0) ;
         fDisk(0,0, a,b, CLOSED) ;
         canvas.append( new fPsWrite(Black+"\n")) ;
         K = 0.5 ; x = 3; y = K-x ;
         fLine(K-ymin, ymin, K-ymax, ymax) ;
         fTeXlabel(K-ymin, ymin, "tl", "$x+y+3z=C$") ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         K = 3 ;
         fLine(K-ymin, ymin, K-ymax, ymax) ;
         K = -3 ;
         fLine(K-ymin, ymin, K-ymax, ymax) ;

         fEnv("lineWidth", 0.5) ;
         canvas.append( new fPsWrite(Black+"\n")) ;
         K = 0.5 ; x = 2.7; y = K-x ;
         fArrow(x, y, x+L, y+L) ;
         K = 3 ; x = 2; y = K-x ;
         fArrow(x, y, x+L, y+L) ;
         fDisk(x,y, r,r, FILLED);
         K = -3 ; x = -2; y = K-x ;
         fArrow(x, y, x-L, y-L) ;
         fDisk(x,y, r,r, FILLED);

         
         fTeXlabel(xmin-2,ymax, "bc", "$x^2+2y^2+3z^2 = 72$") ;
         x = -2.0 ; y = b*Math.sqrt(1-x*x/a/a) ;
         fArrow(x - ymax +y, ymax-0.05, x-0.1,y+0.1) ;







          
     }
}

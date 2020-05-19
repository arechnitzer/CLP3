                  /*  File:  ellipseLevel.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class ellipseLevel extends Template {

     static {templateClass = new ellipseLevel() ; }

     public void setup() {
          filePrefix = "ellipseLevel" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4*1.2 ;      // in inches
          ysize = 2*1.2 ;   // in inches. 
          xmin = -4 ;
          xmax = 6 ;
          ymin = -2.5 ;
          ymax = 2.5 ;
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
         double C = 2 ; 
         double X = Math.sqrt(C-1) ; double Y =0.5*Math.sqrt(C-1) ;
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.1, ymax, "tr", "$y$") ;
         fLine(1,0, 1,-0.15) ;
         fTeXlabel(1, -0.18, "tc", "$1$") ;
         fLine(0, 1, -0.1,1) ;
         fTeXlabel(-0.15, 1, "rc", "$1$") ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fDisk(1,0, r, r, FILLED) ;
              fTeXlabel(1,0.1, "bc", "${\\scriptstyle f=1}$") ;
         fDisk(1,0, X, Y, CLOSED) ;
              fTeXlabel(0.95*X+1.1,0.3*Y, "bl", "${\\scriptstyle f=2}$") ;
         C = 5 ;  X = Math.sqrt(C-1) ;  Y =0.5*Math.sqrt(C-1) ;
         fDisk(1,0, X, Y, CLOSED) ;
              fTeXlabel(0.95*X+1.1,0.3*Y, "bl", "${\\scriptstyle f=5}$") ;
         C = 10 ;  X = Math.sqrt(C-1) ;  Y =0.5*Math.sqrt(C-1) ;
         fDisk(1,0, X, Y, CLOSED) ;
              fTeXlabel(0.95*X+1.1,0.3*Y, "bl", "${\\scriptstyle f=10}$") ;
         C = 17 ;  X = Math.sqrt(C-1) ;  Y =0.5*Math.sqrt(C-1) ;
         fDisk(1,0, X, Y, CLOSED) ;
              fTeXlabel(0.95*X+1.1,0.3*Y, "bl", "${\\scriptstyle f=17}$") ;


          
     }
}

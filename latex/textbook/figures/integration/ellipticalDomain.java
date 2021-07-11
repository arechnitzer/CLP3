                  /*  File:  ellipticalDomain.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class ellipticalDomain extends Template {

     static {templateClass = new ellipticalDomain() ; }

     public void setup() {
          filePrefix = "ellipticalDomain" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
          xmin = -2 ;
          xmax = 2 ;
          ymin = -1.0 ;
          ymax = 1.0 ;
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
         double X = 1.2 ; double Y = 0.6 ;
         double r = 0.08 ;

         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax+0.05, 0, "cl", "$x$") ;
         fTeXlabel(0, ymax+0.05, "bc", "$y$") ;

         fEnv("psFillGray", 0.8) ;
         fDisk(0,0, X, Y, FILLED) ;
         fTeXlabel(0, 0, "cc", "$\\cR$") ;

         String Red    = "0.73333 0.33333 0.4 setrgbcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("psFillGray", 0.0) ;
         fEnv("lineWidth", 1.0) ;
         fDisk(0,0, X, Y, CLOSED) ;
         fDisk(X,0, r, r, FILLED) ;
         fTeXlabel(X+0.05, 0.05, "bl", "$(1,0)$") ;
         fDisk(0,Y, r, r, FILLED) ;
         fTeXlabel(-0.05, Y+0.05, "br", "$(0,1/2)$") ;
          
     }
}

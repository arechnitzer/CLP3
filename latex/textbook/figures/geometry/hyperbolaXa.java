                  /*  File:  hyperbolaXa.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperbolaXa extends Template {

     static {templateClass = new hyperbolaXa() ; }

     public void setup() {
          filePrefix = "hyperbolaXa" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -3 ;
          xmax = 3 ;
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
         double r = 0.12 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$y$") ;
         fTeXlabel(-0.05, ymax, "tr", "$z$") ;

         canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
         fLine(ymax,ymin, ymin,ymax) ;
         fLine(-ymax,ymin, -ymin,ymax) ;
         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
         fTeXlabel(ymax-0.6, ymax, "tr", "$z=y$") ;
         
         fCurve("[sqrt(1+t*t),t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(1+t*t),t]", 1, ymin, ymax, OPEN) ;

         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fCurve("[sqrt(1+t*t),t]", 1, 0, ymax, OPEN) ;
         fTeXlabel(-2, 1.5, "tr", "$y^2-z^2=1$") ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Red) ;
         fDisk(1, 0, r, r, FILLED) ;


          
     }
}

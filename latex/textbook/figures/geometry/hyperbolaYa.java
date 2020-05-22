                  /*  File:  hyperbolaYa.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperbolaYa extends Template {

     static {templateClass = new hyperbolaYa() ; }

     public void setup() {
          filePrefix = "hyperbolaYa" ;   
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
         fTeXlabel(xmax, -0.1, "tr", "$x$") ;
         fTeXlabel(-0.05, ymax, "tr", "$z$") ;

         canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
         fLine(ymax/2,ymin, ymin/2,ymax) ;
         fLine(-ymax/2,ymin, -ymin/2,ymax) ;
         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
//         fTeXlabel(-ymax/2, ymin, "tl", "$z=2x$") ;

         fCurve("[sqrt(1+t*t)/2,t]", 1, ymin, ymax, OPEN) ;
         fCurve("[-sqrt(1+t*t)/2,t]", 1, ymin, ymax, OPEN) ;

         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fCurve("[sqrt(1+t*t)/2,t]", 1, 0, ymax, OPEN) ;
         fTeXlabel(1, 1.5, "tl", "$4x^2-z^2=1$") ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         fDisk(0.5, 0, r, r, FILLED) ;


          
     }
}

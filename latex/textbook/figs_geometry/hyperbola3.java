                  /*  File:  hyperbola3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperbola3 extends Template {

     static {templateClass = new hyperbola3() ; }

     public void setup() {
          filePrefix = "hyperbola3" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
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
         double r = 0.08 ;
         fEnv("lineWidth", 0.5) ;
         fLine(xmin, 0, xmax, 0) ;
         fLine(0, ymin, 0, ymax) ;
         fTeXlabel(xmax, -0.1, "tr", "$y$") ;
         fTeXlabel(-0.05, ymax, "tr", "$z$") ;

         
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("lineWidth", 1.0) ;
         fCurve("[1/t,t]", 1, 0.01, ymax, OPEN) ;
         fCurve("[-1/t,-t]", 1, 0.01, ymax, OPEN) ;
         fTeXlabel(0.6, 3.6, "tl", "$yz=1$") ;


          
     }
}

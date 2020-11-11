                  /*  File:  mscalmul.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class mscalmul extends Template {

     static {templateClass = new mscalmul() ; }

     public void setup() {
          filePrefix = "mscalmul" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -10 ;
          xmax = 100 ;
          ymin = -10 ;
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
          double a1 = 45 ; double a2 = 30 ;
          fEnv("lineWidth", 0.5) ;
          fLine( -5, 0, 90, 0) ;
          fLine( 0, -5, 0, 90) ;

          fLine( -5, a2, 0, a2) ;
          fLine( -5, 2*a2, 0, 2*a2) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fEnv("headLength", 6*1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fDisk( 0, 0,  3, 3, FILLED) ;
          fDisk( a1, a2,  3, 3, FILLED) ;
          fDisk( 2*a1, 2*a2,  3, 3, FILLED) ;
          fArrow( 0, 0, 0.95*a1, 0.95*a2) ;
          fArrow( 0, 0, 0.975*2*a1, 0.975*2*a2) ;
          fTeXlabel( -5, a2, "rc", "$a_2$") ;
          fTeXlabel( -5, 2*a2, "rc", "$2a_2$") ;
          fTeXlabel( a1+2, a2-2, "tl", "$\\llt a_1,a_2\\rgt$") ;
          fTeXlabel( 2*a1, 2*a2+3, "bc", "$\\llt 2a_1,2a_2\\rgt$") ;
     }
}

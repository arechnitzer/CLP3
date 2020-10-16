                  /*  File:  maddvec.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class maddvec extends Template {

     static {templateClass = new maddvec() ; }

     public void setup() {
          filePrefix = "maddvec" ;   
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
          fEnv("lineWidth", 0.5) ;
          double a1 = 45 ; double a2 = 30 ;
          double b1 = 10 ; double b2 = 60 ; 
          fLine( -5, 0, 90, 0) ;
          fLine( 0, -5, 0, 90) ;

          fLine( -5, a2, 0, a2) ;
          fLine( -5,a2+b2, 0, a2+b2) ;
          fBracket( -2, a2+2,  -2, a2+b2-2 ) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fEnv("headLength", 6*1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fDisk( 0, 0,  3, 3, FILLED) ;
          fDisk( a1, a2,  3, 3, FILLED) ;
          fDisk( a1+b1, a2+b2,  3, 3, FILLED) ;
          fArrow( 0, 0,   0.95*a1, 0.95*a2) ;
          fArrow( a1, a2, a1+0.95*b1, a2+0.95*b2) ;
          fArrow( 0, 0,   0.97*(a1+b1), 0.97*(a2+b2)) ;
          fTeXlabel( -10, 30, "rc", "$a_2$") ;
          fTeXlabel( -10, 90, "rc", "$a_2+b_2$") ;
          fTeXlabel( -12, 60, "rc", "$b_2$") ;
          fTeXlabel( 0.6*a1, 0.6*a2, "tl", "$\\llt a_1,a_2\\rgt$") ;
          fTeXlabel( a1+0.5*b1, a2+0.5*b2, "tl", "$\\llt b_1,b_2\\rgt$") ;
          fTeXlabel( a1+b1, a2+b2+4, "bc", "$\\llt a_1+b_1,a_2+b_2\\rgt$") ;
     }
}

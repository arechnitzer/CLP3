                  /*  File:  coffee.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coffee extends Template {

     static {templateClass = new coffee() ; }

     public void setup() {
          filePrefix = "coffee" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;      // in inches
          ysize = 1.8 ;   // in inches
          xmin = -100 ;
          xmax = 100 ;
          ymin = -50 ;
          ymax = 50 ;
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
          fEnv("lineWidth", 1.0) ;
          fDisk(0, 30, 20, 5, CLOSED) ;
          fEllipticalArc(0, 0, 40, 10, -180, 0, OPEN) ;
          fEllipticalArc(0, -30, 20, 5, -180, 0, OPEN) ;
          fEnv("psDash", "[4 4] 2") ;
          fEllipticalArc(0, 0, 40, 10, 0, 180, OPEN) ;
          fEllipticalArc(0, -30, 20, 5, 0, 180, OPEN) ;
          fEnv("psDash", "clear") ;
          
          fCurve("[40-20*(t/30)*(t/30),t]", 1, -30, 30, OPEN) ;
          fCurve("[-40+20*(t/30)*(t/30),t]", 1, -30, 30, OPEN) ;

          fEnv("lineWidth", 0.5) ;
          fLine( 50, 30, 60, 30) ;
          fLine( 50, -30, 60, -30) ;
          fArrow( 55, 7, 55, 29) ;
          fArrow( 55, -7, 55, -29) ;
          fTeXlabel( 56, 0, "cc", "12''") ;

          fLine( 0, -38,  0, -44) ;
          fLine( 20, -38, 20, -44) ;
          fArrow( 35, -41, 21, -41) ;
          fArrow( -15, -41, -1, -41) ; 
          fTeXlabel( 10, -41, "cc", "2''") ;

          fArrow( 0, 0, 39, 0) ;
          fArrow( 39, 0, 0, 0) ;
          fTeXlabel( 18, 1, "bc", "3''") ;

     }
}

                  /*  File:  piped.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class piped extends Template {

     static {templateClass = new piped() ; }

     public void setup() {
          filePrefix = "piped" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1*1.2 ;      // in inches
          ysize = 1*1.2 ;   // in inches. 
          xmin =  0 ;
          xmax = 115 ;
          ymin =  0 ;
          ymax = 115 ;
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
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         fRotate( 10*Math.PI/180.0) ;
         fArrow( 0, 0, 50, 0) ;
         fArrow( 0, 0, 40, 30) ;
         fArrow( 0, 0, 20, 50) ;

         fEnv("lineWidth", 0.5) ;
         fLine( 50, 0,  90, 30) ;
         fLine( 50, 0,  70, 50) ;

         fLine( 40, 30,   90, 30) ;
         fLine( 40, 30,   60, 80) ;

         fLine( 20, 50,  70, 50) ;
         fLine( 20, 50,  60, 80) ;

         fLine( 90, 30, 110, 80) ;
         fLine( 70, 50, 110, 80) ;
         fLine( 60, 80, 110, 80) ;

         fTeXlabel( 10, 43, "br", "$\\va$") ;
         fTeXlabel( 48, 16, "br", "$\\vb$") ;
         fTeXlabel( 50, -13, "br", "$\\vc$") ;
     }
}

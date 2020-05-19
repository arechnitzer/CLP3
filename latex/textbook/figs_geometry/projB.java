                  /*  File:  projB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class projB extends Template {

     static {templateClass = new projB() ; }

     public void setup() {
          filePrefix = "projB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -15 ;
          xmax = 85 ;
          ymin = -25 ;
          ymax = 75 ;
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
         fRotate(30*Math.PI/180.0) ;
         fArrow( 50, 0, 100, 0) ;
         fArrow( 50, 0, 20, 50) ;
         fDisk(50,0, 2, 2, FILLED) ;

         fLine( 20, 50, 20, 0) ;
         fLine( 20, 5,  15, 5) ;
         fLine( 15, 5, 15, 0) ;

         canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
         fLine( 50, 0,    -10, 0) ;
         canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

         fEnv("lineWidth", 1) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("psFillColor", Red) ;
         fEnv("useColorPs", "true") ;
         fArrow( 50, 0, 20, 0) ;

         fTeXlabel(   25,  50, "bl",  "$\\va$") ;
         fTeXlabel(   95, -3, "tl",  "$\\vb$") ;
         fTeXlabel(   26,  -1, "tl",  "$\\text{proj}_{\\vb}\\,\\va$"  ) ;
         fTeXlabel(   55,  8, "cc",  "$\\theta$") ;
     }
}

                  /*  File:  distance.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class distance extends Template {

     static {templateClass = new distance() ; }

     public void setup() {
          filePrefix = "distance" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -5 ;
          xmax = 100 ;
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
         fRotate( 30*Math.PI/180.0) ;
         fLine( -50, 0, 75, 0) ;
         fTeXlabel(-10, 2,  "br",  "$\\vn\\cdot\\vx=c$") ;
//         fArrow( 0, 0, 50, 50) ;
         fLine( 50, 50,  50, -50) ;
         fDisk(50,-30, 2, 2, FILLED) ;
         fTeXlabel(48, -30,  "tr",  "$\\vp$") ;


         fLine( 50, 5,  55, 5) ;
         fLine( 55, 5, 55, 0) ;

         fEnv("lineWidth", 1) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("psFillColor", Blue) ;
         fEnv("useColorPs", "true") ;
         fArrow( 50, 0, 50, 40) ;
         fTeXlabel(48, 38,  "tr",  "$\\vn$") ;

     }
}

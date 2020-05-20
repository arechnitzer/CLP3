                  /*  File:  threedPlane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class threedPlane extends Template {

     static {templateClass = new threedPlane() ; }

     public void setup() {
          filePrefix = "threedPlane" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -75 ;
          xmax = 125 ;
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
         fEnv("lineWidth", 0.5) ;
         fRotate(-20*Math.PI/180.0) ;
         fLine(0, 0, 100, 0) ;
         fLine(100, 0,   100, 40) ;
         fLine(0, 30,      0, 40) ;
         fLine(0, 40,    100, 40) ;

         fLine(0, 0,   -10, 30 ) ;
         fLine(100, 0,   90, 30) ;
         fLine(-10, 30,   90, 30) ;

         fLine(0, 0, -30, -10) ;
         fLine(100, 0, 70, -10) ;
         fLine( -30, -10, 70, -10) ;

         fLine(-10, -10, -25, -25) ;
         fLine(-25, -25,  75, -25) ;
         fLine(75, -25,  100, 0) ;

         fDisk(100, 0, 3, 3, FILLED) ;
         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fArrow(100, 0,    50, 0) ;

         fTeXlabel(100, -3, "tl", "$(x_0,y_0,z_0)$") ;
         fTeXlabel(60, 8,  "br", "$\\vd$") ;
     }
}

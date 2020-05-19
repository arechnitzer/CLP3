                  /*  File:  vector3d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class vector3d extends Template {

     static {templateClass = new vector3d() ; }

     public void setup() {
          filePrefix = "vector3d" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -60 ;
          xmax = 180 ;
          ymin = -80 ;
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
         fLine(0, 0,   0, 100) ;
         fLine(0, 0,   100, 0) ;
         fLine(0, 0,   -50, -70) ;

         fEnv("lineWidth", 0.8) ;
         fLine(0, 0, -25, -35) ;
         fLine(-25, -35,   50, -35) ;
         fLine(50, -35,    50, 75) ;
         canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
         fLine(50, -35,    75, 0) ;
         canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

         fDisk( 50, 75,  3, 3, FILLED) ;

         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         fEnv("useColorPs", "true") ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("psFillColor", Red) ;
         fArrow(0, 0,  50, 75) ;


         fTeXlabel(55, 75, "lc", "$(a,b,c)$") ;
         fTeXlabel(-15, -10, "rc", "$a$") ;
         fTeXlabel(12.5, -40, "tc", "$b$") ;
         fTeXlabel(55, 35, "lc", "$c$") ;

         fTeXlabel(-53, -75, "rt", "$x$") ;
         fTeXlabel(105, 0, "lc", "$y$") ;
         fTeXlabel(0, 105, "bc", "$z$") ;          
     }
}

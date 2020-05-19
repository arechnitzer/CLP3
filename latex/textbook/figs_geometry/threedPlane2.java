                  /*  File:  threedPlane2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class threedPlane2 extends Template {

     static {templateClass = new threedPlane2() ; }

     public void setup() {
          filePrefix = "threedPlane2" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*1.5 ;      // in inches
          ysize = 1*1.5 ;   // in inches. 
          xmin = 0 ;
          xmax = 200 ;
          ymin = 0 ;
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
         fRotate(10*Math.PI/180.0) ;
         fLine(0, 0,   150, 0) ;
         fLine(0, 0,    50, 50) ;
         fLine(50, 50,   200, 50) ;
         fLine(150, 0,   200, 50) ;

         fDisk( 40, 20, 2, 2, FILLED) ;
         fDisk( 100, 30, 2, 2, FILLED) ;
         fLine( 40, 29,  49, 31.5) ;
         fLine(49, 31.5, 49, 21.5) ;

         fTeXlabel(43, 20, "lt", "$(x_0,y_0,z_0)$") ;
         fTeXlabel(100, 45, "lt", "$(x,y,z)$") ;
         fTeXlabel(35, 53, "rc", "$\\vn$") ;
         fEnv("lineWidth", 1.0) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         fArrow(40, 20,  100, 30) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fArrow(40, 20, 40, 60) ;
     }
}

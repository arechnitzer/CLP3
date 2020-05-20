                  /*  File:  crossRR.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class crossRR extends Template {

     static {templateClass = new crossRR() ; }

     public void setup() {
          filePrefix = "crossRR" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 1 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -50 ;
          ymax =  50;
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
         fRotate(-45*Math.PI/180.0) ;
         fLine(-35,-13, -35+1.7*40,-13+1.7*30) ;

         fEllipticalArc(0, 0, 15, 10, -275, 20, OPEN ) ;
         fArrowhead(3,  -6.2, 28) ;
         fTeXlabel(59, 0, "cc", "$\\va$") ;
         fTeXlabel(51, 30, "cc", "$\\vb$") ;
         fTeXlabel(-16, 55, "cc", "$\\va\\times\\vb$") ;

         String Red = "0 1 1 0 setcmykcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fEnv("psFillColor", Red) ;
         fEnv("useColorPs", "true") ;
         fEnv("lineWidth", 1.0) ;
         fArrow(0, 0,    50, 0) ;
         fArrow(0, 0,    40, 30) ;
         fArrow(0, 0,    -8, 50) ;



         fEnv("lineWidth", 0.5) ;
         canvas.append( new fPsWrite(Black+"\n")) ;
         fLine(-35,-13, 60,-13) ;


     }
}

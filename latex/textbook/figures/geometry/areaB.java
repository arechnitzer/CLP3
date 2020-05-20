                  /*  File:  areaB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class areaB extends Template {

     static {templateClass = new areaB() ; }

     public void setup() {
          filePrefix = "areaB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
          xmin =  0 ;
          xmax = 65 ;
          ymin =  0 ;
          ymax = 65 ;
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
         fArrow(0, 0, 50, 0) ;
         fArrow(0, 0, 20, 40) ;
         fArrow(50, 0,  70, 40) ;
         fArrow(20, 40, 70, 40) ;
         fLine(20,0, 20,40) ;
         fEllipticalArc(0, 0, 7, 7, 10, 70, OPEN ) ;
         fTeXlabel(35, -6, "cc", "$\\va$") ;
         fTeXlabel(55, 47, "cc", "$\\va$") ;
         fTeXlabel(7, 30, "cc", "$\\vb$") ;
         fTeXlabel(71, 24, "cc", "$\\vb$") ;
         fTeXlabel(11, 7.5, "cc", "$\\theta$") ;
         canvas.append( new fPsWrite("0.7 setgray\n")) ;
         fLine(20,0, 20,40) ;
         fLine(20,5, 25,5) ;
         fLine(25,5, 25,0) ;


     }
}

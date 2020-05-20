                  /*  File:  polar5e1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5e1 extends Template {

     static {templateClass = new polar5e1() ; }

     public void setup() {
          filePrefix = "polar5e1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
          ymin = -0.2 ;
          ymax =  2.4 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.9) ;
          double sq2 = Math.sqrt(2) ;
          fEllipticalArc(1,0, 1,1, 0,180, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fTeXlabel(1, 1.05, "bc", "$\\scriptstyle (x-1)^2+y^2=1$") ;
          fTeXlabel(1, 0.5, "cc", "$\\cR$") ;

             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(1,0, 1,1, 0,180,  OPEN) ;
          fLine(0,0,  2,0) ;

          
     }
}

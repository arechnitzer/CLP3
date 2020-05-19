                  /*  File:  OE13D_7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE13D_7 extends Template {

     static {templateClass = new OE13D_7() ; }

     public void setup() {
          filePrefix = "OE13D_7" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4 ;      // in inches
          ysize = 1.4 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.6 ;
          ymax = 0.8 ;
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
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0.5,0, 0.5,0.5, 0,360, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fTeXlabel(0.85, 0.35, "bl", "$x^2+y^2=ax$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0.5,0, 0.5,0.5, 0,360, OPEN) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(0.5, 0, r, r, FILLED) ;
          fTeXlabel(0.5, 0.05, "bc", "$\\scriptstyle (a/2,0)$") ;          
     }
}

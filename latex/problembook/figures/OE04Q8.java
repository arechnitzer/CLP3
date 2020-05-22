                  /*  File:  OE04Q8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE04Q8 extends Template {

     static {templateClass = new OE04Q8() ; }

     public void setup() {
          filePrefix = "OE04Q8" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 9*0.15 ;  
          ysize = 13*0.15 ;   
          xmin = -0.1 ;
          xmax = 0.8 ;
          ymin = -0.1 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fEllipticalArc(0, 0, 0.2, 0.2, 60, 90, OPEN) ;

          fTeXlabel(xmax, -0.04, "tr", "$r$") ;
          fTeXlabel(-0.02, ymax, "tr", "$z$") ;

          double th = Math.PI/6.0 ;
          double x = Math.sin(th) ;
          fLine(x, 0, x, -0.06) ;
          fTeXlabel(x, -0.08, "tc", "$\\frac{3}{2}$") ;

          fEnv("lineWidth", 4.0) ;
          fEnv("psGray", 0.7) ;
          double r = 0.3 ;
          fLine(r, Math.sqrt(3)*r, r, Math.sqrt(1-r*r)) ;
          fEnv("psGray", 0.0) ;


          fEnv("lineWidth", 2.0) ;
          r = 1 ;
          fLine(0, 0, 0, r) ;
          fLine(0, 0, r*Math.cos(2*th), r*Math.sin(2*th) ) ;
          fEllipticalArc(0, 0, r, r, 60, 90, OPEN) ;
          
          fTeXlabel(0.035,0.25, "bl", "$\\frac{\\pi}{6}$") ;
          fTeXlabel(0.3,0.47, "cl", "$z=\\sqrt{3}\\,r$") ;
          fTeXlabel(0.2, 1.01, "bl", "$z^2+r^2=9$") ;

          
     }
}

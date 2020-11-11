                  /*  File:  astroid4.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroid4 extends Template {

     static {templateClass = new astroid4() ; }

     public void setup() {
          filePrefix = "astroid4" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0, ymin,0, ymax) ;
          fTeXlabel(xmax, -6, "tr", "$x$") ;
          fTeXlabel(-1.5, ymax, "tr", "$y$") ;
          fTeXlabel(-20, 40, "br", "$x^{2/3}+y^{2/3}=a^{2/3}$") ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[80*cos(t)*cos(t)*cos(t) , 80*sin(t)*sin(t)*sin(t)]", 1, 0, 2*Math.PI,                   OPEN) ;

          fTeXlabel(75, 5, "bl", "$t=0$") ;
          fTeXlabel(-75, -5, "tr", "$t=\\pi$") ;
          fTeXlabel(5, 80, "cl", "$t=\\pi/2$") ;
          fTeXlabel(5, -80, "cl", "$t=3\\pi/2$") ;



     }
}

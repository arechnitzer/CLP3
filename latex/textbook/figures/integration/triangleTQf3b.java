                  /*  File:  triangleTQf3b.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleTQf3b extends Template {

     static {templateClass = new triangleTQf3b() ; }

     public void setup() {
          filePrefix = "triangleTQf3b" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.6 ;      // in inches
          ysize = 0.7 ;   // in inches. 
          xmin = -1 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 6 ;
          topmargin = 0 ;   // in inches
          bottommargin = -0.1 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
     


     double angle = Math.atan2(4, 5) ; double angleDeg = angle*180/Math.PI ;
     double r = 1.5 ;
     double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ;
     double x = 5 ;
     double y = x*Math.tan(angle) ;

     fEnv("lineWidth", 0.5) ;
     fLine(0, 0, x, 0) ;
     fLine(0, 0, x, y) ;
     fLine(x, 0,  x, y) ;
     fEllipticalArc(0, 0, r/aspect, r, 0, angleDeg, OPEN) ;

     fTeXlabel(1.6,0.3, "bl", "$u$") ;
     fTeXlabel(x/2+0.1, -0.4, "tc", "$3$") ;
     fTeXlabel(x+0.2, y/2, "lc", "$\\sqrt{x^2-9}$") ;
     fTeXlabel(x/2-0.1, y/2+0.2, "br", "$x$") ;
          
     }
}

                  /*  File:  triangleApple.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class triangleApple extends Template {

     static {templateClass = new triangleApple() ; }

     public void setup() {
          filePrefix = "triangleApple" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0 ;      // in inches
          ysize = 1.0 ;   // in inches. 
          xmin = -1 ;
          xmax = 5 ;
          ymin = -1 ;
          ymax = 5 ;
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
//     double y = x*Math.tan(angle) ;
     double y = 4 ;

     fEnv("lineWidth", 0.5) ;
     fLine(0, 0, x, 0) ;
     fLine(0, 0, x, y) ;
     fLine(x, 0,  x, y) ;
     fEllipticalArc(0, 0, r/aspect, r, 0, angleDeg, OPEN) ;

     fTeXlabel(1.6,0.4, "bl", "$\\alpha$") ;
     fTeXlabel(x/2+0.1, -0.4, "tc", "$\\sqrt{a^2-b^2}$") ;
     fTeXlabel(x+0.2, y/2, "lc", "$b$") ;
     fTeXlabel(x/2+0.1, y/2+0.2, "br", "$a$") ;
          
     }
}

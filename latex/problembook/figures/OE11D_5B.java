                  /*  File:  OE11D_5B.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE11D_5B extends Template {

     static {templateClass = new OE11D_5B() ; }

     public void setup() {
          filePrefix = "OE11D_5B" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 1.4 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1.8 ;
          ymin = -0.2 ;
          ymax = 1.2 ;
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
          fEllipticalArc(0,0, sq2, sq2, 0, 45, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEllipticalArc(0,0, sq2, sq2, -90, 90, OPEN) ;
//          fTeXlabel(1.4, ymin-0.05, "tc", "$\\scriptstyle x^2+y^2=2$") ;
          fTeXlabel(1.4, ymin-0.05, "tc", "$x^2+y^2=2$") ;
          fLine(0,0, ymax,ymax) ;
//          fTeXlabel(ymax+0.05, ymax, "tl", "$\\scriptstyle y=x$") ;
          fTeXlabel(ymax+0.05, ymax, "tl", "$y=x$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(0, 0, 1, 1) ;
          fLine(0, 0, sq2, 0) ;
          fEllipticalArc(0,0, sq2, sq2, 0, 45, OPEN) ;
          
     }
}

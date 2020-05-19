                  /*  File:  lagrangeCC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class lagrangeCC extends Template {

     static {templateClass = new lagrangeCC() ; }

     public void setup() {
          filePrefix = "lagrangeCC" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -1.6 ;
          xmax = 1.6 ;
          ymin = -1.6 ;
          ymax = 1.6 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.1, 0, "cl", "$x$") ;
          fTeXlabel(0, ymax+0.2, "bc", "$y$") ;
          fEnv("lineWidth", 0.8) ;
          double S=1/Math.sqrt(2) ;
//        fCurve("[cos(t)+"+S+"*sin(t), cos(t)-"+S+"*sin(t)]", 1, 0, 2*Math.PI, CLOSED) ;
          fEnv("psFillGray", 0.6) ;
          double r = 0.06 ;
          double x = 1 ; double y = 1 ;
          fDisk(x, y, r, r, FILLED) ;
          fDisk(-x, -y, r, r, FILLED) ;
          fTeXlabel(1.05*x, 1.05*y, "bl", "$\\scriptstyle (1,1)$") ;
          fTeXlabel(-1.05*x, -1.05*y, "tr", "$\\scriptstyle (-1,-1)$") ;

          x = S ; y = S ;
          fDisk(x, -y, r, r, FILLED) ;
          fDisk(-x, y, r, r, FILLED) ;
          fTeXlabel(1.05*x, -1.05*y, "tl", "$\\scriptstyle (1,-1)/\\sqrt{2}$") ;
          fTeXlabel(-1.05*x, 1.05*y, "br", "$\\scriptstyle (-1,1)/\\sqrt{2}$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
//          fLine(1,1, -1,-1) ;
//          fLine(S,-S,  -S,S) ;

//          fTeXlabel(0, ymin, "tc", "$3x^2-2xy+3y^2=4$") ;

     }
}

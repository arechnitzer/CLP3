                  /*  File:  polar6a1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar6a1 extends Template {

     static {templateClass = new polar6a1() ; }

     public void setup() {
          filePrefix = "polar6a1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 3.4*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
          ymin = -1.7 ;
          ymax =  1.7 ;
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


          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2 ;
          double r1 = 0.83*r ;
          double r2 = 0.73*r ;

          fEllipticalArc(0,0, 2,2, -45,45, WEDGE+FILLED) ;

          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r1, r1, -45,45, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, r2, r2, -45,45, WEDGE+FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(0,0, r1, r1, -45,45, OPEN) ;
          fEllipticalArc(0,0, r2, r2, -45,45, OPEN) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, 1,1, -60,60, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
//          fLine(0,0, xmax, xmax) ;
          fEllipticalArc(0,0, 2,2, -60,60, OPEN) ;
          fEllipticalArc(0,0, 1,1, -60,60, OPEN) ;
          double x = 1.7 ;
          fLine(0,0, x,x) ;
          fLine(0,0, x,-x) ;

//          fTeXlabel(1.95, 0.75, "cl", "$\\scriptstyle r=2$") ;
          fTeXlabel(1.95, 0.75, "cl", "$r=2$") ;
          fTeXlabel(0.9, 0.23, "cr", "$\\scriptstyle r=1$") ;
//          fTeXlabel(0.9, 0.23, "cr", "$r=1$") ;
//          fTeXlabel(x,  x, "cl", "$\\scriptstyle \\theta=\\nicefrac{\\pi}{4}$") ;
//          fTeXlabel(x, -x, "cl", "$\\scriptstyle \\theta=-\\nicefrac{\\pi}{4}$") ;
          fTeXlabel(x+0.05,  x, "cl", "$\\theta=\\nicefrac{\\pi}{4}$") ;
          fTeXlabel(x+0.05, -x, "cl", "$\\theta=-\\nicefrac{\\pi}{4}$") ;

          fEnv("lineWidth",2.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, 2,2, -45,45, OPEN) ;
          fEllipticalArc(0,0, 1,1, -45,45, OPEN) ;
          fLine(sq2, sq2, 1/sq2, 1/sq2) ;
          fLine(sq2,-sq2, 1/sq2,-1/sq2) ;

          
     }
}

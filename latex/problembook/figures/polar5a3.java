                  /*  File:  polar5a3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5a3 extends Template {

     static {templateClass = new polar5a3() ; }

     public void setup() {
          filePrefix = "polar5a3" ;    
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
          fEllipticalArc(0,0, 2,2, 0,45, WEDGE+FILLED) ;

          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2 ;
          double r1 = 0.83*r ;
          double r2 = 0.73*r ;

          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r1, r1, 0,45, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, r2, r2, 0,45, WEDGE+FILLED) ;
//          fEnv("psFillGray", 1.0) ;
//          fEllipticalArc(0,0, sq2,sq2, 0,45, WEDGE+FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(0,0, r1, r1, 0,45, OPEN) ;
          fEllipticalArc(0,0, r2, r2, 0,45, OPEN) ;



          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fEllipticalArc(0,0, 2,2, 0,60, OPEN) ;
//          fEllipticalArc(0,0, sq2,sq2, -30,45, OPEN) ;


          fTeXlabel(0.95, 1.75, "cr", "$r=2$") ;
          fTeXlabel(xmax+0.05, xmax, "cl", "$\\theta=\\frac{\\pi}{4}$") ;
//          double thRad = 22.5*Math.PI/180 ;
//          double x = 1.3*Math.cos(thRad) ; 
//          double y = 1.3*Math.sin(thRad) ; 
//          fTeXlabel(x, y, "cc", "$\\cR$") ;


          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0,45, OPEN) ;
//          fEllipticalArc(0,0, sq2,sq2, 0,45, OPEN) ;
          fLine(0,0, sq2,sq2) ;
          fLine(0,0,  2,0) ;

          
     }
}

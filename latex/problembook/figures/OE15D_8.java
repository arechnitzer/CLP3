                  /*  File:  OE15D_8.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE15D_8 extends Template {

     static {templateClass = new OE15D_8() ; }

     public void setup() {
          filePrefix = "OE15D_8" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6*0.2 ;      // in inches
          ysize = 7*0.2 ;   // in inches
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
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
          fTeXlabel(-0.05, ymax, "tr", "$z$") ;
          fTeXlabel(xmax, -0.05, "tr", "$r$") ;

          double th1 = 30 ; double th1Rad = th1*Math.PI/180 ;
          double th2 = 35 ; double th2Rad = th2*Math.PI/180 ;


          fEnv("psFillGray", 0.9) ;
          fCurve("[t, t*t*t]",1, 0,1, FILLED) ;
          fLine(0,0, xmax,xmax) ;
          fCurve("[t, t*t*t]",1, 0,xmax, OPEN) ;

          fEnv("lineWidth", 1.0) ;
          fLine(0,0, 1,1) ;
          fCurve("[t, t*t*t]",1, 0,1, OPEN) ;


          double x = 0.7; double y = x*x*x ;
          double th = Math.atan(y/x)*180/Math.PI ; 
          double r = 0.2 ;
          fEllipticalArc(0,0, r,r, th,90, OPEN) ;
          fTeXlabel(0.3*r,r, "bl", "$\\varphi$") ;
          fEnv("lineWidth", 2.0) ;
          fLine(0,0, x,y) ;



          x = 0.8 ;
          fTeXlabel(x+0.03, x*x*x, "cl",    "$z=r^2$") ;
          fTeXlabel(ymax+0.03, ymax, "tl",    "$z=r$") ;

     }
}

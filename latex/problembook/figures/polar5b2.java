                  /*  File:  polar5b2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5b2 extends Template {

     static {templateClass = new polar5b2() ; }

     public void setup() {
          filePrefix = "polar5b2" ;    
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
          fEllipticalArc(0,0, 2,2, 0,90, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, 1,1, 0,90, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
//          fLine(0,0, xmax, xmax) ;
          fEllipticalArc(0,0, 2,2, -30,120, OPEN) ;
          fEllipticalArc(0,0, 1,1, -30,120, OPEN) ;


          fTeXlabel(-0.25, 2.0, "cr", "$\\scriptstyle r=2$") ;
          fTeXlabel(1, -0.25, "tc", "$\\scriptstyle r=1$") ;
//          fTeXlabel(xmax+0.05, xmax, "cl", "$y=x$") ;

          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
          double r = 2 ;             

          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          double r1 = 0.83*r ;
          double r2 = 0.73*r ;
          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r2, r2, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, 1,1, th,th+dth, WEDGE+FILLED) ;
          double x = 2*Math.cos(thRad) ; double y = 2*Math.sin(thRad) ; 
          fLine(0,0, x,y) ;
          x = 2*Math.cos(thRad+dthRad) ; y = 2*Math.sin(thRad+dthRad) ; 
          fLine(0,0, x,y) ;
//          fEllipticalArc(0,0, r,r, th,th+dth, OPEN) ;

          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0,90, OPEN) ;
          fEllipticalArc(0,0, 1,1, 0,90, OPEN) ;
          fLine(0,1, 0,2) ;
          fLine(1,0, 2,0) ;

          
     }
}

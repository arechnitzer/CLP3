                  /*  File:  polar5a1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5a1 extends Template {

     static {templateClass = new polar5a1() ; }

     public void setup() {
          filePrefix = "polar5a1" ;    
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
//          fEnv("psFillGray", 1.0) ;
//          fEllipticalArc(0,0, sq2,sq2, 0,45, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fLine(0,0, xmax, xmax) ;
          fEllipticalArc(0,0, 2,2, 0,60, OPEN) ;
//          fEllipticalArc(0,0, sq2,sq2, -30,45, OPEN) ;


          fTeXlabel(1.18, 1.85, "cr", "$\\scriptstyle x^2+y^2=4$") ;
//          fTeXlabel(sq2-0.25, -0.25, "tc", "$\\scriptstyle x^2+y^2=2$") ;
          fTeXlabel(xmax+0.05, xmax, "cl", "$y=x$") ;
          double thRad = 22.5*Math.PI/180 ;
          double x = 1.3*Math.cos(thRad) ; 
          double y = 1.3*Math.sin(thRad) ; 
          fTeXlabel(x, y, "cc", "$\\cR$") ;

             

//          double th = 25 ; double thRad = th*Math.PI/180 ;
//          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
//          double r = 2 ;
// 
//          fEnv("psFillGray", 0.6) ;
//          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
//          fEnv("psFillGray", 0.3) ;
//          fEllipticalArc(0,0, 0.93*r,0.93*r, th,th+dth, WEDGE+FILLED) ;
//          fEnv("psFillGray", 0.6) ;
//          fEllipticalArc(0,0, 0.83*r,0.83*r, th,th+dth, WEDGE+FILLED) ;
//          fEnv("psFillGray", 1.0) ;
//          fEllipticalArc(0,0, sq2,sq2, th-5,th+dth+5, WEDGE+FILLED) ;
//          double x = sq2*Math.cos(thRad) ; double y = sq2*Math.sin(thRad) ; 
//          fLine(0,0, x,y) ;
//          x = sq2*Math.cos(thRad+dthRad) ; y = sq2*Math.sin(thRad+dthRad) ; 
//          fLine(0,0, x,y) ;

          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0,45, OPEN) ;
//          fEllipticalArc(0,0, sq2,sq2, 0,45, OPEN) ;
          fLine(0,0, sq2,sq2) ;
          fLine(0,0,  2,0) ;

          
     }
}

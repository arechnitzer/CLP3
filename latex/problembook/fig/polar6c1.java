                  /*  File:  polar6c1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar6c1 extends Template {

     static {templateClass = new polar6c1() ; }

     public void setup() {
          filePrefix = "polar6c1" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.6*0.4 ;      // in inches
          ysize = 2.8*0.4 ;   // in inches. 
          xmin = -3.2 ;
          xmax =  3.4 ;
          ymin = -1.2 ;
          ymax =  1.6 ;
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
          fEllipticalArc(0,0, 3,1, 0,360, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fTeXlabel(1, 1.03, "bc", "$\\scriptstyle x^2+9y^2=9$") ;
//          fTeXlabel(1, 0.5, "cc", "$\\cR$") ;

          double th = 42 ; double thRad = th*Math.PI/180 ;
          double dth =15 ;  double dthRad = dth*Math.PI/180 ;
          double c1 = Math.cos(thRad) ; 
          double s1 = Math.sin(thRad) ; 
          double c2 = Math.cos(thRad-dthRad) ; 
          double s2 = Math.sin(thRad-dthRad) ; 
          double T1 = Math.atan(s1/(3*c1))*180/Math.PI ;
          double T2 = Math.atan(s2/(3*c2))*180/Math.PI ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 3,1, th-dth,th, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          double r1 = 2 ;
          double r2 = 1.75 ;
          fEllipticalArc(0,0, r1, r1, T2,T1, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r2, r2, T2,T1, WEDGE+FILLED) ;

             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, 3,1, 0,360,  OPEN) ;

          
     }
}

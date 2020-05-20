                  /*  File:  polar5e3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5e3 extends Template {

     static {templateClass = new polar5e3() ; }

     public void setup() {
          filePrefix = "polar5e3" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.8 ;
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
          fEllipticalArc(1,0, 1,1, 0,180, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fTeXlabel(1, 1.08, "bc", "$\\scriptstyle r=2\\cos\\theta$") ;
//          fTeXlabel(1, 0.5, "cc", "$\\cR$") ;

 
          double r1 = 1 ;
          double r2 = 0.83 ;
          double thRad1 = Math.acos(r1/2.0) ; double th1 = thRad1*180/Math.PI ;
          double thRad2 = Math.acos(r2/2.0) ; double th2 = thRad2*180/Math.PI ;
          double th = 20 ; 
          double dth = 12 ;


          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r1, r1, 0,th1, WEDGE+FILLED) ;
          fEllipticalArc(1,0,  1,  1, 2*th1,2*th2, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, r1, r1, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, r2, r2, 0,th2, WEDGE+FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fEllipticalArc(0,0, r1, r1, 0,90, OPEN) ;
          fEllipticalArc(0,0, r2, r2, 0,90, OPEN) ;
             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(1,0, 1,1, 0,180,  OPEN) ;
          fLine(0,0,  2,0) ;

          double rr = 0.07 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(2,0, rr,rr, FILLED) ;
          fTeXlabel(2.05,0.05, "bl", "$(2,0)$") ;

          
     }
}

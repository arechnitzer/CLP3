                  /*  File:  polarA.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polarA extends Template {

     static {templateClass = new polarA() ; }

     public void setup() {
          filePrefix = "polarA" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = 0.0 ;
          xmax = 1 ;
          ymin = 0.0 ;
          ymax = 1 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double r1 = 0.8 ;
          double r2 = 1.0 ;
          double th1 = 10 ; double th1Rad = th1*Math.PI/180.0 ;
          double th2 = 30 ; double th2Rad = th2*Math.PI/180.0 ;


          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
//          fEnv("useColorPs", "true") ;
//          fEnv("psFillColor", Red) ;

          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, r2, r2, th1, th2, WEDGE+FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,0, r1, r1, th1, th2, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
          fLine(0,0, r2*Math.cos(th1Rad), r2*Math.sin(th1Rad) ) ;
          fLine(0,0, r2*Math.cos(th2Rad), r2*Math.sin(th2Rad) ) ;
          fEllipticalArc(0,0, r2, r2, 0, 45, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(r1*Math.cos(th1Rad), r1*Math.sin(th1Rad), 
                       r2*Math.cos(th1Rad), r2*Math.sin(th1Rad) ) ;
          fLine(r1*Math.cos(th2Rad), r1*Math.sin(th2Rad), 
                       r2*Math.cos(th2Rad), r2*Math.sin(th2Rad) ) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(0,0, r1, r1, th1, th2, OPEN) ;
          fEllipticalArc(0,0, r2, r2, th1, th2, OPEN) ;

          fTeXlabel(0.2, 0.06, "bl", "$\\scriptstyle\\dee{\\phi}$") ;
          fTeXlabel(0.87*r2*Math.cos(0.9*th1Rad), 0.87*r2*Math.sin(0.9*th1Rad), "tl",
                              "$\\scriptstyle\\dee{\\rho}$") ;
          fTeXlabel(0.5*r2*Math.cos(1.05*th2Rad), 0.5*r2*Math.sin(1.05*th2Rad), "br",
                              "$\\rho$") ;
          double th3Rad = 0.5*th1Rad+0.5*th2Rad ;
          fTeXlabel(1.05*r2*Math.cos(th3Rad), 1.05*r2*Math.sin(th3Rad), "cl",
                              "$\\rho\\,\\dee{\\phi}$") ;

          
     }
}

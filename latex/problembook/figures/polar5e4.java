                  /*  File:  polar5e4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar5e4 extends Template {

     static {templateClass = new polar5e4() ; }

     public void setup() {
          filePrefix = "polar5e4" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.5 ;      // in inches
          ysize = 2.0*0.5 ;   // in inches. 
          xmin = -0.2 ;
          xmax =  2.4 ;
          ymin = -0.2 ;
          ymax =  1.8 ;
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

          double th = 32 ; double thRad = th*Math.PI/180 ;
          double r = 2*Math.cos(thRad) ;
          double x = r*Math.cos(thRad) ; double y = r*Math.sin(thRad) ; 
          fLine(0,0, x,y) ;
          double rr = 0.07 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(x,y, rr,rr, FILLED) ;
          fEllipticalArc(0,0, 0.4,0.4, 0,th, OPEN) ;
//          fTeXlabel(0.45, 0.05, "bl", "$\\scriptstyle \\theta$") ;
//          fTeXlabel(x/2, y/2, "br", "$\\scriptstyle r$") ;
          fTeXlabel(0.5, 0.05, "bl", "$\\theta$") ;
          fTeXlabel(0.6*x, 0.6*y, "br", "$r$") ;

             
          fEnv("lineWidth",1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEllipticalArc(1,0, 1,1, 0,180,  OPEN) ;
          fLine(0,0,  2,0) ;

          
     }
}

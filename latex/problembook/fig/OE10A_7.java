                  /*  File:  OE10A_7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10A_7 extends Template {

     static {templateClass = new OE10A_7() ; }

     public void setup() {
          filePrefix = "OE10A_7" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.3*1.6 ;      // in inches
          ysize = 1.3*1.6 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.2 ;
          ymin = -0.1 ;
          ymax = 1.2 ;
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
          fEnv("psFillGray", 0.8) ;
          fEllipticalArc(0,0, 1,1, 0, 90, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fEllipticalArc(0,0, 1,1, -30, 120, OPEN) ;

          fTeXlabel(0.76,0.75, "cl", "$r=1$") ;
          fTeXlabel(0.4,0.5, "cc", "$P$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 1,1, 0, 90, OPEN) ;



          double th = 25 ; double thRad = th*Math.PI/180 ;
          double dth = 7 ;  double dthRad = dth*Math.PI/180 ;
          double r = 1 ;
 
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, r,r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.3) ;
          fEllipticalArc(0,0, 0.8*r,0.8*r, th,th+dth, WEDGE+FILLED) ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,0, 0.68*r,0.68*r, th,th+dth, WEDGE+FILLED) ;
        
     }
}

                  /*  File:  OE10A_5p.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10A_5p extends Template {

     static {templateClass = new OE10A_5p() ; }

     public void setup() {
          filePrefix = "OE10A_5p" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.6 ;      // in inches
          ysize = 1.4*1.6 ;   // in inches. 
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
          fEnv("psFillGray", 0.8) ;
          double th1Rad = Math.atan(0.5) ; double th1 = th1Rad*180/Math.PI ;
          double x1 = Math.cos(th1Rad) ;  double y1 = Math.sin(th1Rad) ;
          double th2Rad = Math.atan(2.0) ; double th2 = th2Rad*180/Math.PI ;
          double x2 = Math.cos(th2Rad) ;  double y2 = Math.sin(th2Rad) ;
          fEllipticalArc(0,0, 1,1, th1, th2, WEDGE+FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fEllipticalArc(0,0, 1,1, -30, 120, OPEN) ;

          fTeXlabel(0.76,0.75, "cl", "$r=1$") ;

          fLine(0,0, xmax,xmax/2) ;
          fTeXlabel(xmax+0.03,xmax/2, "cl", "$\\theta=\\arctan\\frac{1}{2}$") ;
          
          fLine(0,0, ymax/2,ymax) ;
          fTeXlabel(ymax/2+0.03,ymax, "cl", "$\\theta=\\arctan 2$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 1,1, th1, th2, OPEN) ;
          fLine(0,0, x1,y1) ;
          fLine(0,0, x2,y2) ;



          double th = 35 ; double thRad = th*Math.PI/180 ;
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

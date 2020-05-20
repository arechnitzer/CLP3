                  /*  File:  OE10D_6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_6 extends Template {

     static {templateClass = new OE10D_6() ; }

     public void setup() {
          filePrefix = "OE10D_6" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.2*0.8 ;      // in inches
          ysize = 1.8*0.8 ;   // in inches. 
          xmin = -1.6 ;
          xmax = 1.6 ;
          ymin = -0.2 ;
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
          double sq6 = Math.sqrt(6) ;
          double sq2 = Math.sqrt(2) ;
          double thRad = Math.atan(1/sq2) ; double th = thRad*180/Math.PI ;
          fEllipticalArc(0,0, sq2,sq2, 45, 135, FILLED) ;
          fCurve("[t, t*t]",1, -1,1, FILLED) ;
//          { 
//            double[] xlist = { 0, 1,  2} ;
//            double[] ylist = { 2, 0,  0} ;
//            fPolygon(xlist, ylist, 3, FILLED) ;
//           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;

          fEllipticalArc(0,0, sq2,sq2, 0, 180, OPEN) ;
          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine(xmin,1,  1,1) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(xmin-0.05, 1, "rc", "$z=1$") ;
          fTeXlabel(-sq2, 0.2, "br", "$x^2+y^2+z^2=2$") ;
          fTeXlabel(-sq2+0.1, ymax, "tr", "$z=x^2+y^2$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, sq2,sq2, 45, 135, OPEN) ;
          fCurve("[t, t*t]",1, -1,1, OPEN) ;

          double r = 0.04 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(1,1, r,r, FILLED) ;
          fTeXlabel(1.07, 1, "cl", "$\\scriptstyle (1,0,1)$") ;

          
     }
}

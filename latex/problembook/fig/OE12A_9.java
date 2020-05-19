                  /*  File:  OE12A_9.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12A_9 extends Template {

     static {templateClass = new OE12A_9() ; }

     public void setup() {
          filePrefix = "OE12A_9" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.6 ;      // in inches
          ysize = 3.5*0.6 ;   // in inches. 
          xmin = -2.0 ;
          xmax = 2.0 ;
          ymin = -0.5 ;
          ymax =  3.0 ;
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
          fEllipticalArc(0,0, sq6,sq6, 90-th, 90+th, FILLED) ;
          fCurve("[t, t*t]",1, -sq2,sq2, FILLED) ;
//          { 
//            double[] xlist = { 0, 1,  2} ;
//            double[] ylist = { 2, 0,  0} ;
//            fPolygon(xlist, ylist, 3, FILLED) ;
//           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$z$") ;

          fEllipticalArc(0,0, sq6,sq6, 0, 180, OPEN) ;
          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine(xmin,2,  sq2,2) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(xmin-0.05, 2, "rc", "$z=2$") ;
          fTeXlabel(xmin, 1.33, "tr", "$x^2+y^2+z^2=6$") ;
          fTeXlabel(-1.7, ymax+0.02, "br", "$z=x^2+y^2$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, sq6,sq6, 90-th, 90+th, OPEN) ;
          fCurve("[t, t*t]",1, -sq2,sq2, OPEN) ;

          double r = 0.05 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(sq2,2, r,r, FILLED) ;
          fTeXlabel(sq2+0.07, 2+0.07, "cl", "$\\scriptstyle (\\sqrt{2},0,2)$") ;

          
     }
}

                  /*  File:  OE10A_8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10A_8 extends Template {

     static {templateClass = new OE10A_8() ; }

     public void setup() {
          filePrefix = "OE10A_8" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.5 ;      // in inches
          ysize = 3.6*0.5 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -0.2 ;
          ymax =  3.4 ;
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
          double sq3 = Math.sqrt(3) ;
          double thRad = Math.atan(sq3) ; double th = thRad*180/Math.PI ;
          fEllipticalArc(0,0, 3,3, 60, 120, WEDGE+FILLED) ;
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

          fEllipticalArc(0,0, 3,3, 0, 180, OPEN) ;
          fLine(0,0, xmax,sq3*xmax) ;
          fLine(0,0, -xmax,sq3*xmax) ;

//          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
//              fLine(xmin,2,  sq3,2) ;
//          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(xmin+0.03, 2.1, "tr", "$r^2+z^2=9$") ;
          fTeXlabel(ymax/sq3+0.1, ymax, "cl", "$z=\\sqrt{3}\\,r$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 3,3, 60, 120, OPEN) ;
          fLine(0,0, 1.5,1.5*sq3) ;
          fLine(0,0,-1.5,1.5*sq3) ;

          double r = 0.06 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(1.5,1.5*sq3, r,r, FILLED) ;
          fTeXlabel(1.65, 1.5*sq3+0.1, "cl", 
                 "$\\scriptstyle r=\\frac{3}{2},\\ z=\\frac{3\\sqrt{3}}{2}$") ;

          
     }
}

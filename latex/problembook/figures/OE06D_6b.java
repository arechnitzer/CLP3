                  /*  File:  OE06D_6b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06D_6b extends Template {

     static {templateClass = new OE06D_6b() ; }

     public void setup() {
          filePrefix = "OE06D_6b" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*1.3 ;      // in inches
          ysize = 1.4*1.3 ;   // in inches. 
          xmin = -0.8 ;
          xmax = 0.8 ;
          ymin = -0.2 ;
          ymax =  1.2 ;
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
          double thRad = Math.atan(1/sq2) ; double th = thRad*180/Math.PI ;
          fEllipticalArc(0,0, 1,1, 45, 135, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;


          fEllipticalArc(0,0, 1,1, 0, 180, OPEN) ;
          fEllipticalArc(0,0, 0.2,0.2, 45, 90, OPEN) ;
          fTeXlabel(0.05, 0.2, "lb", "$\\frac{\\pi}{4}$") ;

          fLine(0,0, xmax,xmax) ;
          fLine(0,0, -xmax,xmax) ;

//          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
//              fLine(xmin,2,  sq2,2) ;
//          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fTeXlabel(xmin+0.03, 0.57, "tr", "$x^2+y^2+z^2=4$") ;
          fTeXlabel(0.42, 0.4, "tl", "$z=\\sqrt{x^2+y^2}$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 1,1, 45, 135, OPEN) ;
          fLine(0,0, 1/sq2,1/sq2) ;
          fLine(0,0, -1/sq2,1/sq2) ;

//          double r = 0.03 ;
//          fEnv("psFillGray", 0.0) ;
//          fDisk(1/sq2,1/sq2, r,r, FILLED) ;
//          fTeXlabel(1/sq2+0.07, 1/sq2, "cl", 
//                 "$\\scriptstyle (1\\,,\\,0\\,,\\,1)$") ;

          
     }
}

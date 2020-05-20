                  /*  File:  OE13D_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE13D_5 extends Template {

     static {templateClass = new OE13D_5() ; }

     public void setup() {
          filePrefix = "OE13D_5" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      // in inches
          ysize = 2.0 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -2.5 ;
          ymax = 2.5 ;
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
          fEllipticalArc(0,0,2,2,0,30, WEDGE+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fEllipticalArc(0,0,2,2, 0,360, OPEN) ;
          fTeXlabel(-1.5, 1.75, "tr", "$x^2+y^2=4$") ;
          double X=2.5 ;
          double Y=X/Math.sqrt(3) ;
          double r = 0.5 ;
          fLine(0, 0, X, Y) ;
          fEllipticalArc(0,0,r,r, 0,30, OPEN) ;
          fTeXlabel(1.2*r, 0.07, "bl", "$\\scriptstyle \\pi/6$") ;
//          fTeXlabel(1, -0.2, "tc", "$\\scriptstyle 2$") ;
//          fTeXlabel(0.7, 1.8, "bc", "$\\scriptstyle 4$") ;
//          fTeXlabel(2.8, 1.5, "cc", "$D$") ;
          fLine(0, 0, X, Y) ;
          fTeXlabel(X+0.1, Y+0.05, "cl", "$x=\\sqrt{3}\\,y$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0,2,2,0,30, OPEN) ;
          Y=1 ;
          X=Y*Math.sqrt(3) ;
          fLine(0, 0, X, Y) ;
          fLine(0, 0, 2, 0) ;

          fEnv("psFillGray", 0.0) ;
          r = 0.1 ;
          fDisk(X, Y, r, r, FILLED) ;
          fTeXlabel(X+0.2, Y+0.05, "tl", "$\\scriptstyle (\\sqrt{3},1)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          Y = 0.5 ;
          double XR = Math.sqrt(4-Y*Y) ;
          double XL = Math.sqrt(3)*Y ;
          fEnv("lineWidth", 4.0) ;
          fLine(XL,Y, XR,Y) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XR = 1.7 ;
          XL = 1.5 ;
          fLine(XL,Y, XR,Y) ;




          
     }
}

                  /*  File:  OE10D_5a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE10D_5a extends Template {

     static {templateClass = new OE10D_5a() ; }

     public void setup() {
          filePrefix = "OE10D_5a" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.5 ;      // in inches
          ysize = 4.0*0.5 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 4.5 ;
          ymin = -1.5 ;
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
          fCurve("[t*t, t]",1, -1,2, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          fCurve("[t*t, t]",1, ymin,ymax, OPEN) ;
          fTeXlabel(2, Math.sqrt(2), "br", "$x=y^2$") ;
          fCurve("[t, t-2]",1, xmin,xmax, OPEN) ;
          fTeXlabel(3, 0.95, "tl", "$y=x-2$") ;
          fTeXlabel(1.5, 0.6, "cc", "$D$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(1, -1, 4, 2) ;
          fCurve("[t*t, t]",1, -1,2, OPEN) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          fDisk(1, -1, r, r, FILLED) ;
          fDisk(4, 2, r, r, FILLED) ;
          fTeXlabel(1.2, -0.95, "cl", "$\\scriptstyle (1,-1)$") ;
          fTeXlabel(4.05, 1.95, "tl", "$\\scriptstyle (4,2)$") ;

//          canvas.append( new fPsWrite("0.6 setgray\n")) ;
//          double Y = 0.5 ;
//          double XR = Y*Y ;
//          double XL = Y+2 ;
//          fEnv("lineWidth", 6.0) ;
//          fLine(XL,Y, XR,Y) ;
//          canvas.append( new fPsWrite("0.3 setgray\n")) ;
//          XR = 1.65 ;
//          XL = 1.5 ;
//          fLine(XL,Y, XR,Y) ;          
     }
}

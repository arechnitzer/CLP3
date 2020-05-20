                  /*  File:  OE08A_8yh.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08A_8yh extends Template {

     static {templateClass = new OE08A_8yh() ; }

     public void setup() {
          filePrefix = "OE08A_8yh" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.7*2.5 ;      // in inches
          ysize = 0.7*2.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 0.6 ;
          ymin = -0.1 ;
          ymax = 0.6 ;
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
           double Y = 0.5 ; double X = Y*Y ;  double Z=1-Y ;
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { 0, X,    X, 0} ;
            double[] ylist = { 0, 0,    Z,  Z} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }         


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.015, 0, "cl", "$x$") ;
          fTeXlabel(0, ymax+0.015, "cb", "$z$") ;

          fLine(X,ymin,  X, ymax) ;
          fLine(xmin, Z,  X, Z) ;
          fTeXlabel(X, ymax+0.005, "bc", "$x=y^2$") ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.02 ;
          fDisk(X, Z, r, r, FILLED) ;
          fArrow(X+0.15,Z, X+0.02, Z) ;
          fTeXlabel(X+0.28, Y+0.0415, "cc", "$x=y^2$") ;
          fTeXlabel(X+0.28, Y-0.0425, "cc", "$ z=1-y$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { 0, X,    X, 0} ;
            double[] ylist = { 0, 0,    Z,  Z} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           } 


          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double YS = 0.2 ;
          double XL = 0 ;
          double XR = X ;
          fEnv("lineWidth", 7.0) ;
          fLine(XL,YS, XR,YS) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          XL = 0.1 ;
          XR = 0.15 ;
          fLine(XL,YS, XR,YS) ;  
     }
}

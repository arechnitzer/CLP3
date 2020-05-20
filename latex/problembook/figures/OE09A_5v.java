                  /*  File:  OE09A_5v.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE09A_5v extends Template {

     static {templateClass = new OE09A_5v() ; }

     public void setup() {
          filePrefix = "OE09A_5v" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.5 ;      // in inches
          ysize = 1.4*1.5 ;   // in inches. 
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
         { 
            double[] xlist = { 0, 1,  0} ;
            double[] ylist = { 0, 1,  1} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          fLine(xmin,xmin, xmax,xmax) ;
          fTeXlabel(0.58,0.5, "cl", "$y=x$") ;
          fTeXlabel(0.5,0.7, "cc", "$\\cT$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
         { 
            double[] xlist = { 0, 1,  0} ;
            double[] ylist = { 0, 1,  1} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             


          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.05, 1.0, "cl", "$\\scriptstyle (1,1)$") ;
          fDisk(0, 1, r, r, FILLED) ;
          fTeXlabel(-0.05, 1.0, "cr", "$\\scriptstyle (0,1)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.3 ;
          double YB = X ;
          double YT = 1 ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.5 ;
          YT = 0.6 ;
          fLine(X,YB, X,YT) ;          
     }
}

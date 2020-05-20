                  /*  File:  OE16D_6v.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE16D_6v extends Template {

     static {templateClass = new OE16D_6v() ; }

     public void setup() {
          filePrefix = "OE16D_6v" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.3;
          ymin = -0.1 ;
          ymax =  1.3 ;
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
          fCurve("[t, t*t]",1, 0,1, FILLED) ;
          { 
            double[] xlist = { 0, 0,  1, 0.5} ;
            double[] ylist = { 0, 1,  1, 0.25} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;
          fLine(xmin,1, xmax,1) ;

          fTeXlabel(xmax+0.05, 1, "lc", "$y=1$") ;
          fTeXlabel(0.7, 0.49, "tl", "$y=x^2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, t*t]",1, 0,1, OPEN) ;
          fLine(0,1, 1,1) ;
          fLine(0,0, 0,1) ;

          double r = 0.04 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(1,1, r,r, FILLED) ;
          fTeXlabel(0.97, 1.03, "br", "$\\scriptstyle (1,1)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.3 ;
          double YB = X*X ;
          double YT = 1 ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.65 ;
          YT = 0.77 ;
          fLine(X,YB, X,YT) ;


          
     }
}

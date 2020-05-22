                  /*  File:  OE08D_6v.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE08D_6v extends Template {

     static {templateClass = new OE08D_6v() ; }

     public void setup() {
          filePrefix = "OE08D_6v" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*1.0 ;      // in inches
          ysize = 1.4*1.0 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.5 ;
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
            double[] xlist = { 0, 1,  1, 0.5} ;
            double[] ylist = { 0, 0,  1, 0.25} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 1.0) ;
          fCurve("[t, t*t]",1, 0,1,FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fLine(1,ymin, 1,ymax) ;
          fCurve("[t, t*t]",1, xmin,xmax,OPEN) ;
//          fTeXlabel(1.05,0.6, "cl", "$x=1$") ;
          fTeXlabel(Math.sqrt(0.6)-0.05,0.6, "cr", "$y=x^2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, t*t]",1, 0,1,OPEN) ;
          fLine(1,0, 1,1) ;
          fLine(0,0, 1,0) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.05, 1.0, "cl", "$\\scriptstyle (1,1)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.7 ;
          double YB = 0 ;
          double YT = X*X ;
          fEnv("lineWidth", 7.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.2 ;
          YT = 0.3 ;
          fLine(X,YB, X,YT) ;          
     }
}

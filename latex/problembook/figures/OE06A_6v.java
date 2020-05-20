                  /*  File:  OE06A_6v.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_6v extends Template {

     static {templateClass = new OE06A_6v() ; }

     public void setup() {
          filePrefix = "OE06A_6v" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.0 ;      // in inches
          ysize = 2.4*1.0 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 2.3 ;
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
            double[] xlist = { 0, 1,  0,} ;
            double[] ylist = { 0, 1,  2} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fLine(xmin,xmin, xmax,xmax) ;
          fLine(2,0, 2-ymax,ymax) ;
          fTeXlabel(0.6,1.5, "cl", "$y=2-x$") ;
          fTeXlabel(0.6,0.5, "cl", "$y=x$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
         { 
            double[] xlist = { 0, 1,  0,} ;
            double[] ylist = { 0, 1,  2} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             


          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.05, 1.0, "cl", "$\\scriptstyle (1,1)$") ;
          fDisk(0, 2, r, r, FILLED) ;
          fTeXlabel(-0.05, 1.95, "cr", "$\\scriptstyle (0,2)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.4 ;
          double YB = X ;
          double YT = 2-X ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.9 ;
          YT = 1.0 ;
          fLine(X,YB, X,YT) ;          
        
     }
}

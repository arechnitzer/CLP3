                  /*  File:  OE06A_7v.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_7v extends Template {

     static {templateClass = new OE06A_7v() ; }

     public void setup() {
          filePrefix = "OE06A_7v" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.6*0.6 ;      // in inches
          ysize = 2.4*0.6 ;   // in inches. 
          xmin = -0.1 ;
          xmax = 2.5 ;
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
          fEllipticalArc(0,0, 2,2, 0, 90, FILLED) ;
         { 
            double[] xlist = { 0, 2,  1.2, 0} ;
            double[] ylist = { 0, 0,  1,2, 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fTeXlabel(1.55,1.5, "cl", "$y=\\sqrt{4-x^2}$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, 2,2, 0, 90, OPEN) ;
          fLine(0,0, 2,0) ;
          fLine(0,0, 0,2) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.04 ;
          fDisk(2, 0, r, r, FILLED) ;
          fTeXlabel(2.0, -0.07, "ct", "$\\scriptstyle (2,0)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.8 ;
          double YB = 0 ;
          double YT = Math.sqrt(4-X*X) ;
          fEnv("lineWidth", 8.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.9 ;
          YT = 1.05 ;
          fLine(X,YB, X,YT) ;          
        
     }
}

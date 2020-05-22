                  /*  File:  OE05D_7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE05D_7 extends Template {

     static {templateClass = new OE05D_7() ; }

     public void setup() {
          filePrefix = "OE05D_7" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.4*1.4 ;      // in inches
          ysize = 1.4*1.4 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.2;
          ymin = -.1 ;
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
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("psFillGray", 0.8) ;
          fCurve("[t, t*t]",1, -1,1, FILLED) ;
                       

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;

          fLine(xmin, 1, xmax, 1) ;
          fTeXlabel(0.5, 1.02, "cb", "$y=1$") ;
          fCurve("[t, t*t]",1, xmin,xmax, OPEN) ;
          fTeXlabel(-Math.sqrt(0.5)-0.07, 0.5, "rc", "$y=x^2$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fLine(-1, 1, 1, 1) ;
          fCurve("[t, t*t]",1, -1,1, OPEN) ;

          fEnv("psFillGray", 0.0) ;
          double r = 0.03 ;
          fDisk(-1, 1, r, r*aspect, FILLED) ;
          fDisk(1, 1, r, r*aspect, FILLED) ;
          fTeXlabel(-1.02, 0.97, "tr", "$\\scriptstyle (-1,1)$") ;
          fTeXlabel(1.02, 0.97, "tl", "$\\scriptstyle (1,1)$") ;

          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double X = 0.3 ;
          double YB = X*X ;
          double YT = 1 ;
          fEnv("lineWidth", 7.0) ;
          fLine(X,YB, X,YT) ;
          canvas.append( new fPsWrite("0.3 setgray\n")) ;
          YB = 0.6 ;
          YT = 0.68 ;
          fLine(X,YB, X,YT) ;          


          
     }
}

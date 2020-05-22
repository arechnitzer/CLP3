                  /*  File:  OE07A_7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE07A_7 extends Template {

     static {templateClass = new OE07A_7() ; }

     public void setup() {
          filePrefix = "OE07A_7" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5*0.4 ;      // in inches
          ysize = 10.5*0.25 ;   // in inches. 
          xmin = -1.5 ;
          xmax = 3.5 ;
          ymin = -0.5 ;
          ymax = 10.0 ;
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

          fEnv("psFillGray", 0.9) ;
          fCurve("[t, t*t]",1, -1,3,FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.03, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;

          fLine(xmin,2*xmin+3, xmax,2*xmax+3) ;
          fCurve("[t, t*t]",1, xmin,xmax,OPEN) ;
          fTeXlabel(2.5, 8.0, "br", "$y=2x+3$") ;
          fTeXlabel(1.2,1, "cl", "$y=x^2$") ;


          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve("[t, t*t]",1, -1,3,OPEN) ;
          fLine(-1,1, 3,9) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          fDisk(-1, 1, r, r*aspect, FILLED) ;
          fDisk(3, 9, r, r*aspect, FILLED) ;
          fTeXlabel(-1.15, 1.0, "cr", "$\\scriptstyle (-1,1)$") ;
          fTeXlabel(3.15, 9.0, "cl", "$\\scriptstyle (3,9)$") ;

//          canvas.append( new fPsWrite("0.6 setgray\n")) ;
//          double X = 1.5 ;
//          double YB = X*X ;
//          double YT = 2*X+3 ;
//          fEnv("lineWidth", 7.0) ;
//          fLine(X,YB, X,YT) ;
//          canvas.append( new fPsWrite("0.3 setgray\n")) ;
//          YB = 3.4 ;
//          YT = 3.8 ;
//          fLine(X,YB, X,YT) ;          
     }
}

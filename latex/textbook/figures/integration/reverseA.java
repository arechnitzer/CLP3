                  /*  File:  reverseA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class reverseA extends Template {

     static {templateClass = new reverseA() ; }

     public void setup() {
          filePrefix = "reverseA" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*0.75 ;   
          ysize = 5.0*0.4 ;   
          xmin = -1.5  ;
          xmax = 2.5 ;
          ymin = -0.5 ;
          ymax = 4.5 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fCurve("[t,t*t]", 1, -1, 2, FILLED) ;
          fCurve("[t,t*t]", 1, xmin, xmax, OPEN) ;
          fLine(xmin, 2+xmin, xmax, 2+xmax) ;
    

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[t,t*t]", 1, -1, 2, OPEN) ;
          fLine(-1, 2-1, 2, 2+2) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double r = 0.08 ;
          fDisk(-1,1,r,r*aspect,FILLED) ;
          fDisk(2,4,r,r*aspect,FILLED) ;
          fTeXlabel(2.1,3.9, "cl", "$(2,4)$") ;
          fTeXlabel(-1.15, 1.05, "cr", "$(-1,1)$") ;

          double xl = 0.87 ;  double xr = 1.13 ; 
          double yt = 2+1 ;  double yb = 1*1 ;
          double ytt = 2.18 ;  double ybb = 1.82 ;


          fEnv("useColorPs", "false") ;
          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xl, xl, xr, xr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 0.3) ;
          { 
            double[] xlist = { xl,  xl,  xr,  xr} ;
            double[] ylist = { ytt, ybb, ybb, ytt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(xr, yt, xr, 3.5) ;
          fLine(xl, yt, xl, 3.5) ;
          fTeXlabel(0.5*xr+0.5*xl, 3.45, "cb", "$\\scriptstyle\\dee{x}$") ;
          fLine(xl, ytt, -0.47 , ytt) ;
          fLine(xl, ybb, -0.47 , ybb) ;
          fTeXlabel(-0.47, 0.5*ybb+0.5*ytt, "cl", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(1.5, 1.5*1.5,"lt", "$y=x^2$") ;
          fTeXlabel(xmin-0.05, 2+xmin, "tr", "$y=x+2$") ;

     }
}

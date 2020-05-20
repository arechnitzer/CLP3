                  /*  File:  reverseB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class reverseB extends Template {

     static {templateClass = new reverseB() ; }

     public void setup() {
          filePrefix = "reverseB" ;
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

          double yt = 0.63 ;  double yb = 0.37 ; 
          double xl = -Math.sqrt(0.5) ;  double xr = Math.sqrt(0.5) ;
          double xll = 0.3 ;  double xrr = 0.5 ;


          fEnv("useColorPs", "false") ;
          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xl, xl, xr, xr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 0.3) ;
          { 
            double[] xlist = { xll,  xll,  xrr,  xrr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(xrr, yt, xrr, 3) ;
          fLine(xll, yt, xll, 3) ;
          fTeXlabel(0.5*xrr+0.5*xll, 3.05, "cb", "$\\scriptstyle\\dee{x}$") ;
          fLine(xr, yt, 1.15 , yt) ;
          fLine(xr, yb, 1.15 , yb) ;
          fTeXlabel(1.15, 0.5*yb+0.5*yt, "cl", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          yt = 1.63 ;  yb = 1.37 ; 
          xl = 1.5-2 ;  xr = Math.sqrt(1.5) ;
          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xl, xl, xr, xr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fEnv("psFillGray", 0.3) ;
          { 
            double[] xlist = { xll,  xll,  xrr,  xrr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }        
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(xr, yt, 1.65 , yt) ;
          fLine(xr, yb, 1.65 , yb) ;
          fTeXlabel(1.65, 0.5*yb+0.5*yt, "cl", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
     



          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(1.7, 1.7*1.7,"lt", "$x=\\sqrt{y}$") ;
          fTeXlabel(xmin-0.05, 2+xmin, "tr", "$x=y-2$") ;
          fTeXlabel(xmin-0.02, xmin*xmin, "br", "$x=-\\sqrt{y}$") ;

     }
}

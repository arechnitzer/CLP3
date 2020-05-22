                  /*  File:  cofm.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class cofm extends Template {

     static {templateClass = new cofm() ; }

     public void setup() {
          filePrefix = "cofm" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*0.75 ;   
          ysize = 2.2*0.75 ;   
          xmin = -0.2  ;
          xmax = 2.5 ;
          ymin = -1.1 ;
          ymax = 1.1 ;
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
          fCurve("[t,sqrt(2*t-t*t)]", 1, 0, 2, FILLED) ;
          fCurve("[t,-sqrt(2*t-t*t)]", 1, 0, 2, FILLED) ;
    

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[t,sqrt(2*t-t*t)]", 1, 0, 2, OPEN) ;
          fCurve("[t, -sqrt(2*t-t*t)]", 1, 0, 2, OPEN) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double r = 0.05 ;
          fDisk(1,0,r,r*aspect,FILLED) ;
          fDisk(2,0,r,r*aspect,FILLED) ;
          fTeXlabel(0.97,0.03, "br", "$(1,0)$") ;
          fTeXlabel(2.1, 0.03, "bl", "$(2,0)$") ;

          double xl = 1.43 ;  double xr = 1.57 ; 
          double yt = Math.sqrt(2*1.5-1.5*1.5) ;  double yb = -Math.sqrt(2*1.5-1.5*1.5) ;
          double ytt = 0.6 ;  double ybb = 0.4 ;


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
          fTeXlabel(0.5*xr+0.5*xl, ymax, "cb", "$\\scriptstyle\\dee{x}$") ;
          fLine(xr, ytt, 2.2 , ytt) ;
          fLine(xr, ybb, 2.2 , ybb) ;
          fTeXlabel(2.1, 0.5*ybb+0.5*ytt, "cl", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;

          fLine(1.0, ymin, 1.0, ymax) ;
          fTeXlabel(1, ymax,"bc", "$x=1$") ;



          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(1.85, -Math.sqrt(2*1.8-1.8*1.8), "tl", "$(x-1)^2+y^2=1$") ;

     }
}

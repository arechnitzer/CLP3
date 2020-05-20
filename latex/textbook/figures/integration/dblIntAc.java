                  /*  File:  dblIntAc.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class dblIntAc extends Template {

     static {templateClass = new dblIntAc() ; }

     public void setup() {
          filePrefix = "dblIntAc" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.1*1.0 ;   
          ysize = 1.6*1.0 ;   
          xmin = -0.8  ;
          xmax = 2.3 ;
          ymin = -0.4 ;
          ymax = 1.2 ;
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
          double Xmax = 2.2 ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fCurve("[2*t*t,t]", 1, 0, 1, FILLED) ;
          fCurve("[t,t*t/4]", 1, 0, 2, FILLED) ;
          { 
            double[] xlist = { 0, 1,    2, 0.5} ;
            double[] ylist = { 0, 0.25, 1, 0.5} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }         
          fCurve("[2*t*t,t]", 1, ymin, Math.sqrt(Xmax/2.0), OPEN) ;
          fCurve("[t,t*t/4]", 1, xmin, Xmax, OPEN) ;
    

          fLine(xmin, 0.0, Xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[2*t*t,t]", 1, 0, 1, OPEN) ;
          fCurve("[t,t*t/4]", 1, 0, 2, OPEN) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double r = 0.04 ;
          fDisk(2,1,r,r,FILLED) ;
          fDisk(0,0,r,r,FILLED) ;

          double yt = 0.55 ;  double yb = 0.45 ; 
          double xl = 2*0.5*0.5 ;  double xr = Math.sqrt(4*0.5) ;
          double xll = 0.95 ;  double xrr = 1.05 ;


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
          fLine(2, 1, xmax,1 ) ;
          fLine(xrr, yt, xrr, 1) ;
          fLine(xll, yt, xll, 1) ;
          fTeXlabel(0.5*xrr+0.5*xll, 1.05, "cb", "$\\scriptstyle\\dee{x}$") ;
          fLine(xl, yt, -0.1 , yt) ;
          fLine(xl, yb, -0.1 , yb) ;
          fTeXlabel(-0.12, 0.5*yb+0.5*yt, "cr", "$\\scriptstyle\\dee{y}$") ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(Xmax+0.03, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.03, "cb", "$y$") ;
          fTeXlabel(Xmax, Xmax*Xmax/4.0,"cb",
                                  "$x=R(y)=\\sqrt{4\\nu y}$") ;
          fTeXlabel(2*ymin*ymin+0.03, ymin, "cl", "$x=L(y)=\\frac{2 y^2}{\\nu}$") ;
          fTeXlabel(xmax+0.05, 1, "cl", "$y=d=\\nu$") ;

     }
}

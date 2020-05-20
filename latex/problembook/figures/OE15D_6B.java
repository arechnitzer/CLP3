                  /*  File:  OE15D_6B.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE15D_6B extends Template {

     static {templateClass = new OE15D_6B() ; }

     public void setup() {
          filePrefix = "OE15D_6B" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*0.75 ;   
          ysize = 1.7*0.75 ;   
          xmin = -1.2  ;
          xmax = 1.5 ;
          ymin = -0.2 ;
          ymax = 1.5 ;
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
          fCurve("[t,1-t*t]", 1, -1, 1, FILLED) ;
          fCurve("[t,1-t*t]", 1, xmin, xmax, OPEN) ;
    

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[t,1-t*t]", 1, -1, 1, OPEN) ;
          fLine(-1, 0, 1, 0) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          double r = 0.05 ;
          fDisk(-1,0,r,r*aspect,FILLED) ;
          fDisk(1,0,r,r*aspect,FILLED) ;
          fDisk(0,1,r,r*aspect,FILLED) ;
          fTeXlabel(-1.05,0.05, "br", "$(-1,0)$") ;
          fTeXlabel(-0.05,1.05, "br", "$(0,1)$") ;
          fTeXlabel( 1.05,0.05, "bl", "$(1,0)$") ;

          double yt = 0.4 ;  double yb = 0.25 ;
          double xl = -Math.sqrt(1-yb) ;  double xr = Math.sqrt(1-yb) ; 
          double xll = 0.35 ;  double xrr = 0.5 ;


          fEnv("useColorPs", "false") ;
          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xl,  xl,  xr, xr} ;
            double[] ylist = { yt,  yb,  yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             

          fEnv("psFillGray", 0.3) ;
          { 
            double[] xlist = { xll, xll, xrr, xrr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


//          fEnv("lineWidth", 0.5) ;
//          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
//          fLine(xr, yt, xr, 1.2) ;
//          fLine(xl, yt, xl, 1.2) ;
//          fTeXlabel(0.5*xr+0.5*xl, 1.25, "cb", "$\\scriptstyle\\dee{x}$") ;
//          fLine(xl, ytt, 0.8 , ytt) ;
//          fLine(xl, ybb, 0.8 , ybb) ;
//          fTeXlabel(0.85, 0.5*ybb+0.5*ytt, "cl", "$\\scriptstyle\\dee{y}$") ;
//          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
          fTeXlabel(-0.65, 0.6,"rb", "$x=-\\sqrt{1-y}$") ;
          fTeXlabel( 0.65, 0.6,"lb", "$x=+\\sqrt{1-y}$") ;
          fTeXlabel(-0.2, 0.6,"cc", "$D$") ;

     }
}

                  /*  File:  levelHyperbola.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class levelHyperbola extends Template {

     static {templateClass = new levelHyperbola() ; }

     public void setup() {
          filePrefix = "levelHyperbola" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;     
          ysize = 2.0 ;   
          xmin = -6 ;
          xmax = 6 ;
          ymin = -6 ;
          ymax = 6 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fTeXlabel(xmax+.2,0,"lc","$x$") ;
          fLine(0, ymin, 0, 0) ;
          fLine(0, 0.8, 0, ymax) ;
          fTeXlabel(0, ymax+.2,"bc","$y$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("1/x", 0, 0.01, xmax, OPEN) ;
          fCurve("1/x", 0, xmin, -0.01, OPEN) ;
          fCurve("4/x", 0, 0.01, xmax, OPEN) ;
          fCurve("4/x", 0, xmin, -0.01, OPEN) ;
          fCurve("-1/x", 0, 0.01, xmax, OPEN) ;
          fCurve("-1/x", 0, xmin, -0.01, OPEN) ;
          fCurve("-4/x", 0, 0.01, xmax, OPEN) ;
          fCurve("-4/x", 0, xmin, -0.01, OPEN) ;
          
       //   fTeXlabel(-2, 1.2,"br","$f=1$") ;
          fTeXlabel(2.1, 2.1,"bl","$\\scriptstyle f=2$") ;
          fTeXlabel(1.7, 0.5,"bl","${\\scriptstyle f=1}$") ;
          fTeXlabel(-2.1, -2,"tr","$\\scriptstyle f=2$") ;
          fTeXlabel(2, -2,"tl","$\\scriptstyle f=-2$") ;
          fTeXlabel(-2, 2,"br","$\\scriptstyle f=-2$") ;

          double r = 0.2 ;
          fEnv("psFillColor", Blue) ;
          fEnv("useColorPs", "true") ;
          fDisk(0,0, r,r, FILLED) ;
          fTeXlabel(0.0, 0.07,"bc","$\\scriptstyle f=0$") ;
          
     }
}

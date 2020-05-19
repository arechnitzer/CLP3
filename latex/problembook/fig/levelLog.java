                  /*  File:  levelLog.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class levelLog extends Template {

     static {templateClass = new levelLog() ; }

     public void setup() {
          filePrefix = "levelLog" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;     
          ysize = 1.8 ;   
          xmin = -6 ;
          xmax = 6 ;
          ymin = -2 ;
          ymax = 2 ;
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
          fTeXlabel(xmax+.25,0,"lc","$x$") ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(0, ymax+.1,"bc","$y$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("[exp(t),t]", 1, ymin, ymax, OPEN) ;
          fCurve("[-exp(t),t]", 1, ymin, ymax, OPEN) ;
          fCurve("[2*exp(t),t]", 1, ymin, ymax, OPEN) ;
          fCurve("[-2*exp(t),t]", 1, ymin, ymax, OPEN) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.2, 1.95,"cl","${\\scriptstyle  f=1}$") ;
          fTeXlabel(xmin-0.1, 1.95,"cr","${\\scriptstyle  f=-1}$") ;
          fTeXlabel(xmax+0.2, 1.25,"cl","${\\scriptstyle  f=2}$") ;
          fTeXlabel(xmin-0.1, 1.25,"cr","${\\scriptstyle  f=-2}$") ;
          fTeXlabel(0.2, 1.7,"lc","${\\scriptstyle  f=0}$") ;
          
     }
}

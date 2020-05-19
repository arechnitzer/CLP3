                  /*  File:  ant.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class ant extends Template {

     static {templateClass = new ant() ; }

     public void setup() {
          filePrefix = "ant" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.5*0.6 ;      // in inches
          ysize = 3.2*0.6 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2 ;
          xmax = 2.5 ;
          ymin = -2*0.8 ;
          ymax = 2*0.8 ;
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
          fLine(0,ymin,0,ymax) ;

          fEnv("lineWidth", 1.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(-Math.sqrt(2*ymin*ymin), ymin, Math.sqrt(2*ymax*ymax), ymax) ;
          fLine(Math.sqrt(2*ymin*ymin), ymin, -Math.sqrt(2*ymax*ymax), ymax) ;
          fCurve("[sqrt(1+2*t*t),t]", 1, ymin+0.1, ymax-0.1, OPEN);
          fCurve("[-sqrt(1+2*t*t),t]", 1, ymin, ymax, OPEN);
          fCurve("[t,sqrt((1+t*t)/2)]", 1, xmin, xmax-0.2, OPEN);
          fCurve("[t,-sqrt((1+t*t)/2)]", 1, xmin, xmax-0.2, OPEN);
          fCurve("[sqrt(2+2*t*t),t]", 1, ymin+0.2, ymax-0.2, OPEN);
          fTeXlabel(-0.45, 0.3, "tr",  "$\\scriptstyle T=0$") ;
          fTeXlabel(-0.45, -0.3, "br",  "$\\scriptstyle T=0$") ;

          fEnv("psFillGray", 1.0) ;
          fDisk(0, 0.95, .2, .13, FILLED) ;
          fTeXlabel(0, 0.95, "cc", "$T=-1$") ;
          fDisk(0, -0.97, .2, .13, FILLED) ;
          fTeXlabel(0, -0.95, "cc", "$T=-1$") ;
          fTeXlabel(1.0, 0.1, "rb", "$\\scriptstyle T=1$") ;
          fTeXlabel(1.5, 0.1, "lb", "$T=2$") ;
          fTeXlabel(-1.1, 0.1, "rb", "$T=1$") ;

          fEnv("psFillGray", 0.0) ;
          fDisk(2, -1, .05, .05, FILLED) ;
          fTeXlabel(2.05, -1, "lb", "$(2,-1)$") ;


          
     }
}

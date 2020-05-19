                  /*  File:  OE00DQ6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE00DQ6 extends Template {

     static {templateClass = new OE00DQ6() ; }

     public void setup() {
          filePrefix = "OE00DQ6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*0.8 ;      // in inches
          ysize = 2.4*0.8 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.2 ;
          xmax = 1.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fCurve("[t*t,t]", 1, -1, 1, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 4.0) ;
//          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          double x = 0.3 ;
          double y = 0.3 ;
          fLine(x,-Math.sqrt(x) ,x, Math.sqrt(x)) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(y*y, y , 1, y) ;
//          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fLine(1,ymin, 1, ymax) ;
          fCurve("[t*t,t]", 1, ymin, ymax, OPEN) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("[t*t,t]", 1, -1, 1, OPEN) ;
          fLine(1, -1, 1, 1) ;

          fTeXlabel(xmax+0.07, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.07, "bc", "$y$") ;          
          fTeXlabel(xmax+0.07,Math.sqrt(xmax)+0.02, "cl", "$x=y^2$") ;          
          fTeXlabel(1.25, ymin, "tr", "$x=1$") ;          
     }
}

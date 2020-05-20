                  /*  File:  OE01AQ8a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01AQ8a extends Template {

     static {templateClass = new OE01AQ8a() ; }

     public void setup() {
          filePrefix = "OE01AQ8a" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = 1.2 ;
          xmax = -0.2 ;
          ymin = -0.2 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          double[] xlist = {0, 1, 0} ;
          double[] ylist = {0, 0, 1} ;
          fPolygon(xlist, ylist, 3, FILLED) ;
          fCurve("1-x*x", 0, 0, 1, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          double x = 0.3 ;
          fLine(x,0 ,x, 1-x*x) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;

          fEnv("lineWidth", 1.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve("1-x*x", 0, 0, 1, OPEN) ;
          fLine(0, 0, 1, 0) ;
          fLine(0, 0, 0, 1) ;

          fTeXlabel(xmin+0.05, 0, "rc", "$x$") ;
          fTeXlabel(0, ymax+0.05, "bc", "$z$") ;          
          fTeXlabel(0.52, 0.78, "rc", "$z=1-x^2$") ;          
     }
}

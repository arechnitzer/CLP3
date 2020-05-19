                  /*  File:  OE01DQ6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01DQ6 extends Template {

     static {templateClass = new OE01DQ6() ; }

     public void setup() {
          filePrefix = "OE01DQ6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.6*2 ;      // in inches
          ysize = 1 *2;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.5 ;
          xmax = 3.5 ;
          ymin = -0.5 ;
          ymax = 10.5 ;
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
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("psFillGray", 0.8) ;
          double[] xlist={0, 3, 3} ;
          double[] ylist={0, 9, 0} ;
          fPolygon(xlist, ylist, 3, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fCurve("x*x", 0, 0, 3, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fCurve("x*x", 0, xmin, xmax, OPEN) ;
          fLine(3,ymin, 3,ymax) ;

          fEnv("lineWidth", 4.0) ;
//          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          double x = 2 ;
          fLine(x, x*x, x, 0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          double y = 2 ;
          fLine(3, y, Math.sqrt(y), y) ;
//          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("x*x", 0, 0, 3, OPEN) ;
          fLine(0,0, 3,0) ;
          fLine(3,0, 3,9) ;
          fEnv("psFillGray", 0.0) ;
          double r = 0.1 ;
          fDisk(3,9, r,r*aspect, FILLED) ;

          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.3, "bc", "$y$") ;
          fTeXlabel(3, ymin-0.2, "tc", "$x=3$") ;
          fTeXlabel(Math.sqrt(ymax)+0.1, ymax, "cl", "$x=\\sqrt{y}$") ;
          fTeXlabel(3.2, 9, "lc", "$(3,9)$") ;
          
     }
}

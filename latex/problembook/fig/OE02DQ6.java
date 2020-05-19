                  /*  File:  OE02DQ6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE02DQ6 extends Template {

     static {templateClass = new OE02DQ6() ; }

     public void setup() {
          filePrefix = "OE02DQ6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.4 ;      // in inches
          ysize = 5.5*0.4;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -0.5 ;
          ymax = 5.0 ;
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
          fCurve("x*x", 0, -2, 2, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fCurve("x*x", 0, xmin, xmax, OPEN) ;
          fLine(-2,ymin, -2,ymax) ;
          fLine(2,ymin, 2,ymax) ;
          fLine(xmin,4, xmax,4) ;

//          fEnv("lineWidth", 3.0) ;
//          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          fEnv("lineWidth", 4.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          double x = 1 ;
          fLine(x, x*x, x, 4) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          double y = 3 ;
          fLine(-Math.sqrt(y), y, Math.sqrt(y), y) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
//          canvas.append( new fPsWrite("0.0 setgray\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("x*x", 0, -2, 2, OPEN) ;
          fLine(-2,4, 2,4) ;


          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.15, "bc", "$y$") ;
          fTeXlabel(xmin-0.1, 4, "rc", "$y=4$") ;
          fTeXlabel(Math.sqrt(ymax)+0.1, ymax, "cl", "$y=x^2$") ;
          fTeXlabel(2, ymin-0.1, "tc", "$x=2$") ;
          fTeXlabel(-2, ymin-0.1, "tc", "$x=-2$") ;
          
     }
}

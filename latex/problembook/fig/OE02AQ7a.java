                  /*  File:  OE02AQ7a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE02AQ7a extends Template {

     static {templateClass = new OE02AQ7a() ; }

     public void setup() {
          filePrefix = "OE02AQ7a" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -0.5 ;
          ymax = 2.5 ;
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
          fEnv("lineWidth", 1.0) ;
          fDisk(0, 1, 1, 1, CLOSED+FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;

//          fEnv("lineWidth", 4.0) ;
////          canvas.append( new fPsWrite("0.4 setgray\n")) ;
//          double y = 1.3 ;
//          double x = 0.5 ;
//          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
//          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
//          String Black = "0 0 0 setrgbcolor  " ;
//           canvas.append( new fPsWrite(Pink+"\n")) ;
//          fLine(-Math.sqrt(2*y-y*y), y, Math.sqrt(2*y-y*y), y) ;
//          canvas.append( new fPsWrite(Blue+"\n")) ;
//          fLine(x, 1-Math.sqrt(1-x*x), x, 1+Math.sqrt(1-x*x)) ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
////          canvas.append( new fPsWrite("0.0 setgray\n")) ;


          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;          
          fTeXlabel(1.1, 1, "lc", "$x^2+y^2=2y$") ;          
          fTeXlabel(0.2, 1, "cc", "$D$") ;          
     }
}

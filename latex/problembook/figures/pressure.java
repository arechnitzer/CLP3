                  /*  File:  pressure.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pressure extends Template {

     static {templateClass = new pressure() ; }

     public void setup() {
          filePrefix = "pressure" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 8*0.25 ;      // in inches
          ysize =  8*0.25 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -1 ;
          xmax = 7 ;
          ymin = -4 ;
          ymax = 4 ;
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
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          double c = 0 ; double R = Math.sqrt(1+c*c) ;
//          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          c = 1 ; R = Math.sqrt(1+c*c) ;
          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          fTeXlabel(R+c, 1, "tl", "$\\scriptstyle p=1$") ;

          c = 2 ; R = Math.sqrt(1+c*c) ;
          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          fTeXlabel(R+c-0.05, 1.3, "tl", "$\\scriptstyle p=2$") ;

          c = 3 ; R = Math.sqrt(1+c*c) ;
          fEllipticalArc(c,0, R,R, 0, 360, OPEN) ;
          fTeXlabel(R+c-0.1, 1.6, "tl", "$\\scriptstyle p=3$") ;

     }
}

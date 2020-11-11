                  /*  File:  annulusPart.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class annulusPart extends Template {

     static {templateClass = new annulusPart() ; }

     public void setup() {
          filePrefix = "annulusPart" ; // used as the prefix for any ps or lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -0.5 ;
          xmax = 5.5 ;
          ymin = -0.5 ;
          ymax =  5.5 ;
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
          double sq2 = Math.sqrt(2) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          fArrow(5.5, 2.5,  3+1,2) ;
          fTeXlabel(5.52,2.5, "cl", "$(x-3)^2+(y-2)^2=1$") ;
          fArrow(5.5, 5,  3+sq2,2+sq2) ;
          fTeXlabel(5.51,5, "lb", "$(x-3)^2+(y-2)^2=4$") ;
          fEnv("lineWidth", 1.5) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(3, 2, 2, 2, CLOSED) ;
          canvas.append( new fPsWrite(Pink+"\n")) ;
          fDisk(3, 2, 1, 1, CLOSED) ;
          canvas.append( new fPsWrite(Orange+"\n")) ;
          fLine(xmin,1, xmax,1) ;
          fTeXlabel(xmax+0.1, 1, "lc", "$y=1$") ;

          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;


     }
}

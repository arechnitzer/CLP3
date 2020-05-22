                  /*  File:  string_elmnt.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class string_elmnt extends Template {

     static {templateClass = new string_elmnt() ; }

     public void setup() {
          filePrefix = "string_elmnt" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3 ;    
          ysize = 2 ;   
          xmin = -100 ;
          xmax = 100 ;
          ymin = -50 ;
          ymax = 50 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = -0.1 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {

          fEnv("lineWidth", 0.5) ;
          fLine(-50, -40, 50, -40 ) ;
          fLine(-30, -40, -30, 0 ) ;
          fLine(-30, 0, 30, 0 ) ;
          fLine(30, 0, 30, 30 ) ;

          fTeXlabel(-28, -20, "lc", "$w(x,t)$") ;
          fTeXlabel(0, -2, "tc", "$\\De x$") ;
          fTeXlabel(32, 15, "lc", "$\\De w$") ;
          fTeXlabel(-30, -43, "tc", "$x$") ;

          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow( 30, 30, 70, 46) ;
          fLine(  30, 30, 70, 30) ;
          fTeXlabel(72, 46, "lc", "$T(x+\\De x,t)$") ;

          fArrow( -30, 0, -55, -20) ;
          fTeXlabel(-57, -20, "rc", "$T(x,t)$") ;

          fEllipticalArc( 30, 30, 15, 15, 0, 20,  OPEN) ;
          fTeXlabel(50, 34, "lc", "$\\theta(x+\\De x,t)$") ;

          fEllipticalArc( -30, 0, 15, 15, 0, 33, OPEN) ;
          fTeXlabel(-13, 5, "lc", "$\\theta(x,t)$") ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.5) ;

          double[] xlist = {-30, 30}  ; 
          double[] ylist = {  0, 30}  ; 
          fBezier bez = new fBezier(xlist, ylist, 2, OPEN) ;
          bez.configure("vertex0angle", 10) ;
          canvas.append(bez) ;

          
     }
}

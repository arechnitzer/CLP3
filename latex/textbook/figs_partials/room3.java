                  /*  File:  room3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class room3 extends Template {

     static {templateClass = new room3() ; }

     public void setup() {
          filePrefix = "room3" ;    // used as the prefix for any ps, lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5;      // in inches
          ysize = 1.5 ;   // in inches
          xmin = -12 ;
          xmax = 12 ;
          ymin = -12 ;
          ymax = 12;
          topmargin = -0.1 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
//          fLine(xmin,0, xmax,0) ;
//          fTeXlabel(xmax, -0.3, "tr", "$x$") ;
//          fLine(0,ymin, 0, ymax) ;
//          fTeXlabel(-0.2, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve("[( exp(t/10)+exp(-t/10) )*cos(t)/8 , ( exp(t/10)+exp(-t/10) )*sin(t)/8]",
                                1, 0,45, OPEN) ;
          double t = 12.5*Math.PI ;
          double x = ( Math.exp(t/10)+Math.exp(-t/10) )*Math.cos(t)/8 ;
          double y = ( Math.exp(t/10)+Math.exp(-t/10) )*Math.sin(t)/8 ;
          fArrowhead(x,y,0) ;

//          fEnv("useColorPs", "false") ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("psFillGray", 1.0) ;
          fEnv("psFillColor", Blue) ;

          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, 0.6, 0.6, CLOSED+FILLED) ;


          
     }
}

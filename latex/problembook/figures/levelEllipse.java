                  /*  File:  levelEllipse.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class levelEllipse extends Template {

     static {templateClass = new levelEllipse() ; }

     public void setup() {
          filePrefix = "levelEllipse" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.5 ;     
          ysize = 4.0*0.5 ;   
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -2.0 ;
          ymax = 2.0 ;
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
          fTeXlabel(xmax,-0.1,"tr","$x$") ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.07, ymax,"tr","$y$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.0) ;
          fCurve("[cos(t), sin(t)/sqrt(2)]", 1, 0, 2*Math.PI, OPEN) ;
          fCurve("[2*cos(t), sin(t)*sqrt(2)]", 1, 0, 2*Math.PI, OPEN) ;
          double ang = Math.PI*3.0/4.0 ;
      //    fArrow(-2,1.2,Math.cos(ang), Math.sin(ang)/Math.sqrt(2) ) ;
      //    fTeXlabel(-2, 1.2,"br","$f=1$") ;
          fTeXlabel(Math.cos(ang),Math.sin(ang)/Math.sqrt(2),"br","$\\scriptstyle f=1$");
          fTeXlabel(1.7, 1.1,"bc","$\\scriptstyle f=2$") ;
          double r = 0.07 ;
          fEnv("psFillColor", Blue) ;
          fEnv("useColorPs", "true") ;
          fDisk(0,0, r,r, FILLED) ;
          fTeXlabel(0.08, 0.07,"bl","$\\scriptstyle f=0$") ;
          
     }
}

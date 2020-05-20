                  /*  File:  halfDomeB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class halfDomeB extends Template {

     static {templateClass = new halfDomeB() ; }

     public void setup() {
          filePrefix = "halfDomeB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;   
          ysize = 2.5 ;   
          xmin = -5  ;
          xmax = 5 ;
          ymin = -5 ;
          ymax = 5 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double rx = 4 ; double ry = 4 ;
          fEnv("psFillGray", 0.9) ;
          fEllipticalArc(0,0, rx, ry, 0, 180, FILLED) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.5) ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(0,0, rx, ry, 0, 180, OPEN) ;
          fLine(-rx,0, rx,0) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 12.0) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          double x = 1.5 ;
          fLine(x, ry*Math.sqrt(1-x*x/rx/rx), x, 0) ;
          canvas.append( new fPsWrite("0.5 setgray\n")) ;
          double yst = 0.5 ;  double ysb = 1.2 ;  
          fLine(x , yst, x , ysb) ;
          fEnv("lineWidth", 0.5) ;
          double yMin = -1.5 ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, yMin, 0.0, ymax) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(-rx, -0.5, -rx , 0) ;
          fLine( rx, -0.5,  rx , 0) ;
          fLine( x, yst,  xmin , yst) ;
          fLine( x, ysb,  xmin , ysb) ;
          double dx = 0.33 ;
          fLine( x-dx, ry*Math.sqrt(1-x*x/rx/rx),  x-dx , ymax) ;
          fLine( x+dx, ry*Math.sqrt(1-x*x/rx/rx),  x+dx , ymax) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax+0.1, 0.0, "cl", "$y$") ;
          fTeXlabel(-0.1, yMin, "br", "$x$") ;
          fTeXlabel(0.0, yMin-0.5, "ct", "top view") ;
          fTeXlabel(-0.1,  ry, "br", "$x=-\\sqrt{a^2-y^2}$") ;
          fTeXlabel(xmin, 0.5*(yst+ysb), "cl", "$\\scriptstyle\\dee{x}$") ;
          fTeXlabel(x+0.03, ymax, "tc", "$\\scriptstyle\\dee{y}$") ;
          fTeXlabel( rx+0.05,  -0.55, "ct", "$y =a$") ;
          fTeXlabel(-rx+0.3,  -0.55, "ct", "$y =-a$") ;
          fTeXlabel(-rx/3.0,  ry/2.5, "cb", "$\\cR$") ;

     }
}

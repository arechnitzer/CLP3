                  /*  File:  egDblIntEb.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class egDblIntEb extends Template {

     static {templateClass = new egDblIntEb() ; }

     public void setup() {
          filePrefix = "egDblIntEb" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;   
          ysize = 2.5*0.8 ;   
          xmin = -5  ;
          xmax = 5 ;
          ymin = -4 ;
          ymax = 4 ;
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
          double rx = 4 ; double ry = 3 ;
          fEnv("psFillGray", 0.9) ;
          fDisk(0,0, rx, ry, FILLED) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.5) ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(0,0, rx, ry, CLOSED) ;
          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("lineWidth", 12.0) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          double x = 1.5 ;
          fLine(x, ry*Math.sqrt(1-x*x/rx/rx), x, -ry*Math.sqrt(1-x*x/rx/rx)) ;
          canvas.append( new fPsWrite("0.5 setgray\n")) ;
          double yst = 0.5 ;  double ysb = 1.2 ;  
          fLine(x , -yst, x , -ysb) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(-rx, 2, -rx , 0) ;
          fLine( rx, 2,  rx , 0) ;
          fLine( x, -yst,  xmin , -yst) ;
          fLine( x, -ysb,  xmin , -ysb) ;
          double dx = 0.33 ;
          fLine( x-dx, ry*Math.sqrt(1-x*x/rx/rx),  x-dx , ymax) ;
          fLine( x+dx, ry*Math.sqrt(1-x*x/rx/rx),  x+dx , ymax) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax+0.1, 0.0, "cl", "$y$") ;
          fTeXlabel(0.0, ymin-0.25, "ct", "$x$") ;
          fTeXlabel(0.0, ymin-1.0, "ct", "top view") ;
          fTeXlabel(-0.1,  ry, "br", "$x=-\\sqrt{\\frac{1-2y^2}{3}}$") ;
          fTeXlabel(-0.1, -ry-0.2, "tr", "$x=\\sqrt{\\frac{1-2y^2}{3}}$") ;
          fTeXlabel(xmin, -0.5*(yst+ysb), "cl", "$\\scriptstyle\\dee{x}$") ;
          fTeXlabel(x+0.03, ymax, "tc", "$\\scriptstyle\\dee{y}$") ;
          fTeXlabel( rx+0.1,  2.1, "cb", "$y =\\nicefrac{1}{\\sqrt{2}}$") ;
          fTeXlabel(-rx-0.2,  2.1, "cb", "$y =- \\nicefrac{1}{\\sqrt{2}}$") ;
          fTeXlabel(-rx/3.0,  ry/3.0, "cb", "$\\cR$") ;

     }
}

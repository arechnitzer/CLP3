                  /*  File:  optExampleA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class optExampleA extends Template {

     static {templateClass = new optExampleA() ; }

     public void setup() {
          filePrefix = "optExampleA" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2*3.4/2.4 ;      // in inches
          ysize = 1.2 ;   // in inches. 
          xmin = -1.7 ;
          xmax = 1.7 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;   // in inches
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
          fLine(xmin, 0, 1.3, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(1.2+0.1, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fEnv("lineWidth", 0.8) ;
          fDisk(0, 0, 1, 1, CLOSED) ;
          fEnv("psFillGray", 0.6) ;
          double r = 0.06 ;
          fDisk(0.5, 0.5, r, r, FILLED) ;
          fArrow(1.6,0.4,  0.5+1.5*r, 0.5) ;
          fTeXlabel(1.7, 0.7, "tl", "$(\\tfrac{1}{2},\\tfrac{1}{2})$") ;
          fDisk(-0.5, -0.5, r, r, FILLED) ;
          fArrow(-1.6,-0.4,  -0.5-1.5*r, -0.5) ;
          fTeXlabel(-1.7, -0.5, "br", "$(-\\tfrac{1}{2},-\\tfrac{1}{2})$") ;
          double x = 1/Math.sqrt(2) ;
          double y = x ;
          fDisk(x, y, r, r, FILLED) ;
          fTeXlabel(x-r, y+r, "bl", 
                             "$(\\tfrac{1}{\\sqrt{2}},\\tfrac{1}{\\sqrt{2}})$") ;
          fDisk(-x, -y, r, r, FILLED) ;
          fTeXlabel(-x-r, -y-r, "tr",
                             "$(-\\tfrac{1}{\\sqrt{2}},-\\tfrac{1}{\\sqrt{2}})$") ;


     }
}

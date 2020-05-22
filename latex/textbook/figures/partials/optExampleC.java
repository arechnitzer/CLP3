                  /*  File:  optExampleC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class optExampleC extends Template {

     static {templateClass = new optExampleC() ; }

     public void setup() {
          filePrefix = "optExampleC" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;      // in inches
          ysize = 1.2 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1.2 ;
          ymin = -0.2 ;
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
          fEnv("lineWidth", 1.0) ;
          {double[] xlist = {0, 0, 1, 1} ;
           double[] ylist = {0, 1, 1, 0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
          }
          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          fEnv("psFillGray", 0.6) ;
          fEnv("lineWidth", 2.0) ;
          {double[] xlist = {0, 0, 1} ;
           double[] ylist = {1, 0, 0} ;
           fPolygon(xlist, ylist, 3, OPEN) ;
          }

          double r = 0.04 ;
          fDisk(0 , 0 , r, r, FILLED) ;
          fTeXlabel(-0.05, -0.05, "tr", "$(0,0)$") ;

          fDisk(1 , 0 , r, r, FILLED) ;
          fTeXlabel(1.05, -0.05, "tc", "$(1,0)$") ;

          fDisk(1 , 1 , r, r, FILLED) ;
          fTeXlabel(1.05, 1.05, "bl", "$(1,1)$") ;

          fDisk(1 , 0.5, r, r, FILLED) ;
          fTeXlabel(1.05, 0.5, "cl", "$(1,\\tfrac{1}{2})$") ;

          fDisk(0 , 1 , r, r, FILLED) ;
          fTeXlabel(-0.05, 1.05, "br", "$(0,1)$") ;

          double x = 1/Math.sqrt(3) ;
          fDisk(x, 1, r, r, FILLED) ;
          fTeXlabel(x, 1+2*r, "cb", "$(\\tfrac{1}{\\sqrt{3}},1)$") ;

     }
}

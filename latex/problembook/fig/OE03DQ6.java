                  /*  File:  OE03DQ6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE03DQ6 extends Template {

     static {templateClass = new OE03DQ6() ; }

     public void setup() {
          filePrefix = "OE03DQ6" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -1 ;
          xmax = 4 ;
          ymin = -1 ;
          ymax = 4 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          {double[] xlist = {0, 2, 3, 3, 0} ;
           double[] ylist = {3, 3, 2, 0, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;
          }        
          fEnv("psFillGray", 1.0) ;
          fCurve("6/x", 0, 1, xmax, FILLED) ;
          fEnv("psFillGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0,ymin, 0, ymax) ;
          fLine(xmin, 3, xmax, 3) ;
          fLine(3, ymin, 3, ymax) ;
          fCurve("6/x", 0, 1, xmax, OPEN) ;
          fLine(2, 0, 2, -0.3) ;
          fTeXlabel(2, -0.4, "tc", "$2$") ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
              fLine(2,0, 2,3) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0, 3, 2, 3) ;
          fLine(3, 0, 3, 2) ;
          fCurve("6/x", 0, 2, 3, OPEN) ;
          fLine(0, 0, 3, 0) ;
          fLine(0, 0, 0, 3) ;

          fDisk(2,3,0.1,0.1,FILLED) ;
          fEnv("lineWidth", 3.0) ;
          fEnv("psGray", 0.3) ;
          fLine(1,0,1,3) ;
          fLine(2.5,0,2.5,6.0/2.5) ;


          fTeXlabel(xmax+0.1, 0, "lc", "$x$") ;
          fTeXlabel(xmax+0.1, 3, "lc", "$y=3$") ;
          fTeXlabel(xmax+0.1, 1.5, "lc", "$xy=6$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fTeXlabel(3, ymax+0.1, "bc", "$x=3$") ;
          fTeXlabel(1.7, 3.1, "br", "$\\scriptstyle(2,3)$") ;

          
     }
}

                  /*  File:  optExampleCCc.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class optExampleCCc extends Template {

     static {templateClass = new optExampleCCc() ; }

     public void setup() {
          filePrefix = "optExampleCCc" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6*0.7 ;      // in inches
          ysize = 2.8*0.7 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1.4 ;
          ymin = -0.4 ;
          ymax = 2.4 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.05, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.05, "bc", "$y$") ;
          fEnv("psDash", "[2 2] 1") ;
          fLine(xmin, 2-2*xmin, xmax, 2-2*xmax) ;
          fEnv("psDash", "clear") ;

          fEnv("lineWidth", 1.0) ;
//          {double[] xlist = {0, 1, 0, 0} ;
//           double[] ylist = {0, 0, 2, 0} ;
//           fPolygon(xlist, ylist, 4, CLOSED) ;
//          }
//          canvas.append( new fPsWrite("0.8 setgray\n")) ;
//          fEnv("psFillGray", 0.8) ;
//          fEnv("lineWidth", 2.0) ;
//          {double[] xlist = {0, 1, 0, 0} ;
//           double[] ylist = {0, 0, 2, 0} ;
//           fPolygon(xlist, ylist, 4, FILLED) ;
//          }

          fEnv("psFillGray", 0.7) ;
          double r = 0.04 ;
//          fDisk(0 , 0 , r, r, FILLED) ;
//          fTeXlabel(-0.05, -0.05, "tr", "$(0,0)$") ;

          fDisk(1 , 0 , r, r, FILLED) ;
          fTeXlabel(1.0, -0.05, "tr", "$(1,0)$") ;

          fDisk(0 , 2 , r, r, FILLED) ;
          fTeXlabel(-0.07, 2.0, "cr", "$(0,2)$") ;

//          fDisk(-1 , -2 , r, r, FILLED) ;
//          fTeXlabel(-1.0, -2.0+0.05, "bc", "$(-1,-2)$") ;

//          fDisk(0.5, 1, r, r, FILLED) ;
//          fTeXlabel(0.55, 1, "bl", "$(\\sfrac{1}{2},1)$") ;


          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth", 1.0) ;
          fArrow(0.02,2-0.04,  0+0.98,2-0.98*2) ;
          fTeXlabel(0.8, 0.3, "cr", "$\\llt 1,-2\\rgt$") ;
          fEnv("lineWidth", 0.5) ;
          fLine(r,2,  1,2) ;
          fArrow(r,2, 0.6,2) ;
          fLine(1,2,  1,r) ;
          fTeXlabel(0.5, 2.07, "bc", "$\\De x = 1$") ;
          fArrow(1,2,  1,0.9) ;
          fTeXlabel(1.05, 0.95, "cl", "$\\De y = -2$") ;




     }
}

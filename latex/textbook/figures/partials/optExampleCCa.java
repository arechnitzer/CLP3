                  /*  File:  optExampleCCa.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class optExampleCCa extends Template {

     static {templateClass = new optExampleCCa() ; }

     public void setup() {
          filePrefix = "optExampleCCa" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*0.7 ;      // in inches
          ysize = 2.4*0.7 ;   // in inches. 
          xmin = -0.2 ;
          xmax = 1.2 ;
          ymin = -0.2 ;
          ymax = 2.2 ;
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
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax+0.05, 0, "lc", "$x$") ;
          fTeXlabel(0, ymax+0.05, "bc", "$y$") ;
          fEnv("lineWidth", 1.0) ;
          {double[] xlist = {0, 1, 0, 0} ;
           double[] ylist = {0, 0, 2, 0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
          }
          canvas.append( new fPsWrite("0.8 setgray\n")) ;
          fEnv("psFillGray", 0.8) ;
          fEnv("lineWidth", 2.0) ;
          {double[] xlist = {0, 1, 0, 0} ;
           double[] ylist = {0, 0, 2, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
          }

          fEnv("psFillGray", 0.0) ;
          double r = 0.04 ;
          fDisk(0 , 0 , r, r, FILLED) ;
          fTeXlabel(-0.05, -0.05, "tr", "$(0,0)$") ;

          fDisk(1 , 0 , r, r, FILLED) ;
          fTeXlabel(1.2, -0.05, "tr", "$(1,0)$") ;

          fDisk(0 , 2 , r, r, FILLED) ;
          fTeXlabel(-0.07, 2.0, "cr", "$(0,2)$") ;

//          double x = 1/Math.sqrt(3) ;
//          fDisk(x, 1, r, r, FILLED) ;
//          fTeXlabel(x, 1+2*r, "cb", "$(\\tfrac{1}{\\sqrt{3}},1)$") ;

     }
}

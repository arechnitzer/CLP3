                  /*  File:  domain2f.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain2f extends Template {

     static {templateClass = new domain2f() ; }

     public void setup() {
          filePrefix = "domain2f" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.25 ;    
          ysize = 1.25 ;  
          xmin = -10 ;
          xmax = 65 ;
          ymin = -10 ;
          ymax = 65 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
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
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax, -2, "tr", "$x$") ;
          fTeXlabel(-2, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          {double[] xlist = {0,  0, 50} ;
           double[] ylist = {0, 50, 50} ;
           fPolygon(xlist,ylist,3,CLOSED+FILLED) ;
          }

          double r = 2 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(50,50, r,r, FILLED) ;
          fTeXlabel(51, 51, "bl", "$(1,1)$") ;

          fEnv("psFillGray", 0.3) ;
          {double[] xlist = {30, 35, 35, 30} ;
           double[] ylist = {30, 35, 50, 50} ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fTeXlabel(22, 20, "tl", "$y=x$") ;
          
     }
}

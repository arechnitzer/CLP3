                  /*  File:  domainTetrahedron2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainTetrahedron2 extends Template {

     static {templateClass = new domainTetrahedron2() ; }

     public void setup() {
          filePrefix = "domainTetrahedron2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6 ;    
          ysize = 1.6 ;  
          xmin = -0.1 ;
          xmax =  1.1 ;
          ymin = -0.1 ;
          ymax =  1.1 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.5 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          double y = 0.3 ;
          double dy = 0.02 ;
          {fEnv("psFillGray", 0.7) ;
           double[] xlist = {   0, 1-y-dy, 1-y+dy, 0} ;
           double[] ylist = {y+dy, y+dy, y-dy, y-dy} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          fLine(0,1,1,0) ;
          fEnv("psFillGray", 0.0) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05, 0, "lc", "$x$") ;
          fTeXlabel(0,ymax+0.05, "bc", "$y$") ;
          fTeXlabel(-0.03,1, "rc", 
              "$\\big(0,b(1-\\frac{z}{c})\\big)$") ;
          fTeXlabel(1-y+0.05,y+0.04, "lc", 
              "$\\big(a(1-\\frac{y}{b}-\\frac{z}{c}), y\\big)$") ;
          
     }
}


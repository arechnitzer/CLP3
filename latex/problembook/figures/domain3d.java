                  /*  File:  domain3d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain3d extends Template {

     static {templateClass = new domain3d() ; }

     public void setup() {
          filePrefix = "domain3d" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.2*0.6 ;    
          ysize = 2.7*0.6 ;  
          xmin = -0.35 ;
          xmax =  1.85 ;
          ymin = -2.2 ;
          ymax =  0.5 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          fCurve("[(1-sin(t))*cos(t),(1-sin(t))*sin(t)]", 1, - Math.PI/2, Math.PI/2, OPEN+FILLED);
          fTeXlabel(1.3, -1, "lc", "$\\rho=a(1-\\cos\\varphi)$") ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;

          fTeXlabel(-0.1, ymax, "rt", "$z$") ;
          fTeXlabel(xmax, -0.1, "rt", "$y$") ;
          
     }
}


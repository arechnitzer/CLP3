                  /*  File:  domain1b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain1b extends Template {

     static {templateClass = new domain1b() ; }

     public void setup() {
          filePrefix = "domain1b" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.25 ;    
          ysize = 1.25 ;  
          xmin = -0.35 ;
          xmax =  1.85 ;
          ymin = -1.1 ;
          ymax =  1.1 ;
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
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          fEllipticalArc(0,0, Math.sqrt(2), Math.sqrt(2), -45, 45, FILLED) ;
          fEllipticalArc(0,0, Math.sqrt(2), Math.sqrt(2), -45, 45, OPEN) ;
          fLine(1,1,1,-1) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax, -0.075, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fLine(0,0,1,1) ;
          fLine(0,0,1,-1) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(1,1, .05, .05, FILLED) ;

          fTeXlabel(1, 1, "bl", "$(1,1)$") ;
          fTeXlabel(2, -0.5+0.05, "cl", "$x=1$") ;
          fTeXlabel(2, 0.5+0.05, "cl", "$r=\\sqrt{2}$") ;
          fArrow(2, -0.5, 1, -0.5) ;
          fArrow(2, 0.5, Math.sqrt(1.75), 0.5) ;
          
     }
}


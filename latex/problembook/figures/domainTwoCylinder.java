                  /*  File:  domainTwoCylinder.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainTwoCylinder extends Template {

     static {templateClass = new domainTwoCylinder() ; }

     public void setup() {
          filePrefix = "domainTwoCylinder" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.1 ;    
          ysize = 1.2 ;  
          xmin = -0.1 ;
          xmax =  1.0 ;
          ymin = -0.6 ;
          ymax =  0.6 ;
          topmargin = 0.0 ;   // in inches
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
          fEnv("psFillGray", 0.8) ;
          fDisk(0.4,0.0, 0.4, 0.4, CLOSED+FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax, -0.04, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fTeXlabel(0.8, 0.45, "bc", "$r=2a\\cos\\theta$") ;
          
     }
}


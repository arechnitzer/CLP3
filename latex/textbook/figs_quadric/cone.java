                  /*  File:  cone.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cone extends Template {

     static {templateClass = new cone() ; }

     public void setup() {
          filePrefix = "cone" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2*0.7 ;      
          ysize = 2*180/120*0.7 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -90 ;
          ymax = 90 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double r = 30 ;
          double h = 25 ;
          double y = h ;
          double x = r*y/h ;
          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/4.5, CLOSED+FILLED) ;
          fLine(-x,-h, x,h) ;
          fLine(x,-h, -x,h) ;
          fEllipticalArc(0,-h, x,x/4.5, 180, 360, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(0,-h, x,x/4.5, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
//          fEnv("lineWidth", 0.5) ;
//          fArrow(0,h, 0, 2.2*h) ; 
//          fTeXlabel(4.0, 2.2*h, "cl", "$\\hn=\\hk$") ;
//          fArrow(0,-h-x/3, 0, -2.2*h) ; 
//          fTeXlabel(4.0, -2.2*h, "bl", "$\\hn=-\\hk$") ;
//          fArrow(x, 0, x+1.2*h,0) ; 
//          fTeXlabel(x+1.2*h, 5, "br", "$\\hn$") ;
     }
}

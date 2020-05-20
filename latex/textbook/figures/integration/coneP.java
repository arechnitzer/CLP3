                  /*  File:  coneP.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneP extends Template {

     static {templateClass = new coneP() ; }

     public void setup() {
          filePrefix = "coneP" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      
          ysize = 2 ;  
          xmin = -60 ;
          xmax = 60 ;
          ymin = -30 ;
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
          double h = 50 ;
          double y = h ;
          double x = r*y/h ;
          double s2 = 2 ;

          fEnv("lineWidth", 1) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(0,h,x,x/3.0, CLOSED+FILLED) ;
          fEnv("lineWidth", 0.5) ;
//          canvas.append( new fPsWrite("0.3 setgray\n")) ;          
          y = 0.58*h ; x = r*y/h ;
          fEnv("psFillGray", 0.6) ;
          fEllipticalArc(0,y, x,x/3.0, 180, 360, OPEN+FILLED) ;
          y = 0.65*h ; x = r*y/h ;
          fEnv("psFillGray", 1.0) ;
          fEllipticalArc(0,y, x,x/3.0, 180, 360, OPEN+FILLED) ;
//          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
          y = 0.60*h ; x = r*y/h ;
          fEllipticalArc(0,y, x,x/3.0, 0, 180, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
//          fArrow(0,h, 0, 1.5*h) ; 
          fEnv("lineWidth", 1) ;
          y = h ; x = r*y/h ;
          fLine(0,0, -x,h) ;
          fLine(0,0, x,h) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2 2] 1 setdash\n")) ;
//          fLine(0,h, 0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine(0,h, 0, 1.5*h) ; 
          fLine(0,0,h,0) ;
          fLine(0,0,-h/s2,-h/s2) ;

          fTeXlabel(0, 1.5*h+0.6, "bc", "$z$") ;
          fTeXlabel(h+0.6, -0.8, "cl", "$y$") ;
          fTeXlabel(-h/s2-0.3, -h/s2-0.3, "tr", "$x$") ;


     }
}

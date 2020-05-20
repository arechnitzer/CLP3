                  /*  File:  coneYY_r.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneYY_r extends Template {

     static {templateClass = new coneYY_r() ; }

     public void setup() {
          filePrefix = "coneYY_r" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          ysize = 2*1.2 ;      
          xsize = 2*180/120*1.2 ;  
          ymin = -60 ;
          ymax = 60 ;
          xmin = -90 ;
          xmax = 90 ;
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
          double x = h ;
          double y = r*x/h ;
          fEnv("lineWidth", 1.5) ;
          fEnv("psFillGray", 0.8) ;
          fDisk(h,0, y/3.0,y, FILLED) ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fLine(-h,y, h,-y) ;
          fLine(-h,-y,  h,y) ;
          fDisk(h,0, y/3.0,y, CLOSED) ;
          fEllipticalArc(-h,0,  y/3.0,y,  90, 270, OPEN) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fEllipticalArc(-h,0,  y/3.0,y, -90, 90, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fArrow(h-y/3.0,0, xmax,0) ;
          fTeXlabel(xmax+1, 0, "cl", "$y$") ;
          fArrow(0,0, 0,0.7*ymax) ;
          fTeXlabel(0, 0.7*ymax+2, "cb", "$z$") ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine(-h,0, h-y/3.0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

     }
}

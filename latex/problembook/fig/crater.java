                  /*  File:  crater.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class crater extends Template {

     static {templateClass = new crater() ; }

     public void setup() {
          filePrefix = "crater" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.2*1.5 ;    
          ysize = 1.4*1.5 ;   
          xmin = -11 ;
          xmax = 11 ;
          ymin = -7 ;
          ymax = 7 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.2, "tr","$x$") ;
          fTeXlabel(-0.2, ymax, "tr","$y$") ;

          fEnv("lineWidth", 1.0) ;
          double z = -5 ;
          double r = Math.sqrt(-100.0/z-10.0) ;
          fDisk(-1, 0, r, r/2.0, CLOSED) ;
          z = -7.5 ; r = Math.sqrt(-100.0/z-10.0) ;
          fDisk(-1, 0, r, r/2.0, CLOSED) ;
          z = -2.5 ; r = Math.sqrt(-100.0/z-10.0) ;
          fDisk(-1, 0, r, r/2.0, CLOSED) ;
          z = -1 ; r = Math.sqrt(-100.0/z-10.0) ;
          fDisk(-1, 0, r, r/2.0, CLOSED) ;

          fEnv("lineWidth", 1.0) ;
//          fEnv("psGray", 0.6) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve("(x+1)*(x+1)*(x+1)*(x+1)/125", 0, -1, 4, OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("psGray", 0.0) ;

          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(4, 5, 0.2, 0.2, CLOSED+FILLED) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(-1,0, 0.2, 0.2, FILLED) ;


          
          
     }
}

                  /*  File:  dderivC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dderivC extends Template {

     static {templateClass = new dderivC() ; }

     public void setup() {
          filePrefix = "dderivC" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3 ;      // in inches
          ysize = 3*3.6/5.0 ;   // in inches. 
          xmin = -2.5 ;
          xmax = 2.5 ;
          ymin = -1.8 ;
          ymax = 1.8 ;
          topmargin = 0.1 ;   // in inches
          bottommargin =-0.1 ;   // in inches
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
          fTeXlabel(xmax+0.1, 0, "lb", "$x$") ;
          fTeXlabel(0, ymax+0.1, "bc", "$y$") ;
          fEnv("lineWidth", 1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          double z0 = 4 ;
          fDisk(0, 0, Math.sqrt(5-z0), Math.sqrt( (5-z0)/2 ), CLOSED ) ;
          fTeXlabel(Math.sqrt( 2*(5-z0)/3.0 ) -0.02, Math.sqrt( (5-z0)/6.0 ) -0.02,
                     "tr", "${\\scriptstyle f(x,y)=4}$") ;
          z0 = 3 ;
          fDisk(0, 0, Math.sqrt(5-z0), Math.sqrt( (5-z0)/2 ), CLOSED ) ;
          z0 = 2 ;
          fDisk(0, 0, Math.sqrt(5-z0), Math.sqrt( (5-z0)/2 ), CLOSED ) ;
          z0 = 1 ;
          fDisk(0, 0, Math.sqrt(5-z0), Math.sqrt( (5-z0)/2 ), CLOSED ) ;
          z0 = 0 ;
          fDisk(0, 0, Math.sqrt(5-z0), Math.sqrt( (5-z0)/2 ), CLOSED ) ;
          fTeXlabel(Math.sqrt( 2*(5-z0)/3.0 ) +0.02, Math.sqrt( (5-z0)/6.0 ) +0.02,
                     "bl", "${\\scriptstyle f(x,y)=0}$") ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          
          fDisk(-1, -1, 0.04, 0.04, FILLED) ;
          double s = 0.1 ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(-1, -1, -1+2*s, -1+4*s) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psGray", 0.4) ;
          fEnv("arrowHeadGray", 0.4) ;
          fArrow(-1.62, -1.22, -1.0, -1.0) ;
          fTeXlabel(-1.6, -1.2, "tr", "$(-1,-1)$") ;

          
     }
}

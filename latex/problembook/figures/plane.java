                  /*  File:  plane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class plane extends Template {

     static {templateClass = new plane() ; }

     public void setup() {
          filePrefix = "plane" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;      
          ysize = 2.0 ;   
          xmin = -50 ;
          xmax = 100 ;
          ymin = -50 ;
          ymax = 100 ;
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
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("lineWidth", 0.5) ;
          fLine(0, 0,   90, 0) ;
          fLine(0, 0,    0, 60) ;
          fLine(0, 0,  -50,-50) ;

          fEnv("lineWidth", 1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine(-40, -40,   75, 0) ;
          fLine(-40, -40,    0,  37) ;
          fLine( 75, 0,      0,  37) ;
          canvas.append( new fPsWrite(Black+"\n")) ;


          double r = 2.5 ;
          fDisk(-40,-40,r,r*aspect, FILLED) ;
          fTeXlabel(-40, -38, "br", "$(4,0,0)$") ;
          fDisk(75,0,r,r*aspect, FILLED) ;
          fTeXlabel(75, 2, "bl", "$(0,4,0)$") ;
          fDisk(0,37,r,r*aspect, FILLED) ;
          fTeXlabel(-3, 37, "cr", "$(0,0,2)$") ;

          fTeXlabel(90, -3, "tr", "$y$") ;
          fTeXlabel(-53, -53, "rt", "$x$") ;
          fTeXlabel(-3, 60, "tr", "$z$") ;
     }
}

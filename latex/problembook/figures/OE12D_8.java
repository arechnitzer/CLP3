                  /*  File:  OE12D_8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12D_8 extends Template {

     static {templateClass = new OE12D_8() ; }

     public void setup() {
          filePrefix = "OE12D_8" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.7*0.6 ;      // in inches
          ysize = 2.7*0.6 ;   // in inches. 
          xmin = -1.2 ;
          xmax = 1.5 ;
          ymin = -1.2 ;
          ymax = 1.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("psFillGray", 0.8) ;
          fDisk(0,0, 1,1, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0.5,0, 0.5,0.5, FILLED) ;
          fTeXlabel(-0.4, 0.4, "cc", "$\\cC$") ;
          fTeXlabel(0.5, 0.2, "cc", "$H$") ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(0,0, 1,1, CLOSED) ;
          fDisk(0.5,0, 0.5,0.5, CLOSED) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.05 ;
          fDisk(1, 0, r, r, FILLED) ;
          fTeXlabel(1.05, 0.05, "bl", "$\\scriptstyle (1,0)$") ;


          
     }
}

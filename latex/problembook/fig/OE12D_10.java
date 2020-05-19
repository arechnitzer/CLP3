                  /*  File:  OE12D_10.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE12D_10 extends Template {

     static {templateClass = new OE12D_10() ; }

     public void setup() {
          filePrefix = "OE12D_10" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4 ;      // in inches
          ysize = 1.4 ;   // in inches. 
          xmin = -0.7 ;
          xmax = 0.7 ;
          ymin = -0.2 ;
          ymax = 1.2 ;
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
          fDisk(0,0.5, 0.5,0.5, FILLED) ;
          fTeXlabel(-0.2, 0.5, "cc", "$V$") ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$y$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;



          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(0,0.5, 0.5,0.5, CLOSED) ;

          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          double th = 60 ; double thRad = th*Math.PI/180 ;
          fLine(0,0, xmax, xmax/Math.tan(thRad) ) ;
          double r = 0.2 ;
          fEllipticalArc(0,0, r,r, 90-th,90, OPEN) ;
          fTeXlabel(0.1, r, "bl", "$\\varphi$") ;



          
     }
}

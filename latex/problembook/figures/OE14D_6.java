                  /*  File:  OE14D_6.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14D_6 extends Template {

     static {templateClass = new OE14D_6() ; }

     public void setup() {
          filePrefix = "OE14D_6" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 2.5 ;
          ymin = -1.5 ;
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
          fEllipticalArc(1,0,1,1,-180,90, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fLine(xmin,xmin, xmax, xmax) ;
          fEllipticalArc(1,0,1,1, 0,360, OPEN) ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEllipticalArc(1,0,1,1,-180,90, OPEN) ;
          fLine(0, 0, 1, 1) ;

          fTeXlabel(1.9, 0.5, "bl", "$(x-1)^2+y^2=1$") ;
          fTeXlabel(ymax+0.1, ymax, "cl", "$y=x$") ;
          fTeXlabel(0.6, -0.4, "cc", "$D$") ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.06 ;
          fDisk(1, 0, r, r, FILLED) ;
          fTeXlabel(1.05, 0.05, "bl", "$\\scriptstyle (1,0)$") ;
          fEnv("lineWidth", 0.5) ;
          fLine(1,0, 1,-1) ;
          fTeXlabel(1.05, -0.5, "cl", "$\\scriptstyle 1$") ;
          







//          fTeXlabel(4.15, 4.15, "bl", "$(4,4)$") ;
//          fDisk(0, 8, r, r, FILLED) ;
//          fTeXlabel(-0.15, 7.85, "tr", "$(0,8)$") ;
//          fDisk(8, 0, r, r, FILLED) ;
//          fTeXlabel(7.85, -0.20, "tr", "$(8,0)$") ;

//          fArrow(1.6,0.4,  0.5+1.5*r, 0.5) ;
//          fTeXlabel(1.7, 0.7, "tl", "$(\\tfrac{1}{2},\\tfrac{1}{2})$") ;


     }
}

                  /*  File:  reverse2A.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class reverse2A extends Template {

     static {templateClass = new reverse2A() ; }

     public void setup() {
          filePrefix = "reverse2A" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.2 ;   
          ysize = 1.2 ;   
          xmin = -0.1  ;
          xmax = 1.3 ;
          ymin = -0.1 ;
          ymax = 1.3 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { 0, 1, 1} ;
            double[] ylist = { 0, 0, 1} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             
          fLine(xmin, ymin, xmax, ymax) ;
          fLine( 1, ymin, 1, ymax) ;

          fLine( xmin, 0, xmax,0) ;
          fLine( 0, ymin, 0, ymax) ;
    

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          { 
            double[] xlist = { 0, 1, 1} ;
            double[] ylist = { 0, 0, 1} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             

          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          double r = 0.05 ;
          fDisk(1,1,r,r,FILLED) ;
          fTeXlabel(1.05, 1.05, "tl", "$(1,1)$") ;

          fTeXlabel(xmax, -0.04, "tr", "$x$") ;
          fTeXlabel(-0.02, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.02, ymax,"lt", "$y=x$") ;
          fTeXlabel(0.98, ymax,"rt", "$x=1$") ;

     }
}

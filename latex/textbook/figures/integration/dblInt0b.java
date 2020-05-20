                  /*  File:  dblInt0b.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class dblInt0b extends Template {

     static {templateClass = new dblInt0b() ; }

     public void setup() {
          filePrefix = "dblInt0b" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*1.0 ;   
          ysize = 1.5*1.0 ;   
          xmin = -0.1  ;
          xmax = 1.4 ;
          ymin = -0.1 ;
          ymax = 1.4 ;
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
          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;
          fLine(xmin, 1-xmin, xmax, 1-xmax) ;

          { 
            double[] xlist = { 0, 1, 0} ;
            double[] ylist = { 0, 0, 1} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }         
    

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;

          fEnv("lineWidth", 2.0) ;
          { 
            double[] xlist = { 0, 1, 0} ;
            double[] ylist = { 0, 0, 1} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }         

          double r = 0.04 ;
          fDisk(1,0,r,r,FILLED) ;
          fDisk(0,1,r,r,FILLED) ;
          double x = 0.3 ;
          fEnv("lineWidth", 4.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(x,0, x,1-x) ;


          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fTeXlabel(x+0.02, 1-x+0.02, "bl", "$y=T(x)=1-x$") ;
//          fTeXlabel(0.3, 0.3, "cc", "$\\cR$") ;
          fTeXlabel(0.97, -0.05, "tr", "$\\scriptstyle (1,0)$") ;
          fTeXlabel(-0.03, 0.97, "tr", "$\\scriptstyle (0,1)$") ;
     }
}

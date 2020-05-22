                  /*  File:  OE14D_5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE14D_5 extends Template {

     static {templateClass = new OE14D_5() ; }

     public void setup() {
          filePrefix = "OE14D_5" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -0.5 ;
          xmax = 9.5 ;
          ymin = -0.5 ;
          ymax = 9.5 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.3, "tr", "$x$") ;
          fTeXlabel(-0.2, ymax, "tr", "$y$") ;

          fEnv("psFillGray", 0.8) ;
          { 
            double[] xlist = { 0, 0, 8} ;
            double[] ylist = { 0, 8, 0} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }             
          fEnv("lineWidth",1.0) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Red) ;
          { 
            double[] xlist = { 0, 0, 8} ;
            double[] ylist = { 0, 8, 0} ;
            fPolygon(xlist, ylist, 3, CLOSED) ;
           }             

          fEnv("lineWidth",2.5) ;
          { 
            double[] xlist = { 8, 0, 0} ;
            double[] ylist = { 0, 0, 8} ;
            fPolygon(xlist, ylist, 3, OPEN) ;
           }             


//          fEnv("lineWidth", 0.8) ;
//          fEnv("psFillGray", 0.6) ;
          double r = 0.25 ;
//          fDisk(0, 0, r, r, FILLED) ;
          fDisk(1, 1, r, r, FILLED) ;
          fTeXlabel(1.15, 1.15, "bl", "$(1,1)$") ;
          fDisk(4, 4, r, r, FILLED) ;
          fTeXlabel(4.15, 4.15, "bl", "$(4,4)$") ;
          fDisk(0, 8, r, r, FILLED) ;
          fTeXlabel(-0.15, 7.85, "tr", "$(0,8)$") ;
          fDisk(8, 0, r, r, FILLED) ;
          fTeXlabel(7.85, -0.20, "tr", "$(8,0)$") ;

          fTeXlabel(-0.15, 4, "cr", "$L_1$") ;
          fTeXlabel(4, -0.25, "ct", "$L_2$") ;
          fTeXlabel(2.15, 6.15, "bl", "$L_3$") ;


//          fArrow(1.6,0.4,  0.5+1.5*r, 0.5) ;
//          fTeXlabel(1.7, 0.7, "tl", "$(\\tfrac{1}{2},\\tfrac{1}{2})$") ;


     }
}

                  /*  File:  OE07A_8.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE07A_8 extends Template {

     static {templateClass = new OE07A_8() ; }

     public void setup() {
          filePrefix = "OE07A_8" ;    
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.5*0.5 ;      // in inches
          ysize = 2.6*0.5 ;   // in inches. 
          xmin = -2.25 ;
          xmax =  2.25 ;
          ymin = -0.2 ;
          ymax =  2.4 ;
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
          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { -2, 2,  2, -2} ;
            double[] ylist = {  0, 0,  2, 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             

          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;

          fTeXlabel(2.1, 1, "cl", "$x^2+y^2=4$") ;
          fTeXlabel(1, 1, "cc", "$V$") ;

          fEnv("lineWidth",1.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          { 
            double[] xlist = { -2, 2,  2, -2} ;
            double[] ylist = {  0, 0,  2, 2} ;
            fPolygon(xlist, ylist, 4, CLOSED) ;
           }             

          double r = 0.07 ;
          fEnv("psFillGray", 0.0) ;
          fDisk(2,2, r,r, FILLED) ;
          fTeXlabel(2.05, 2.05, "bl",  "$\\scriptstyle (2,0,2)$") ;

          
     }
}

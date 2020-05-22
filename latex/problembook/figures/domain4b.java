                  /*  File:  domain4b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain4b extends Template {

     static {templateClass = new domain4b() ; }

     public void setup() {
          filePrefix = "domain4b" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 5.0*0.7 ;    
          ysize = 2.0*0.7 ;  
          xmin = -2.5 ;
          xmax =  2.5 ;
          ymin = -0.1 ;
          ymax =  1.9 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          fCurve(new halfdisk(),-2,6,FILLED+CLOSED)  ;
          fEnv("psFillGray", 0.3) ;
          {double[] xlist = {-Math.sqrt(3.5), -Math.sqrt(3.5), Math.sqrt(3.5), Math.sqrt(3.5)} ;
           double[] ylist = {0.525,  0.675, 0.675, 0.525 } ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          {double[] xlist = {0.925, 1.075, 1.075, 0.925} ;
           double[] ylist = {0,  0, Math.sqrt(1.5), Math.sqrt(1.5) } ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax, -0.05, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fTeXlabel(2, -0.15, "tc", "$2$") ;
          fTeXlabel(0, -0.15, "tc", "$0$") ;
          fTeXlabel(-2, -0.15, "tc", "$-2$") ;
          fTeXlabel(0.05, Math.sqrt(2)+0.02, "bl", "$\\sqrt{2}$") ;
          fTeXlabel(-1.6, 1.3, "bc", "$x^2+2y^2=4$") ;
          
     }
}


class halfdisk implements S2V {


   public halfdisk() {
   }

     public double[] map(double t) {
      double[] out = {0,0} ;
      if ( t<2) {
           out[0] = t;
           out[1] = Math.sqrt(2-t*t/2) ;
      }  else  {
           out[0] = 4-t ;
           out[1] = 0 ;
      }
      return out ;
   }
}

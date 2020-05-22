                  /*  File:  domain2e.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain2e extends Template {

     static {templateClass = new domain2e() ; }

     public void setup() {
          filePrefix = "domain2e" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.25 ;    
          ysize = 1.25 ;  
          xmin = -10 ;
          xmax = 65 ;
          ymin = -10 ;
          ymax = 65 ;
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
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax, -2, "tr", "$x$") ;
          fTeXlabel(-2, ymax, "tr", "$y$") ;

          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          fCurve(new parabolaLine(),0,100,FILLED)  ;
          fCurve("[t, t*t/50]",1,0,60,OPEN) ;
          fLine(0,0, 60, 60) ;
          fTeXlabel(51, 49, "tl", "$(1,1)$") ;
          fEnv("psFillGray", 0.3) ;
          {double[] xlist = {22.5, 22.5, Math.sqrt(50*22.5), Math.sqrt(50*22.5)} ;
           double[] ylist = {20,  25,    25, 20} ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fDisk(50,50, 2,2 , FILLED) ;
          fTeXlabel(32, 32*32/50.0, "tl", "$y=x^2$") ;
          fTeXlabel(40, 40, "br", "$y=x$") ;
          
     }
}


class parabolaLine implements S2V {


   public parabolaLine() {
   }

     public double[] map(double t) {
      double[] out = {0,0} ;
      if ( t<50) {
           out[0] = t;
           out[1] = t*t/50 ;
      }  else {
           out[0] = 100-t ;
           out[1] = 100-t ;
      }
      return out ;
   }
}

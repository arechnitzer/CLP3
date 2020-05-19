                  /*  File:  domain2d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain2d extends Template {

     static {templateClass = new domain2d() ; }

     public void setup() {
          filePrefix = "domain2d" ;  
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
          fCurve(new downparabola(),0,100,FILLED)  ;
          fCurve("[t, 50-t*t/50]",1,0,60,OPEN) ;
          fTeXlabel(52, 2, "bl", "$(1,0)$") ;
          fEnv("psFillGray", 0.3) ;
          {double[] xlist = {30, 35, 35, 30} ;
           double[] ylist = {0,  0, 50-32.5*32.5/50, 50-32.5*32.5/50} ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fDisk(50,0, 2,2 , FILLED) ;
          fTeXlabel(22, 50-20*20/50.0, "bl", "$y=1-x^2$") ;          
     }
}


class downparabola implements S2V {


   public downparabola() {
   }

     public double[] map(double t) {
      double[] out = {0,0} ;
      if ( t<50) {
           out[0] = t;
           out[1] = 50-t*t/50 ;
      }  else {
           out[0] = 100-t ;
           out[1] = 0 ;
      }
      return out ;
   }
}

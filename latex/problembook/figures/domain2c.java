                  /*  File:  domain2c.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain2c extends Template {

     static {templateClass = new domain2c() ; }

     public void setup() {
          filePrefix = "domain2c" ;  
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
          fCurve(new twoparabolas(),0,100,FILLED)  ;
          fCurve("[t, t*t/50]",1,0,60,OPEN) ;
          fCurve("[t*t/50, t]",1,0,60,OPEN) ;
          fTeXlabel(52, 48, "tl", "$(1,1)$") ;
          fEnv("psFillGray", 0.3) ;
          {double[] xlist = {20, 25, 25, 20} ;
           double[] ylist = {21.5*21.5/50.0,  21.5*21.5/50.0, Math.sqrt(50*22.5), 
                             Math.sqrt(50*22.5)} ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("psFillGray", 0.0) ;
          fDisk(50,50, 2,2 , FILLED) ;
          fTeXlabel(32, 32*32/50.0, "tl", "$y=x^2$") ;
          fTeXlabel(45, Math.sqrt(50*45), "br", "$x=y^2$") ;
          
     }
}


class twoparabolas implements S2V {


   public twoparabolas() {
   }

     public double[] map(double t) {
      double[] out = {0,0} ;
      if ( t<50) {
           out[0] = t;
           out[1] = t*t/50 ;
      }  else {
           out[0] = (100-t)*(100-t)/50 ;
           out[1] = 100-t ;
      }
      return out ;
   }
}

                  /*  File:  domain4c.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain4c extends Template {

     static {templateClass = new domain4c() ; }

     public void setup() {
          filePrefix = "domain4c" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4 ;    
          ysize = 1.4 ;  
          xmin = -3 ;
          xmax =  3 ;
          ymin = -6 ;
          ymax =  6 ;
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
          fCurve(new parabolaSkewLine(),-2,4,FILLED+CLOSED)  ;
          fCurve("[t, t*t+4*t]",1,xmin,xmax,OPEN) ;
          fCurve("[t, 3*t+2]",1,xmin,xmax,OPEN) ;
          fEnv("psFillGray", 0.3) ;
          {double[] xlist = {-1.4/3.0, -1.4/3.0, -2+Math.sqrt(4.6), -2+Math.sqrt(4.6)} ;
           double[] ylist = {0.4,  0.8, 0.8, 0.4 } ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          {double[] xlist = {-0.9, -1.1, -1.1, -0.9} ;
           double[] ylist = {-1,  -1, -3, -3 } ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fLine(0,ymin,0,ymax) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymin+0.5) ;
          fLine(0,ymin+1.5,0,-2.5) ;
          fLine(0,-1.5,0,ymax) ;
          fTeXlabel(xmax, -0.25, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;


          fEnv("psFillGray", 0.0) ;
          fDisk(1,5, .15, .3, FILLED) ;
          fDisk(-2,-4, .15, .3, FILLED) ;

          fTeXlabel(1.15, 5.3, "tl", "$(1,5)$") ;
          fTeXlabel(-2, -4.3, "tl", "$(-2,-4)$") ;
          fTeXlabel(-0.3, 1.4, "br", "$y=3x+2$") ;
          fTeXlabel(-0.4, -1.3, "lt", "$y=x^2+4x$") ;
          
     }
}


class parabolaSkewLine implements S2V {


   public parabolaSkewLine() {
   }

     public double[] map(double t) {
      double[] out = {0,0} ;
      if ( t<1) {
           out[0] = t;
           out[1] = t*t+4*t ;
      }  else  {
           out[0] = 2-t ;
           out[1] = 3*(2-t)+2 ;
      }
      return out ;
   }
}

                  /*  File:  domain4a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domain4a extends Template {

     static {templateClass = new domain4a() ; }

     public void setup() {
          filePrefix = "domain4a" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4 ;    
          ysize = 1.4 ;  
          xmin = -0.15 ;
          xmax =  2.85 ;
          ymin = -0.5 ;
          ymax =  10.5 ;
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
          fTeXlabel(xmax, -0.2, "tr", "$x$") ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;


          fEnv("lineWidth", 1.0) ;
          fEnv("psFillGray", 0.7) ;
          fCurve(new exptriangle(),0,5,FILLED)  ;
          fCurve("[t, exp(t)]",1,0,2.5,OPEN) ;
          fLine(xmin, 1, 2.5, 1) ;
          fLine(2, 0, 2, ymax) ;
          fEnv("psFillGray", 0.3) ;
          double widy = 0.3*0.75 ;
          double widx = widy*3.0/11.0 ;
          {double[] xlist = {Math.log(2), Math.log(2), 2, 2} ;
           double[] ylist = {2-widy,  2+widy, 2+widy, 2-widy } ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          {double[] xlist = {1.6-widx, 1.6+widx, 1.6+widx, 1.6-widx} ;
           double[] ylist = {1,  1, Math.exp(1.6), Math.exp(1.6) } ;
           fPolygon(xlist,ylist,4,FILLED) ;
          }
          fTeXlabel(2, -0.3, "tc", "$2$") ;
          fTeXlabel(0.1, -0.3, "tl", "$0$") ;
          fTeXlabel(-0.2, 1, "rc", "$1$") ;
//          fTeXlabel(-0.1, Math.exp(2),  "rc", "$e^2$") ;
          fTeXlabel(2.5, 11, "tl", "$y=e^x$") ;
          fTeXlabel(2.5, 9.75, "tl", "$x=\\ln y$") ;

          double r = 0.07 ;
          fEnv("psFillGray", 0.0) ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fDisk(2, Math.exp(2), r,r*aspect, FILLED) ;
          fTeXlabel(2.1, Math.exp(2), "tl", "$(2,e^2)$") ;

          
     }
}


class exptriangle implements S2V {


   public exptriangle() {
   }

     public double[] map(double t) {
      double[] out = {0,0} ;
      if ( t<2) {
           out[0] = t;
           out[1] = Math.exp(t) ;
      }  else if ( t<3 ) {
           out[0] = 2 ;
           out[1] = Math.exp(2) -(t-2)*(1-Math.exp(2)) ;
      }  else  {
           out[0] = 5-t ;
           out[1] = 1 ;
      }
      return out ;
   }
}

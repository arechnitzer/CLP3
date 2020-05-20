                  /*  File:  g_n.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class g_n extends Template {

     static {templateClass = new g_n() ; }

     public void setup() {
          filePrefix = "g_n" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.7*0.8 ;     
          ysize = 2.9*0.4 ;   
          xmin = -.1 ;
          xmax = 1.4 ;
          ymin = -0.4 ;
          ymax = 5.4 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0.4 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double d1 = 0.5 ;
          double d2 = 1.0 ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fTeXlabel(xmax,-0.2,"tr","$t$") ;
          fLine(0, ymin, 0, ymax) ;
          fTeXlabel(-0.05, ymax,"tr","$y$") ;
          fLine(d1, 0, d1, -0.4) ;
          fTeXlabel(d1, -0.4,"tc","$\\de_{n+1}$") ;
          fLine(d2, 0, d2, -0.4) ;
          fTeXlabel(d2+0.1, -0.4,"tc","$\\de_{n}$") ;
          fLine(0, 2/(d2-d1), -0.07, 2/(d2-d1)) ;
          fTeXlabel(-0.1,2/(d2-d1), "rc","$\\frac{2}{\\de_{n}-\\de_{n+1}}$") ;
          fTeXlabel(d2, 1/(d2-d1),"lc","$y=g_n(t)$") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          {double[] xlist = {xmin, d1, (d1+d2)/2, d2, xmax} ;
           double[] ylist = {   0,  0,     2/(d2-d1), 0, 0} ;
           fPolygon(xlist, ylist, 5, OPEN) ;
          }


     }
}

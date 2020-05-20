                  /*  File:  coneX.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class coneX extends Template {

     static {templateClass = new coneX() ; }

     public void setup() {
          filePrefix = "coneX" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.4*1.5 ;   
          ysize = 1.1*1.5 ;   
          xmin = -7.0 ;
          xmax = 7.0 ;
          ymin = -10.0 ;
          ymax = 2.0 ;
          topmargin = 0.0 ;
          bottommargin = 0.0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;          
          fLine(-6, 0, 0, -9) ;
          fLine(0, -9, 6, 0) ;
          fLine(-6, -0, 6, 0) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 0.2) ;
          
          fEnv("psFillGray", 0.6) ;
          double D = 3 ;
          double d = 0.25 ;
          double X = (9-D)*2.0/3.0 ;
          double x = d*2.0/3.0 ;
          {double[] xlist = {-X-x, X+x, X-x, -X+x} ;
           double[] ylist = {-D+d, -D+d, -D-d, -D-d } ;
           fPolygon(xlist, ylist, 4, FILLED) ;
          }
          fArrow(0,-(D+9)/2.0+0.6,0,-D) ;
          fArrow(0,-(D+9)/2.0-0.6 ,0,-8.8) ;
          fArrow(X/2.0-0.8,-D+1.2 , 0,-D+1.2) ;
          fArrow(X/2.0+0.8,-D+1.2 , X,-D+1.2) ;
          fArrow(6, -D+d+1.5, 6,-D+d) ;
          fArrow(6, -D-d-1.5, 6,-D-d) ;
          fArrow(-6.5, -4.5+0.6, -6.5, 0) ;
          fArrow(-6.5, -4.5-0.8, -6.5, -9) ;
          fArrow(3-0.7,  0.8 , 0, 0.8) ;
          fArrow(3+0.7,  0.8 , 6, 0.8) ;


          fTeXlabel(6.2, -D+0.3, "lc", "$dz$") ;
          fTeXlabel(0, -(D+9)/2.0, "cc", "$z$") ;
          fTeXlabel(-6.5, -4.5, "cc", "$h$") ;
          fTeXlabel(3, 0.8, "cc", "$a$") ;
          fTeXlabel(X/2.0,-D+1.2, "cc", "$\\tfrac{z}{h}a$") ;

     }
}

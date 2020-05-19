                  /*  File:  coneT.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class coneT extends Template {

     static {templateClass = new coneT() ; }

     public void setup() {
          filePrefix = "coneT" ;
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
          fLine(0, 0, 0, -9) ;
          fLine(0, -9, 6, 0) ;
          fLine(0, 0, 6, 0) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 0.2) ;
          
          fEnv("psFillGray", 0.6) ;
          double D = 3 ;
          double d = 0.25 ;
          double X = (9-D)*2.0/3.0 ;
          double x = d*2.0/3.0 ;
          {double[] xlist = {0, X+x, X-x, 0} ;
           double[] ylist = {-D+d, -D+d, -D-d, -D-d } ;
           fPolygon(xlist, ylist, 4, FILLED) ;
          }
          double x1 = -0.6 ;
          double x2 = -1.5 ;
          fArrow(x1,-(D+9)/2.0+0.6,x1,-D) ;
          fArrow(x1,-(D+9)/2.0-0.6 ,x1,-8.8) ;
          fArrow(x2, -4.5+0.6, x2, 0) ;
          fArrow(x2, -4.5-0.8, x2, -9) ;


          fTeXlabel(x1, -(D+9)/2.0, "cc", "$z$") ;
          fTeXlabel(x2, -4.5, "cc", "$h$") ;
          fTeXlabel(3, 0.8, "cc", "$a$") ;
//          fTeXlabel(X/2.0,-D+1.2, "cc", "$R=\\tfrac{z}{h}a$") ;
          fTeXlabel(X/2.0,-D+1.0, "cc", "$R$") ;

     }
}

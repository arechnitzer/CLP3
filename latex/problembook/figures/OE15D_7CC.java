                  /*  File:  OE15D_7CC.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE15D_7CC extends Template {

     static {templateClass = new OE15D_7CC() ; }

     public void setup() {
          filePrefix = "OE15D_7CC" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 2.0 ;   
          xmin = -1.2  ;
          xmax = 1.2 ;
          ymin = -1.2 ;
          ymax = 1.2 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          double X = 0.8 ; double Y = Math.sqrt(1-X*X) ;

           {fEnv("psFillGray", 0.8) ;
           double[] xlist = {-Y, -Y, Y, Y} ;
           double[] ylist = {-Y, -1, -1, Y} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(Y, ymin, Y, ymax) ;
          fTeXlabel(Y+0.05, 0.5*Y,"cl", "$y=\\sqrt{1-x^2}$") ;
          fLine(-Y, ymin, -Y, ymax) ;
          fTeXlabel(-Y-0.05, Y,"cr", "$y=-\\sqrt{1-x^2}$") ;
          fLine(xmin, xmin, xmax, xmax) ;
          fTeXlabel(xmax+0.03, ymax,"cl", "$z=y$") ;
          fLine(xmin, -1, xmax, -1) ;
          fTeXlabel(xmax+0.03, -0.97,"lc", "$z=-1$") ;
          fLine(Y, Y, xmax, Y) ;
          fTeXlabel(xmax+0.03, Y+0.03,"cl", "$z=\\sqrt{1-x^2}$") ;
          fLine(-Y, -Y, xmax, -Y) ;
          fTeXlabel(xmax+0.03, -Y+0.03,"cl", "$z=-\\sqrt{1-x^2}$") ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fTeXlabel(xmax, -0.05, "tr", "$y$") ;
          fTeXlabel(-0.03, ymax, "tr", "$z$") ;

          fEnv("lineWidth", 3.0) ;
          canvas.append( new fPsWrite("0.4 setgray\n")) ;
          double z1 = -0.2 ;
          double z2 = -0.8 ;
          fLine(z1,z1, Y,z1) ;
          fLine(-Y,z2, Y,z2) ;

     }
}

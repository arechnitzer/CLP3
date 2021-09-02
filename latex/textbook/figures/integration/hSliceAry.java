                  /*  File:  hSliceAry.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hSliceAry extends Template {

     static {templateClass = new hSliceAry() ; }

     public void setup() {
          filePrefix = "hSliceAry" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 2.0 ;   
          xmin = -6  ;
          xmax = 4 ;
          ymin = -5 ;
          ymax = 5 ;
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
          fEnv("psFillGray", 0.9) ;
          fCurve("[-0.5*t*t+3,t]", 1, -2, 4, FILLED) ;
          fCurve("[-0.5*t*t+3,t]", 1, ymin, ymax, OPEN) ;
          fLine(xmin, -xmin-1, xmax, -xmax-1) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[-0.5*t*t+3,t]", 1, -2, 4, OPEN) ;
          fLine(1, -2, -5, 4) ;


          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          fLine(-5, 4, xmax , 4) ;
          fLine(1, -2, xmax , -2) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.25, "cb", "$y$") ;
          fTeXlabel(xmin-0.3, -Math.sqrt(-2*xmin+6)-0.1,"cr",
                                  "$x=-L(y)$") ;
          fTeXlabel(-ymin-0.8, ymin, "cl", "$x=-R(y)$") ;
          fTeXlabel(xmax+0.1, 4, "cl", "$y = d$") ;
          fTeXlabel(xmax+0.1, -2.05, "cl", "$y = c$") ;
          fTeXlabel(-0.6, 1.0, "cc", "$\\cR_y$") ;
     }
}

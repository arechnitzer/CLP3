                  /*  File:  hSliceA.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hSliceA extends Template {

     static {templateClass = new hSliceA() ; }

     public void setup() {
          filePrefix = "hSliceA" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;   
          ysize = 2.0 ;   
          xmin = -4  ;
          xmax = 6 ;
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
          fCurve("[0.5*t*t-3,t]", 1, -2, 4, FILLED) ;
          fCurve("[0.5*t*t-3,t]", 1, ymin, ymax, OPEN) ;
          fLine(xmin, xmin-1, xmax, xmax-1) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;

          fEnv("lineWidth", 2.0) ;
          fCurve("[0.5*t*t-3,t]", 1, -2, 4, OPEN) ;
          fLine(-1, -2, 5, 4) ;

//          fEnv("lineWidth", 8.0) ;
//          canvas.append( new fPsWrite("0.7 setgray\n")) ;
//          double y = 1.5 ;
//          fLine(0.5*y*y-3, y, y+1, y) ;
//          canvas.append( new fPsWrite("0.0 setgray\n")) ;
//          double xsr = 0.25 ;  double xsl = 1.0 ;  double xj = 0.5 ;
//          fLine(xsl, y, xsr, y) ;



          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
//          double xr = y+1 ;  double xl = (y*y-6)/2.0 ; 
//          fLine(xl, 0, xl,y ) ;
//          fLine(xr, 0, xr,y ) ;
//          fLine(xr, y, xmax , y) ;
          fLine(5, 4, xmin , 4) ;
          fLine(-1, -2, xmin , -2) ;
//          fLine(xj, y, xj , -1.5) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xmax+0.1, 0.0, "cl", "$x$") ;
          fTeXlabel(0.0, ymax+0.25, "cb", "$y$") ;
          fTeXlabel(xmax+0.3, -Math.sqrt(2*xmax+6)-0.1,"cl",
                                  "$x=L(y)$") ;
          fTeXlabel(ymin+0.9, ymin, "cr", "$x=R(y)$") ;
//          fTeXlabel(xj-0.2, -1.52, "tl", "$x = x_j^*$") ;
//          fTeXlabel(xmax+0.1, y, "cl", "$y = y_i^*$") ;
          fTeXlabel(xmin-0.1, 4, "cr", "$y = d$") ;
          fTeXlabel(xmin-0.1, -2.05, "cr", "$y = c$") ;
          fTeXlabel(0.5, 1.25, "cc", "$\\cR$") ;

//          double h = 0.2 ;
//          fLine(xl,0, xl,-h) ;   
//             fTeXlabel(xl+0.1, -h*1.5, "tc", "$\\scriptstyle L(y_i^*)$") ;
//          fLine(xr,0, xr,-h) ;   
//             fTeXlabel(xr, -h*1.5, "tc", "$\\scriptstyle R(y_i^*)$") ;


     }
}

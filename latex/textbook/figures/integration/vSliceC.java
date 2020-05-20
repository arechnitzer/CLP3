                  /*  File:  vSliceC.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class vSliceC extends Template {

     static {templateClass = new vSliceC() ; }

     public void setup() {
          filePrefix = "vSliceC" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.75 ;   
          ysize = 1.5*11.5/9.5 ;   
          xmin = -2.0 ;
          xmax = 2.5 ;
          ymin = -4.5 ;
          ymax = 7.0 ;
          topmargin = 0 ;
          bottommargin = 0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 0.5) ;
          double yMin = -3.0 ;


          fCurve("y=6-x*x", 0, xmin, 2.2, OPEN) ;
          fCurve("y=x", 0, xmin, 2.2, OPEN) ;
          fLine(xmin,-2.5, xmax,-2.5) ;
          fLine(-1.8,yMin,-1.8,ymax) ;
          fTeXlabel(xmax, -2.65, "tr", "$x$") ;
          fTeXlabel(-1.85, ymax, "tr", "$y$") ;

          fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { -1, -1, 0, 2} ;
            double[] ylist = { -1,  5, 6, 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fCurve("y=6-x*x", 0, -1, 2, FILLED) ;


          int N = 8 ;
          double dx = 3.0/N ;
          double xl, xr, xis, tl, bl, tr, br, tis, bis ;
          double i = 5 ;
          xl = -1 + (i-1)*dx ;  bl = xl ;  tl = 6-xl*xl ;
          xr = -1 + i*dx     ;  br = xr ;  tr = 6-xr*xr ;
          xis = -1 +(i-0.66)*dx ;  bis = xis ;  tis = 6-xis*xis ;
          fLine(xl,bl, xl,tl) ;
          fLine(xr,br, xr,tr) ;
          fLine(xl, yMin, xl, -2.5) ;
          fLine(xr, yMin, xr, -2.5) ;
          fLine(xis, yMin, xis, -2.5) ;
          fArrow(xr+0.5,-3.5, xr,yMin-0.1) ;
          fArrow(xl-0.5,-3.5, xl,yMin-0.1) ;
          fArrow(xis-0.15,-4.5, xis,yMin-0.1) ;
          fTeXlabel(xl-0.55, -3.53, "rt", "$x_{i-1}$") ;
          fTeXlabel(xr+0.55, -3.53, "lt", "$x_i$") ;
          fTeXlabel(xis-0.1,-4.6, "ct", "$x_i^*$") ;
          fLine(-1.8, tis, -1.93, tis) ;
          fLine(-1.8, bis, -1.93, bis) ;
          fTeXlabel(-1.96, bis, "cr", "$B(x_i^*)$") ;
          fTeXlabel(-1.96, tis, "cr", "$T(x_i^*)$") ;
          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
          fLine(-1.8, tis, xl, tis) ;
          fLine(-1.8, bis, xl, bis) ;
          fLine(xl, yMin, xl, bis) ;
          fLine(xr, yMin, xr, bis) ;
          fLine(xis, yMin, xis, tis) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;




          fTeXlabel(xmin-0.05, 6-xmin*xmin, "rc", "$\\scriptstyle y=T(x)$") ;
          fTeXlabel(xmin-0.05, xmin, "rc", "$\\scriptstyle y=B(x)$") ;



          fEnv("lineWidth", 2.0) ;
          fCurve("y=6-x*x", 0, -1, 2, OPEN) ;
          fCurve("y=x", 0, -1, 2, OPEN) ;
          fLine(-1,-1,  -1,5) ;
//          fTeXlabel( 0.2, 3, "cc", "$\\cR$") ;

          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          { 
             double[] xlist = { xl, xl, xr, xr} ;
             double[] ylist = { bis, tis, tis, bis} ;
             fPolygon(xlist, ylist, 4, CLOSED) ;
          }


     }
}

                  /*  File:  vSliceD.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class vSliceD extends Template {

     static {templateClass = new vSliceD() ; }

     public void setup() {
          filePrefix = "vSliceD" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.75*5.5/4.5 ;   
          ysize = 1.5*11.0/9.5 ;   
          xmin = -3.0 ;
          xmax = 2.5 ;
          ymin = -4.5 ;
          ymax = 6.5 ;
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
          double xMin = -1.93 ;


//          fCurve("y=6-x*x", 0, xMin, 2.2, OPEN) ;
//          fCurve("y=x", 0, xMin, 2.2, OPEN) ;
          fLine(xMin,-2.5, xmax,-2.5) ;
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

//          fTeXlabel(xMin-0.1, 6-xMin*xMin, "rc", "$y=T(x)$") ;
//          fTeXlabel(xMin-0.1, xMin, "rc", "$y=B(x)$") ;

          fEnv("lineWidth", 2.0) ;
          fCurve("y=6-x*x", 0, -1, 2, OPEN) ;
          fCurve("y=x", 0, -1, 2, OPEN) ;
          fLine(-1,-1,  -1,5) ;
//          fTeXlabel( 0.2, 3, "cc", "$\\cR$") ;

          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;

          int M = 5 ;
          double dy = (tis-bis)/M ;
          double yj ;
          double tj = bis + 2*dy; double bj = bis + dy  ;
          double yjs = bis + 1.6*dy ;
            fEnv("psFillGray", 0.6) ;
            { 
              double[] xlist = { xl, xl, xr, xr} ;
              double[] ylist = { bj, tj, tj, bj} ;
              fPolygon(xlist, ylist, 4, FILLED) ;
            }
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(-1.8, bj, xMin, bj) ;
          fLine(-1.8, tj, xMin, tj) ;
          fLine(-1.8, yjs, xMin, yjs) ;
          fArrow(-2.4, tj+1,xMin-0.07,tj) ;
          fArrow(-2.4, bj-1,xMin-0.07,bj) ;
          fArrow(-2.4,yjs, xMin-0.07,yjs) ;
          fTeXlabel(-2.45, bj-1, "rt", "$y_{j-1}$") ;
          fTeXlabel(-2.45, tj+1, "rb", "$y_j$") ;
          fTeXlabel(-2.45,yjs, "rc", "$y_j^*$") ;
          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
          fLine(-1.8, tj, xl, tj) ;
          fLine(-1.8, bj, xl, bj) ;
          fLine(-1.8, yjs, xis, yjs) ;
          fLine(xl, yMin, xl, bis) ;
          fLine(xr, yMin, xr, bis) ;
          fLine(xis, yMin, xis, tis) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          { 
             double[] xlist = { xl, xl, xr, xr} ;
             double[] ylist = { bis, tis, tis, bis} ;
             fPolygon(xlist, ylist, 4, CLOSED) ;
          }

          canvas.append( new fPsWrite(Red+"\n")) ;


          for (int m = 0; m <= M; m++) {
               yj = bis + m*dy ;
               fLine(xl,yj, xr,yj) ;
          }



     }
}

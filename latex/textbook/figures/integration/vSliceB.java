                  /*  File:  vSliceB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class vSliceB extends Template {

     static {templateClass = new vSliceB() ; }

     public void setup() {
          filePrefix = "vSliceB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.75 ;   
          ysize = 1.5 ;   
          xmin = -2.0 ;
          xmax = 2.5 ;
          ymin = -3.0 ;
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

          fCurve("y=6-x*x", 0, xmin, 2.2, OPEN) ;
          fCurve("y=x", 0, xmin, 2.2, OPEN) ;
          fLine(xmin,-2.5, xmax,-2.5) ;
          fLine(-1.8,ymin,-1.8,ymax) ;
          fTeXlabel(xmax, -2.65, "tr", "$x$") ;
          fTeXlabel(-1.85, ymax, "tr", "$y$") ;

          fTeXlabel(xmin-0.1, 6-xmin*xmin, "rc", "$y=T(x)$") ;
          fTeXlabel(xmin-0.1, xmin, "rc", "$y=B(x)$") ;


                    fEnv("psFillGray", 0.9) ;
          { 
            double[] xlist = { -1, -1, 0, 2} ;
            double[] ylist = { -1,  5, 6, 2} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          fCurve("y=6-x*x", 0, -1, 2, FILLED) ;


          int N = 8 ;
          double dx = 3.0/N ;
          double xi, ti, bi ;

          fTeXlabel(-1+0.05, ymin-0.2, "tc", "$x_0$") ;
          fTeXlabel(-1+dx+0.05, ymin-0.2, "tc", "$x_1$") ;
          fTeXlabel(-1+2*dx+0.05, ymin-0.2, "tc", "$x_2$") ;
          fTeXlabel(-1+5*dx+0.05, ymin-0.2, "tc", "$\\cdots$") ;
          fTeXlabel( 2+0.05, ymin-0.2, "tc", "$x_n$") ;
          fLine(-1,-2.5, -1,ymin) ;
          fLine( 2,-2.5,  2,ymin) ;

          for (int m = 1; m < N; m++) {
               xi = -1 + m*dx ;
               bi = xi ;
               ti = 6-xi*xi ;
               fLine(xi,bi, xi,ti) ;
               canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
                  fLine(xi, -2.5, xi, bi) ;
               canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

//               fEnv("psFillGray", 0.6) ;
//               { 
//                 double[] xlist = { x0, x0, x1, x1} ;
//                 double[] ylist = { b0, t0, t0, b0} ;
//                 fPolygon(xlist, ylist, 4, FILLED) ;
//               }
               fLine(xi, ymin, xi, -2.5) ;
//               fTeXlabel(x1, -0.1, "tc", "$\\tfrac{"+m+"}{"+N+"}$") ;
          }
          canvas.append( new fPsWrite("[2.5 2.5] 1.0 setdash\n")) ;
             fLine(-1, -2.5, -1, -1) ;
             fLine(2, -2.5, 2, 2) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fEnv("lineWidth", 2.0) ;
          fCurve("y=6-x*x", 0, -1, 2, OPEN) ;
          fCurve("y=x", 0, -1, 2, OPEN) ;
          fLine(-1,-1,  -1,5) ;
//          fTeXlabel( 0.2, 3, "cc", "$\\cR$") ;

     }
}

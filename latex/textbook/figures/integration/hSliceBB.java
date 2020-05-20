                  /*  File:  hSliceBB.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class hSliceBB extends Template {

     static {templateClass = new hSliceBB() ; }

     public void setup() {
          filePrefix = "hSliceBB" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.5*0.6 ;   
          ysize = 4.0*0.6 ;   
          xmin = -3  ;
          xmax = 4.0 ;
          ymin = -1.2 ;
          ymax = 2.8 ;
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
          double yMin = -0.25 ;
          double xMax =  3.5 ;
          fEnv("psFillGray", 0.9) ;
          fCurve("[0.5*t*t-3,t]", 1, -2, 4, FILLED) ;
          fEnv("lineWidth", 2.0) ;
          fCurve("[0.5*t*t-3,t]", 1, -2, 2.6, OPEN) ;
          fLine(-1, -2, 5, 4) ;

          fEnv("psFillGray", 1.0) ;
          { 
            double[] xlist = { xmin, xmin, xMax+1, xMax+1} ;
            double[] ylist = {  2.4,  5.0, 5.0,   2.4} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          { 
            double[] xlist = { xmin-1, xmin-1, xMax, xMax} ;
            double[] ylist = { -0.1, -2.0, -2.0, -0.1} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xMax, 0.0) ;
          fLine(0.0, yMin, 0.0, ymax) ;


          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          double y = 1.5 ; double yb = 1.3 ; double yt = 1.7 ;
          double xL = 0.5*y*y-3 ;   double xR = y+1 ;
          fEnv("psFillGray", 0.7) ;
          { 
            double[] xlist = { xL, xL, xR, xR} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          double xsl = 0.25 ;  double xsr = 0.8 ;  double xj = 0.5 ;
          fEnv("psFillGray", 0.0) ;
          { 
            double[] xlist = { xsl, xsl, xsr, xsr} ;
            double[] ylist = { yt, yb, yb, yt} ;
            fPolygon(xlist, ylist, 4, FILLED) ;
           }             




          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0 setdash\n")) ;
          double xr = y+1 ;  double xl = (y*y-6)/2.0 ; 
          fLine(xl, 0, xl,yb ) ;
          fLine(xr, 0, xr,yb ) ;
          fLine(xr, y, xMax , y) ;
          fLine(xr, yt, xMax , yt) ;
          fLine(xr, yb, xMax , yb) ;
          fLine(5, 4, xmin , 4) ;
          fLine(-1, -2, xmin , -2) ;
          fLine(xj, yb, xj , yMin) ;
          fLine(xsl, yb, xsl , yMin) ;
          fLine(xsr, yb, xsr , yMin) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


          fTeXlabel(xMax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;
//          fTeXlabel(xj-0.2, -1.52, "tl", "$x = x_j^*$") ;
          fTeXlabel(xj, -0.25, "ct", "$x_j^*$") ;
          fArrow(xsl-0.3,yMin-0.3, xsl,-0.25) ;
          fTeXlabel(xsl-0.3, yMin-0.3, "tr", "$x_{j-1}$") ;
          fArrow(xsr+0.3,yMin-0.3, xsr,-0.25) ;
          fTeXlabel(xsr+0.35, yMin-0.3, "tl", "$x_j$") ;


          fTeXlabel(xMax+0.1, y, "cl", "$y = y_i^*$") ;
          fArrow(xMax+0.3,yb-0.3, xMax,yb) ;
          fTeXlabel(xMax+0.35, yb-0.3, "tl", "$y = y_{i-1}$") ;
          fArrow(xMax+0.3,yt+0.3, xMax,yt) ;
          fTeXlabel(xMax+0.35, yt+0.3, "bl", "$y = y_i$") ;

          double h = 0.2 ;
          fLine(xl,0, xl,-h) ;   
//             fTeXlabel(xl+0.1, -h*1.5, "tc", "$\\scriptstyle L(y_i^*)$") ;
             fTeXlabel(xl+0.1, -h*1.5, "tc", "$L(y_i^*)$") ;
          fLine(xr,0, xr,-h) ;   
//             fTeXlabel(xr, -h*1.5, "tc", "$\\scriptstyle R(y_i^*)$") ;
             fTeXlabel(xr, -h*1.5, "tc", "$R(y_i^*)$") ;


     }
}

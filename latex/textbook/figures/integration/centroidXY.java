                  /*  File:  centroidXY.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class centroidXY extends Template {

     static {templateClass = new centroidXY() ; }

     public void setup() {
          filePrefix = "centroidXY" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*3.3/3.0*1.2 ;   
          ysize = 1.5*1.2 ;   
          xmin = -0.5  ;
          xmax = 2.8 ;
          ymin = -1 ;
          ymax = 5 ;
          ymin = -1 ;
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
          fLine(xmin, 0.0, xmax, 0.0) ;
          double xs = 0.3 ;
          fLine(-xs, ymin, -xs, ymax) ;
          fCurve("y=6*x-2*x*x", 0, 0, 2, FILLED) ;
          fCurve("y=x*x",       0, 0, 2, FILLED) ;          
          fCurve("y=6*x-2*x*x", 0, xmin, 2.4, OPEN) ;
          fCurve("y=x*x", 0, xmin, xmax, OPEN) ;
          fEnv("lineWidth", 2.0) ;
          fCurve("y=6*x-2*x*x", 0, 0, 2, OPEN) ;
          fCurve("y=y=x*x", 0, 0, 2, OPEN) ;
//          fEnv("lineWidth", 3.0) ;
          double x = 1.5 ; 
          double y1 = 0.25*x*x + 0.75*(6*x-2*x*x) ;
          double y2 = 0.4*x*x + 0.6*(6*x-2*x*x) ;
//          {double[] xlist = {0, 1, 2, 1, 0} ;
//           double[] ylist = {0, 4, 4, 1, 0} ;
//           fPolygon(xlist, ylist, 4, FILLED) ;} 
          fEnv("lineWidth", 6.0) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fLine(x, x*x, x, 6*x-2*x*x) ;
          canvas.append( new fPsWrite("0.5 setgray\n")) ;
          fLine(x, y1, x, y2) ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;


          fEnv("psFillGray", 0.0) ;
          double r = 0.07 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fDisk(0,0, r,r*aspect, FILLED) ;
          fDisk(2,4, r,r*aspect, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
          fLine(x, 0, x,x*x ) ;
          fLine(-xs, x*x, x,x*x ) ;
          fLine(-xs, 6*x-2*x*x, x,6*x-2*x*x ) ;
          fLine(2, 0, 2,4 ) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          double h = 0.15 ;
          fLine(x,0, x,-h) ;  fTeXlabel(x,-1.3*h, "tc", "$x$") ;
          fLine(2,0, 2,-h) ;  fTeXlabel(2,-1.3*h, "tc", "$b$") ;
          fLine(-xs,6*x-2*x*x, -h/aspect-xs,6*x-2*x*x) ;  
               fTeXlabel(-1.3*h/aspect-xs, 6*x-2*x*x, "cr", "$T(x)$") ;
          fLine(-xs,x*x, -h/aspect-xs,x*x) ; 
               fTeXlabel(-1.3*h/aspect-xs, x*x,"cr", "$B(x)$") ;


          fTeXlabel(xmax+0.05, 0.0, "cl", "$x$") ;
          fTeXlabel(-xs, ymax+0.15, "cb", "$y$") ;
          fTeXlabel(2.4, 6*2.4-2*2.4*2.4+0.1, "tl", "$y=T(x)$") ;
          fTeXlabel(Math.sqrt(ymax), ymax+0.2, "bl", "$y=B(x)$") ;
          fTeXlabel(0.05, -0.15, "tl", "$a$") ;
          fTeXlabel(1, 3, "cc", "$\\cR$") ;


     }
}

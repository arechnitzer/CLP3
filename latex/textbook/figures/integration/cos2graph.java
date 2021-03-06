                  /*  File:  cos2graph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cos2graph extends Template {

     static {templateClass = new cos2graph() ; }

     public void setup() {
          filePrefix = "cos2graph" ;    // used as the prefix for ps and lbl files 
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 1.2 ;   
          double pi = Math.PI ;
          xmin = -1.2*pi ;
          xmax =  1.2*pi ;
          ymin = -0.2 ;
          ymax = 1.5 ;
          topmargin = 0.15 ;   // in inches
          bottommargin = 0.15 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double pi = Math.PI ;
          double S = Math.cos(pi/8)*Math.cos(pi/8) ;
          double SS = Math.cos(pi/4)*Math.cos(pi/4) ;
          fEnv("psFillGray", 0.6) ;
          fCurve("y=cos(x)*cos(x)", 0, -1.5*pi, -pi, FILLED) ;
          fCurve("y=cos(x)*cos(x)", 0,  0.5*pi,  pi, FILLED) ;
          {double[] xlist = {-3*pi/2, -5*pi/4, -9*pi/8, -pi, -pi} ;
           double[] ylist =  {0  ,     SS,     S, 1, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;} 
          {double[] xlist = {pi/2, 3*pi/4, 7*pi/8, pi, pi} ;
           double[] ylist =  {0  ,     SS,     S,   1, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;} 

          fEnv("psFillGray", 0.8) ;
          fCurve("y=cos(x)*cos(x)", 0, -pi, -pi/2, FILLED) ;
          fCurve("y=cos(x)*cos(x)", 0,   0,  pi/2, FILLED) ;
          fCurve("y=cos(x)*cos(x)", 0,   pi, 3*pi/2, FILLED) ;

          {double[] xlist = {-pi, -7*pi/8, -3*pi/4, -pi/2, -pi} ;
           double[] ylist = {1,         S,    SS,    0, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;} 
          {double[] xlist = {0, pi/8, pi/4, pi/2, 0} ;
           double[] ylist = {1,   S,    SS,    0, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;} 
          {double[] xlist = {pi, 9*pi/8, 5*pi/4, 3*pi/2, pi} ;
           double[] ylist = {1,   S,    SS,    0, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;} 

          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          fEnv("psFillColor", Blue) ;
          fCurve("y=cos(x)*cos(x)", 0, -0.5*pi,   0, FILLED) ;
          {double[] xlist = {-pi/2, -pi/4, -pi/8, 0, 0} ;
           double[] ylist =  {0  ,     SS,     S, 1, 0} ;
           fPolygon(xlist, ylist, 5, FILLED) ;} 
          fEnv("useColorPs", "false") ;

          fEnv("psFillGray", 1.0) ;
          fCurve("y=cos(x)*cos(x)", 0, -0.75*pi, -0.25*pi, FILLED) ;
          fCurve("y=cos(x)*cos(x)", 0,  0.25*pi,  0.75*pi, FILLED) ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax,0) ;
          fLine(0,ymin, 0, ymax) ;
          fTeXlabel(-0.1, ymax, "tr", "$y$") ;
          fTeXlabel(xmax+0.1, 0, "cl", "$x$") ;
          for(int i=-2 ; i<3 ; i++) {
               fLine(i*pi/2, 0,  i*pi/2, -0.08) ;
          }
          fTeXlabel(-pi,-0.13, "tc", "$\\scriptstyle-\\pi$") ;
          fTeXlabel(-0.5*pi,-0.12, "tc", "$-\\nicefrac{\\pi}{2}$") ;
          fTeXlabel(pi,-0.13, "tc", "$\\scriptstyle\\pi$") ;
          fTeXlabel(0.5*pi,-0.12, "tc", "$\\nicefrac{\\pi}{2}$") ;
          fLine(-0.13,1,  0,1) ;
          fTeXlabel(-0.2,1.05, "rc", "$\\scriptstyle 1$") ;

          fEnv("lineWidth", 1.0) ;
          fTeXlabel(pi, 1.05, "bc", "$y=\\cos^2 x$") ;
          fCurve("y=cos(x)*cos(x)", 0, xmin, xmax, OPEN) ;
     }
}





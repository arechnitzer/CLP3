                  /*  File:  domainFivehedron1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainFivehedron1 extends Template {

     static {templateClass = new domainFivehedron1() ; }

     public void setup() {
          filePrefix = "domainFivehedron1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -70 ;
          xmax =  80 ;
          ymin = -70 ;
          ymax =  80 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double th = -135*Math.PI/180 ;
          double x0 = Math.cos(th) ;
          double x1 = Math.sin(th) ;
          double a = 70 ;
          double b = 70 ;
          double c = 70 ;
          double z = 30 ;

          {fEnv("psFillGray", 0.8) ;
           double[] xlist = {0, a*x0+b, b} ;
           double[] ylist = {c, a*x1,   0} ;
           fPolygon(xlist, ylist, 3, FILLED) ;
           }
//          {fEnv("psFillGray", 0.8) ;
//           double[] xlist = {0, a*x0, a*x0+b} ;
//           double[] ylist = {c, a*x1,  a*x1} ;
//           fPolygon(xlist, ylist, 3, FILLED) ;
//           }

          fEnv("lineWidth", 1.0) ;
          fLine(0,0,b,0) ;
          fLine(0,0,0,c) ;
          fLine(0,0,a*x0,a*x1) ;
          fLine(0,c,b,0) ;
          fLine(a*x0+b,a*x1,b,0) ;
          fLine(a*x0,a*x1,a*x0+b,a*x1) ;
          fLine(a*x0+b,a*x1,0,c) ;
          fLine(a*x0,a*x1,0,c) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fLine(a*x0*(c-z)/c,a*x1*(c-z)/c+z,0,z) ;
          fLine(a*x0*(c-z)/c,a*x1*(c-z)/c+z,(a*x0+b)*(c-z)/c,a*x1*(c-z)/c+z) ;
          fLine(b*(c-z)/c,z,(a*x0+b)*(c-z)/c,a*x1*(c-z)/c+z) ;
          fLine(0,z,b*(c-z)/c,z) ;
          fArrow(60,60,b*(c-z)/(3*c),z) ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0, xmax*x1, "tr", "$x$") ;
          fTeXlabel(60, 60, "bl", "$z=z_0$") ;
          fTeXlabel(a*x0+b,a*x1, "tl", "$(1,1,0)$") ;
          
     }
}


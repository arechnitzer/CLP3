                  /*  File:  domainTetrahedron.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainTetrahedron extends Template {

     static {templateClass = new domainTetrahedron() ; }

     public void setup() {
          filePrefix = "domainTetrahedron" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.6 ;    
          ysize = 1.6 ;  
          xmin = -70 ;
          xmax =  90 ;
          ymin = -70 ;
          ymax =  90 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.3 ;   // in inches
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

//          {fEnv("psFillGray", 0.8) ;
//           double[] xlist = {0, a*x0, b} ;
//           double[] ylist = {c, a*x1,   0} ;
//           fPolygon(xlist, ylist, 3, FILLED) ;
//           }

          fEnv("lineWidth", 1.0) ;
          fLine(0,0,b,0) ;
          fLine(0,0,0,c) ;
          fLine(0,0,a*x0,a*x1) ;
          fLine(0,c,b,0) ;
          fLine(a*x0,a*x1,0,c) ;
          fLine(a*x0,a*x1,b,0) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fLine(a*x0*(c-z)/c,a*x1*(c-z)/c+z,0,z) ;
          fLine(a*x0*(c-z)/c,a*x1*(c-z)/c+z,b*(c-z)/c,z) ;
          fLine(0,z,b*(c-z)/c,z) ;
          fArrow(60,60,b*(c-z)/(3*c),z) ;
          fTeXlabel(xmax+5,-2, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0, xmax*x1, "tr", "$x$") ;
          fTeXlabel(60, 60, "bl", "$z=z_0$") ;
          fTeXlabel(a*x0-2,a*x1, "br", "$(a,0,0)$") ;
          fTeXlabel(b,5, "bl", "$(0,b,0)$") ;
          fTeXlabel(-5,c, "rc", "$(0,0,c)$") ;
          
     }
}


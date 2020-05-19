                  /*  File:  projEg.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class projEg extends Template {

     static {templateClass = new projEg() ; }

     public void setup() {
          filePrefix = "projEg" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;      // in inches
          ysize = 1.5 ;   // in inches. 
          xmin = -10 ;
          xmax = 90 ;
          ymin = -10 ;
          ymax = 90 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
         fEnv("lineWidth", 0.5) ;
         double u = 25 ;  double eps = 4 ;

         fLine(xmin, 0, xmax, 0 ) ;
         fLine(0, ymin, 0, ymax ) ;
         fTeXlabel(xmax, -2, "tr", "$x$") ;
         fTeXlabel(-0.75, ymax, "tr", "$y$") ;

         fDisk(0,0, 2, 2, FILLED) ;

         canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
         fLine(xmin, xmin,  xmax, xmax) ;
         canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


         fEnv("lineWidth", 1) ;
         fEnv("headHalfWidth", 2*1.3) ;
         fEnv("headLength", 6*1.3) ;
         String Blue = "0 0.53333 0.8 setrgbcolor  " ;
         String Black = "0 0 0 1 setcmykcolor  " ;
         fEnv("useColorPs", "true") ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fEnv("psFillColor", Blue) ;
         fArrow(0, 0, 1.5*u, 1.5*u) ;

         canvas.append( new fPsWrite(Black+"\n")) ;
         fEnv("psFillColor", Black) ;
         fArrow(0, 0, u, u) ;
         fArrow(0, 0, 0, 3*u) ;

         fEnv("lineWidth", 0.5) ;
         fLine(0, 3*u,  1.5*u, 1.5*u) ;
         fLine(1.5*u+eps, 1.5*u+eps,  1.5*u, 1.5*u+2*eps) ;
         fLine(1.5*u-eps, 1.5*u+eps,  1.5*u, 1.5*u+2*eps) ;


         fTeXlabel(-2,3*u, "tr",  "$\\llt 0,3\\rgt$") ;
         fTeXlabel(0.8*u+2,0.8*u, "tl",  "$\\llt 1,1\\rgt$") ;
         fTeXlabel(1.5*u+1,1.5*u,"tl","$\\text{proj}_{\\llt 1,1\\rgt}\\!\\llt 0,3\\rgt$");
     }
}

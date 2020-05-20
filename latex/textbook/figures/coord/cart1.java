                  /*  File:  cart1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cart1 extends Template {

     static {templateClass = new cart1() ; }

     public void setup() {
          filePrefix = "cart1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -70 ;
          xmax =  80 ;
          ymin = -70 ;
          ymax =  80 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 30 ;
//          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double x = 50 ;
          double y = 60 ;
          double z = 60 ;
          double r = 3 ;



          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fLine(y,0, x*x0+y,x*x1) ;
          fLine(x*x0,x*x1, x*x0+y,x*x1) ;
          fLine(x*x0+y,x*x1, x*x0+y,x*x1+z) ;
          fDisk(x*x0+y,x*x1+z,3,3,FILLED) ; 
          fDisk(x*x0+y,x*x1,3,3,FILLED) ; 
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0-1, xmax*x1-1, "tr", "$x$") ;
          fTeXlabel(x*x0+y+2,x*x1+z+2, "bl", "$(x,y,z)$") ;
          fTeXlabel(x*x0+y+2,x*x1-2, "tl", "$(x,y,0)$") ;
          fTeXlabel(x*x0/2+3+y,x*x1/2, "tl", "$x$") ;
          fTeXlabel(x*x0+y/2,x*x1-3, "tr", "$y$") ;
          fTeXlabel(x*x0+y+3,x*x1+0.6*z, "lc", "$z$") ;
          
     }
}




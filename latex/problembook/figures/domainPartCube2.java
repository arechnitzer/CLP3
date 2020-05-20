                  /*  File:  domainPartCube2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainPartCube2 extends Template {

     static {templateClass = new domainPartCube2() ; }

     public void setup() {
          filePrefix = "domainPartCube2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.9 ;    
          ysize = 1.9 ;  
          xmin = -0.2 ;
          xmax =  1.7 ;
          ymin = -1.7 ;
          ymax =  0.2 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.5) ;
          double z = 0.5 ;
          {fEnv("psFillGray", 0.7) ;
           double[] xlist = {1-z, 1-z,   1, 1} ;
           double[] ylist = {  0,  -1, z-1, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          {double[] xlist = {1-z, 1-z,   1, 1} ;
           double[] ylist = {  0,  -1, z-1, 0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
           }


          fEnv("lineWidth", 0.5) ;
          fLine(xmin,xmin+z-2,xmax,xmax+z-2) ;
          fLine(1-z,ymin,1-z,ymax) ;
          fLine(1,ymin,1,ymax) ;
          fLine(xmin, -1, 1-0.5*z, -1) ;

          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05,0, "lc", "$y$") ;
          fTeXlabel(0,ymin-0.05, "tc", "$x$") ;
          fArrow(1.3, -1.3, 1-z+0.03, -1.3) ;
          fTeXlabel(1.34,-1.3, "lc", "$y=1-z$") ;
          fTeXlabel(xmax-0.4,-0.3, "lc", "$x+y=2-z$") ;
          fTeXlabel(xmin-0.05,-1, "rc", "$x=1$") ;
          fTeXlabel(1.05,-0.9, "lc", "$y=1$") ;
          fTeXlabel(0.5*(1-z) +0.5, -0.4, "cc", "$D_z$") ;
          
     }
}


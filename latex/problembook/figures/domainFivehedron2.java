                  /*  File:  domainFivehedron2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainFivehedron2 extends Template {

     static {templateClass = new domainFivehedron2() ; }

     public void setup() {
          filePrefix = "domainFivehedron2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -0.1 ;
          xmax =  1.2 ;
          ymin = -0.1 ;
          ymax =  1.2 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          ;
          double x = 0.5 ;
          {fEnv("psFillGray", 0.8) ;
           double[] xlist = { 0,   0,   x, 1} ;
           double[] ylist = { 0, 1-x, 1-x, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          {fEnv("lineWidth", 1.5) ; 
           double[] xlist = { 0,   0,   x, 1} ;
           double[] ylist = { 0, 1-x, 1-x, 0} ;
           fPolygon(xlist, ylist, 4, CLOSED) ;
           }

          {fEnv("psFillGray", 0.6) ;
           double[] xlist = {0.27, 0.27, 0.33, 0.33} ;
           double[] ylist = {   0, 1-x, 1-x, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          {fEnv("psFillGray", 0.6) ;
           double[] xlist = {0.77, 0.77, 0.83, 0.83} ;
           double[] ylist = {   0, 1-0.77, 1-0.83, 0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,1-x,xmax,1-x) ;
          fLine(xmin,1-xmin,xmax,1-xmax) ;
          fEnv("psFillGray", 0.0) ;
          fDisk(x,1-x, 0.03, 0.03, FILLED) ;
          fDisk(1,0, 0.03, 0.03, FILLED) ;

          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(x,1-x,x,ymin) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05, 0, "lc", "$y$") ;
          fTeXlabel(xmax+0.05, 1-x, "lc", "$z=1-x$") ;
          fTeXlabel(0,ymax+0.05, "bc", "$z$") ;
          fTeXlabel(1+0.1,ymin-0.05, "tc", "$z=1-y$") ;
          fTeXlabel(x,ymin-0.05, "tc", "$y=x$") ;
          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(0.75,0.8,x+0.03,1-x+0.03) ;
          fTeXlabel(1,0.8, "bc", "$(y=x,\\  z=1-x)$") ;
          fArrow(1.2,0.225,1+0.03,0.03) ;
          fTeXlabel(1.21,0.225, "cl", "$(y=1,\\  z=0)$") ;

          fTeXlabel(x+0.15, 0.15, "cc", "$D_x$") ;
     }
}


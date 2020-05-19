                  /*  File:  domainPartCube1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainPartCube1 extends Template {

     static {templateClass = new domainPartCube1() ; }

     public void setup() {
          filePrefix = "domainPartCube1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -1 ;
          xmax =  1.2 ;
          ymin = -1 ;
          ymax =  1.2 ;
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
          double th = -135*Math.PI/180 ;
          double x0 = Math.cos(th) ;
          double x1 = Math.sin(th) ;
          {fEnv("psFillGray", 0.5) ;
           double[] xlist = {0, x0  , x0+1, 1} ;
           double[] ylist = {1, x1+1, x1,   0} ;
           fPolygon(xlist, ylist, 4, FILLED) ;
           }
          fEnv("lineWidth", 1.0) ;
          fLine(1,0,0,1) ;
          {fEnv("psFillGray", 0.7) ;
           double[] xlist = {x0  , x0+1, 1} ;
           double[] ylist = {x1+1, x1,   1} ;
           fPolygon(xlist, ylist, 3, FILLED) ;
           }
          fLine(0,1,1,1) ;
          fLine(1,0,1,1) ;
          fLine(0,1,x0,x1+1) ;
          fLine(1,1,x0,x1+1) ;
          fLine(x0,x1+1,x0+1,x1) ;
          fLine(1,0,x0+1,x1) ;
          fLine(1,1,x0+1,x1) ;

          fEnv("lineWidth", 0.5) ;
          fLine(1,0,xmax,0) ;
          fLine(0,1,0,ymax) ;
          double f = 0.3 ;
          fLine(f*xmax*x0*0.75, f*xmax*x1*0.75, xmax*x0*0.75, xmax*x1*0.75) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine(0,0,1,0) ;
          fLine(0,0,0,1) ;
          fLine(0,0, f*xmax*x0*0.75, f*xmax*x1*0.75) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(xmax+.1,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+.1, "bc", "$z$") ;
          fTeXlabel(xmax*0.75*x0, xmax*0.75*x1, "tr", "$x$") ;
          
     }
}


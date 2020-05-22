                  /*  File: pointDistProjB.java  */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pointDistProjB extends Template {

     static {templateClass = new pointDistProjB() ; }

     public void setup() {
          filePrefix = "pointDistProjB" ;   
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3*1.2 ;      // in inches
          ysize = 1.5*1.2 ;   // in inches. 
          xmin = -200 ;
          xmax = 200 ;
          ymin = -50 ;
          ymax = 150 ;
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
         double nx = 1 ; double ny = 3 ;
         double dx = 3 ; double dy = -1 ; 
         double rx = 100; double ry = -50 ;
         double lp = 75 ; double h = 30 ; double lx = 25 ;
         double k = 40 ;
         double r = 3.5 ; double s = 2.5 ;
         double x= rx -lx*dx ; double y = ry-lx*dy ;
         fEnv("lineWidth", 1.0) ;
         fLine(rx+h*nx, ry+h*ny,   rx-lp*dx+h*nx, ry-lp*dy+h*ny) ;
         fDisk(x, y, r, r, FILLED) ;
         fTeXlabel(x-1, y-7.5, "tl", "$Q$") ;          
         fDisk(x+h*nx, y+h*ny, r, r, FILLED) ;
         fTeXlabel(x+h*nx+2.5, y+h*ny+11, "br", "$N$") ;          
         fDisk(x+h*nx-k*dx, y+h*ny-k*dy, r, r, FILLED) ;
         fTeXlabel(x+h*nx-k*dx+2.5, y+h*ny-k*dy+7, "br", "$P$") ;          


         fEnv("lineWidth", 0.5) ;
         fLine(x-10*nx , y-10*ny , x+h*nx+20*nx, y+h*ny+20*ny) ;
         fLine(x+h*nx+s*dx , y+h*ny+s*dy , x+h*nx+s*dx+s*nx, y+h*ny+s*dy+s*ny) ;
         fLine(x+h*nx+s*nx , y+h*ny+s*ny , x+h*nx+s*dx+s*nx, y+h*ny+s*dy+s*ny) ;


         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fArrow(x+h*nx-k*dx, y+h*ny-k*dy,  x+h*nx-0.02*k*dx, y+h*ny-0.02*k*dy) ;
         fTeXlabel(x+h*nx-0.7*k*dx, y+h*ny-0.7*k*dy,"bl", "$\\text{proj}_{\\vd}\\,\\vv$");
         fArrow(x+h*nx-k*dx, y+h*ny-k*dy, x+0.02*h*nx-0.02*k*dx, y+0.02*h*ny-0.02*k*dy) ;
         fTeXlabel(x+0.6*h*nx-0.6*k*dx-2.5, y+0.6*h*ny-0.6*k*dy, "tr", "$\\vv$") ;         
         fArrow(x, y, x+0.98*h*nx, y+0.98*h*ny) ;
         fTeXlabel(x+0.6*h*nx+2.5, y+0.6*h*ny, "tl", "$\\vw$") ;         
 
         fEnv("psFillColor", Pink) ;
         canvas.append( new fPsWrite(Pink+"\n")) ;
         fArrow(x+h*nx, y+h*ny,  x+h*nx+0.5*k*dx, y+h*ny+0.5*k*dy) ;
         fTeXlabel(x+h*nx+0.5*k*dx-3, y+h*ny+0.5*k*dy+10, "br", "$\\vd$") ;          

         fTeXlabel(rx+h*nx+2, ry+h*ny, "cl", "$L$") ;          


     }
}

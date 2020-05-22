                  /*  File: pointDistProj.java  */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pointDistProj extends Template {

     static {templateClass = new pointDistProj() ; }

     public void setup() {
          filePrefix = "pointDistProj" ;   
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
         double k = 20 ;
         double r = 3.5 ; double s = 2.5 ;
         double x= rx -lx*dx ; double y = ry-lx*dy ;
         fEnv("lineWidth", 1.0) ;
         fLine(rx+h*nx, ry+h*ny,   rx-lp*dx+h*nx, ry-lp*dy+h*ny) ;
         fDisk(x, y, r, r, FILLED) ;
         fTeXlabel(x-1, y-7.5, "tl", "$\\vx$") ;          
         fDisk(x+h*nx, y+h*ny, r, r, FILLED) ;
         fTeXlabel(x+h*nx+2.5, y+h*ny+5, "br", "$\\vy$") ;          
         fDisk(x+h*nx-k*dx, y+h*ny-k*dy, r, r, FILLED) ;
         fTeXlabel(x+h*nx-k*dx+2.5, y+h*ny-k*dy+5, "br", "$\\vz$") ;          


         fEnv("lineWidth", 0.5) ;
         fLine(x-10*nx , y-10*ny , x+h*nx+20*nx, y+h*ny+20*ny) ;
         fLine(x+h*nx+s*dx , y+h*ny+s*dy , x+h*nx+s*dx+s*nx, y+h*ny+s*dy+s*ny) ;
         fLine(x+h*nx+s*nx , y+h*ny+s*ny , x+h*nx+s*dx+s*nx, y+h*ny+s*dy+s*ny) ;

//         fEnv("psFillGray", 0.6) ;
//         fDisk(x+0.7*h*nx, y+0.7*h*ny, r, r, FILLED) ;

         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fArrow(x, y,  x+0.98*h*nx, y+0.98*h*ny) ;
         fTeXlabel(x+0.75*h*nx, y+0.75*h*ny,  "tl",  "$\\text{proj}_{\\vn}\\,\\vv$"  ) ;
         fArrow(x, y,  x+0.98*h*nx-0.98*k*dx, y+0.98*h*ny-0.98*k*dy) ;
         fTeXlabel(x+0.6*h*nx-0.6*k*dx-2.5, y+0.6*h*ny-0.6*k*dy, "tr", "$\\vv$") ;          
         fEnv("psFillColor", Pink) ;
         canvas.append( new fPsWrite(Pink+"\n")) ;
         fArrow(x, y,  x+0.4*h*nx, y+0.4*h*ny) ;
         fArrow(x+h*nx, y+h*ny,  x+1.4*h*nx, y+1.4*h*ny) ;

//         fTeXlabel(rx+2, ry, "cl", "$P$") ;          
         fTeXlabel(rx+h*nx+2, ry+h*ny, "cl", "$P$") ;          


         fTeXlabel(x+0.4*h*nx+3, y+0.4*h*ny-5, "cl", "$\\vn$") ;          
         fTeXlabel(x+1.4*h*nx+3, y+1.4*h*ny-5, "cl", "$\\vn$") ;          
//         fTeXlabel(x+0.7*h*nx+1, y+0.7*h*ny-3, "tl", "$\\vx+t\\vn$") ;          
     }
}

                  /*  File: planeDistB.java  */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class planeDistB extends Template {

     static {templateClass = new planeDistB() ; }

     public void setup() {
          filePrefix = "planeDistB" ;   
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
         double r = 3.5 ; double s = 2.5 ;
         double x= rx -lx*dx ; double y = ry-lx*dy ;
         double x1= x -20*dx ; double y1 = y -20*dy ;
         double vx= h*nx -15*dx ; double vy = h*ny - 15*dy;
         fEnv("lineWidth", 1.0) ;
         fLine(rx, ry,   rx-lp*dx, ry-lp*dy) ;
         fLine(rx+h*nx, ry+h*ny,   rx-lp*dx+h*nx, ry-lp*dy+h*ny) ;
         fDisk(x, y, r, r, FILLED) ;
         fDisk(x+h*nx, y+h*ny, r, r, FILLED) ;
         fDisk(x1, y1, r, r, FILLED) ;
         fDisk(x1+vx, y1+vy, r, r, FILLED) ;

         fEnv("lineWidth", 0.5) ;
         fLine(x-10*nx , y-10*ny , x+h*nx+10*nx, y+h*ny+10*ny) ;
         fLine(x+s*dx , y+s*dy , x+s*dx+s*nx, y+s*dy+s*ny) ;
         fLine(x+s*nx , y+s*ny , x+s*dx+s*nx, y+s*dy+s*ny) ;
         fLine(x+s*dx+h*nx , y+s*dy+h*ny , x+s*dx+s*nx+h*nx, y+s*dy+s*ny+h*ny) ;
         fLine(x+s*nx+h*nx , y+s*ny+h*ny , x+s*dx+s*nx+h*nx, y+s*dy+s*ny+h*ny) ;


         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         String Blue = "1 1 0 0 setcmykcolor  " ;
         String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
         fEnv("useColorPs", "true") ;
         fEnv("psFillColor", Blue) ;
         canvas.append( new fPsWrite(Blue+"\n")) ;
         fArrow(x, y,  x+0.98*h*nx, y+0.98*h*ny) ;
         fTeXlabel(x+0.75*h*nx+1, y+0.75*h*ny,  "tl",  "$\\text{proj}_{\\vn}\\vv$"  ) ;
         fArrow(x1, y1, x1+0.98*vx, y1+0.98*vy) ;


         fEnv("psFillColor", Pink) ;
         canvas.append( new fPsWrite(Pink+"\n")) ;
         fArrow(x, y,  x+0.4*h*nx, y+0.4*h*ny) ;

         fTeXlabel(rx+2, ry, "cl", "$P$") ;          
         fTeXlabel(rx+h*nx+2, ry+h*ny, "cl", "$P'$") ;          

         fTeXlabel(x-1, y-12, "tl", "$\\vx(s)$") ;          
         fTeXlabel(x+h*nx+4, y+h*ny+10, "br", "$\\vy(t)$") ;          

         fTeXlabel(x+0.4*h*nx+3, y+0.4*h*ny-8, "cl", "$\\vn$") ;          
         fTeXlabel(x1+0.5*vx-3, y1+0.5*vy, "cr", "$\\vv$") ;          
     }
}

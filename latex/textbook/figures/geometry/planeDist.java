                  /*  File: planeDist.java  */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class planeDist extends Template {

     static {templateClass = new planeDist() ; }

     public void setup() {
          filePrefix = "planeDist" ;   
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
         fEnv("lineWidth", 1.0) ;
         fLine(rx, ry,   rx-lp*dx, ry-lp*dy) ;
         fLine(rx+h*nx, ry+h*ny,   rx-lp*dx+h*nx, ry-lp*dy+h*ny) ;
         fDisk(x, y, r, r, FILLED) ;
         fDisk(x+h*nx, y+h*ny, r, r, FILLED) ;

         fEnv("lineWidth", 0.5) ;
         fLine(x-10*nx , y-10*ny , x+h*nx+10*nx, y+h*ny+10*ny) ;
         fLine(x+s*dx , y+s*dy , x+s*dx+s*nx, y+s*dy+s*ny) ;
         fLine(x+s*nx , y+s*ny , x+s*dx+s*nx, y+s*dy+s*ny) ;
         fLine(x+s*dx+h*nx , y+s*dy+h*ny , x+s*dx+s*nx+h*nx, y+s*dy+s*ny+h*ny) ;
         fLine(x+s*nx+h*nx , y+s*ny+h*ny , x+s*dx+s*nx+h*nx, y+s*dy+s*ny+h*ny) ;

         fEnv("psFillGray", 0.6) ;
         fDisk(x+0.8*h*nx, y+0.8*h*ny, r, r, FILLED) ;

         fEnv("lineWidth", 1.2) ;
         fEnv("headHalfWidth", 2*1.5) ;
         fEnv("headLength", 6*1.5) ;
         String Red = "0 1 1 0 setcmykcolor  " ;
         canvas.append( new fPsWrite(Red+"\n")) ;
         fArrow(x, y,  x+0.4*h*nx, y+0.4*h*ny) ;

         fTeXlabel(rx+2, ry, "cl", "$P$") ;          
         fTeXlabel(rx+h*nx+2, ry+h*ny, "cl", "$P'$") ;          

         fTeXlabel(x-1, y-7.5, "tl", "$\\vx$") ;          
         fTeXlabel(x+h*nx+2.5, y+h*ny+10, "br", "$\\vx'$") ;          

         fTeXlabel(x+0.4*h*nx+3, y+0.4*h*ny-5, "cl", "$\\vn$") ;          
         fTeXlabel(x+0.8*h*nx+1, y+0.8*h*ny-3, "tl", "$\\vx+t\\vn$") ;          
     }
}

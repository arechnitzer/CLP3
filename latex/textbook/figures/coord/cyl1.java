                  /*  File:  cyl1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cyl1 extends Template {

     static {templateClass = new cyl1() ; }

// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 40 ;
     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;


     public void setup() {
          filePrefix = "cyl1" ;  
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
          double r = 130 ;
          double th = Math.PI/3.5 ;
          double x = r*Math.cos(th) ;
          double y = r*Math.sin(th) ;
          double z = 90 ;



          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fLine(0,0, x*x0+y,x*x1) ;
          fLine(x*x0+y,x*x1, x*x0+y,x*x1+z) ;
          fDisk(x*x0+y,x*x1+z,3,3,FILLED) ; 
          fTeXlabel(x*x0+y+5,x*x1+z, "lc", "$(x,y,z)$") ;
          fDisk(x*x0+y,x*x1,3,3,FILLED) ; 
          fTeXlabel(x*x0+y+5,x*x1, "lc", "$(x,y,0)$") ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0-1, xmax*x1-1, "tr", "$x$") ;
          fTeXlabel(x*x0+y+2,x*x1+z*0.6, "lc", "$z$") ;
          fTeXlabel(x*x0/2.0+y/2.0,x*x1/2.0+4, "bl", "$r$") ;

          double R = 15 ;
          fCurve(new circ3d(proj,0,0,0, 0.8*R,0,0,  0,1.1*R,0), 
                               -0.2*th*180/Math.PI, 0.85*th*180/Math.PI, OPEN)  ;
          fTeXlabel(-1.7*3,-3.5*3, "tc", "$\\theta$") ;

          
     }
}

class circ3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, double r) {
        this.proj = proj ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = r ; ;
        this.ya = 0 ;
        this.za = 0 ;
        this.xb = 0 ;
        this.yb = r ;
        this.zb = 0 ;
   }


   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.proj = proj ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.xa = xa ;
        this.ya = ya ;
        this.za = za ;
        this.xb = xb ;
        this.yb = yb ;
        this.zb = zb ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}






                  /*  File:  xeqzPlane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xeqzPlane extends Template {

     static {templateClass = new xeqzPlane() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;


     public void setup() {
          filePrefix = "xeqzPlane" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -80 ;
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
//          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double X = 0.6*xmax ;
          double xm = 0 ;
          double xmm = 0 ;
          double x = 70 ;
          double ym = 0 ;
          double ymm = 0 ;
          double yM = 60 ;
          double zm = 33 ;
          double zM = 0.7*ymax ;
          double r = 3 ;


         fEnv("psFillGray", 0.8) ;
         {double[] xlist = {xm,    x,   x, xm} ;
          double[] ylist = {ym,  ym,  yM, yM} ;
          double[] zlist = {xm,    x,   x, xm} ;
          fPolygon3d(xlist,ylist, zlist, 4, FILLED) ;}

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,ymm,0, 0,xmax,0) ;
          fLine3d(0,0,zm, 0,0,zM) ;
          fLine3d(xmm,0,0, X,0,0) ;


          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
               fLine3d(0,0,0, 0,0,zm) ;
               fLine3d(0,0,0, 0,ymm,0) ;
               fLine3d(0,0,0, xmm,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;



          fEnv("lineWidth", 1.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(xm,0,xm, x,0,x) ;



//          fLine(y,0, x*x0+y,x*x1) ;
//          fLine(x*x0,x*x1, x*x0+y,x*x1) ;
//          fLine(x*x0+y,x*x1, x*x0+y,x*x1+z) ;
//          fDisk(x*x0+y,x*x1+z,3,3,FILLED) ; 
//          fDisk(x*x0+y,x*x1,3,3,FILLED) ; 
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,zM+3, "bc", "$z$") ;
          fTeXlabel(X*x0-1, X*x1-1, "tr", "$x$") ;
//          fTeXlabel(x*x0+y+2,x*x1+z+2, "bl", "$(x,y,z)$") ;
//          fTeXlabel(x*x0+y+2,x*x1-2, "tl", "$(x,y,0)$") ;
//          fTeXlabel(x*x0/2+3+y,x*x1/2, "tl", "$x$") ;
//          fTeXlabel(x*x0+y/2,x*x1-3, "tr", "$y$") ;
//          fTeXlabel(x*x0+y+3,x*x1+0.6*z, "lc", "$z$") ;
          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*x0+y;
          double Y = x*x1+z ;
          fDisk(X,Y,r1,r2,TYPE) ;
     }

     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fArrow(X1,Y1,X2,Y2) ;
     }

     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }



     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*x0+ylist[i] ;
               yy[i] = xlist[i]*x1+zlist[i] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
     }


}

class circ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
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


   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.projFactor = projFactor ;
        this.al = al ;
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
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}





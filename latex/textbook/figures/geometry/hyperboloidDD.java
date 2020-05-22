                  /*  File:  hyperboloidDD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperboloidDD extends Template {

     static {templateClass = new hyperboloidDD() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "hyperboloidDD" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*0.8 ;    
          ysize = 2.0*0.8 ;  
          xmin = -4 ;
          xmax =  4 ;
          ymin = -4 ;
          ymax =  4 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = -0.2 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 60 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double z0 = 0 ; double X = 0 ; double Y = 0 ;

          double xm = 3 ;
          double ym = 3.6 ;
          double zm = 3.5 ;



          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;

          fEnv("lineWidth", 1.0) ;

          z0 = 3 ; X = 0.5*Math.sqrt(-1+z0*z0) ; Y = Math.sqrt(-1+z0*z0) ;
          fCurve(new circ3d(al, 0.5,   0,0,3, X,0,0, 0,Y,0),
                 0,360,OPEN) ;
          z0 = -3 ; X = 0.5*Math.sqrt(-1+z0*z0) ; Y = Math.sqrt(-1+z0*z0) ;
          fCurve(new circ3d(al, 0.5,   0,0,-3, X,0,0, 0,Y,0),
                 0,360,OPEN) ;

          fCurve(new hyperbola3d(al, 0.5,   0,0,0, 0,1,0, 0,0,1, 1,1),
                 1,3,OPEN) ;

          fCurve(new hyperbola3d(al, 0.5,   0,0,0, 0,-1,0, 0,0,1, 1,1),
                 1,3,OPEN) ;


          fCurve(new hyperbola3d(al, 0.5,   0,0,0, 0,1,0, 0,0,-1, 1,1),
                 1,3,OPEN) ;

          fCurve(new hyperbola3d(al, 0.5,   0,0,0, 0,-1,0, 0,0,-1, 1,1),
                 1,3,OPEN) ;

     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
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
        this.xa = r ; 
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
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}

//  The next class generates the curve a^2x^2-b^2y^2=-1 but with 
//      the x axis vector (1,0) replaced by (xa,ya,za) and
//      the y axis vector (0,1) replaced by (xb,yb,zb) and
//      the origin shifted to (cx,cy,cz)

class hyperbola3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 1.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 1.0 ;
     double zb = 0.0 ;
     double a  = 1 ;
     double b = 1 ;


   public hyperbola3d(double al, double projFactor, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb,
                 double a, double b) {
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
        this.a = a ;
        this.b = b ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double X = Math.sqrt(-1+b*b*t*t)/a ;
          double x = cx+xa*X+xb*t ;
          double y = cy+ya*X+yb*t ;
          double z = cz+za*X+zb*t ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




                  /*  File:  parabolicCylinder.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class parabolicCylinder extends Template {

     static {templateClass = new parabolicCylinder() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "parabolicCylinder" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 2.0 ;  
          xmin = -1.2 ;
          xmax =  4.8 ;
          ymin = -0.5 ;
          ymax =  3.5 ;
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
          double al = 30 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 0.5 ; 
          double xs = -2 ;
          double xM = 2.2 ;

          double xm = 2 ;
          double ym = 3 ;
          double zm = 3 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.08, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.08,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;

          fCurve(new parabola3d(al, 0.5,   0,0,0, a),
                 xs , xM ,OPEN) ;

          fCurve(new parabola3d(al, 0.5,   0,2,0, a),
                 xs , xM ,OPEN) ;

          fLine3d(xs, 0, xs*xs*a,   xs, 2, xs*xs*a) ;
          fLine3d(xM, 0, xM*xM*a,   xM, 2, xM*xM*a) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
//          fCurve(new parabola3d(al, 0.5,   0,0.5,0, a),
//                 xs , xM ,OPEN) ;
          fCurve(new parabola3d(al, 0.5,   0,1.0,0, a),
                 xs , xM ,OPEN) ;
//          fCurve(new parabola3d(al, 0.5,   0,1.5,0, a),
//                 xs , xM ,OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

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

//  The next class generates the curve z=ax^2, with x as the parameter, but with 
//      the origin shifted to (cx,cy,cz)

class parabola3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double a = 1 ;


   public parabola3d(double al, double projFactor, 
                 double cx, double cy, double cz, double a) {
        this.al = al ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.a = a ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+t ;
          double y = cy ;
          double z = cz+a*t*t ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




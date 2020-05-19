                  /*  File:  spher7.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class spher7 extends Template {

     static {templateClass = new spher7() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "spher7" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.5 ;    
          ysize = 3.5 ;  
          xmin = -70 ;
          xmax =  90 ;
          ymin = -70 ;
          ymax =  90 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = -0.2 ;   // in inches
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
          double a = 65 ;
          double r1 = 50 ;
          double r2 = 80 ;
          double th1 = 50 ;
          double th2 = 73 ;
          double phi1 = 50 ;
          double phi2 = 70 ;
          double xm = 80 ;
          double ym = 80 ;
          double zm = 90 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;


          double xh = Math.cos(th1*Math.PI/180);
          double yh = Math.sin(th1*Math.PI/180);
          double xv = Math.sin(phi1*Math.PI/180);
          double zv = Math.cos(phi1*Math.PI/180);
          // th1, phi1
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2*xh,r2*yh,0),
                 0,90,OPEN)  ;
          fLine3d(0,0,0, r2*xh,r2*yh,0) ;
          fLine3d(0,0,r2*zv, r2*xh*xv,r2*yh*xv,r2*zv) ;
          fLine3d(0,0,0, r2*xh*xv,r2*yh*xv,r2*zv) ;
          fArrow3d(r2*xh*xv/2,r2*yh*xv/2-30,r2*zv-7,  r2*xh/2*xv,r2*yh*xv/2,r2*zv) ;
          fTeXlabel3d(r2*xh*xv/2,r2*yh*xv/2-31,r2*zv-7, "cr", "$\\rho\\sin\\varphi$") ;
          fTeXlabel(4,8, "bc", "$\\varphi$") ;
          fTeXlabel(21,12, "bc", "$\\rho$") ;
          fTeXlabel(26,41.5, "bc", "$\\dee{\\theta}$") ;
          // th2, phi1
          xh = Math.cos(th2*Math.PI/180);
          yh = Math.sin(th2*Math.PI/180);
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2*xh,r2*yh,0),
                 0,90,OPEN)  ;
//          fLine3d(0,0,0, r2*xh,r2*yh,0) ;
          xv = Math.sin(phi1*Math.PI/180);
          zv = Math.cos(phi1*Math.PI/180);
          fLine3d(0,0,r2*zv, r2*xh*xv,r2*yh*xv,r2*zv) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          // th1, phi1
          xh = Math.cos(th1*Math.PI/180);
          yh = Math.sin(th1*Math.PI/180);


          fCurve(new circ3d(al, 0.5,   0,0,r2*zv, r2*xv),th1,th2,OPEN)  ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fCurve(new circ3d(al, 0.5,   0,0,r2*zv, r2*xv),0,90,OPEN)  ;


          xh = Math.cos((th1+th2)*Math.PI/360);
          yh = Math.sin((th1+th2)*Math.PI/360);
          xv = Math.sin(phi1*Math.PI/180);
          zv = Math.cos(phi1*Math.PI/180);
          fArrow3d(r2*xh*xv,r2*yh*xv,r2*zv+30,  r2*xh*xv,r2*yh*xv,r2*zv+2) ;
          fTeXlabel3d(r2*xh*xv,r2*yh*xv,r2*zv+30, "bc", "$\\rho\\sin\\varphi\\, \\dee{\\theta}$") ;

          
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




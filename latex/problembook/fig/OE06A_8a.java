                  /*  File:  OE06A_8a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE06A_8a extends Template {

     static {templateClass = new OE06A_8a() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE06A_8a" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0 ;  
          xmin = -40 ;
          xmax =  110 ;
          ymin = -60 ;
          ymax =  90 ;
          topmargin = -0.2 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double rho = 35 ;
          double xm = 80 ;
          double ym = 50 ;
          double zm = 80 ;



          fEnv("lineWidth", 0.5) ;
          fLine(0,0,ym,0) ;
          fLine(0,0,0,zm) ;
          fLine(0,0, xm*x0, xm*x1) ;
          fTeXlabel(ym+4,0, "lc", "$y$") ;
          fTeXlabel(0,zm+4, "bc", "$z$") ;
          fTeXlabel(xm*x0-0.05, xm*x1-1, "tr", "$x$") ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(al, 0.5,   0,0,0, rho,0,0, 0, 0, rho),0,90,OPEN)  ;
          fCurve(new outer(al, 0.5,  rho, 0),0,90,OPEN)  ;

          double r = 2 ;
          fEnv("psFillGray", 0.0) ;
          fDisk3d(rho,0,0, r,r) ;
          fTeXlabel3d(rho, -3, 0, "cr", "$\\scriptstyle (1,0,0)$") ;
          fDisk3d(0,0,rho, r,r) ;
          fTeXlabel3d(0, 3, rho+1, "bl", "$\\scriptstyle (0,0,1)$") ;
          fDisk3d(0,0,2*rho, r,r) ;
          fTeXlabel3d(0, -3, 2*rho, "cr", "$\\scriptstyle (0,0,2)$") ;


          
     }

     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double rx, double ry) {
          double X = x*x0+y ;
          double Y = x*x1+z ;

          fDisk(X, Y, rx, ry, FILLED) ;
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

class outer implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double th = 0 ; double thRad = th*Math.PI/180.0 ;
     double rho = 35 ;

   public outer(double al, double projFactor, double rho, double th) {
        this.al = al ;
        this.projFactor =projFactor ;
        this.rho = rho ;
        this.th = th ;
        thRad = th*Math.PI/180.0 ;
   }


   public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double tRad = t*Math.PI/180 ;
          double x = rho*(1+Math.cos(tRad))*Math.sin(tRad)*Math.cos(thRad) ;
          double y = rho*(1+Math.cos(tRad))*Math.sin(tRad)*Math.sin(thRad) ;
          double z = rho*(1+Math.cos(tRad))*Math.cos(tRad) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}






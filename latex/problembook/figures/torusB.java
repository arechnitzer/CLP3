                  /*  File:  torusB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class torusB extends Template {

     static {templateClass = new torusB() ; }

     public void setup() {
          filePrefix = "torusB" ;  
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
          double al = 65 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double rho = 35 ;
          double R = rho ;
          double z = 40 ;
          double xm = 130*0.8 ;
          double ym = 110*0.8 ;
          double zm = 40 ;



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
          fCurve(new circ3d(al, 0.5,   R,0,0, rho,0,0, 0, 0, rho),0,180,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,R,0, 0,rho,0, 0, 0, rho),0,180,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, R+rho,0,0, 0, R+rho, 0),0,90,OPEN)  ;
          double phi = 20 ; double phiRad = phi*Math.PI/180 ;
          double cphi = Math.cos(phiRad) ;  double sphi = Math.sin(phiRad) ; 
          double Rr = rho -rho*sphi ;
          fCurve(new circ3d(al, 0.5,   0,0,rho*cphi, Rr,0,0, 0, Rr, 0),0,90,OPEN)  ;
          double th = Math.PI/6 ;
          double x = R*Math.cos(th) ;
          double y = R*Math.sin(th) ;
          fCurve(new circ3d(al, 0.5,   x,y,0, rho*x/R,rho*y/R,0, 0, 0, rho),0,180,OPEN)  ;
          th = Math.PI/3 ;
          x = R*Math.cos(th) ;
          y = R*Math.sin(th) ;
          fCurve(new circ3d(al, 0.5,   x,y,0, rho*x/R,rho*y/R,0, 0, 0, rho),0,180,OPEN)  ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          th = Math.PI/6 ;
          x = R*Math.cos(th) ;
          y = R*Math.sin(th) ;
          fLine(0,0, 2.0*x*x0+2.0*y,2.0*x*x1) ;
          th = Math.PI/3 ;
          x = R*Math.cos(th) ;
          y = R*Math.sin(th) ;
          fLine(0,0, 2.0*x*x0+2.0*y,2.0*x*x1) ;



          
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





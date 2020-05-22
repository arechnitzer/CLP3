                  /*  File:  pipedVolume.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pipedVolume extends Template {

     static {templateClass = new pipedVolume() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "pipedVolume" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  
          xmin = -20 ;
          xmax =  160 ;
          ymin = -20 ;
          ymax =  160 ;
          topmargin = -0.6 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
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

          double a1 =   0 ; double a2 = 20  ; double a3 = 60 ;
          double b1 = -40 ; double b2 = 40 ; double b3 =  0 ;
          double c1 =  0 ; double c2 = 80  ; double c3 =  0 ;


          fEnv("lineWidth", 0.6) ;
          fArrow3d(0,0,0, a1,a2,a3) ;
          fArrow3d(0,0,0, b1,b2,b3) ;
          fArrow3d(0,0,0, c1,c2,c3) ;
          fArrow3d(0,0,0, 0,  0, 100) ;
          fEnv("lineWidth", 0.4) ;
          fLine3d(a1,a2,a3, a1+b1,a2+b2,a3+b3) ;
          fLine3d(a1,a2,a3, a1+c1,a2+c2,a3+c3) ;
          fLine3d(b1,b2,b3, a1+b1,a2+b2,a3+b3) ;
          fLine3d(b1,b2,b3, b1+c1,b2+c2,b3+c3) ;
          fLine3d(c1,c2,c3, c1+b1,c2+b2,c3+b3) ;
          fLine3d(c1,c2,c3, a1+c1,a2+c2,a3+c3) ;
          fLine3d(a1+b1,a2+b2,a3+b3, a1+b1+c1,a2+b2+c2,a3+b3+c3) ;
          fLine3d(a1+c1,a2+c2,a3+c3, a1+b1+c1,a2+b2+c2,a3+b3+c3) ;
          fLine3d(b1+c1,b2+c2,b3+c3, a1+b1+c1,a2+b2+c2,a3+b3+c3) ;
          double r1 = 10 ;
          double r2 = r1/Math.sqrt(2) ;
          double r3 = r1/Math.sqrt(10) ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,r1,0, -r2,r2,0),0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,r3,3*r3, 0,0,r1),0,90,OPEN)  ;
          fLine3d(a1,a2,a3, 0, 0, a3) ;

          fTeXlabel3d(a1,a2+2,a3-2, "tl", "$\\va$") ;          
          fTeXlabel3d(b1,b2-3,b3+4, "br", "$\\vc$") ;          
          fTeXlabel3d(c1,c2-3,c3+6, "br", "$\\vb$") ;          
          fTeXlabel3d(0,-5,100, "tr", "$\\vb\\times\\vc$") ;          
          fTeXlabel3d(-5,30,0, "bc", "$\\theta$") ;          
          fTeXlabel3d(-3,7,25, "br", "$\\varphi$") ;          
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




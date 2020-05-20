                  /*  File:  coneGraph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class coneGraph extends Template {

     static {templateClass = new coneGraph() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "coneGraph" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0 ;  
          xmin = -7 ;
          xmax =  7 ;
          ymin = -6 ;
          ymax =  10 ;
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
          double xm = 8 ;
          double ym = 8 ;
          double zm = 10 ;

          fEnv("lineWidth", 0.5) ;
          double Z = 3.8 ;
          fLine3d(0,0,-1, 0,0,Z) ;
          fLine3d(0,-1,0, 0,ym,0) ;
          fLine3d(-1,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.2, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.2,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;


          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(al, 0.5,   0,0,6, 6),0,360,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,3, 3),0,360,OPEN)  ;
          double th = 3 ; double thRad = th*Math.PI/180 ;
          fLine3d(0,0,0, 6*Math.sin(thRad),6*Math.cos(thRad),6) ;
          th = 30 ;  thRad = th*Math.PI/180 ;
          fLine3d(0,0,0, 6*Math.sin(thRad),-6*Math.cos(thRad),6) ;

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine3d(0,0,Z, 0,0,zm) ;
//          fDisk3d(0,0,Z, 0.2,0.2, FILLED) ;




          
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








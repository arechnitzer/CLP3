                  /*  File:  xyzPlane.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xyzPlane extends Template {

     static {templateClass = new xyzPlane() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;


     public void setup() {
          filePrefix = "xyzPlane" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.8 ;    
          ysize = 1.5 ;  
          xmin = -80 ;
          xmax =  100 ;
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
          double xM = 55 ;
          double yM = 100 ;
          double zM = 80 ;
          double r = 2 ;
          double x = 40 ;
          double y = 60 ;
          double z = 60 ;


         fEnv("psFillGray", 0.8) ;
         {double[] xlist = {x,  0,   0} ;
          double[] ylist = {0,  y,   0} ;
          double[] zlist = {0,  0,   z} ;
          fPolygon3d(xlist,ylist, zlist, 3, FILLED) ;}

          fEnv("lineWidth", 0.5) ;
          fLine3d(x,0,0, xM,0,0) ;
          fLine3d(0,y,0, 0,yM,0) ;
          fLine3d(0,0,z, 0,0,zM) ;

          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
               fLine3d(0,0,0, x,0,0) ;
               fLine3d(0,0,0, 0,y,0) ;
               fLine3d(0,0,0, 0,0,z) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;


          fEnv("lineWidth", 1.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(x,0,0, 0,y,0) ;
          fLine3d(0,y,0, 0,0,z) ;
          fLine3d(0,0,z, x,0,0) ;



          fEnv("psFillGray", 0.0) ;
          fDisk3d(x,0,0,r,r,FILLED) ; 
          fDisk3d(0,y,0,r,r,FILLED) ; 
          fDisk3d(0,0,z,r,r,FILLED) ; 

          fTeXlabel3d(xM+2,0, 0,"tr", "$x$") ;
          fTeXlabel3d(0,yM+2, 0,"cl", "$y$") ;
          fTeXlabel3d(0, 0, zM+2,"bc", "$z$") ;

          fTeXlabel3d(x,-1,0.5, "br", "$\\scriptstyle (1,0,0)$") ;
          fTeXlabel3d(0,y+1,0.5, "bl", "$\\scriptstyle (0,1,0)$") ;
          fTeXlabel3d(0,1,z, "bl", "$\\scriptstyle (0,0,1)$") ;

          
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





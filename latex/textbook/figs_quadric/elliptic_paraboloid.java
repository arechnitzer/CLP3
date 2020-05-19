                  /*  File:  elliptic_paraboloid.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class elliptic_paraboloid extends Template {

     static {templateClass = new elliptic_paraboloid() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;


     public void setup() {
          filePrefix = "elliptic_paraboloid" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*2.14 ;    
          ysize = 1.0*2.14 ;  
          xmin = -10 ;
          xmax =  10 ;
          ymin = -10 ;
          ymax =  10 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 50 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 0.4 ;
          double b = 0 ;
          double y = 4 ;
          double z = a*y*y + b ;
          double Y = 2.8 ;
          double Z = a*Y*Y + b ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 1.0) ;
//          fEnv("useColorPs", "true") ;
//          String Red = "0 1 1 0 setcmykcolor  " ;
//          String Black = "0 0 0 1 setcmykcolor  " ;
//          String Blue = "1 1 0 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillGray", 0.8) ;
          fCurve(new paraYZ3d(al, 0.5, -18, a,b),-y,y,OPEN)  ;
          fCurve(new circ3d(al, 0.5,  0,0,z, y,0,0, 0,y,0),0,360,CLOSED+FILLED)  ;
          fCurve(new circ3d(al, 0.5,  0,0,Z, Y,0,0, 0,Y,0),-90,90,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new circ3d(al, 0.5,  0,0,Z, Y,0,0, 0,Y,0),90,270,OPEN)  ;
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

}


class paraYZ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double a = 1.0 ;
     double b = 0.0 ;
     double rot = 0.0 ;
     double rotRad = 0.0 ;
     double cos = 1.0 ;
     double sin = 0.0 ;

   public paraYZ3d(double al, double projFactor, 
                 double rot, double a, double b) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.rot = rot ;
        rotRad = rot*Math.PI/180 ;
        this.a = a ;
        this.b = b ;
        cos = Math.cos(rotRad) ;
        sin = Math.sin(rotRad) ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t*sin ;
          double y = t*cos ;
          double z = a*t*t+b ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
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







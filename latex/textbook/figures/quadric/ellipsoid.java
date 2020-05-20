                  /*  File:  ellipsoid.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class ellipsoid extends Template {

     static {templateClass = new ellipsoid() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;
     static double projFactor =   0.5 ;

     public void setup() {
          filePrefix = "ellipsoid" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 0.95 ;    
          ysize = 0.95 ;  
          xmin = -80 ;
          xmax =  90 ;
          ymin = -80 ;
          ymax =  80 ;
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
          double al = 30 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
          projFactor = 0.5 ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
//          projFactor = 1.0 ;
          double r11a = 73 ; double r11b = 45 ;
          double r1a = 39 ;  double r1b = 42 ;
          double r12a = 37.5 ; double r12b = 69 ;


          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(al, projFactor,   0,0,0, 0,r11a,0, 0,0,r11b),
                 0,360,CLOSED)  ;
          fCurve(new circ3d(al, projFactor,   0,0,0, r1a,0,0, 0,0,r1b),
                 -90,90,OPEN)  ;
          fCurve(new circ3d(al, projFactor,   0,0,0, r12a,0,0, 0,r12b,0),
                 -90,90,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new circ3d(al, projFactor,   0,0,0, r12a,0,0, 0,r12b,0),
                 90,270,OPEN)  ;
          fCurve(new circ3d(al, projFactor,   0,0,0, r1a,0,0, 0,0,r1b),
                 90,270,OPEN)  ;
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




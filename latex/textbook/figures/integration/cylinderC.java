                  /*  File:  cylinderC.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cylinderC extends Template {

     static {templateClass = new cylinderC() ; }

       static  double al = 60 ;

       // cabinet projection
      static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;

       // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;

       // Orthogonal isometric projection with direction of view (1,1,1).  
//     static double[][] proj = { {-Math.sqrt(3)/2.0, Math.sqrt(3)/2.0, 0},
//                                {             -0.5,             -0.5, 1}   } ;


     public void setup() {
          filePrefix = "cylinderC" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*1.2 ;    
          ysize = 2.0*1.2 ;  
          xmin = -50 ;
          xmax =  150 ;
          ymin = -80 ;
          ymax =  120 ;
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
          double r = 40 ;
          double h = 15 ;
          double z = 80 ;
          double xm = 75 ;
          double ym = 100 ;
          double zm = 95 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,z,0, 0,ym,0) ;
          fLine3d(0,0,z, 0, 0,zm) ;
          fLine3d(r,0,0, xm,0,0) ;
          fTeXlabel3d(0,ym+4,0, "lc", "$y$") ;
          fTeXlabel3d(0,0,zm+4, "bc", "$z$") ;
          fTeXlabel3d(xm+3,0,0, "tr", "$x$") ;


          fEnv("lineWidth", 1.0) ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;


          fCurve(new circ3d(proj,   0,0,z, r),0,90,OPEN)  ;
          fLine3d(0,r,r, 0,r,z) ;
          fLine3d(r,0,0, r,0,z) ;
          fLine3d(0,0,z, r,0,z) ;
          fLine3d(0,0,z, 0,r,z) ;
          fLine3d(0,r,0, 0,z,0) ;
          fLine3d(0,0,r, 0,0,z) ;



          fCurve(new circ3d(proj,   0,z,0, 0,0,r, r,0,0), 0,90,OPEN)  ;
          fLine3d(0,r,r, 0,z,r) ;
          fLine3d(r,0,0, r,z,0) ;
          fLine3d(0,z,0, r,z,0) ;
          fLine3d(0,z,0, 0,z,r) ;

          fEnv("lineWidth", 1.5) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new circ3d(proj,   0,0,0, 0,0,r, r,0,0), 0,90,OPEN)  ;
          fCurve(new circ3d(proj,   0,0,0, r), 0,90,OPEN)  ;
          fCurve(new circ3d(proj,   0,0,0, r,0,0, 0,r,r), 0,90,OPEN)  ;
          fLine3d(0,r,0, 0,r,r) ;
          fLine3d(0,0,r, 0,r,r) ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fLine3d(0,0,0, 0,0,r) ;
          fLine3d(0,0,0, 0,r,0) ;
          fLine3d(0,0,0, r,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;





//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fEnv("lineWidth", 0.5) ;
//          fLine3d(0,z,0, 0,ym,0) ;
//          fLine3d(0,0,0, 0,0.5*z,0) ;


     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;

          fTeXlabel(X, Y, biase, label) ;
     }

     public void fDot3d(double x, double y, double z,
                         double rx, double ry, long TYPE) {
          double X = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          double Y = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          fDisk(X, Y, rx, ry, TYPE) ;     
     }

}


class circ3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, double r) {
        this.proj = proj ;
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


   public circ3d(double[][] proj, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.proj = proj ;
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}





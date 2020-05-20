                  /*  File:  sphereRhoThB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sphereRhoThB extends Template {

     static {templateClass = new sphereRhoThB() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     // cabinet projection
     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;


     public void setup() {
          filePrefix = "sphereRhoThB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ; 

          double Xmin= -10 ;
          double Xmax= 90 ;
          double Ymin= -10 ;
          double Ymax= 90 ;
          double Zmin= -10 ;
          double Zmax= 90 ;
          xmin = xmax = Xmin*proj[0][0]+Ymin*proj[0][1]+Zmin*proj[0][2] ;
          ymin = ymax = Xmin*proj[1][0]+Ymin*proj[1][1]+Zmin*proj[1][2] ;
          double Dx = (Xmax-Xmin)*proj[0][0] ;
          double Dy = (Xmax-Xmin)*proj[1][0] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
          Dx = (Ymax-Ymin)*proj[0][1] ;
          Dy = (Ymax-Ymin)*proj[1][1] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
          Dx = (Zmax-Zmin)*proj[0][2] ;
          Dy = (Zmax-Zmin)*proj[1][2] ;
          if (Dx>0) xmax += Dx ; else xmin += Dx ;
          if (Dy>0) ymax += Dy ; else ymin += Dy ;
 
//          xmin = -70 ;
//          xmax =  90 ;
//          ymin = -70 ;
//          ymax =  90 ;
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
          double al = 60 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r1 = 50 ;
          double r2 = 70 ;

          double th2 = 50 ;
          double phi1 = 90*0.5 ;
          double phi2 = 90*0.7 ;

          double xm = 95 ;
          double ym = 85 ;
          double zm = 85 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,r2, 0,0,zm) ;
          fLine3d(0,r2,0, 0,ym,0) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0.0 setdash\n")) ;
          fLine3d(0,0,0, 0,r2,0) ;
          fLine3d(0,0,0, r2,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(r2,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;


          // th2, phi1
          double xh = Math.cos(th2*Math.PI/180);
          double yh = Math.sin(th2*Math.PI/180);
          double xv = Math.sin(phi1*Math.PI/180);
          double zv = Math.cos(phi1*Math.PI/180);
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2*xh,r2*yh,0),
                 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2,0,0),
                 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, r2,0,0, 0,r2,0),
                 0,90,OPEN)  ;
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,r2,0, 0,0,r2),
                 0,90,OPEN)  ;
          canvas.append( new fPsWrite("[2.5 2.5] 0.0 setdash\n")) ;
          fLine3d(0,0,0, r2*xh,r2*yh,0) ;
          fLine3d(0,0,0,  0,0,r2) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, r2*xh*xv,r2*yh*xv,r2*zv) ;
          fTeXlabel3d(0.5*r2*xh*xv,0.5*r2*yh*xv,0.5*r2*zv, "br", "$\\scriptstyle\\rho$") ;
          // th2, phi2
          xv = Math.sin(phi2*Math.PI/180);
          zv = Math.cos(phi2*Math.PI/180);
//          fLine3d(0,0,0, r2*xh*xv,r2*yh*xv,r2*zv) ;

          fCurve(new circ3d(al, 0.5,   0,0,0, 20,0,0, 0,20,0),  0,th2,OPEN)  ;
          fTeXlabel3d(25, 7 ,0,  "tc", "$\\scriptstyle\\theta$") ;          


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          // th2, phi1
          fCurve(new circ3d(al, 0.5,   0,0,0, 0,0,r2, r2*xh,r2*yh,0),
                 0,90,OPEN)  ;







          
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




                  /*  File:  OE200_19D_1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE200_19D_1 extends Template {

     static {templateClass = new OE200_19D_1() ; }



// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     // cabinet projection
//     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     // cavalier projection
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     static double[] view = {1, -proj[0][0], -proj[1][0]} ;

////  Orthogonal isometric projection with direction of view (1,1,1).  
//     static double[][] proj = { {-Math.sqrt(3)/2.0, Math.sqrt(3)/2.0, 0},
//                                {             -0.5,             -0.5, 1}   } ;
//     static double[] view = {1, 1, 1} ;

////  General orthogonal projection.  
     static double[] fwd = {0.3, 1.0, 0.5} ; 
     static double[] up = {0,0,1} ;
     static double Lfwd = Math.sqrt(fwd[0]*fwd[0]+fwd[1]*fwd[1]+fwd[2]*fwd[2]) ; 
     static double[] Nfwd = {fwd[0]/Lfwd,fwd[1]/Lfwd,fwd[2]/Lfwd} ; 

     static double Dot = Nfwd[0]*up[0]+Nfwd[1]*up[1]+Nfwd[2]*up[2] ; 
     static double[] Iup = {up[0]-Dot*Nfwd[0],up[1]-Dot*Nfwd[1],up[2]-Dot*Nfwd[2]};
     static double Lup = Math.sqrt(Iup[0]*Iup[0]+Iup[1]*Iup[1]+Iup[2]*Iup[2]) ; 
     static double[] Nup = {Iup[0]/Lup,Iup[1]/Lup,Iup[2]/Lup} ; 
     static double[] Nleft = {-Nfwd[1]*Nup[2]+Nfwd[2]*Nup[1],
                              -Nfwd[2]*Nup[0]+Nfwd[0]*Nup[2],
                              -Nfwd[0]*Nup[1]+Nfwd[1]*Nup[0]} ; 

     static double[][] proj = { {Nleft[0], Nleft[1], Nleft[2]},
                                { Nup[0],  Nup[1], Nup[2]}   } ;
     static double[] view = {fwd[0], fwd[1], fwd[2]} ;



     public void setup() {
          filePrefix = "OE200_19D_1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*1.5 ;    
          ysize = 2.0*1.5 ;  

          double Xmin= -0.1 ;
          double Xmax=  2 ;
          double Ymin=  -0.1 ;
          double Ymax=  2 ;
          double Zmin=  -0.1 ;
          double Zmax=  2.5 ;
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


          topmargin = -0.8 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          double a = 65 ;
          double r = 80 ;
          double xm = -0.75 ;
          double xM = 1.5 ;
          double ym =-0.75 ;
          double yM = 1.1 ;
          double zM = 1.0 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double X1, Y2, Z, ZZ, R, R1, R2 ;
          double A = 1.8 ;
          double B = 0.0 ;
          R1 = 0.8 ;
          R2 = Math.sqrt(B/A)-0.03 ;
          X1 = A*R1*R1-B ;
          Y2 = 0 ;
          Z = 2 ;
          ZZ = 1.32 ;
          R = Math.sqrt(Z) ;
          double th = 25*Math.PI/180 ;

          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;

          fCurve(new circ3d(proj, X1,0,0, 0,R1,0, 0,0,R1) , 0, 360, FILLED)  ;

          double x1 = X1 ; 
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(0,0,0, x1,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(x1,0,0, xM,0,0) ;
          fLine3d(0,0,0, 0,yM,0) ;
          fLine3d(0,0,0, 0,0,zM) ;

          fTeXlabel3d(0,0,zM+0.05, "cb", "$z$") ;
          fTeXlabel3d(0,yM+0.05,0, "cl", "$y$") ;
          fTeXlabel3d(xM+0.05,0,0, "tr", "$x$") ;


          fEnv("lineWidth", 1.3) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new paraX3d(proj,A,B,th) , -R1, R1,OPEN)  ;
          fCurve(new circ3d(proj, X1,0,0, 0,R1,0, 0,0,R1) , 0, 360,OPEN)  ;
          fEnv("lineWidth", 0.5) ;


          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillGray", 0.0) ;
          fEnv("lineWidth", 1.0) ;

          fTeXlabel3d(0.2*X1, 0, -1.0*R1, "tc", "$y^2+z^2=x$") ;
          fTeXlabel3d(0.5*X1, 0, 0.3*R1, "cc", "$f>0$") ;
          fTeXlabel3d(0.5*X1 ,0, 1.2*R1, "cc", "$f<0$") ;





     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fArrow(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          double Y = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          fDisk(X,Y,r1,r2,TYPE) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;

          fTeXlabel(X, Y, biase, label) ;
     }

     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*proj[0][0]+ylist[i]*proj[0][1]+zlist[i]*proj[0][2] ;
               yy[i] = xlist[i]*proj[1][0]+ylist[i]*proj[1][1]+zlist[i]*proj[1][2] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
     }


}



class paraY3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double A = 1 ;
     double B = 1 ;
     double th = 10*Math.PI/180 ;

   public paraY3d(double[][] proj, double A,  double B, double th) {
        this.proj = proj ;
        this.A = A ;
        this.B = B ;
        this.th = th ;
   }


     public double[] map(double t) {
          double[] out = {0,0} ;
          double x = 0 ;
          double y = A*t*t-B  ;
          double z = t ;
          double X = x*Math.cos(th) - z*Math.sin(th) ;
          double Z = x*Math.sin(th) + z*Math.cos(th);
          out[0] = X*proj[0][0]+y*proj[0][1]+Z*proj[0][2] ;
          out[1] = X*proj[1][0]+y*proj[1][1]+Z*proj[1][2] ;
          return out ;
   }
}


class paraX3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double A = 1 ;
     double B = 1 ;
     double th = 10*Math.PI/180 ;

   public paraX3d(double[][] proj, double A,  double B, double th) {
        this.proj = proj ;
        this.A = A ;
        this.B = B ;
        this.th = th ;
   }



     public double[] map(double t) {
          double[] out = {0,0} ;
          double x = A*t*t-B ;
          double y = 0 ;
          double z = t ;
          double Y = y*Math.cos(th) - z*Math.sin(th) ;
          double Z = y*Math.sin(th) + z*Math.cos(th);
          out[0] = x*proj[0][0]+Y*proj[0][1]+Z*proj[0][2] ;
          out[1] = x*proj[1][0]+Y*proj[1][1]+Z*proj[1][2] ;
          return out ;
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




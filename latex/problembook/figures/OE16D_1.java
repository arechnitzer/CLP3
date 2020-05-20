                  /*  File:  OE16D_1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE16D_1 extends Template {

     static {templateClass = new OE16D_1() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;




// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
//     static double al = 60 ;
//     // cabinet projection
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
     static double[] fwd = {-0.5, -0.5, 0.1} ; 
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
          filePrefix = "OE16D_1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  

          double Xmin= -1.0 ;
          double Xmax=  13 ;
          double Ymin= -1.0 ;
          double Ymax=  20 ;
          double Zmin= -1.0 ;
          double Zmax=  13 ;
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
          leftmargin = 0.0 ;   // in inches
          rightmargin = -0.2 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
//          double al = 60 ;
//          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double r = 30 ;
          double rr = 0.15 ;
          double xm = 13 ;
          double ym = 20 ;
          double zm = 13 ;


          fEnv("lineWidth", 0.5) ;
//          double xt =0.0 ;
//          double yl =0.0 ;
//          double yt =0.0 ;
//          double zt =0.0 ;
//          fLine3d(0,0,zt, 0,0,zm) ;
//          fLine3d(0,yt,0, 0,ym,0) ;
//          fLine3d(0,0,0, 0,yl,0) ;
//          fLine3d(xt,0,0, xm,0,0) ;
//          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
//              fLine3d(0,0,0,  xt,0,0) ;
//              fLine3d(0,yl,0,  0,yt,0) ;
//              fLine3d(0,0,0,  0,0,zt) ;
//          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
//          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
//          fTeXlabel3d(0,ym+0.1,0, "cr", "$y$") ;
//          fTeXlabel3d(xm+0.3,0,0, "lc", "$x$") ;

          double X = 12 ;  double Y=14 ; double Z=12 ;
          double u2 = 0 ; double u3 = 8 ; double u1 = -X*(u2/Y+u3/Z) ;
          double v1 = 7 ; double v3 = 0 ; double v2 = -Y*(v1/X+v3/Z) ; 
          double Z1 = -7 ; double Z2 = -3 ; double Z3 = 2 ;
          fEnv("lineWidth", 1.0) ;
               fLine3d(Z1,Z2,Z3, Z1+u1,Z2+u2,Z3+u3) ;
               fLine3d(Z1,Z2,Z3, Z1+v1,Z2+v2,Z3+v3) ;
               fLine3d(Z1+u1,Z2+u2,Z3+u3, Z1+u1+v1,Z2+u2+v2,Z3+u3+v3 ) ;
               fLine3d(Z1+v1,Z2+v2,Z3+v3, Z1+u1+v1,Z2+u2+v2,Z3+u3+v3 ) ;
          fEnv("lineWidth", 0.5) ;
               double a1 = 0 ; double b1 = 2 ; double c1 = 2 ;
               double t =  1/( a1/X + b1/Y + c1/Z) ;
               double A1 = t*a1 ; double B1 = t*b1 ; double C1 = t*c1 ;

               double a2 = 2 ; double b2 = 1.5 ; double c2 = 3 ;
               t =  1/( a2/X + b2/Y + c2/Z) ;
               double A2 = t*a2 ; double B2 = t*b2 ; double C2 = t*c2 ;

               double a3 = 5 ; double b3 = 2 ; double c3 = 1 ;
               t =  1/( a3/X + b3/Y + c3/Z) ;
               double A3 = t*a3 ; double B3 = t*b3 ; double C3 = t*c3 ;

          fEnv("psFillGray", 0.7) ;
          {  double[] xlist = {A1,  A2, A3} ;
             double[] ylist = {B1,  B2, B3} ;
             double[] zlist = {C1,  C2, C3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }
          fEnv("psFillGray", 0.8) ;
          {  double[] xlist = {a1,  a2, a3} ;
             double[] ylist = {b1,  b2, b3} ;
             double[] zlist = {c1,  c2, c3} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }


          fEnv("psFillGray", 0.0) ;
               fDisk3d(a1,b1,c1, rr, rr) ;
               fTeXlabel3d(a1-0.2,b1,c1, "cr", "$A$") ;
               fDisk3d(A1,B1,C1, rr, rr) ;
               fTeXlabel3d(A1-0.2,B1,C1, "cr", "$\\tilde A$") ;

               fDisk3d(a2,b2,c2, rr, rr) ;
               fTeXlabel3d(a2-0.2,b2,c2, "br", "$B$") ;
               fDisk3d(A2,B2,C2, rr, rr) ;
               fTeXlabel3d(A2,B2,C2+0.3, "cb", "$\\tilde B$") ;

               fDisk3d(a3,b3,c3, rr, rr) ;
               fTeXlabel3d(a3+0.2,b3,c3-0.2, "cl", "$C$") ;
               fDisk3d(A3,B3,C3, rr, rr) ;
               fTeXlabel3d(A3+0.4,B3,C3, "cl", "$\\tilde C$") ;


               fDisk3d(0,0,0, rr, rr) ;
               fTeXlabel3d(0,0,-0.3, "ct", "$(0,0,0)$") ;


          canvas.append( new fPsWrite("0.5 setgray\n")) ;
               fLine3d(0,0,0, A1, B1, C1) ;
               fLine3d(0,0,0, A2, B2, C2) ;
               fLine3d(0,0,0, A3, B3, C3) ;

         fTeXlabel3d(Z1+0.5*u1+v1,Z2+0.5*u2+v2,Z3+0.5*u3+v3+0.5, "cl", "$x+7y+z=32$") ;

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

     public void fDisk3d(double x, double y, double z,
                         double rx, double ry) {
          double X = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          double Y = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          fDisk(X, Y, rx, ry, FILLED) ;
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
          
//          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
//          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

//          out[0] = x*x0+y ;
//          out[1] = x*x1+z;
          return out ;
   }
}

class interSect implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double r = 10 ;

   public interSect(double[][] proj) {
        this.proj = proj ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = t*t/2 ;
          double y = t ;
          double z = t*t ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}


class interSectX implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double r = 10 ;

   public interSectX(double[][] proj) {
        this.proj = proj ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = 3 ;
          double y = t ;
          double z = t*t ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}



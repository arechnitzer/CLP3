                  /*  File:  distanceB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class distanceB extends Template {

     static {templateClass = new distanceB() ; }



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
     static double[] fwd = {1, 0.15, 0.5} ; 
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
          filePrefix = "distanceB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*1.3 ;    
          ysize = 2.0*1.3 ;  

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


          topmargin = 0.0 ;   // in inches
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
          String Blue = "1 1 0 0 setcmykcolor  " ;
          double a = 65 ;
          double r = 80 ;
          double xm = 1.5 ;
          double ym = 1.5 ;
          double zm = 2.3 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double Z, ZZ, R ;
          Z = 2 ;
          ZZ = 1.32 ;
          R = Math.sqrt(Z) ;



          fEnv("lineWidth", 0.5) ;
          fEnv("psFillGray", 0.9) ;

          fCurve(new circ3d(proj, 0,0,Z, R,0,0, 0,R,0) , 0, 90, FILLED)  ;
          {  double[] xlist = {0, 0, R} ;
             double[] ylist = {0, R, 0} ;
             double[] zlist = {Z, Z, Z} ;
             fPolygon3d(xlist, ylist, zlist, 3, FILLED) ; }


          double yt = 1.35 ;
          fLine3d(0,0,ZZ, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
          fLine3d(0,0,0, 0,0,ZZ) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.05, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.05,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.05,0,0, "tr", "$x$") ;


          fEnv("lineWidth", 2.0) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new paraX3d(proj) , 0, Math.sqrt(Z),OPEN)  ;
          fCurve(new paraY3d(proj) , 0,  Math.sqrt(Z),OPEN)  ;
          fCurve(new circ3d(proj, 0,0,Z, R,0,0, 0,R,0) , 0, 90,OPEN)  ;
          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,Z, 0,R,Z) ;
          fLine3d(0,0,Z, R,0,Z) ;
          fTeXlabel3d(0,R,Z, "tl", "$z=x^2+y^2$") ;


          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;

          r = 0.04 ;
          double y1 = 1.0 ;  double y2 = 0.7 ; double z2 = y2*y2 ;
          fEnv("lineWidth", 1.0) ;
          fDisk3d(0,y1,0, r,r*aspect,FILLED) ;
                    fTeXlabel3d(0,y1,-0.1, "tc", "$(0,3,0)$") ;
          fDisk3d(0,y2,z2, r,r*aspect,FILLED) ;
                    fTeXlabel3d(0,y2+0.1,z2, "cl", "$(a,b,a^2+b^2)$") ;
          fLine3d(0,y1,0, 0,y2,z2) ;


          canvas.append( new fPsWrite(Black+"\n")) ;

          fEnv("psFillGray", 0.0) ;
          double x = 0.7 ;  double y = x ; double z = 2*x*x ;
          double rr = 0.035 ;
//          fDisk3d(x,y,z, rr, rr, FILLED) ;
          double L = 0.8/Math.sqrt(2+16*x*x) ;
          double dx = 1*L ; double dy = 1*L ; double dz = 4*x*L ;
          fEnv("lineWidth", 1.0) ;





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


class paraX3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public paraX3d(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          double[] out = {0,0} ;
          double x = 0 ;
          double y = t ;
          double z = t*t;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}

class paraY3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public paraY3d(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          double[] out = {0,0} ;
          double x = t ;
          double y = 0 ;
          double z = t*t ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}


class paraXY3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };

   public paraXY3d(double[][] proj) {
        this.proj = proj ;
   }


     public double[] map(double t) {
          double[] out = {0,0} ;
          double x = t ;
          double y = t ;
          double z = 2*t*t ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
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




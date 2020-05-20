                  /*  File:  xderivSide.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xderivSide extends Template {

     static {templateClass = new xderivSide() ; }
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

////  Orthogonal isometric projection with direction of view (1,1,1).  
//     static double[][] proj = { {-Math.sqrt(3)/2.0, Math.sqrt(3)/2.0, 0},
//                                {             -0.5,             -0.5, 1}   } ;
//     static double[] view = {1, 1, 1} ;

////  General orthogonal projection.  
//     static double[] fwd = {1, 0.2, 1} ; 
//     static double[] up = {0,0,1} ;
//     static double Lfwd = Math.sqrt(fwd[0]*fwd[0]+fwd[1]*fwd[1]+fwd[2]*fwd[2]) ; 
//     static double[] Nfwd = {fwd[0]/Lfwd,fwd[1]/Lfwd,fwd[2]/Lfwd} ; 
//
//     static double Dot = Nfwd[0]*up[0]+Nfwd[1]*up[1]+Nfwd[2]*up[2] ; 
//     static double[] Iup = {up[0]-Dot*Nfwd[0],up[1]-Dot*Nfwd[1],up[2]-Dot*Nfwd[2]};
//     static double Lup = Math.sqrt(Iup[0]*Iup[0]+Iup[1]*Iup[1]+Iup[2]*Iup[2]) ; 
//     static double[] Nup = {Iup[0]/Lup,Iup[1]/Lup,Iup[2]/Lup} ; 
//     static double[] Nleft = {-Nfwd[1]*Nup[2]+Nfwd[2]*Nup[1],
//                              -Nfwd[2]*Nup[0]+Nfwd[0]*Nup[2],
//                              -Nfwd[0]*Nup[1]+Nfwd[1]*Nup[0]} ; 
//
//     static double[][] proj = { {Nleft[0], Nleft[1], Nleft[2]},
//                                { Nup[0],  Nup[1], Nup[2]}   } ;
//     static double[] view = {fwd[0], fwd[1], fwd[2]} ;



     public void setup() {
          filePrefix = "xderivSide" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0 ;    
          ysize = 4.0 ;  

          double Xmin= -10 ;
          double Xmax= 160 ;
          double Ymin= -10 ;
          double Ymax= 110 ;
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
          double a = 65 ;
          double rx = 150 ;
          double ry = 100 ;
          double rz = 80 ;
          double xm = 90 ;
          double ym = 110 ;
          double zm = 90 ;
          int nth = 5 ;
          int nphi = 5 ;
          double dth = 90/nth ;
          double dphi = 90/nphi ;
          double th1 = dth*3 ;
          double th2 = dth*4 ;
          double phi1 = dphi*3 ;
          double phi2 = dphi*4 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$x$") ;


          canvas.append( new fPsWrite("0.7 setgray\n")) ;

          double Y = 30 ; double Z = rz*Math.sqrt(1-Y*Y/(ry*ry)) ;
                          double X = rx*Math.sqrt(1-Y*Y/(ry*ry)) ;
          fTeXlabel3d(0,ym+3,0.6*Z, "cl", "$z=f(x,b),\\ y=b$") ;
          double XX = 30 ; double ZZ = Z*Math.sqrt(1-XX*XX/(X*X)) ;
          double XXX = 80 ; double ZZZ = Z*Math.sqrt(1-XXX*XXX/(X*X)) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new circ3d(proj,   0,0,0, 0,X,0, 0,0,Z),
                      39,90,OPEN)  ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(0,XX,0, 0,XX,ZZ) ;
          fLine3d(0,XXX,0, 0,XXX,ZZZ) ;
          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine3d(0,XXX,ZZ, 0,XX,ZZ) ;
          fEnv("lineWidth", 2.0) ;
          fLine3d(0,XXX,ZZ, 0,XXX,ZZZ) ;
          fLine3d(0,XXX,0, 0,XX,0) ;
          fEnv("lineWidth", 0.5) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fEnv("headLength", 6*1.5) ;
          fArrow3d(0,3.3*XX,0.4*Z,  0,XX,0.4*Z) ;
          fTeXlabel3d(0,3.3*XX+2,0.4*Z, "cl", "$f(a,b)$") ;
          fArrow3d(0,3.3*XX,0.25*Z,  0,XXX,0.25*Z) ;
          fTeXlabel3d(0,3.3*XX+2,0.25*Z, "cl", "$f(a+h,b)$") ;
          fDisk3d(0,XX,0, 1.4, 1.4*aspect) ;
          fTeXlabel3d(0,XX,-3, "tc", "$(a,b,0)$") ;
          fDisk3d(0,XXX,0, 1.4, 1.4*aspect) ;
          fTeXlabel3d(0,XXX,-3, "tc", "$(a+h,b,0)$") ;
          fArrow3d(0,3.3*XX,0.5*(ZZ+ZZZ),  0,XXX,0.5*(ZZ+ZZZ)) ;
          fTeXlabel3d(0,3.3*XX+2,0.5*(ZZ+ZZZ), "cl", "$f(a+h,b)-f(a,b)$") ;





//          th = 0 ;
//          for ( int i=0; i <= nth ; i++ ) {
//               xh = Math.cos(th*Math.PI/180);
//               yh = Math.sin(th*Math.PI/180);
//               fCurve(new circ3d(proj,   0,0,0, 0,0,r, r*xh,r*yh,0),
//                      0,90,OPEN)  ;
//               th += dth ;
//          } 


//          phi = dphi ;
//          for ( int i=1; i <= nphi ; i++ ) {
//          xv = Math.sin(phi*Math.PI/180);
//          zv = Math.cos(phi*Math.PI/180);
//          fCurve(new circ3d(proj,   0,0,r*zv, r*xv),0,90,OPEN)  ;
//               phi += dphi ;
//          } 
//
//
//
//          canvas.append( new fPsWrite(Red+"\n")) ;
//          fEnv("lineWidth", 1.5) ;
//          xh = Math.cos(th1*Math.PI/180);
//          yh = Math.sin(th1*Math.PI/180);
//          fCurve(new circ3d(proj,   0,0,0, 0,0,r, r*xh,r*yh,0),
//                 phi1,phi2,OPEN)  ;
//
//
//          xh = Math.cos(th2*Math.PI/180);
//          yh = Math.sin(th2*Math.PI/180);
//          fCurve(new circ3d(proj,   0,0,0, 0,0,r, r*xh,r*yh,0),
//                 phi1,phi2,OPEN)  ;
//
//
//
//          xv = Math.sin(phi2*Math.PI/180);
//          zv = Math.cos(phi2*Math.PI/180);
//          fCurve(new circ3d(proj,   0,0,r*zv, r*xv),th1,th2,OPEN)  ;
//          xv = Math.sin(phi1*Math.PI/180);
//          zv = Math.cos(phi1*Math.PI/180);
//          fCurve(new circ3d(proj,   0,0,r*zv, r*xv),th1,th2,OPEN)  ;
//
//
//
//          xh = Math.cos(th2*Math.PI/180);
//          yh = Math.sin(th2*Math.PI/180);
//          xv = Math.sin((0.7*phi1+0.3*phi2)*Math.PI/180);
//          zv = Math.cos((0.7*phi1+0.3*phi2)*Math.PI/180);
//          fTeXlabel3d(r*xh*xv,r*yh*xv+2,r*zv, "lc", "$\\rho\\,d\\varphi$") ;
//
//
//          xh = Math.cos((th1+th2)*Math.PI/360);
//          yh = Math.sin((th1+th2)*Math.PI/360);
//          xv = Math.sin(phi1*Math.PI/180);
//          zv = Math.cos(phi1*Math.PI/180);
//          fEnv("lineWidth", 0.5) ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
//          fTeXlabel3d(r*xh*xv,r*yh*xv,r*zv+40, "bc", "$\\rho\\sin\\varphi\\, \\dee{\\theta}$") ;

          

          
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




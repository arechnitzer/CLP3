                  /*  File:  xyzSurfDD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class xyzSurfDD extends Template {

     static {templateClass = new xyzSurfDD() ; }

// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
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

//  General orthogonal projection.  
     static double[] fwd = {1,0.2,0.6} ; 
     static double[] up = {0,0,1} ;
     static double Lfwd = Math.sqrt(fwd[0]*fwd[0]+fwd[1]*fwd[1]+fwd[2]*fwd[2]) ; 
     static double[] Nfwd = {fwd[0]/Lfwd,fwd[1]/Lfwd,fwd[2]/Lfwd} ; 

     static double Dot = Nfwd[0]*up[0]+Nfwd[1]*up[1]+Nfwd[2]*up[2] ; 
     static double[] Iup = {up[0]-Dot*Nfwd[0],up[1]-Dot*Nfwd[1],up[2]-Dot*Nfwd[2]} ;
     static double Lup = Math.sqrt(Iup[0]*Iup[0]+Iup[1]*Iup[1]+Iup[2]*Iup[2]) ; 
     static double[] Nup = {Iup[0]/Lup,Iup[1]/Lup,Iup[2]/Lup} ; 
     static double[] Nleft = {-Nfwd[1]*Nup[2]+Nfwd[2]*Nup[1],
                              -Nfwd[2]*Nup[0]+Nfwd[0]*Nup[2],
                              -Nfwd[0]*Nup[1]+Nfwd[1]*Nup[0]} ; 

     static double[][] proj = { {Nleft[0], Nleft[1], Nleft[2]},
                                { Nup[0],  Nup[1], Nup[2]}   } ;
     static double[] view = {fwd[0], fwd[1], fwd[2]} ;


     static double Ia =  0.5 ;  // ambient intensity
     static double Id =  0.3 ;  // directional intensity
                                // keep Ia, Id >=0, Ia+Id <= 1
     static double Drnth = 60 ;  // lighting direction angle, in degrees
     static double Drnphi = 60 ;
     static double cosDrnth = Math.cos(Drnth*Math.PI/180.0) ;  
     static double sinDrnth = Math.sin(Drnth*Math.PI/180.0) ;  
     static double cosDrnphi = Math.cos(Drnphi*Math.PI/180.0) ;  
     static double sinDrnphi = Math.sin(Drnphi*Math.PI/180.0) ;  
     static double du, dv ;



     public void setup() {
          filePrefix = "xyzSurfDD" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0*0.75 ;  
          double Xmin= 0.0 ;
          double Xmax= 5.0 ;
          double Ymin= 0.0 ;
          double Ymax= 5.0 ;
          double Zmin= 0.0 ;
          double Zmax= 4.0 ;
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
          bottommargin =0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double density, u, v ;
          double[] pt ;
          double[] x,y,hx,hy,vx,vy,dens ;
          boolean[] skip ;


          Ia =  0.4 ;  // ambient intensity
          Id =  0.4 ;  // directional intensity
          int nu = 33 ;
          int nv = 33 ;
          double u1 = -14 ;
          du = 1 ;
          double v1 = 1.0 ;
          dv = 0.5 ;


          x = new double[nu*nv] ;
          y = new double[nu*nv] ;
          hx = new double[nu*nv] ;
          hy = new double[nu*nv] ;
          vx = new double[nu*nv] ;
          vy = new double[nu*nv] ;
          dens = new double[nu*nv] ;
          skip = new boolean[nu*nv] ;
          int n = 0 ;
          u=u1-du ;
          for (int j=0; j<nu; j++) {
               u += du ;
               v = v1-dv ;
               for (int i=0; i<nv; i++) {
                    v += dv ;
                    pt = seatPt(u,v) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = seatVVelocity(u, v) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = seatUVelocity(u, v) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = seatDensity(u, v) ;
                    skip[n]  = !seatVisible(u, v) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nv)) ;
          
     }



     public double[] seatPt(double u, double v) {  // angle in degrees
          double[] out = {0,0} ;
          double a = Math.sqrt(u*u+4*v*v) ;
          double x = Math.sqrt(0.5*(a+u)) ;
          double y = Math.sqrt(0.5*(a-u)) ;
          double z = 4/v  ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }


     public double[] seatUVelocity(double u, double v) {  // angle in degrees
          double[] out = {0,0} ;
          double a = Math.sqrt(u*u+4*v*v) ;
          double xx = Math.sqrt(0.5*(a+u)) ;
          double yy = Math.sqrt(0.5*(a-u)) ;
          double x = du*0.25*(1+u/a)/xx ;
          double y = du*0.25*(-1+u/a)/yy ;
          double z = 0  ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }


     public double[] seatVVelocity(double u, double v) {  // angle in degrees
          double[] out = {0,0} ;
          double a = Math.sqrt(u*u+4*v*v) ;
          double xx = Math.sqrt(0.5*(a+u)) ;
          double yy = Math.sqrt(0.5*(a-u)) ;
          double x = dv*0.25*(4*v/a)/xx ;
          double y = dv*0.25*(4*v/a)/yy ;
          double z = -dv*4/(v*v)  ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }

// For motivation for the next two routines see the notes visibilityDensity3d.tex.

     public double seatDensity(double u, double v) {  // angle in degrees

          double a = Math.sqrt(u*u+4*v*v) ;
          double x = Math.sqrt(0.5*(a+u)) ;
          double y = Math.sqrt(0.5*(a-u)) ;
          double z = 4/v  ;
          double lN = Math.sqrt(1/(x*x) + 1/(y*y) + 1/(z*z)) ;
          double N1 = 1/(x*lN) ;  double N2 = 1/(y*lN) ; double N3 = 1/(z*lN) ;
          double L1 = cosDrnth*sinDrnphi ; double L2 = sinDrnth*sinDrnphi; 
                double L3 = cosDrnphi ;
          double LdN = L1*N1 + L2*N2 + L3*N3 ;
          double rL1 = 2*LdN*N1-L1 ; double rL2 = 2*LdN*N2-L2; 
                double rL3 = 2*LdN*N3-L3 ;
          double density = Ia +Id*(
                            rL1*view[0] + rL2*view[1] + rL3*view[2]) ;
          return density ;
     }

     public boolean seatVisible(double u, double v) {  // angle in degrees
          return true ;
     }





}








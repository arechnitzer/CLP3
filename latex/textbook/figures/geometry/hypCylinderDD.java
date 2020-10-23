                  /*  File:  hypCylinderDD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hypCylinderDD extends Template {

     static {templateClass = new hypCylinderDD() ; }

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
     static double[] fwd = {1,0.5,0.6} ; 
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
     static double Id =  0.5 ;  // directional intensity
                                // keep Ia, Id >=0, Ia+Id <= 1
     static double Drnth = 60 ;  // lighting direction angle, in degrees
     static double Drnphi = 60 ;
     static double cosDrnth = Math.cos(Drnth*Math.PI/180.0) ;  
     static double sinDrnth = Math.sin(Drnth*Math.PI/180.0) ;  
     static double cosDrnphi = Math.cos(Drnphi*Math.PI/180.0) ;  
     static double sinDrnphi = Math.sin(Drnphi*Math.PI/180.0) ;  
     static double du, dv ;



     public void setup() {
          filePrefix = "hypCylinderDD" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0*0.75 ;  
          double Xmin= -2.5 ;
          double Xmax= 1.3 ;
          double Ymin= -1.2 ;
          double Ymax= 2.0 ;
          double Zmin= -1.8 ;
          double Zmax= 0.4 ;
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


          Ia =  0.5 ;  // ambient intensity
          Id =  0.7 ;  // directional intensity
          int nu = 20 ;
          int nv = 15 ;
          double u1 = -2.4 ;
          du = 0.2 ;
          double v1 = 0.1 ;
          dv = 0.2 ;


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
                    pt = hypParaPt(u,v) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypParaVVelocity(u, v) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypParaUVelocity(u, v) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypParaDensity(u, v) ;
                    skip[n]  = hypParaVisible(u, v) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nv)) ;


//          nu = 19 ;
//          nv = 11 ;
          u1 = 0.0 ;
          du = 0.2 ;
          v1 = 0.2 ;
          dv = 0.2 ;



          x = new double[nu*nv] ;
          y = new double[nu*nv] ;
          hx = new double[nu*nv] ;
          hy = new double[nu*nv] ;
          vx = new double[nu*nv] ;
          vy = new double[nu*nv] ;
          dens = new double[nu*nv] ;
          skip = new boolean[nu*nv] ;
          n = 0 ;
          u=u1-du ;
          for (int j=0; j<nu; j++) {
               u += du ;
               v = v1-dv ;
               for (int i=0; i<nv; i++) {
                    v += dv ;
                    pt = hypParaPt(u,v) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypParaVVelocity(u, v) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypParaUVelocity(u, v) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypParaDensity(u, v) ;
                    skip[n]  = !hypParaVisible(u, v) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nv)) ;


          
     }



     public double[] hypParaPt(double u, double v) {  // angle in degrees
          double[] out = {0,0} ;
          double x = u ;
          double y = v ;
          double z = 1/v  ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }


     public double[] hypParaUVelocity(double u, double v) {  // angle in degrees
          double[] out = {0,0} ;
          double x = du ;
          double y = 0 ;
          double z = 0  ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }


     public double[] hypParaVVelocity(double u, double v) {  // angle in degrees
          double[] out = {0,0} ;
          double x = 0 ;
          double y = dv ;
          double z = -dv/(v*v)  ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }

// For motivation for the next two routines see the notes visibilityDensity3d.tex.

     public double hypParaDensity(double u, double v) {  // angle in degrees

          double lN = Math.sqrt(v*v + 1/(v*v)) ;
          double N1 = 0 ;  double N2 = 1/(v*lN) ; double N3 = v/lN ;
          double L1 = cosDrnth*sinDrnphi ; double L2 = sinDrnth*sinDrnphi; 
                double L3 = cosDrnphi ;
          double LdN = L1*N1 + L2*N2 + L3*N3 ;
          double rL1 = 2*LdN*N1-L1 ; double rL2 = 2*LdN*N2-L2; 
                double rL3 = 2*LdN*N3-L3 ;
          double density = Ia +Id*(
                            rL1*view[0] + rL2*view[1] + rL3*view[2]) ;

//          double density =Ia +Id*(
//                            u*cosDrnth*sinDrnphi 
//                          - v*sinDrnth*sinDrnphi
//                          + cosDrnphi)/Math.sqrt(1+4*u*u+16*v*v) ;
          return density ;
     }

     public boolean hypParaVisible(double u, double v) {  // angle in degrees
          return true ;
     }





}








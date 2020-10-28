                  /*  File:  hyperboloid1sheetDD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperboloid1sheetDD extends Template {

     static {templateClass = new hyperboloid1sheetDD() ; }

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
//     static double[] fwd = {1,1,0.5} ; 
     static double[] fwd = {1,0.7,0.5} ; 
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


     static double Ia =  0.4 ;  // ambient intensity
     static double Id =  0.2 ;  // directional intensity
                                // keep Ia, Id >=0, Ia+Id <= 1
//     static double Drnth = -60 ;  // lighting direction angle, in degrees
     static double Drnth = 20 ;  // lighting direction angle, in degrees
//     static double Drnphi = 100 ;
     static double Drnphi = 120 ;
     static double cosDrnth = Math.cos(Drnth*Math.PI/180.0) ;  
     static double sinDrnth = Math.sin(Drnth*Math.PI/180.0) ;  
     static double cosDrnphi = Math.cos(Drnphi*Math.PI/180.0) ;  
     static double sinDrnphi = Math.sin(Drnphi*Math.PI/180.0) ;  
     static double cosPhi, cosTh, sinPhi, sinTh, dth, dz ;
     static double A = 3 ;
     static double sqA = Math.sqrt(A) ;



     public void setup() {
          filePrefix = "hyperboloid1sheetDD" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0 ;  
          double Xmin= -3 ;
          double Xmax= 3 ;
          double Ymin= -3 ;
          double Ymax= 3 ;
          double Zmin= -2.1 ;
          double Zmax= 2.1 ;
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
          double th, density, z ;
          double[] pt ;
          double[] x,y,hx,hy,vx,vy,dens ;
          boolean[] skip ;


          Ia =  0.5 ;  // ambient intensity
          Id =  0.2 ;  // directional intensity
          int nth = 13 ;
          int nz = 13 ;
          double th1 = 90 ;
          dth = 30*Math.PI/180 ;
          double z1 = -0.4 ;
          dz = 0.2 ;

          x = new double[nth*nz] ;
          y = new double[nth*nz] ;
          hx = new double[nth*nz] ;
          hy = new double[nth*nz] ;
          vx = new double[nth*nz] ;
          vy = new double[nth*nz] ;
          dens = new double[nth*nz] ;
          skip = new boolean[nth*nz] ;
          int n = 0 ;
          th=th1-dth ;
          for (int j=0; j<nth; j++) {
               th += dth ;
               z = z1-dz ;
               for (int i=0; i<nz; i++) {
                    z += dz ;
                    cosTh = Math.cos(th) ;
                    sinTh = Math.sin(th) ;
                    pt = hypPt(z,th) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypRVelocity(z,th) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypThVelocity(z,th) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypDensity(z,th) ;
//                    skip[n]  = false ;
                    skip[n]  = hypVisible(z,th) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nz)) ;


          Ia =  0.5 ;  // ambient intensity
          Id =  0.2 ;  // directional intensity
          nth = 37 ;
          nz = 21 ;
          th1 = 0 ;
          dth = 10*Math.PI/180 ;
          z1 = -2 ;
          dz = 0.2 ;

          x = new double[nth*nz] ;
          y = new double[nth*nz] ;
          hx = new double[nth*nz] ;
          hy = new double[nth*nz] ;
          vx = new double[nth*nz] ;
          vy = new double[nth*nz] ;
          dens = new double[nth*nz] ;
          skip = new boolean[nth*nz] ;
          n = 0 ;
          z=z1-dz ;
          for (int j=0; j<nz; j++) {
               z += dz ;
               th = th1-dth ;
               for (int i=0; i<nth; i++) {
                    th += dth ;
                    cosTh = Math.cos(th) ;
                    sinTh = Math.sin(th) ;
                    pt = hypPt(z,th) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypThVelocity(z,th) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypRVelocity(z,th) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypDensity(z,th) ;
//                    skip[n]  = false ;
                    skip[n]  = !hypVisible(z,th) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nth)) ;          
     }



     public double[] hypPt(double z, double th) {  // angle in degrees
          double[] out = {0,0} ;
          double r = Math.sqrt(1+z*z) ;
          double x = r*cosTh/sqA ;
          double y = r*sinTh ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }


     public double[] hypThVelocity(double z, double th) {  // angle in degrees
          double[] out = {0,0} ;
          double r = Math.sqrt(1+z*z) ;
          double x = -dth*r*sinTh/sqA ;
          double y = dth*r*cosTh ;
          out[0] = x*proj[0][0]+y*proj[0][1] ;
          out[1] = x*proj[1][0]+y*proj[1][1] ;
          return out ;
     }


     public double[] hypRVelocity(double z, double th) {  // angle in degrees
          double[] out = {0,0} ;
          double dr = z*dz/Math.sqrt(1+z*z) ;
          double x = dr*cosTh/sqA ;
          double y = dr*sinTh ;
          out[0] = x*proj[0][0]+y*proj[0][1]+dz*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+dz*proj[1][2] ;
          return out ;
     }


// For motivation for the next two routines see the notes visibilityDensity3d.tex.

     public double hypDensity(double z, double th) {  // angle in degrees
          double r = Math.sqrt(1+z*z) ;
          double x = r*cosTh/sqA ;
          double y = r*sinTh ;
          double lN = Math.sqrt(A*A*x*x +y*y + z*z) ;
          double N1 = A*x/lN ;  double N2 = y/lN ; double N3 = -z/lN ;
          double L1 = cosDrnth*sinDrnphi ; double L2 = sinDrnth*sinDrnphi; 
                double L3 = cosDrnphi ;
          double LdN = L1*N1 + L2*N2 + L3*N3 ;
          double rL1 = 2*LdN*N1-L1 ; double rL2 = 2*LdN*N2-L2; 
                double rL3 = 2*LdN*N3-L3 ;
          double density = Ia +Id*(
                            rL1*view[0] + rL2*view[1] + rL3*view[2]) ;
 
//          double Z1 = Math.sqrt(1+2*z*z) ;
//          double Z2 = Math.sqrt((1+z*z)/(1+2*z*z)) ;
//          double density = Ia +Id*(
//                            A*Z2*cosTh*cosDrnth*sinDrnphi 
//                          + Z2*sinTh*sinDrnth*sinDrnphi
//                          - z*cosDrnphi/Z1) ;
          return density ;
     }

     public boolean hypVisible(double z, double th) {  // angle in degrees
          double r = Math.sqrt(1+z*z) ;
          double dotProd =    sqA*r*cosTh*view[0]
                            + r*sinTh*view[1]
                            - z*view[2] ;
          if (dotProd>=0) {
               return true ;
          } else {
               return false ;
          }
     }





}








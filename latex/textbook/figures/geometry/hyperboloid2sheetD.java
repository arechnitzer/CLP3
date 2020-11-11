                  /*  File:  hyperboloid2sheetD.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperboloid2sheetD extends Template {

     static {templateClass = new hyperboloid2sheetD() ; }

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
     static double[] fwd = {1,1,0.5} ; 
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
     static double Drnth = -30 ;  // lighting direction angle, in degrees
     static double Drnphi = 90 ;
     static double cosDrnth = Math.cos(Drnth*Math.PI/180.0) ;  
     static double sinDrnth = Math.sin(Drnth*Math.PI/180.0) ;  
     static double cosDrnphi = Math.cos(Drnphi*Math.PI/180.0) ;  
     static double sinDrnphi = Math.sin(Drnphi*Math.PI/180.0) ;  
     static double cosPhi, cosTh, sinPhi, sinTh, dth, dr ;



     public void setup() {
          filePrefix = "hyperboloid2sheetD" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*0.7 ;    
          ysize = 3.0*0.7 ;  
          double Xmin= -4 ;
          double Xmax= 4 ;
          double Ymin= -4 ;
          double Ymax= 4 ;
          double Zmin= -6 ;
          double Zmax= 6 ;
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
          double th, density, r ;
          double[] pt ;
          double[] x,y,hx,hy,vx,vy,dens ;
          boolean[] skip ;


          Ia =  0.5 ;  // ambient intensity
          Id =  0.5 ;  // directional intensity
          int nth = 13 ;
          int nr = 25 ;
          double th1 = -75*Math.PI/180 ;
          dth = 30*Math.PI/180 ;
          double r1 = 0 ;
          dr = 0.2 ;
          double sign = -1 ;

          x = new double[nth*nr] ;
          y = new double[nth*nr] ;
          hx = new double[nth*nr] ;
          hy = new double[nth*nr] ;
          vx = new double[nth*nr] ;
          vy = new double[nth*nr] ;
          dens = new double[nth*nr] ;
          skip = new boolean[nth*nr] ;
          int n = 0 ;
          r=r1-dr ;
          for (int j=0; j<nr; j++) {
               r += dr ;
               th = th1-dth ;
               for (int i=0; i<nth; i++) {
                    th += dth ;
                    cosTh = Math.cos(th) ;
                    sinTh = Math.sin(th) ;
                    pt = hypPt(r, th, sign) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypThVelocity(r, th, sign) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypRVelocity(r, th, sign) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypDensity(r, th, sign) ;
                    skip[n]  = !hypVisible(r, th, sign) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nth)) ;

          Ia =  0.5 ;  // ambient intensity
          Id =  0.5 ;  // directional intensity
          nth = 13 ;
          nr = 25 ;
          th1 = 270 ;
          dth = 30*Math.PI/180 ;
          r1 = 0 ;
          dr = 0.2 ;
          sign = 1 ;

          x = new double[nth*nr] ;
          y = new double[nth*nr] ;
          hx = new double[nth*nr] ;
          hy = new double[nth*nr] ;
          vx = new double[nth*nr] ;
          vy = new double[nth*nr] ;
          dens = new double[nth*nr] ;
          skip = new boolean[nth*nr] ;
          n = 0 ;
          r=r1-dr ;
          for (int j=0; j<nr; j++) {
               r += dr ;
               th = th1-dth ;
               for (int i=0; i<nth; i++) {
                    th += dth ;
                    cosTh = Math.cos(th) ;
                    sinTh = Math.sin(th) ;
                    pt = hypPt(r, th, sign) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypThVelocity(r, th, sign) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypRVelocity(r, th, sign) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypDensity(r, th, sign) ;
                    skip[n]  = hypVisible(r, th, sign) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nth)) ;



          Ia =  0.5 ;  // ambient intensity
          Id =  0.5 ;  // directional intensity
          nth = 13 ;
          nr = 25 ;
          th1 = 270 ;
          dth = 30*Math.PI/180 ;
          r1 = 0 ;
          dr = 0.2 ;
          sign = 1 ;

          x = new double[nth*nr] ;
          y = new double[nth*nr] ;
          hx = new double[nth*nr] ;
          hy = new double[nth*nr] ;
          vx = new double[nth*nr] ;
          vy = new double[nth*nr] ;
          dens = new double[nth*nr] ;
          skip = new boolean[nth*nr] ;
          n = 0 ;
          r=r1-dr ;
          for (int j=0; j<nr; j++) {
               r += dr ;
               th = th1-dth ;
               for (int i=0; i<nth; i++) {
                    th += dth ;
                    cosTh = Math.cos(th) ;
                    sinTh = Math.sin(th) ;
                    pt = hypPt(r, th, sign) ;
                    x[n] = pt[0] ;
                    y[n] = pt[1] ;
                    pt = hypThVelocity(r, th, sign) ;
                    hx[n] = pt[0] ;
                    hy[n] = pt[1] ;
                    pt = hypRVelocity(r, th, sign) ;
                    vx[n] = pt[0] ;
                    vy[n] = pt[1] ;
                    dens[n]  = hypDensity(r, th, sign) ;
                    skip[n]  = !hypVisible(r, th, sign) ;
                    n++ ;
          }}
          canvas.append( new fCoonsRect(x,y,hx,hy,vx,vy,dens,skip,nth)) ;




          
     }



     public double[] hypPt(double r, double th, double sign) {  
          double[] out = {0,0} ;
          double x = 0.6*r*cosTh ;
          double y = r*sinTh ;
          double z = sign*Math.sqrt(r*r+1) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }


     public double[] hypThVelocity(double r, double th, double sign) {  
          double[] out = {0,0} ;
          double x = -0.6*dth*r*sinTh ;
          double y = dth*r*cosTh ;
          out[0] = x*proj[0][0]+y*proj[0][1] ;
          out[1] = x*proj[1][0]+y*proj[1][1] ;
          return out ;
     }


     public double[] hypRVelocity(double r, double th, double sign) { 
          double[] out = {0,0} ;
          double x = 0.6*dr*cosTh ;
          double y = dr*sinTh ;
          double z = sign*r*dr/Math.sqrt(r*r+1) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
     }

     public double hypDensity(double r, double th, double sign) {  
          double Z = Math.sqrt(2*r*r+1) ;
          double z = sign*Math.sqrt(r*r+1) ;
          double density = Ia +Id*(
                            0.6*r*cosTh*cosDrnth*sinDrnphi 
                          + r*sinTh*sinDrnth*sinDrnphi
                          - z*cosDrnphi)/Z ;
          return density ;
     }

     public boolean hypVisible(double r, double th, double sign) {  
          double z = sign*Math.sqrt(r*r+1) ;
          double dotProd =    1.1*r*cosTh*view[0]
                            + r*sinTh*view[1]
                            - z*view[2] ;
          if (dotProd>=0) {
               return true ;
          } else {
               return false ;
          }
     }





}








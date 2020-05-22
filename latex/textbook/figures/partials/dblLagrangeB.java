                  /*  File:  dblLagrangeB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dblLagrangeB extends Template {

     static {templateClass = new dblLagrangeB() ; }
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
          filePrefix = "dblLagrangeB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  

          double Xmin= -5 ;
          double Xmax= 5 ;
          double Ymin= -1 ;
          double Ymax= 9 ;
          double Zmin= -1 ;
          double Zmax= 9 ;
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


          topmargin = -1.3 ;   // in inches
          bottommargin = -0.1 ;   // in inches
          leftmargin = -0.5 ;   // in inches
          rightmargin = -0.1 ;   // in inches
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
          double x1 = 5 ;
          double ym = 6 ;
          double ym2 = 7 ;
          double x2 = -2 ;
          double z2 = 3 ;
          double s = 1.2 ;
          double l = 3 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(-x1,0,0, -x1,ym2,0) ;
          fLine3d(x1,0,0, x1,ym2,0) ;
          fLine3d(-x1,0,0, x1,0,0) ;
          fLine3d(-x1,ym,0, x1,ym,0) ;

          fLine3d(0,0,0, x2,0,z2) ;
          fLine3d(x2,0,z2, x2,ym2,z2) ;
          fLine3d(0,ym,0, x2,ym,z2) ;

          fTeXlabel3d(x1/2,-0.3,0, "cr", "$g(x,y,z)=0$") ;
          fTeXlabel3d(x2/2,-0.25,z2/2, "cr", "$h(x,y,z)=0$") ;

          fEnv("lineWidth", 1.5) ;
          fLine3d(0,0,0,  0,ym,0) ;

          fEnv("lineWidth", 0.5) ;
          fArrow3d(0,ym,0, 0,ym,l) ;
          fArrow3d(0,ym,0, z2*s,ym,-x2*s) ;
          double la = -0.7 ;
          double mu = 1.5 ;
          fArrow3d(0,ym,0, mu*z2*s,ym,-mu*x2*s+la*l) ;
          fTeXlabel3d(0,ym, l, "br", "$\\vnabla g$") ;
          fTeXlabel3d(z2*s,ym,-x2*s, "br", "$\\vnabla h$") ;
          fTeXlabel3d(mu*z2*s,ym+0.1,-mu*x2*s+la*l+0.1, "tr", "$\\la\\vnabla g+\\mu\\vnabla h$") ;

          fEnv("psGray", 0.8) ;
          fEnv("lineWidth", 1.5) ;
          fLine3d(0,ym,0, 0,ym+0.6*l,0) ;
          fEnv("psGray", 0.0) ;
          fEnv("lineWidth", 0.5) ;
          fArrow3d(0,ym,0, 0,ym+0.3*l,0) ;
          fTeXlabel3d(0,ym+0.3*l,0.2, "bc", "$\\vv$") ;
          fEnv("psFillGray", 0.8) ;
          fDisk(ym*proj[0][1], ym*proj[1][1], 0.15, 0.15, FILLED) ;




          
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

}





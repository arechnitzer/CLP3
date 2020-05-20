                  /*  File:  sphereMass1a.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sphereMass1a extends Template {

     static {templateClass = new sphereMass1a() ; }
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
          filePrefix = "sphereMass1a" ;  
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
          double r = 80 ;
          double xm = 100 ;
          double ym = 90 ;
          double zm = 90 ;
          double z1 = 7 ;
          double z2 = 0 ;
          double r1 = Math.sqrt(r*r-z1*z1) ;
          double r2 = Math.sqrt(r*r-z2*z2) ;
          double phi1 = Math.asin(z1/r) ;
          double phi2 = Math.asin(z2/r) ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;

          double xv, zv ;

//          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("psFillGray", 0.9) ;
          fCurve(new circ3d(proj,   0,0,z2 , r2),0,90,FILLED)  ;
          {  double[] xlist = {0,  r1, r2,  0,  0, 0} ;
             double[] ylist = {0,   0,  0, r2, r1, 0} ;
             double[] zlist = {z1, z1, z2, z2, z1, z1} ;
             fPolygon3d(xlist, ylist, zlist, 6, FILLED) ; }
          fEnv("psFillGray", 0.8) ;
          fCurve(new circ3d(proj,   0,0,z1 , r1),0,90,FILLED)  ;
          double sq2 = Math.sqrt(2) ;
          {  double[] xlist = {0,  r1, r1/sq2,  0} ;
             double[] ylist = {0,   0, r1/sq2, r1} ;
             double[] zlist = {z1, z1,     z1, z1} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }

          fEnv("lineWidth", 0.8) ;
               fCurve(new circ3d(proj,   0,0,0, 0,0,r, r,0,0),
                      0,90,OPEN)  ;
               fCurve(new circ3d(proj,   0,0,0, 0,0,r, 0,r,0),
                      0,90,OPEN)  ;
               fCurve(new circ3d(proj,   0,0,0, r,0,0, 0,r,0),
                      0,90,OPEN)  ;

          fEnv("lineWidth", 1.2) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
               fCurve(new circ3d(proj,   0,0,z1, r1,0,0, 0,r1,0),
                      0,90,OPEN)  ;
               fCurve(new circ3d(proj,   0,0,z2, r2,0,0, 0,r2,0),
                      0,90,OPEN)  ;
               fLine3d(0,0,z1, r1,  0,z1) ;
               fLine3d(0,0,z1,  0, r1,z1) ;
               fCurve(new circ3d(proj,   0,0,0, r,0,0, 0,0,r),
                      phi1*180/Math.PI,phi2*180/Math.PI,OPEN)  ;
               fCurve(new circ3d(proj,   0,0,0, 0,r,0, 0,0,r),
                      phi1*180/Math.PI,phi2*180/Math.PI,OPEN)  ;

          xv = Math.sin(30*Math.PI/180);
          zv = Math.cos(30*Math.PI/180);
//          fTeXlabel3d(0,r*xv+2,r*zv, "bl", "$x^2+y^2+z^2=1$") ; 

          fEnv("lineWidth", 0.5) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fArrow3d(0,15,r+10,  1,1,r+1) ;
          fTeXlabel3d(0,16,r+12, "cl", "$(0,0,1)$") ; 



          z1 = r-1 ;
          z2 = r-3 ;
          r1 = Math.sqrt(r*r-z1*z1) ;
          r2 = Math.sqrt(r*r-z2*z2) ;
          phi1 = Math.asin(z1/r) ;
          phi2 = Math.asin(z2/r) ;
         
          fEnv("psFillGray", 0.9) ;
          fCurve(new circ3d(proj,   0,0,z2 , r2),0,90,FILLED)  ;
          {  double[] xlist = {0,  r1, r2,  0,  0, 0} ;
             double[] ylist = {0,   0,  0, r2, r1, 0} ;
             double[] zlist = {z1, z1, z2, z2, z1, z1} ;
             fPolygon3d(xlist, ylist, zlist, 6, FILLED) ; }
          fEnv("psFillGray", 0.8) ;
          fCurve(new circ3d(proj,   0,0,z1 , r1),0,90,FILLED)  ;
          {  double[] xlist = {0,  r1, r1/sq2,  0} ;
             double[] ylist = {0,   0, r1/sq2, r1} ;
             double[] zlist = {z1, z1,     z1, z1} ;
             fPolygon3d(xlist, ylist, zlist, 4, FILLED) ; }
          fEnv("lineWidth", 1.2) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
               fCurve(new circ3d(proj,   0,0,z1, r1,0,0, 0,r1,0),
                      0,90,OPEN)  ;
               fCurve(new circ3d(proj,   0,0,z2, r2,0,0, 0,r2,0),
                      0,90,OPEN)  ;
               fLine3d(0,0,z1, r1,  0,z1) ;
               fLine3d(0,0,z1,  0, r1,z1) ;
               fCurve(new circ3d(proj,   0,0,0, r,0,0, 0,0,r),
                      phi1*180/Math.PI,phi2*180/Math.PI,OPEN)  ;
               fCurve(new circ3d(proj,   0,0,0, 0,r,0, 0,0,r),
                      phi1*180/Math.PI,phi2*180/Math.PI,OPEN)  ;



          
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




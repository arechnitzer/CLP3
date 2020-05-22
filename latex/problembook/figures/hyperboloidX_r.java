                  /*  File:  hyperboloidX_r.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperboloidX_r extends Template {

     static {templateClass = new hyperboloidX_r() ; }
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
     static double[] fwd = {0.5, 0.9, 0.0} ; 
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
          filePrefix = "hyperboloidX_r" ;  
          outputPsFile = true ;
          outputLblFile = true ;

          xsize = 3.0 ;    
          ysize = 2.0 ;  

          double Xmin= -5 ;
          double Xmax=  5 ;
          double Ymin= -5 ;
          double Ymax=  5 ;
          double Zmin= -3 ;
          double Zmax= 3 ;
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
          leftmargin =  0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 20 ;
//          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double x0 = 0 ; double X = 0 ; double Y = 0 ; double Z = 0 ;

          double xm = 5 ;
          double ym = 5 ;
          double zm = 3 ;
          double Xm = 2 ;


//          fEnv("lineWidth", 0.5) ;
//          fLine3d(0,0,2, 0,0,zm) ;
//          fLine3d(0,3,0, 0,ym,0) ;
//          fLine3d(Xm,0,0, xm,0,0) ;
//          fTeXlabel3d(0,0,zm+0.08, "cb", "$z$") ;
//          fTeXlabel3d(0,ym+0.08,0, "cl", "$y$") ;
//          fTeXlabel3d(xm,-0.05,-0.05, "cr", "$x$") ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.5) ;
          double th = 0 ; double thRad = th*Math.PI/180 ;
          fCurve(new hyperbola3d(proj,   0,0,0, 0,Math.sin(thRad),-Math.cos(thRad), 
                                                1,0,0, 0.5,0.25), -4,4,OPEN) ;

          th = -10 ; thRad = th*Math.PI/180 ;
          fCurve(new hyperbola3d(proj,   0,0,0, 0,Math.sin(thRad),Math.cos(thRad), 
                                                1,0,0, 0.5,0.25), -4,4,OPEN) ;


          fEnv("psFillGray", 0.8) ;
          x0 = 4 ; Y = 3*Math.sqrt(1+x0*x0/16) ; Z = 2*Math.sqrt(1+x0*x0/16) ;
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 0,360,FILLED) ;
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 0,360,OPEN) ;


          x0 = -4 ; Y = 3*Math.sqrt(1+x0*x0/16) ; Z = 2*Math.sqrt(1+x0*x0/16) ;
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 -90,97,OPEN) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 115,240,OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;




//          x0=4 ; 
//          double YM = 3.0*Math.sqrt(1+x0*x0/16) ;
//          double ZM = 2.0*Math.sqrt(1+x0*x0/16) ;
//          fLine3d(x0,0,0, x0,YM,0) ;
//          fLine3d(x0,0,0, x0,0,ZM) ;

//          x0=0 ; 
//          YM = 3.0*Math.sqrt(1+x0*x0/16) ;
//          ZM = 2.0*Math.sqrt(1+x0*x0/16) ;
//          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
//          fLine3d(x0,0,0, x0,YM,0) ;
//          fLine3d(x0,0,0, x0,0,ZM) ;
//          fLine3d(0,0,0,  Xm,0,0) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
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
//  The next class generates the curve a^2x^2-b^2y^2=1 but with 
//      the x axis vector (1,0) replaced by (xa,ya,za) and
//      the y axis vector (0,1) replaced by (xb,yb,zb) and
//      the origin shifted to (cx,cy,cz)

class hyperbola3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 1.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 1.0 ;
     double zb = 0.0 ;
     double a  = 1 ;
     double b = 1 ;


   public hyperbola3d(double[][] proj, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb,
                 double a, double b) {
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
        this.a = a ;
        this.b = b ;
   }

     public double[] map(double t) {
          
//          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
//          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double X = Math.sqrt(1+b*b*t*t)/a ;
          double x = cx+xa*X+xb*t ;
          double y = cy+ya*X+yb*t ;
          double z = cz+za*X+zb*t ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}




                  /*  File:  paraboloidX_l.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class paraboloidX_l extends Template {

     static {templateClass = new paraboloidX_l() ; }
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
     static double[] fwd = {1, 1.1, 0.4} ; 
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
          filePrefix = "paraboloidX_l" ;  
          outputPsFile = true ;
          outputLblFile = true ;

          xsize = 2.5 ;    
          ysize = 2.0 ;  

          double Xmin= -0.2 ;
          double Xmax=  5 ;
          double Ymin= -0.2 ;
          double Ymax=  2 ;
          double Zmin= -0.2 ;
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
          double a = 1 ;  double b = 2/3.0 ;
          double x0 = 4 ; double Y = Math.sqrt(x0)/a ; double Z = Math.sqrt(x0)/b ;

          double xm = 5 ;
          double ym = 2 ;
          double zm = 3 ;
          double Xm = 2.27 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fTeXlabel3d(0,0,zm+0.08, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.08,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "cr", "$x$") ;


          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;

          fEnv("lineWidth", 1.5) ;
          fCurve(new parabola3d(proj,   a,b, 0),
                 0,Y,OPEN) ;

          fCurve(new parabola3d(proj,   a,b, 90),
                 0,Z,OPEN) ;
                 
//          double TH = 45 ; double THrad = TH*Math.PI/180 ;
//          double cth = Math.cos(TH*Math.PI/180.0) ;
//          double sth = Math.sin(TH*Math.PI/180.0) ;
//          double TM = Math.sqrt(x0/(a*a*cth*cth + b*b*sth*sth)) ;
//
//          fCurve(new parabola3d(proj,   a,b, TH),
//                 0,TM,OPEN) ;

//          TH = 60 ; THrad = TH*Math.PI/180 ;
//          cth = Math.cos(TH*Math.PI/180.0) ;
//          sth = Math.sin(TH*Math.PI/180.0) ;
//          TM = Math.sqrt(x0/(a*a*cth*cth + b*b*sth*sth)) ;
//
//          fCurve(new parabola3d(proj,   a,b, TH),
//                 0,TM,OPEN) ;


          fEnv("psFillGray", 0.8) ;
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 0,90,FILLED) ;
         {double[] xlist = {x0, x0, x0,  x0} ;
          double[] ylist = {0,   Y, 0.6*Y, 0} ;
          double[] zlist = {0,   0, 0.6*Z,  Z} ;
          fPolygon3d(xlist,ylist, zlist, 4, FILLED) ;}
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 0,90,OPEN) ;

          fLine3d(x0,0,0, x0,Y,0) ;
          fLine3d(x0,0,0, x0,0,Z) ;

          x0 = 2 ; Y = Math.sqrt(x0)/a ; Z = Math.sqrt(x0)/b ;
          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
                 0,90,OPEN) ;


//          x0 = 4*0.66 ; Y = Math.sqrt(x0)/a ; Z = Math.sqrt(x0)/b ;
//          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
//                 0,90,OPEN) ;

//          x0 = 4*0.33 ; Y = Math.sqrt(x0)/a ; Z = Math.sqrt(x0)/b ;
//          fCurve(new circ3d(proj,   x0,0,0, 0,Y,0, 0,0,Z),
//                 0,90,OPEN) ;


          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fLine3d(Xm,0,0, xm,0,0) ;
          canvas.append( new fPsWrite("[2 2] 0.0 setdash\n")) ;
          fLine3d(0,0,0,  Xm,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
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

//  The next class generates the curve 
//           y = t\cos\th 
//           z = t\sin\th
//           x=a^2(t \cos\th)^2+b^2(t \sin\th)^2 but with 

class parabola3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double a  = 1 ;
     double b = 1 ;
     double th = 90 ;
     double cth = 0 ;
     double sth = 1 ;


   public parabola3d(double[][] proj, 
                 double a, double b, double th) {
        this.proj = proj ;
        this.a = a ;
        this.b = b ;
        this.th = th ;
        cth = Math.cos(th*Math.PI/180.0) ;
        sth = Math.sin(th*Math.PI/180.0) ;
   }

     public double[] map(double t) {
          double[] out = {0,0} ;
          double y = t*cth;
          double z = t*sth ;
          double x = a*a*y*y+b*b*z*z ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}




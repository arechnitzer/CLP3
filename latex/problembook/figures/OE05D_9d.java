                  /*  File:  OE05D_9d.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE05D_9d extends Template {

     static {templateClass = new OE05D_9d() ; }
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
     static double[] fwd = {1, 0.3, 0.8} ; 
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
          filePrefix = "OE05D_9d" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 2.3 ;  

          double Xmin= -0.2 ;
          double Xmax=  3.2 ;
          double Ymin= -1.2 ;
          double Ymax=  2.2 ;
          double Zmin= -0.2 ;
          double Zmax=  2.2 ;
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
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
//          double al = 60 ;
//          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double r = 30 ;
          double rr = 0.05 ;
          double xm = 3.2 ;
          double ym = 2.2 ;
          double zm = 2.2 ;
          

          double Y = 0.5 ;
          double X1 = 1+Y*Y-Y ; double Z1 = 1-Y*Y ;
          double X2 = 2-Y ;
          fEnv("psFillGray", 0.8) ;
          {  double[] xlist = {0,  0, X1, X2, 0} ;
             double[] ylist = {Y,  Y,  Y,  Y, Y} ;
             double[] zlist = {0, Z1, Z1,  0, 0} ;
             fPolygon3d(xlist, ylist, zlist, 5, FILLED) ; }

          


          fEnv("lineWidth", 0.5) ;
          double xt =1.9 ;
          double yt =1.0 ;
          double zt =1.0 ;
          fLine3d(0,0,zt, 0,0,zm) ;
          fLine3d(0,yt,0, 0,ym,0) ;
          fLine3d(xt,0,0, xm,0,0) ;
          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine3d(0,0,0,  xt,0,0) ;
//              fLine3d(0,0,0,  0,yt,0) ;
              fLine3d(0,0,0,  0,0,zt) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;
          fTeXlabel3d(0,0,zm+0.05, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.05,0, "cl", "$y$") ;
          fTeXlabel3d(xm+0.1,0,0, "tc", "$x$") ;


          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
               fEnv("lineWidth", 1.5) ;
               double XM =3.0 ;
               double ZM =3.0 ;
               fCurve(new parabolaX(proj,0), -1,1,OPEN)  ;
//               fCurve(new parabolaX(proj,XM), -1,1,OPEN)  ;
               fLine3d(0,1,0,  1,1,0) ;
               fLine3d(0,-1,0, 3,-1,0) ;

//               fTeXlabel3d(1,-0.32,1.2, "br", "$z=1-y^2$") ;
//               fLine3d(0,2,0,  0,-1,3) ;
//               fLine3d(3,-1,0, 0,-1,3) ;
               fLine3d(3,-1,0, 1,1,0) ;

               fCurve(new interSect(proj), -1,1,OPEN)  ;

          canvas.append( new fPsWrite("[2 2] 1.0 setdash\n")) ;
              fLine3d(0,-1,0,  0,1,0) ;
          canvas.append( new fPsWrite("[  ] 0 setdash\n")) ;


               fEnv("psFillGray", 0.0) ;
               canvas.append( new fPsWrite(Black+"\n")) ;
               fEnv("lineWidth", 0.5) ;
               fDisk3d(0, 1, 0, rr, rr*aspect) ;
               fTeXlabel3d(0, 1, 0.1, "bl", "$\\scriptstyle (0, 1, 0)$") ;
               fDisk3d(0, -1, 0, rr, rr*aspect) ;
               fTeXlabel3d(0, -1, 0.1, "br", "$\\scriptstyle (0, -1, 0)$") ;
               fDisk3d(0, Y, Z1, rr, rr*aspect) ;
               fTeXlabel3d(0, Y+0.05, Z1+0.1, "bl", 
                            "$\\scriptstyle (0\\,,\\, y\\,,\\, 1-y^2)$") ;
               fDisk3d(1, 1, 0, rr, rr*aspect) ;
               fTeXlabel3d(1, 1.1, 0, "cl", "$\\scriptstyle (1, 1, 0)$") ;
               fDisk3d(X2, Y, 0, rr, rr*aspect) ;
               fTeXlabel3d(X2, Y-0.2, -0.2, "tl", 
                           "$\\scriptstyle (2-y\\,,\\, y\\,,\\, 0)$") ;
               fDisk3d(3, -1, 0, rr, rr*aspect) ;
               fTeXlabel3d(3, -1, -0.1, "tr", "$\\scriptstyle (3, -1, 0)$") ;
               fDisk3d(X1, Y, Z1, rr, rr*aspect) ;
               fArrow3d(0, Y-0.1, 1.5,  X1,Y,Z1+0.1) ;
               fTeXlabel3d(0, Y+0.6, 1.65, "cb", 
                           "$\\scriptstyle (1+y^2-y\\,,\\, y\\,,\\, 1-y^2)$") ;








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

class interSect implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double r = 10 ;

   public interSect(double[][] proj) {
        this.proj = proj ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          double y = t ;
          double z = 1-t*t ;
          double x = 2-y-z ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}





class parabolaX implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double X = 0 ;

   public parabolaX(double[][] proj, double X) {
        this.proj = proj ;
        this.X = X ;
   }


   public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = X ;
          double y = t ;
          double z = 1-t*t ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}



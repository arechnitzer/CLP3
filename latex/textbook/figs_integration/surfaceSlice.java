                  /*  File:  surfaceSlice.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class surfaceSlice extends Template {

     static {templateClass = new surfaceSlice() ; }



//// Oblique projection with direction of view (1,-Xy, -Xz). The point 
//// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
//// chosen so that x+a=0. 
//     static double al = 40 ;
//     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
//                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
//     static double[] view = {1, -proj[0][0], -proj[1][0]} ;

//  General orthogonal projection.  
     static double[] fwd = {1, 0.2, 0.1} ; 
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
          filePrefix = "surfaceSlice" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0*1.5 ;    
          ysize = 2.0*1.5 ;  

          double Xmin= -1 ;
          double Xmax= 5 ;
          double Ymin= -9 ;
          double Ymax= 10 ;
          double Zmin= -4 ;
          double Zmax= 5 ;
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
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0.0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {

          double r = 20 ;
          double R = 70 ;
          double rr = 0.2 ;
          double Cx = 0.005 ;
          double Cy = 0.1 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;


          fEnv("lineWidth", 0.5) ;
          fCurve(new saddleY(proj,  Cx, Cy, 7), -2,6, OPEN)  ;
          fCurve(new saddleY(proj,  Cx, Cy, -15), -2,6, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 6), -15,7, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, -2), -15,7, OPEN)  ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          double x = -1 ;
          double y = 2 ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new saddleX(proj,  Cx, Cy, 0), -14,4, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 1), -14,4, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 2), -14,4, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 2.8), -14,4, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 3.6), -14,4, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 4.3), -14,4, OPEN)  ;
          fCurve(new saddleX(proj,  Cx, Cy, 5), -14,4, OPEN)  ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fCurve(new saddleY(proj,  Cx, Cy, -14), 0,5, OPEN)  ;
          fCurve(new saddleY(proj,  Cx, Cy, -11), 0,5, OPEN)  ;
          fCurve(new saddleY(proj,  Cx, Cy, -8), 0,5, OPEN)  ;
          fCurve(new saddleY(proj,  Cx, Cy, -4), 0,5, OPEN)  ;
          fCurve(new saddleY(proj,  Cx, Cy, 0), 0,5, OPEN)  ;
          fCurve(new saddleY(proj,  Cx, Cy, 4), 0,5, OPEN)  ;


     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*proj[0][0]+yl*proj[0][1]+zl*proj[0][2] ;
          double Y1 = xl*proj[1][0]+yl*proj[1][1]+zl*proj[1][2] ;
          double X2 = xr*proj[0][0]+yr*proj[0][1]+zr*proj[0][2] ;
          double Y2 = xr*proj[1][0]+yr*proj[1][1]+zr*proj[1][2] ;
          fLine(X1,Y1,X2,Y2) ;
     }

     public void fDisk3d(double x, double y, double z,
                         double r1, double r2, long TYPE) {
          double X = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          double Y = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          fDisk(X,Y,r1,r2,TYPE) ;
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
        this.xa = r ;
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}


class saddleX implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double Cx = 1.0 ;
     double Cy = 1.0 ;
     double X = 100.0 ;
     double Y = 0.0 ;

   public saddleX(double[][] proj, 
                 double Cx, double Cy, double Y) {
        this.proj = proj ;
        this.Cx = Cx ;
        this.Cy = Cy ;
        this.Y = Y ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = t ;
          double y = Y ;
          double z = Cx*x*x - Cy*y*y ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}

class saddleY implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double Cx = 1.0 ;
     double Cy = 1.0 ;
     double X = 100.0 ;
     double Y = 0.0 ;

   public saddleY(double[][] proj, 
                 double Cx, double Cy, double X) {
        this.proj = proj ;
        this.Cx = Cx ;
        this.Cy = Cy ;
        this.X = X ;
   }


     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = X ;
          double y = t ;
          double z = Cx*x*x - Cy*y*y ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}




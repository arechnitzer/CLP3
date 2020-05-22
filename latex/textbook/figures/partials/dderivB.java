                  /*  File:  dderivB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dderivB extends Template {

     static {templateClass = new dderivB() ; }
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
          filePrefix = "dderivB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 2.5 ;  

          double Xmin= -3.0 ;
          double Xmax= 3.0 ;
          double Ymin= -2.5 ;
          double Ymax= 2.5 ;
          double Zmin= -0.5 ;
          double Zmax= 5.5 ;
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
          bottommargin = 0.2 ;   // in inches
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
          double z0 = 4 ;
          double a = Math.sqrt(5-z0) ;
          double b = Math.sqrt( (5-z0)/2.0 ) ;
          double xm = 4 ;
          double ym = 2.8 ;
          double zm = 5.5 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;

          fEnv("lineWidth", 0.5) ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new circ3d(proj,   0,0,z0, a,0,0, 0,b,0) , 0,90,OPEN)  ;
          fTeXlabel3d(0, Math.sqrt( (5-z0)/2.0 ) +0.1 ,z0+0.05, "cl", "$z=4$") ;
          z0 = 4.75 ;
          fTeXlabel3d(0, Math.sqrt( (5-z0)/2.0 ) +0.1 ,z0+0.05, "cl", "$z=f(x,y)$") ;


          z0 = 3 ; a = Math.sqrt(5-z0) ; b = Math.sqrt( (5-z0)/2.0 ) ;
          fCurve(new circ3d(proj,   0,0,z0, a,0,0, 0,b,0) ,  0,90,OPEN)  ;
          fTeXlabel3d(0, Math.sqrt( (5-z0)/2.0 ) +0.1 ,z0+0.05, "cl", "$z=3$") ;

          z0 = 2 ; a = Math.sqrt(5-z0) ; b = Math.sqrt( (5-z0)/2.0 ) ;
          fCurve(new circ3d(proj,   0,0,z0, a,0,0, 0,b,0) ,  0,90,OPEN)  ;
          fTeXlabel3d(0, Math.sqrt( (5-z0)/2.0 ) +0.1 ,z0+0.05, "cl", "$z=2$") ;

          z0 = 1 ; a = Math.sqrt(5-z0) ; b = Math.sqrt( (5-z0)/2.0 ) ;
          fCurve(new circ3d(proj,   0,0,z0, a,0,0, 0,b,0) ,  0,90,OPEN)  ;
          fTeXlabel3d(0, Math.sqrt( (5-z0)/2.0 ) +0.1 ,z0+0.05, "cl", "$z=1$") ;

          z0 = 0 ; a = Math.sqrt(5-z0) ; b = Math.sqrt( (5-z0)/2.0 ) ;
          fCurve(new circ3d(proj,   0,0,z0, a,0,0, 0,b,0) ,  0,90,OPEN)  ;
          fTeXlabel3d(0, Math.sqrt( (5-z0)/2.0 ) +0.05 ,z0+0.1, "bl", "$z=0$") ;


          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new para3d(proj, 0, 0, 5,    1, 0, 0,   0, 0, -1),
                     0, Math.sqrt(5.0),OPEN)  ;

          fCurve(new para3d(proj, 0, 0, 5,    0, 1, 0,   0, 0, -2),
                     0, Math.sqrt(2.5),OPEN)  ;
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


class para3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double X0 = 0 ; // coeff of t^0
     double Y0 = 0 ;
     double Z0 = 0 ;
     double X1 = 1 ; // coeff of t^1
     double Y1 = 0 ;
     double Z1 = 0 ;
     double X2 = 1 ; // coeff of t^2
     double Y2 = 0 ;
     double Z2 = 0 ;

   public para3d(double[][] proj,
                 double X0, double Y0, double Z0,
                 double X1, double Y1, double Z1,
                 double X2, double Y2, double Z2) {
        this.proj = proj ;
        this.X0 =X0 ;
        this.Y0 =Y0 ;
        this.Z0 =Z0 ;
        this.X1 =X1 ;
        this.Y1 =Y1 ;
        this.Z1 =Z1 ;
        this.X2 =X2 ;
        this.Y2 =Y2 ;
        this.Z2 =Z2 ;
   }



     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = X0 + t*X1 + t*t*X2 ;
          double y = Y0 + t*Y1 + t*t*Y2 ;
          double z = Z0 + t*Z1 + t*t*Z2 ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
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




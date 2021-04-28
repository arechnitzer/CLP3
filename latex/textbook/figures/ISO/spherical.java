                  /*  File:  spherical.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class spherical extends Template {

     static {templateClass = new spherical() ; }



// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 40 ;
     static double[][] proj = { {Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;




     public void setup() {
          filePrefix = "spherical" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.5 ;    
          ysize = 3.5 ;  

          double Xmin= -10 ;
          double Xmax= 90 ;
          double Ymin= -10 ;
          double Ymax= 90 ;
          double Zmin= -10 ;
          double Zmax= 100 ;
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
          double a = 65 ;
//          double xm = 70 ;
//          double ym = 70 ;
//          double zm = 70 ;
          double aspect = (ymax-ymin)/(xmax-xmin) ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;


          double phi, th, psi, rx, ry, rz, rrx, rry, rrz, rho ;
          phi = 0.23*Math.PI ;
          th = 0.37*Math.PI ;
          psi = 0.25*Math.PI ;
          double r = 1.5 ;
          rx = 50 ;
          ry = 35 ;
          rz = 50 ;
          rrx = 50*0.7 ;
          rry = 80*0.7 ;
          rrz = 100*0.7 ;
          rho = 80 ;
          double[] P =  {  
                rho*Math.sin(phi)*Math.cos(th) ,
                rho*Math.sin(phi)*Math.sin(th) ,
                rho*Math.cos(phi) } ;
          double[] Z =  {  
                0 ,
                0 ,
                rho*Math.cos(phi) } ;
          double[] XY =  {  
                rho*Math.sin(phi)*Math.cos(th) ,
                rho*Math.sin(phi)*Math.sin(th) ,
                0 } ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,rrz) ;
          fLine3d(0,0,0, 0,rry,0) ;
          fLine3d(0,0,0, rrx,0,0) ;
          fTeXlabel3d(0,0,rrz+2, "cb", "$z$") ;
          fTeXlabel3d(0,rry+3,0, "cl", "$y$") ;
          fTeXlabel3d(rrx,-1,-1, "tr", "$x$") ;

          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fDisk3d(0, 0, P[2], r, r, FILLED) ;
          fTeXlabel3d(0, -2.0, P[2], "cr", "$(0,0,z)$") ;
          fDisk3d(P[0], P[1], 0, r, r, FILLED) ;
          fTeXlabel3d(P[0], P[1]+2.0, 0, "cl", "$(x,y,0)$") ;
          fDisk3d(P[0], 0, 0, r, r, FILLED) ;
          fTeXlabel3d(P[0], -2.0, 0, "br", "$(x,0,0)$") ;
          fLine3d(P[0], P[1], P[2], P[0], P[1], 0) ;
          fLine3d(P[0],0,0, P[0],P[1], 0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(0,0,0, P[0],P[1], 0) ;
          fLine3d(P[0], P[1], P[2], 0, 0, P[2]) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          double R = 12 ;
          fCurve(new circ3d(proj,0,0,0, 0.8*0.8*R,0,0,  0,0.8*1.1*R,0), 
                                       0, 0.9*th*180/Math.PI, OPEN)  ;
          fCurve(new circ3d(proj,0,0,0, 0,0,1.2*R,   
                   1.2*R*Math.cos(th),1.2*R*Math.sin(th),0), 
                                       0, phi*180/Math.PI, OPEN)  ;
          fTeXlabel3d(1.05*0.56*P[0], 1.05*0.16*P[1], 0, "cl", "$\\phi$") ;
          fTeXlabel3d(0.8*0.56*P[0], 0.8*0.28*P[1], 0.8*0.43*P[2], "bl", "$\\theta$") ;



          canvas.append( new fPsWrite(Orange+"\n")) ;
          fEnv("psFillColor", Orange) ;
          fEnv("lineWidth", 1.0) ;
          fDisk3d(P[0], P[1], P[2], r, r, FILLED) ;
          fTeXlabel3d(P[0], P[1]+2, P[2], "cl", "$(x,y,z)$") ;
          fTeXlabel3d(P[0]/2, P[1]/2+2, P[2]/2-2, "cl", "$r$") ;
          fTeXlabel3d(0.4*P[0], 0.4*P[1], P[2]+2, "bl", "$r\\sin\\theta$") ;
          fTeXlabel3d(0, -1, P[2]/2, "cr", "$r\\cos\\theta$") ;
          fTeXlabel3d(P[0], 0.45*P[1], -2, "ct", "$r\\sin\\theta\\sin\\phi$") ;
          fLine3d(0,0,0, P[0], P[1], P[2])  ;
          
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
          
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;

          return out ;
   }
}




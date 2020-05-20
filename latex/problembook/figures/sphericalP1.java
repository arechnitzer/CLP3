                  /*  File:  sphericalP1.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sphericalP1 extends Template {

     static {templateClass = new sphericalP1() ; }



// Oblique projection with direction of view (1,-Xy, -Xz). The point 
// (x,y,z) is projected to (0, yp, zp) = (x,y,z) + a (1,-Xy, -Xz) with a 
// chosen so that x+a=0. 
     static double al = 60 ;
     static double[][] proj = { {0.5*Math.cos(Math.PI*(1+al/180)), 1, 0},
                                {0.5*Math.sin(Math.PI*(1+al/180)), 0, 1}   } ;
     static double[] view = {1, -proj[0][0], -proj[1][0]} ;




     public void setup() {
          filePrefix = "sphericalP1" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  

          double Xmin= -10 ;
          double Xmax= 100 ;
          double Ymin= -10 ;
          double Ymax= 100 ;
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
//          double xm = 70 ;
//          double ym = 70 ;
//          double zm = 70 ;
          double aspect = (ymax-ymin)/(xmax-xmin) ;

          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;


          double phi, th, rx, ry, rz, rrx, rry, rrz, rho ;
          phi = 0.1666*Math.PI ;
          th = 0.33*Math.PI ;
          double r = 1.4 ;
          rrx = 100 ;
          rry = 100 ;
          rrz = 100 ;
          rho = 80 ;
          double[] P =  {  
                rho*Math.sin(phi)*Math.cos(th) ,
                rho*Math.sin(phi)*Math.sin(th) ,
                rho*Math.cos(phi) } ;
          double[] Z =  {  
                0 ,
                0 ,
                rho } ;
          double[] XY =  {  
                rho*Math.cos(th) ,
                rho*Math.sin(th) ,
                0 } ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,rrz) ;
          fLine3d(0,0,0, 0,rry,0) ;
          fLine3d(0,0,0, rrx,0,0) ;
          fTeXlabel3d(0,0,rrz+2, "cb", "$z$") ;
          fTeXlabel3d(0,rry+2,0, "cl", "$y$") ;
          fTeXlabel3d(rrx,-1,-1, "tr", "$x$") ;

          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fLine3d(0,0,0, XY[0],XY[1], 0) ;
          fLine3d(0,0,0, P[0], P[1], P[2])  ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          double R = 12 ;
          fCurve(new circ3d(proj,0,0,0, 0.8*R,0,0,  0,1.1*R,0), 
                                       0, 0.9*th*180/Math.PI, OPEN)  ;
          fCurve(new circ3d(proj,0,0,0, 0,0,1.2*R,   
                   1.2*R*Math.cos(th),1.2*R*Math.sin(th),0), 
                                       0, phi*180/Math.PI, OPEN)  ;

          fCurve(new circ3d(proj,0,0,0, 0,0,rho,  XY[0],XY[1],0), 0, 90, OPEN)  ;
          fCurve(new circ3d(proj,0,0,0, 0,0,rho,  rho,0,0), 0, 90, OPEN)  ;
          fCurve(new circ3d(proj,0,0,0, 0,0,rho,  0,rho,0), 0, 90, OPEN)  ;
          fCurve(new circ3d(proj,0,0,0, rho,0,0,  0,rho,0), 0, 90, OPEN)  ;
          fTeXlabel3d(13, 6, 0, "tc", "$\\frac{\\pi}{3}$") ;
          fTeXlabel3d(5, 5, 17, "bc", "$\\frac{\\pi}{6}$") ;

          fEnv("psFillColor", Blue) ;
          fEnv("lineWidth", 0.5) ;
          fDisk3d(0,0, 0, r, r*aspect, FILLED) ;
          fDisk3d(P[0], P[1], P[2], r, r*aspect, FILLED) ;
          fDisk3d(0, 0, rho, r, r*aspect, FILLED) ;
          fDisk3d(XY[0], XY[1], 0, r, r*aspect, FILLED) ;
          fDisk3d(rho, 0, 0, r, r*aspect, FILLED) ;
          fDisk3d(0, rho, 0, r, r*aspect, FILLED) ;

          fEnv("useColorPs", "false") ;
          fArrow3d(XY[0], XY[1], -20,  XY[0], XY[1], -1) ;
          fTeXlabel3d(XY[0], XY[1], -21, "tc", 
           "$\\scriptstyle \\rho=1,\\ \\theta=\\frac{\\pi}{3},\\ \\varphi=\\frac{\\pi}{2}$") ;
 
          fArrow3d(0, rho, -20,  0, rho, -1) ;
          fTeXlabel3d(0, rho+10, -21, "tc", 
           "$\\scriptstyle \\rho=1,\\ \\theta=\\frac{\\pi}{2},\\ \\varphi=\\frac{\\pi}{2}$") ; 

          fArrow3d(rho, -15, 0,  rho, -1, 0) ;
          fTeXlabel3d(rho, -16, 0, "rc", 
           "$\\scriptstyle \\rho=1,\\ \\theta=0,\\ \\varphi=\\frac{\\pi}{2}$") ; 

          fArrow3d(0, -30, 0,  0, -1, 0) ;
          fTeXlabel3d(0, -31, 0, "rc", 
           "$\\scriptstyle \\rho=0,\\ \\theta=0.1\\pi,\\ \\varphi=0.7\\pi$") ; 

          fArrow3d(0, -20, rho,  0, -1, rho) ;
          fTeXlabel3d(0, -21, rho, "rc", 
           "$\\scriptstyle \\rho=1,\\ \\theta=0.3\\pi,\\ \\varphi=0$") ; 

          fArrow3d(P[0], P[1]+30, P[2],  P[0], P[1]+1, P[2]) ;
          fTeXlabel3d(P[0], P[1]+31, P[2], "lc", 
           "$\\scriptstyle \\rho=1,\\ \\theta=\\frac{\\pi}{3},\\ \\varphi=\\frac{\\pi}{6}$") ;
 
          fTeXlabel3d(0.5*P[0], 0.5*P[1], 0.5*P[2]+1, "br", "$1$") ; 
          fTeXlabel3d(0.5*XY[0], 0.5*XY[1], -1, "tr", "$1$") ; 
          fTeXlabel3d(0, -1, 0.5*rho, "cr", "$1$") ; 
          fTeXlabel3d(0.5*rho,-1,1, "cr", "$1$") ; 
          fTeXlabel3d(0, 0.5*rho, 1, "cb", "$1$") ; 




          
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




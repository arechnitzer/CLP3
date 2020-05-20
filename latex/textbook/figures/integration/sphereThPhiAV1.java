                  /*  File:  sphereThPhiA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sphereThPhiA extends Template {

     static {templateClass = new sphereThPhiA() ; }
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


     public void setup() {
          filePrefix = "sphereThPhiA" ;  
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
          rightmargin = 0.0 ;   // in inches
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
          double thDeg = 50 ;
          double th = thDeg*Math.PI/180 ;
          double phiDeg = 45 ;
          double phi = phiDeg*Math.PI/180 ;
          double R = 100 ;
          double x = 0.8*R*Math.cos(th) ;
          double y = 0.8*R*Math.sin(th) ;
          double z = R*Math.cos(phi) ;
          double Rx = R*Math.sin(phi) ;
          double Ry = R*Math.sin(phi) ;
          double xm = 95 ;
          double ym = 70 ;
          double zm = 85 ;
          double r = 20 ;
          double X = R*Math.cos(th)*Math.sin(phi) ;
          double Y = R*Math.sin(th)*Math.sin(phi) ;
          double Z = R*Math.cos(phi) ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,z, 0,0,zm) ;
          fLine3d(0,48,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0.0 setdash\n")) ;
          fLine3d(0,0,0, 0,46,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fLine3d(0,0,z, Rx,0,z) ;


          fTeXlabel3d(0,0,zm+3, "cb", "$z$") ;
          fTeXlabel3d(0,ym+3,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-1,-1, "tr", "$x$") ;
          canvas.append( new fPsWrite("0.0 setgray\n")) ;
          fCurve(new circ3d(proj,   0,0,0, r,0,0, 0,r,0),  0,thDeg,OPEN)  ;
          fCurve(new circ3d(proj,   0,0,0, 0,0,r, r*Math.cos(th),r*Math.sin(th),0),  
                                                                      0,phiDeg,OPEN)  ;


          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0.0 setdash\n")) ;
          fLine3d(0,0,0, 0,0,45) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine3d(0,0,40, 0,0,z) ;
          fLine3d(0,0,0, x,y,0) ;
          fLine3d(x,y,0, x,y,z) ;
          fLine3d(0,0,z, x,y,z) ;

          fTeXlabel3d(25, 9 ,0,  "tc", "$\\scriptstyle\\theta$") ;          
          fTeXlabel3d(0,  9 ,25,  "tc", "$\\scriptstyle\\varphi$") ;          

          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(proj,   0,0,z, Rx,0,0, 0,Ry,0),  0,thDeg,OPEN)  ;
          fLine3d(0,0,0, Rx,0,z) ;
//          fLine3d(0,0.4*Ry,0.4*z, 0,Ry,z) ;
          canvas.append( new fPsWrite("[2.5 2.5] 0.0 setdash\n")) ;
//          fLine3d(0,0,0, 0,0.4*Ry,0.4*z) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.5) ;
          fLine3d(0,0,0, X,Y,Z) ;
          
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




                  /*  File:  hyperbolic_paraboloid.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperbolic_paraboloid extends Template {

     static {templateClass = new hyperbolic_paraboloid() ; }


//  General orthogonal projection.  
     static double[] fwd = {1, -0.1, 0.07} ; 
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
          filePrefix = "hyperbolic_paraboloid" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.7 ;    
          ysize = 3.0 ;  

          double Xmin= -1.5 ;
          double Xmax= 1.5 ;
          double Ymin= -1.5 ;
          double Ymax= 1.5 ;
          double Zmin= -1.5 ;
          double Zmax= 1.5 ;
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
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double a = 1.0 ;
          double b = 1.0 ;
          double c = 0.3 ;
          double x = 0 ;
          double y = 0 ;
          double z = 0 ;


          fEnv("lineWidth", 1.0) ;
//          fEnv("useColorPs", "true") ;
//          String Red = "0 1 1 0 setcmykcolor  " ;
//          String Black = "0 0 0 1 setcmykcolor  " ;
//          String Blue = "1 1 0 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new paraY3d(proj,   a,b,c,1),   0,1.5,OPEN)  ;
          fCurve(new paraY3d(proj,   a,b,c,-1), -1.5,1.5,OPEN)  ;
          fCurve(new paraX3d(proj,   a,b,c,0),  -1,1,OPEN)  ;
          x = 1.5 ;
          y = -1 ;
          z = c*(y*y/(b*b)-x*x/(a*a)) ;
          fCurve(new hyperZ3d(proj,   a,b,c,z),  -1,1,OPEN)  ;
          fCurve(new hyperZ3d(proj,   -a,b,c,z),  -1,-0.75,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new paraY3d(proj,   a,b,c,1),  -1.5,0,OPEN)  ;
          fCurve(new hyperZ3d(proj,   -a,b,c,z),  -0.75,1,OPEN)  ;
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

}


class paraX3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double a = 1.0 ;
     double b = 1.0 ;
     double c = 1.0 ;
     double x = 0.0 ;
     double y = 0.0 ;
     double z = 0.0 ;

   public paraX3d(double[][] proj, 
                 double a, double b, double c, double x) {
        this.proj = proj ;
        this.a = a ;
        this.b = b ;
        this.c = c ;
        this.x = x ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double y = t ;
          double z = c*(y*y/(b*b)-x*x/(a*a)) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}


class paraY3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double a = 1.0 ;
     double b = 1.0 ;
     double c = 1.0 ;
     double y = 0.0 ;

   public paraY3d(double[][] proj, 
                 double a, double b, double c, double y) {
        this.proj = proj ;
        this.a = a ;
        this.b = b ;
        this.c = c ;
        this.y = y ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double x = t ;
          double z = c*(y*y/(b*b)-x*x/(a*a)) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}


class hyperZ3d implements S2V {

     double[][] proj = { {1, 0, 0},   { 0,  1, 0}   };
     double a = 1.0 ;
     double b = 1.0 ;
     double c = 1.0 ;
     double z = 0.0 ;

   public hyperZ3d(double[][] proj,
                 double a, double b, double c, double z) {
        this.proj = proj ;
        this.a = a ;
        this.b = b ;
        this.c = c ;
        this.z = z ;
   }

     public double[] map(double t) {
          
          double[] out = {0,0} ;
          double y = t ;
          double x = a*Math.sqrt( y*y/(b*b)-z/c ) ;
          out[0] = x*proj[0][0]+y*proj[0][1]+z*proj[0][2] ;
          out[1] = x*proj[1][0]+y*proj[1][1]+z*proj[1][2] ;
          return out ;
   }
}






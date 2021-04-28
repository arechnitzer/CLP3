                  /*  File:  cyl3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cyl3 extends Template {

     static {templateClass = new cyl3() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "cyl3" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -50 ;
          xmax =  100 ;
          ymin = -70 ;
          ymax =  80 ;
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
          double al = 65 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r = 40 ;
          double z = 50 ;
          double xm = 80 ;
          double ym = 60 ;
          double zm = 80 ;



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0,  xm, 0,0) ;
//          fLine3d(0,r,0, 0,ym,0) ;
//          fLine(0,r*x1+z, 0,zm) ;
//          fLine3d(r,0,0,  xm, 0,0) ;
//          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
//          fLine3d(0,0,0, 0,r,0) ;
//          fLine(0,0, 0,r*x1+z) ;
//          fLine3d(0,0,0,  r, 0,0) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(ym+4,0, "lc", "$y$") ;
          fTeXlabel(0,zm+4, "bc", "$z$") ;
          fTeXlabel(xm*x0-1, xm*x1-1, "tr", "$x$") ;

          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,0, r),-90,90,OPEN)  ;
          fCurve(new circ3d(al, a, 0.5,   0,0,z, r),0,360,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,0, r),90,270,OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fLine(r,0, r, z) ;
          fLine(-r,0, -r, z) ;
          fTeXlabel(r/2,3, "bc", "$\\rho$") ;
          

          fTeXlabel(20,-50, "tc", "surface of constant $\\rho$") ;
          fTeXlabel(20,-68, "tc", "(a cylindrical shell)") ;
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }

}


class circ3d implements S2V {

     double al = 45 ;
     double a = 65 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double r = 50.0 ;

   public circ3d(double al, double a, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
        this.a = a ;
        this.cx = cx ;
        this.cy = cy ;
        this.cz = cz ;
        this.r  = r ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+r*Math.cos(t*Math.PI/180) ;
          double y = cy+r*Math.sin(t*Math.PI/180) ;
          double z = cz ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




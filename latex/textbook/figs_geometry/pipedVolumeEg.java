                  /*  File:  pipedVolumeEg.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class pipedVolumeEg extends Template {

     static {templateClass = new pipedVolumeEg() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "pipedVolumeEg" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.5 ;    
          ysize = 3.0 ;  
          xmin = -100 ;
          xmax =  250 ;
          ymin = -100 ;
          ymax =  200 ;
          topmargin = -0.6 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 40 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;


          fEnv("lineWidth", 0.5) ;
          double Xmax = 140 ; double Ymax = 200  ; double Zmax = 180 ;
          canvas.append( new fPsWrite("0.7 setgray\n")) ;
          fLine3d(0,0,0, Xmax,0,0) ;
          fLine3d(0,0,0, 0,Ymax,0) ;
          fLine3d(0,0,0, 0,0,Zmax) ;
          fTeXlabel3d(Xmax+2,0,0, "tr", "$x$") ;          
          fTeXlabel3d(0,Ymax+2,0, "cl", "$y$") ;          
          fTeXlabel3d(0,0,Zmax+3, "bc", "$z$") ;          
          canvas.append( new fPsWrite("0.0 setgray\n")) ;


          double a1 =   0 ; double a2 = 80  ; double a3 = 160 ;
          double b1 = 80 ; double b2 = 80 ; double b3 =  0 ;
          double c1 =  0 ; double c2 = 80  ; double c3 =  0 ;

         fEnv("psFillGray", 0.9) ;
         {double[] xlist = {0,  80, 80,  0} ;
          double[] ylist = {0,  80,160, 80} ;
          double[] zlist = {0,   0,  0, 0} ;
          fPolygon3d(xlist,ylist, zlist, 4, FILLED) ;}


          fEnv("lineWidth", 0.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine3d(a1,a2,a3, a1+b1,a2+b2,a3+b3) ;
          fLine3d(a1,a2,a3, a1+c1,a2+c2,a3+c3) ;
          fLine3d(b1,b2,b3, a1+b1,a2+b2,a3+b3) ;
          fLine3d(b1,b2,b3, b1+c1,b2+c2,b3+c3) ;
          fLine3d(c1,c2,c3, c1+b1,c2+b2,c3+b3) ;
          fLine3d(c1,c2,c3, a1+c1,a2+c2,a3+c3) ;
          fLine3d(a1+b1,a2+b2,a3+b3, a1+b1+c1,a2+b2+c2,a3+b3+c3) ;
          fLine3d(a1+c1,a2+c2,a3+c3, a1+b1+c1,a2+b2+c2,a3+b3+c3) ;
          fLine3d(b1+c1,b2+c2,b3+c3, a1+b1+c1,a2+b2+c2,a3+b3+c3) ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fEnv("headLength", 6*1.5) ;
          fEnv("headHalfWidth", 2*1.5) ;
          fArrow3d(0,0,0, a1,a2,a3) ;
          fArrow3d(0,0,0, b1,b2,b3) ;
          fArrow3d(0,0,0, c1,c2,c3) ;
          fArrow3d(0,0,0, 0,  0, 80) ;


          fTeXlabel3d(a1,0.5*a2+3,0.5*a3, "tl", "$\\va$") ;          
          fTeXlabel3d(0.5*b1,0.5*b2,b3, "tr", "$\\vb$") ;          
          fTeXlabel3d(c1,0.5*c2,c3+3, "bc", "$\\vc$") ;          
          fTeXlabel3d(0,-5,40, "tr", "$\\vb\\times\\vc$") ;          
     }

     public void fLine3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fLine(X1,Y1,X2,Y2) ;
     }


     public void fArrow3d(double xl, double yl, double zl,
                         double xr, double yr, double zr) {
          double X1 = xl*x0+yl;
          double Y1 = xl*x1+zl;
          double X2 = xr*x0+yr;
          double Y2 = xr*x1+zr;
          fArrow(X1,Y1,X2,Y2) ;
     }


     public void fTeXlabel3d(double xl, double yl, double zl,
                         String biase, String label) {
          double X = xl*x0+yl;
          double Y = xl*x1+zl;
          fTeXlabel(X, Y, biase, label) ;
     }

     public void fPolygon3d(double[] xlist, double[] ylist, double[] zlist,
                                  int nopoints, long type) {
          double[] xx = new double[nopoints] ;
          double[] yy = new double[nopoints] ;
          for (int i = 0 ; i < nopoints ; i++) {
               xx[i] = xlist[i]*x0+ylist[i] ;
               yy[i] = xlist[i]*x1+zlist[i] ;
          }
          fPolygon(xx,yy,nopoints,type) ;
     }


}




class circ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 100.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 100.0 ;
     double zb = 0.0 ;

   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, double r) {
        this.al = al ;
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


   public circ3d(double al, double projFactor, 
                 double cx, double cy, double cz, 
                 double xa, double ya, double za, 
                 double xb, double yb, double zb) {
        this.al = al ;
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
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = cx+xa*Math.cos(t*Math.PI/180)+xb*Math.sin(t*Math.PI/180) ;
          double y = cy+ya*Math.cos(t*Math.PI/180)+yb*Math.sin(t*Math.PI/180) ;
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




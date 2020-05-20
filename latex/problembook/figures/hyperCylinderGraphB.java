                  /*  File:  hyperCylinderGraphB.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperCylinderGraphB extends Template {

     static {templateClass = new hyperCylinderGraphB() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "hyperCylinderGraphB" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0 ;  
          xmin = -1.2 ;
          xmax =  4.8 ;
          ymin = -2.5 ;
          ymax =  3.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = -0.2 ;   // in inches
          rightmargin = 0 ;   // in inches
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
          double z0 = 0 ; 

          double xm = 5 ;
          double ym = 3 ;
          double zm = 3 ;
          double xM = 2.7 ;
          double yM = 2.9 ;
          double zM = 2.7 ;



          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,zM, 0,0,zm) ;
          fLine3d(0,yM,0, 0,ym,0) ;
          fLine3d(xM,0,0, xm,0,0) ;
          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
          fLine3d(0,0,0, 0,0,zM) ;
          fLine3d(0,0,0, 0,yM,0) ;
          fLine3d(0,0,0, xM,0,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel3d(0,0,zm+0.08, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.08,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;



          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;
          canvas.append( new fPsWrite(Orange+"\n")) ;
          fEnv("lineWidth", 1.0) ;

          fCurve(new hyperbola3d(al, 0.5,   0,0,0, 0,0.75,0, 0,0,0.75),
                 1/4.0 , 4.0 ,OPEN) ;

          fCurve(new hyperbola3d(al, 0.5,   5,0,0, 0,0.75,0, 0,0,0.75),
                 1/4.0 , 4.0 ,OPEN) ;

          fLine3d(0, 3/16.0,   3.0,   5, 3/16.0, 3.0) ;
          fLine3d(0,   3.0, 3/16.0,   5,   3.0, 3/16.0) ;

          fEnv("lineWidth", 0.5) ;
//          canvas.append( new fPsWrite(Black+"\n")) ;
          canvas.append( new fPsWrite("0.6 setgray\n")) ;
          double C=2.4 ;
//          fLine3d(xm,0,C, 0,0,C) ;
          fLine3d(0,ym,C, 0,0,C) ;
          fTeXlabel3d(0,ym,C+0.05, "br", "$z=3$") ;
          C=1.6 ;
//          fLine3d(xm,0,C, 0,0,C) ;
          fLine3d(0,ym,C, 0,0,C) ;
          fTeXlabel3d(0,ym,C+0.05, "br", "$z=2$") ;
          C=0.8 ;
//          fLine3d(xm,0,C, 0,0,C) ;
          fLine3d(0,ym,C, 0,0,C) ;
          fTeXlabel3d(0,ym,C+0.05, "br", "$z=1$") ;
          C=0.4 ;
//          fLine3d(xm,0,C, 0,0,C) ;
          fLine3d(0,ym,C, 0,0,C) ;
          fTeXlabel3d(0,ym,C+0.05, "br", "$\\scriptstyle z=0.5$") ;
          C=0.2 ;
//          fLine3d(xm,0,C, 0,0,C) ;
          fLine3d(0,ym,C, 0,0,C) ;

          fEnv("lineWidth", 1.0) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          double P = 9.0/16.0 ;
          C=2.4 ; double y = P/C ;
          fLine3d(xm,y,C, 0,y,C) ;
          C=1.6 ;  y = P/C ;
          fLine3d(xm,y,C, 0,y,C) ;
          C=0.8 ;  y = P/C ;
          fLine3d(xm,y,C, 0,y,C) ;
          C=0.4 ;  y = P/C ;
          fLine3d(xm,y,C, 0,y,C) ;
          C=0.2 ;  y = P/C ;
          fLine3d(xm,y,C, 0,y,C) ;


//          canvas.append( new fPsWrite("[3 3] 0 setdash\n")) ;
//          fCurve(new hyperbola3d(al, 0.5,   1.25,0,0, 0,0.75,0, 0,0,0.75),
//                 1/4.0 , 4.0 ,OPEN) ;
//          fCurve(new hyperbola3d(al, 0.5,   2.5,0,0, 0,0.75,0, 0,0,0.75),
//                 1/4.0 , 4.0 ,OPEN) ;
//          fCurve(new hyperbola3d(al, 0.5,   3.75,0,0, 0,0.75,0, 0,0,0.75),
//                 1/4.0 , 4.0 ,OPEN) ;
//          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

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
        this.xa = r ; 
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
          double z = cz+za*Math.cos(t*Math.PI/180)+zb*Math.sin(t*Math.PI/180) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}

//  The next class generates the curve xy=1, with x as the parameter, but with 
//      the x axis vector (1,0) replaced by (xa,ya,za) and
//      the y axis vector (0,1) replaced by (xb,yb,zb) and
//      the origin shifted to (cx,cy,cz)

class hyperbola3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cx = 0.0 ;
     double cy = 0.0 ;
     double cz = 0.0 ;
     double xa = 1.0 ;
     double ya = 0.0 ;
     double za = 0.0 ;
     double xb = 0.0 ;
     double yb = 1.0 ;
     double zb = 0.0 ;


   public hyperbola3d(double al, double projFactor, 
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
          double x = cx+xa*t+xb/t ;
          double y = cy+ya*t+yb/t ;
          double z = cz+za*t+zb/t ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




                  /*  File:  seatA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class seatA extends Template {

     static {templateClass = new seatA() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "seatA" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 3.0 ;    
          ysize = 3.0 ;  
          xmin = -3.0 ;
          xmax =  6.0 ;
          ymin = -3.0 ;
          ymax =  6.0 ;
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
          double al = 40 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double z0 = 0 ; 

          double xm = 5 ;
          double ym = 4.5 ;
          double zm = 4.5 ;


          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, xm,0,0) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fTeXlabel3d(0,0,zm+0.12, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.12,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.05,-0.05, "tr", "$x$") ;



          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;

//          double X = Math.sqrt(2.0) ; double Y=2.0 ;



          fLine3d(0,0,4, xm,0,4) ;
          fLine3d(0,0,4, 0,ym,4) ;
          fCurve(new seatZ(al, 0.5,   4.0 , 4),
                 1/4.0, 4 ,OPEN) ;

         fCurve(new seatX(al, 0.5,   4.0 , 4),
                 1/4.0, 4 ,OPEN) ;

         fCurve(new seatY(al, 0.5,   4.0 , 4),
                 1/4.0, 4 ,OPEN) ;

  


          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
        canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;

//          fLine3d(0,0,0.5, xm,0,0.5) ;
//          fLine3d(0,0,0.5, 0,ym,0.5) ;
          fCurve(new seatZ(al, 0.5,   4.0 , 0.5),
                 2 , 4 ,OPEN) ;

//          fLine3d(0,0,1, xm,0,1) ;
//          fLine3d(0,0,1, 0,ym,1) ;
          fCurve(new seatZ(al, 0.5,   4.0 , 1.4),
                 1/1.4, 4 ,OPEN) ;

//          fLine3d(0,0,2, xm,0,2) ;
//          fLine3d(0,0,2, 0,ym,2) ;
          fCurve(new seatZ(al, 0.5,   4.0 , 2.6),
                 1/2.6, 4 ,OPEN) ;

//          fLine3d(0,0,3, xm,0,3) ;
//          fLine3d(0,0,3, 0,ym,3) ;
//          fCurve(new seatZ(al, 0.5,   4.0 , 3),
//                 1/3.0, 4 ,OPEN) ;

      fCurve(new seatXY(al, 0.5,   4.0 , 1),
                 0, 3 ,OPEN) ;

        double a ;
//        a = Math.tan(Math.PI/12.0) ;
//        fCurve(new seatXY(al, 0.5,   4.0 , a),
//                 0, 3.67,OPEN) ;

//        a = Math.tan(Math.PI/6.0) ;
//        fCurve(new seatXY(al, 0.5,   4.0 , a),
//                 0, 3.495 ,OPEN) ;

        a = Math.tan(Math.PI/8.0) ;
        fCurve(new seatXY(al, 0.5,   4.0 , a),
                 0, 3.6 ,OPEN) ;

        a = Math.tan(3*Math.PI/8.0) ;
        fCurve(new seatXY(al, 0.5,   4.0 , a),
                 0, 1.492,OPEN) ;

//        a = Math.tan(Math.PI/3.0) ;
//        fCurve(new seatXY(al, 0.5,   4.0 , a),
//                 0, 2.02, OPEN) ;

//        a = Math.tan(5*Math.PI/12.0) ;
//        fCurve(new seatXY(al, 0.5,   4.0 , a),
//                 0, 0.983, OPEN) ;

        canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

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



//  The next class parametrizes  xyz=A, with x as the parameter, and with 
//    z fixed.  

class seatZ implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double A = 4.0 ;
     double Z = 1   ;


   public seatZ(double al, double projFactor, 
                 double A, double Z) {
        this.al = al ;
        this.A = A ;
        this.Z = Z ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double y = A/(t*Z) ;
          double z = Z;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}


//  The next class parametrizes  xyz=A, with x as the parameter, and with 
//    Y fixed.  

class seatY implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double A = 4.0 ;
     double Y = 1   ;


   public seatY(double al, double projFactor, 
                 double A, double Y) {
        this.al = al ;
        this.A = A ;
        this.Y = Y;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double z = A/(t*Y) ;
          double y = Y;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}

//  The next class parametrizes  xyz=A, with y as the parameter, and with 
//    x fixed.  

class seatX implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double A = 4.0 ;
     double X = 1   ;


   public seatX(double al, double projFactor, 
                 double A, double X) {
        this.al = al ;
        this.A = A ;
        this.X = X ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = X ;
          double z = A/(t*X) ;
          double y = t;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}


//  The next class parametrizes  xyz=A, with x=A-t, y=A-at

class seatXY implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double A = 4.0 ;
     double a = 1   ;


   public seatXY(double al, double projFactor, 
                 double A, double a) {
        this.al = al ;
        this.A = A ;
        this.a = a ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = A-t ;
          double y = A-a*t;
          double z = A/(x*y) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}





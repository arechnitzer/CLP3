                  /*  File:  parabolic_cylinder.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class parabolic_cylinder extends Template {

     static {templateClass = new parabolic_cylinder() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;


     public void setup() {
          filePrefix = "parabolic_cylinder" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0*2.14 ;    
          ysize = 1.0*2.14 ;  
          xmin = -10 ;
          xmax =  10 ;
          ymin = -20 ;
          ymax =  20 ;
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
          double al = 50 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 0.15 ;
          double b = 0 ;
          double z = 0 ;
          double xm = -6 ;
          double xM = 7.5 ;
          double xt = -5.5 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 1.0) ;
//          fEnv("useColorPs", "true") ;
//          String Red = "0 1 1 0 setcmykcolor  " ;
//          String Black = "0 0 0 1 setcmykcolor  " ;
//          String Blue = "1 1 0 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new paraZ3d(al, 0.5,   a,b,0),xm,xt,OPEN)  ;
          fCurve(new paraZ3d(al, 0.5,   a,b,0),1,xM,OPEN)  ;
          fCurve(new paraZ3d(al, 0.5,   a,b,10),xm,xM,OPEN)  ;
          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new paraZ3d(al, 0.5,   a,b,0),xt,1,OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          double x = xM ; double y = a*x*x+b ;
          fLine3d(x,y,0, x,y,10) ;
          x = xm ; y = a*x*x+b ;
          fLine3d(x,y,0, x,y,10) ;
          x = 1 ; y = a*x*x+b ;
          fLine3d(x,y,0, x,y,10) ;
          
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


class paraZ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double a = 1.0 ;
     double b = 0.0 ;
     double z = 0.0 ;

   public paraZ3d(double al, double projFactor, 
                 double a, double b, double z) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.a = a ;
        this.b = b ;
        this.z = z ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double y = a*t*t+b ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}






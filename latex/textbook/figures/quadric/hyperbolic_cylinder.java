                  /*  File:  hyperbolic_cylinder.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class hyperbolic_cylinder extends Template {

     static {templateClass = new hyperbolic_cylinder() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;


     public void setup() {
          filePrefix = "hyperbolic_cylinder" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
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
          double a = 1 ;
          double b = 2 ;
          double z = 0 ;
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;


          fEnv("lineWidth", 1.0) ;
//          fEnv("useColorPs", "true") ;
//          String Red = "0 1 1 0 setcmykcolor  " ;
//          String Black = "0 0 0 1 setcmykcolor  " ;
//          String Blue = "1 1 0 0 setcmykcolor  " ;
//          canvas.append( new fPsWrite(Red+"\n")) ;
          fCurve(new hyperZ3d(al, 0.5,   a,b,0),-5, -3.1,OPEN)  ;
          fCurve(new hyperZ3d(al, 0.5,   a,b,0), 0.8, 15,OPEN)  ;
          fCurve(new hyperZ3d(al, 0.5,   a,b,10),-5,15,OPEN)  ;
          fCurve(new hyperZ3d(al, 0.5,   -a,b,0),-0.8, 5,OPEN)  ;
          fCurve(new hyperZ3d(al, 0.5,   -a,b,10),-15,5,OPEN)  ;

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          fCurve(new hyperZ3d(al, 0.5,   a,b,0),-3.1, 0.8,OPEN)  ;
          fCurve(new hyperZ3d(al, 0.5,   -a,b,0),-15, -0.8,OPEN)  ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          double x = 15 ; double y = a*Math.sqrt(1+x*x/b/b) ; 

          fLine3d(x,y,0, x,y,10) ;
          x = -5 ; y = a*Math.sqrt(1+x*x/b/b) ; ;
          fLine3d(x,y,0, x,y,10) ;
          x = 0.8 ; y = a*Math.sqrt(1+x*x/b/b) ; ;
          fLine3d(x,y,0, x,y,10) ;
          x = -15 ;  y = -a*Math.sqrt(1+x*x/b/b) ; ;
          fLine3d(x,y,3, x,y,10) ;
          x = 5 ; y = -a*Math.sqrt(1+x*x/b/b) ; ;
          fLine3d(x,y,0, x,y,10) ;
          x = -0.8 ; y = -a*Math.sqrt(1+x*x/b/b) ; ;
          fLine3d(x,y,0, x,y,10) ;

          canvas.append( new fPsWrite("[3 3] 1.5 setdash\n")) ;
          x = -15 ;  y = -a*Math.sqrt(1+x*x/b/b) ; ;
          fLine3d(x,y,0, x,y,3) ;
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

}


class hyperZ3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double a = 1.0 ;
     double b = 1.0 ;
     double z = 0.0 ;

   public hyperZ3d(double al, double projFactor, 
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
          double y = a*Math.sqrt(1+t*t/b/b) ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}






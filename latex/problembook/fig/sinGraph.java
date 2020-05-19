                  /*  File:  sinGraph.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class sinGraph extends Template {

     static {templateClass = new sinGraph() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "sinGraph" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.5 ;    
          ysize = 2.5 ;  
          xmin = -5 ;
          xmax =  10 ;
          ymin = -7 ;
          ymax =  3 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = -0.2 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          x1 = Math.sin(Math.PI*(1+al/180)) ;
          double xm = 8 ;
          double ym = 5 ;
          double zm = 1.3 ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,-zm, 0,0,zm) ;
          fLine3d(0,-1,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.2, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.5,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.2,-0.2, "tr", "$x$") ;

          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new sin3d(al, 0.5,  0),  0,2*Math.PI,OPEN)  ;
          fCurve(new sin3d(al, 0.5,  2),  0,2*Math.PI,OPEN)  ;
          fCurve(new sin3d(al, 0.5,  4),  0,2*Math.PI,OPEN)  ;
          
          double x = 0 ;
          fLine3d(x,0,1.5*Math.sin(x), x,4,1.5*Math.sin(x)) ;
          x=0.5*Math.PI ; fLine3d(x,0,1.5*Math.sin(x), x,4,1.5*Math.sin(x)) ;
          x=Math.PI ; fLine3d(x,0,1.5*Math.sin(x), x,4,1.5*Math.sin(x)) ;
          x=1.5*Math.PI ; fLine3d(x,0,1.5*Math.sin(x), x,4,1.5*Math.sin(x)) ;
          x=2*Math.PI ; fLine3d(x,0,1.5*Math.sin(x), x,4,1.5*Math.sin(x)) ;

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




class sin3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cy = 0.0 ;

   public sin3d(double al, double projFactor, double cy) {
        this.al = al ;
        this.projFactor = projFactor ;
        this.cy = cy ;
   }



     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double y = cy ;
          double z = 1.5*Math.sin(t) ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




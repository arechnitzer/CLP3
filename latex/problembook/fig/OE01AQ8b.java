                  /*  File:  OE01AQ8b.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE01AQ8b extends Template {

     static {templateClass = new OE01AQ8b() ; }
     static double x0 = 100 ;
     static double x1 =   0 ;

     public void setup() {
          filePrefix = "OE01AQ8b" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0 ;    
          ysize = 4.0 ;  
          xmin = -3 ;
          xmax =  4 ;
          ymin = -3 ;
          ymax =  4 ;
          topmargin = -0.5 ;   // in inches
          bottommargin = -0.8 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
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
          double xm = 2.5 ;
          double ym = 3.5 ;
          double zm = 2.5 ;

          fEnv("lineWidth", 0.5) ;
          fLine3d(0,0,0, 0,0,zm) ;
          fLine3d(0,0,0, 0,ym,0) ;
          fLine3d(0,0,0, xm,0,0) ;
          fTeXlabel3d(0,0,zm+0.1, "cb", "$z$") ;
          fTeXlabel3d(0,ym+0.1,0, "cl", "$y$") ;
          fTeXlabel3d(xm,-0.02,-0.02, "tr", "$x$") ;

          fCurve(new para3d(al, 0.5, 3), 0,1,OPEN)  ;
          fLine3d(0,0,1,  0,3,1) ;
          fLine3d(1,0,0,  1,3,0) ;
          fLine3d(0,3,0,  0,3,1) ;
          fLine3d(1,3,0,  0,3,0) ;

          fLine3d(0,0,2,  0,2,0) ;
          fLine3d(0,0,2,  2,0,0) ;
          fLine3d(0,2,0,  2,0,0) ;

          fEnv("lineWidth", 1.0) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve(new para3d(al, 0.5,  0), 0,1,OPEN)  ;
          fCurve(new bpara3d(al, 0.5), 0,1,OPEN)  ;
          fLine3d(0,0,1,  0,1,1) ;
          fLine3d(1,0,0,  1,1,0) ;

          fLine3d(0,0,0, 0,0,1) ;
          fLine3d(0,0,0, 0,2,0) ;
          fLine3d(0,0,0, 1,0,0) ;

          fLine3d(0,1,1,  0,2,0) ;
          fLine3d(1,1,0,  0,2,0) ;  

          fTeXlabel3d(0,0.05,1.05, "bl", "$a$") ;        
          fTeXlabel3d(0,0.05,0.05, "bl", "$b$") ;        
          fTeXlabel3d(1,-0.05,0.05, "br", "$c$") ;   
          fTeXlabel3d(0,1.02,1.05, "bl", "$d$") ;        
          fTeXlabel3d(0,2.05,0.08, "bl", "$f$") ;        
          fTeXlabel3d(1,1.02,-0.05, "tl", "$g$") ;        

          fTeXlabel3d(0,0.52,1.52, "bl", "$x+y+z=2$") ;        
          fTeXlabel3d(0,3,1.05, "br", "$z=1-x^2$") ;        
     
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




class para3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection
     double cy = 0.0 ;

   public para3d(double al, double projFactor, double cy) {
        this.cy = cy ;
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double y = cy ;
          double z = 1-t*t ; ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}


class bpara3d implements S2V {

     double al = 45 ;
     double projFactor = 0.5 ;
          // normally 0.5 for cabinet projection
          // normally 1.0 for cavalier projection

   public bpara3d(double al, double projFactor) {
   }

     public double[] map(double t) {
          
          double x0 = projFactor*Math.cos(Math.PI*(1+al/180)) ; 
          double x1 = projFactor*Math.sin(Math.PI*(1+al/180)) ;
          double[] out = {0,0} ;
          double x = t ;
          double z = 1-t*t ; ;
          double y = 2-x-z ;
          out[0] = x*x0+y ;
          out[1] = x*x1+z;
          return out ;
   }
}




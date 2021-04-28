                  /*  File:  cyl5.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cyl5 extends Template {

     static {templateClass = new cyl5() ; }

     public void setup() {
          filePrefix = "cyl5" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0;  
          xmin = -20 ;
          xmax =  130 ;
          ymin = -100 ;
          ymax =  50 ;
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
          double al = 30 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r1 = 80 ;
          double r2 = 120 ;
          double z = 20 ;
          double th1 = 50 ;
          double th2 = 80 ;



          fEnv("lineWidth", 0.5) ;
          fLine(0,z,  
                r1*Math.cos(th1*Math.PI/180)*x0+r1*Math.sin(th1*Math.PI/180), 
                r1*Math.cos(th1*Math.PI/180)*x1+z) ;
          fLine(0,z,  
                r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180),
                 r1*Math.cos(th2*Math.PI/180)*x1+z) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,0, r2),th1,th2,OPEN)  ;
          fCurve(new circ3d(al, a, 0.5,   0,0,z, r2),th1,th2,OPEN)  ;
          fCurve(new circ3d(al, a, 0.5,   0,0,z, r1),th1,th2,OPEN)  ;
          fLine(r1*Math.cos(th1*Math.PI/180)*x0+r1*Math.sin(th1*Math.PI/180), 
                r1*Math.cos(th1*Math.PI/180)*x1+z,
                r2*Math.cos(th1*Math.PI/180)*x0+r2*Math.sin(th1*Math.PI/180), 
                r2*Math.cos(th1*Math.PI/180)*x1+z) ;
          fLine(r2*Math.cos(th1*Math.PI/180)*x0+r2*Math.sin(th1*Math.PI/180), 
                r2*Math.cos(th1*Math.PI/180)*x1,
                r2*Math.cos(th1*Math.PI/180)*x0+r2*Math.sin(th1*Math.PI/180), 
                r2*Math.cos(th1*Math.PI/180)*x1+z) ;
          fLine(r2*Math.cos(th1*Math.PI/180)*x0+r2*Math.sin(th1*Math.PI/180),
                r2*Math.cos(th1*Math.PI/180)*x1,
                r2*Math.cos(th1*Math.PI/180)*x0+r2*Math.sin(th1*Math.PI/180),
                r2*Math.cos(th1*Math.PI/180)*x1+z) ;
          fLine(r1*Math.cos(th1*Math.PI/180)*x0+r1*Math.sin(th1*Math.PI/180),
                r1*Math.cos(th1*Math.PI/180)*x1,
                r2*Math.cos(th1*Math.PI/180)*x0+r2*Math.sin(th1*Math.PI/180),
                r2*Math.cos(th1*Math.PI/180)*x1) ;
          fLine(r1*Math.cos(th1*Math.PI/180)*x0+r1*Math.sin(th1*Math.PI/180),
                r1*Math.cos(th1*Math.PI/180)*x1+z,
                r1*Math.cos(th1*Math.PI/180)*x0+r1*Math.sin(th1*Math.PI/180),
                r1*Math.cos(th1*Math.PI/180)*x1) ;
          fLine(r2*Math.cos(th2*Math.PI/180)*x0+r2*Math.sin(th2*Math.PI/180),
                r2*Math.cos(th2*Math.PI/180)*x1+z,
                r2*Math.cos(th2*Math.PI/180)*x0+r2*Math.sin(th2*Math.PI/180),
                r2*Math.cos(th2*Math.PI/180)*x1) ;
          fLine(r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180),
                r1*Math.cos(th2*Math.PI/180)*x1+z,
                r2*Math.cos(th2*Math.PI/180)*x0+r2*Math.sin(th2*Math.PI/180),
                r2*Math.cos(th2*Math.PI/180)*x1+z) ;
          fTeXlabel(r1*Math.cos(th2*Math.PI/180)/2*x0+r1*Math.sin(th2*Math.PI/180)/2,
                 r1*Math.cos(th2*Math.PI/180)*x1+z+6, "bc", "$\\rho$") ;
          fTeXlabel(r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180)+22,
                 r1*Math.cos(th2*Math.PI/180)*x1+z+4, "bc", "$\\dee{\\rho}$") ;
          fTeXlabel(r2*Math.cos(th2*Math.PI/180)*x0+r2*Math.sin(th2*Math.PI/180)+3,
                r2*Math.cos(th2*Math.PI/180)*x1+z/2+2, "lc", "$\\dee{z}$") ;
          fTeXlabel(r2*Math.cos(th2*Math.PI/180)*x0+r2*Math.sin(th2*Math.PI/180)-30,
                r2*Math.cos(th2*Math.PI/180)*x1-13, "lc", "$\\rho\\,\\dee{\\phi}$") ;

          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fCurve(new circ3d(al, a, 0.5,   0,0,0, r1),th1,th2,OPEN)  ;
          fLine(r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180),
                r1*Math.cos(th2*Math.PI/180)*x1,
                r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180),
                r1*Math.cos(th2*Math.PI/180)*x1+z) ;
          fLine(r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180),
                r1*Math.cos(th2*Math.PI/180)*x1,
                r2*Math.cos(th2*Math.PI/180)*x0+r2*Math.sin(th2*Math.PI/180),
                r2*Math.cos(th2*Math.PI/180)*x1) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fLine(0,
                0,
                0,
                z) ;
          fLine(0,
                0,
                r1*Math.cos(th2*Math.PI/180)*x0+r1*Math.sin(th2*Math.PI/180),
                r1*Math.cos(th2*Math.PI/180)*x1) ;
          fLine(0,
                0,
                r1*Math.cos(th1*Math.PI/180)*x0+r1*Math.sin(th1*Math.PI/180),
                r1*Math.cos(th1*Math.PI/180)*x1) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          
          fTeXlabel(55,-35, "tc", "volume element $\\dee{V}=\\rho\\,\\dee{\\rho}\\,\\dee{\\phi}\\,\\dee{z}$") ;

          
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




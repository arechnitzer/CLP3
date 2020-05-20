                  /*  File:  domainCylinderCone.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainCylinderCone extends Template {

     static {templateClass = new domainCylinderCone() ; }

     public void setup() {
          filePrefix = "domainCylinderCone" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
          ysize = 2.0 ;  
          xmin = -120 ;
          xmax =  150 ;
          ymin = -120 ;
          ymax =  150 ;
          topmargin = 0.2 ;   // in inches
          bottommargin = 0.1 ;   // in inches
          leftmargin = 0.3 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 45 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0, xmax*x1, "tr", "$x$") ;


          fEnv("lineWidth", 1.0) ;
          fLine(0, 2*a, 2*a*x0, 2*a*x1) ;
          fTeXlabel(-39, 20, "rc", "$r=2a-z$") ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          double C1 = 2*a*x0 ;
          double C2 = 2*a*x1 ;
          double C3 = 2*a ;
          fCurve("["+C1+"*cos(t)+"+C3+"*sin(t), "+C2+"*cos(t)]", 1, 0, Math.PI/2, OPEN) ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          C1 = a*x0 ;
          C2 = a*x1 ;
          C3 = a ;
          fCurve("["+C3+"*(1+cos(t))+"+C1+"*sin(t), "+C2+"*sin(t)]", 1, 0, Math.PI, OPEN);
          fCurve(new CCintersect(),0,2*a,OPEN)  ;
          fLine(0, 2*a, 2*a, 0) ;
          fLine(0,   0, 2*a, 0) ;
          fLine(0,   0,   0, 2*a) ;


          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("lineWidth", 0.5) ;
          fTeXlabel(-70,-40, "rc", "$r=2a\\sin\\theta$") ;
          fTeXlabel(-15, -50, "tl", "$r=2a$") ;
          fArrow(-65, -42, C1+a-30, C1) ;


          
     }
}

class CCintersect implements S2V {


   public CCintersect() {
   }

     public double[] map(double t) {
          double al = 45 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
      double[] out = {0,0} ;
      double x = Math.sqrt(2*a*t-t*t) ;
      double y = t ;
      double z = 2*a -Math.sqrt(2*a*t) ;
      out[0] = x*x0+y ;
      out[1] = x*x1+z;
      return out ;
   }
}



                  /*  File:  domainCylinderConeb.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class domainCylinderConeb extends Template {

     static {templateClass = new domainCylinderConeb() ; }

     public void setup() {
          filePrefix = "domainCylinderConeb" ;  
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
          leftmargin = 0.0 ;   // in inches
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


          fEnv("lineWidth", 1.0) ;
          fLine(0, 2*a, 0, 0) ;
          fLine(0, 2*a, 2*a, 2*a) ;
          fLine(2*a, 0, 2*a, 2*a) ;
          fLine(0, 0, 2*a, 0) ;
          double C1 = a*x0 ;
          double C2 = a*x1 ;
          double C3 = a ;
          double C4 = 2*a ;
          fCurve("["+C3+"*(1+cos(t))+"+C1+"*sin(t), "+C2+"*sin(t)]", 1, 0, Math.PI, OPEN);
          fCurve("["+C3+"*(1+cos(t))+"+C1+"*sin(t), "+C2+"*sin(t)+"+C4+"]", 1, 0, Math.PI, OPEN) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0, xmax*x1, "tr", "$x$") ;
          fTeXlabel(-20, -38, "tl", "$r=2a\\sin\\theta$") ;
          
     }
}




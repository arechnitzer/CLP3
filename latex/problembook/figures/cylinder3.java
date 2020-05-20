                  /*  File:  cylinder3.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cylinder3 extends Template {

     static {templateClass = new cylinder3() ; }

     public void setup() {
          filePrefix = "cylinder3" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0*0.7 ;    
          ysize = 2.7*0.7 ;  
          xmin = -100 ;
          xmax =  100 ;
          ymin = -150 ;
          ymax =  200 ;
          topmargin = 0.1 ;   // in inches
          bottommargin = -0.2 ;   // in inches
          leftmargin = 0.0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double al = 70 ;
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double h = 150 ;
          double phi = Math.atan(2*a/h) ;


          fEnv("lineWidth", 1.0) ;
          fLine(-a, 0, -a, h) ;
          fLine(a, 0, a, h) ;
          double C1 = a*x0 ;
          double C2 = a*x1 ;
          double C3 = a ;
          fCurve("["+C1+"*cos(t)+"+C3+"*sin(t), "+C2+"*cos(t)]", 
                         1, -Math.PI/2, Math.PI/2, OPEN) ;
          fCurve("["+C1+"*cos(t)+"+C3+"*sin(t), "+C2+"*cos(t)+"+h+"]", 
                         1, 0, 2*Math.PI, OPEN) ;
          canvas.append( new fPsWrite("[3 3] 1.4 setdash\n")) ;
          fCurve("["+C1+"*cos(t)+"+C3+"*sin(t), "+C2+"*cos(t)]", 
                         1, Math.PI/2, 3*Math.PI/2, OPEN) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, xmax*x0, xmax*x1) ;
          fLine(0,0, a,h/2) ;
          fEllipticalArc(0,0, 50,50, 90-phi*180/Math.PI, 90, OPEN) ;
          fTeXlabel(xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(xmax*x0, xmax*x1, "tr", "$x$") ;
          fTeXlabel(15,53, "lb", "$\\varphi$") ;
          fTeXlabel(0,-35, "tl", "$\\varphi>\\tan^{-1}\\frac{a}{h}$") ;
          fTeXlabel(a+10,h/2, "lc", "$\\rho=\\frac{a}{\\sin\\varphi}$") ;
          
     }
}




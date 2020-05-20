                  /*  File:  elliptical_cylinder.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class elliptical_cylinder extends Template {

     static {templateClass = new elliptical_cylinder() ; }

     public void setup() {
          filePrefix = "elliptical_cylinder" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2.0 ;    
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
          double aspect = (ymax-ymin)/(xmax-xmin)*xsize/ysize ;

          double a = 65 ;
          double h = 150 ;


          fEnv("lineWidth", 1.5) ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
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
          canvas.append( new fPsWrite(Black+"\n")) ;
          double r = 3 ;
          fDisk(C3,0,r,r*aspect, FILLED) ;
          fDisk(C1,C2,r,r*aspect, FILLED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0,0,0.8*xmax,0) ;
          fLine(0,0,0,ymax) ;
          fLine(0,0, 1.2*xmax*x0, 1.2*xmax*x1) ;
//          fLine(0,0, 2*a/3,h) ;
//          fEllipticalArc(0,0, 50,50, 90-phi*180/Math.PI, 90, OPEN) ;
          fTeXlabel(0.8*xmax+5,0, "lc", "$y$") ;
          fTeXlabel(0,ymax+5, "bc", "$z$") ;
          fTeXlabel(1.2*xmax*x0, 1.2*xmax*x1, "tr", "$x$") ;

          fEnv("headHalfWidth", 2*1.2) ;
          fEnv("headLength", 6*1.2) ;
          fArrow(1.5*C3, 1.5*C2, C3+2, -2) ;
          fArrow(-C3, 2*C2, C1-4, C2-3) ;
          fTeXlabel(1.5*C3+2, 1.5*C2, "lc", "$(0,4,0)$") ;
          fTeXlabel(-C3-2, 2*C2, "rc", "$(2,0,0)$") ;

          
     }
}




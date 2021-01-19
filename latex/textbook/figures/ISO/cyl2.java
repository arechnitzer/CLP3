                  /*  File:  cyl2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cyl2 extends Template {

     static {templateClass = new cyl2() ; }

     public void setup() {
          filePrefix = "cyl2" ;  
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5 ;    
          ysize = 1.5 ;  
          xmin = -50 ;
          xmax =  100 ;
          ymin = -70 ;
          ymax =  80 ;
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
          double al = 65 ;
//          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
//          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double x = 65 ;
          double y = 25 ;
          double z = 35 ;
          double xm = 40 ;
          double ym = 60 ;
          double zm = 80 ;
          double r = 4 ;



          fEnv("lineWidth", 0.5) ;
          fLine(65,0,80,0) ;
          fLine(0,z,0,ym) ;
          fLine(0.65*xm*x0, 0.65*xm*x1, xm*x0, xm*x1) ;
          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(0,0,60,0) ;
          fLine(0,0,0,z) ;
          fLine(0,0,0.55*xm*x0, 0.55*xm*x1) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;
          fTeXlabel(85,0, "lc", "$y$") ;
          fTeXlabel(0,ym+5, "bc", "$z$") ;
          fTeXlabel(xm*x0, xm*x1, "tr", "$x$") ;

          fDisk(0,z,r,r,FILLED) ; 


          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.33333 0.66666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0,z, ymax,z) ;
          fLine(ymax,z, x*x0+ymax, x*x1+z) ;
          fLine(0,z, x*x0, x*x1+z) ;
          fLine(x*x0, x*x1+z, x*x0+ymax, x*x1+z) ;
          fTeXlabel(-2, z+2, "br", "$(0,0,z)$") ;

          fTeXlabel(20,-50, "tc", "surface of constant $z$") ;
          fTeXlabel(20,-68, "tc", "(a plane)") ;
          
     }
}




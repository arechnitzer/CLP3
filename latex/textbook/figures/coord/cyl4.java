                  /*  File:  cyl4.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class cyl4 extends Template {

     static {templateClass = new cyl4() ; }

     public void setup() {
          filePrefix = "cyl4" ;  
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
          double x0 = 0.5*Math.cos(Math.PI*(1+al/180)) ;  // cabinet projection
          double x1 = 0.5*Math.sin(Math.PI*(1+al/180)) ;
//          double x0 = Math.cos(Math.PI*(1+al/180)) ;  // cavalier projection
//          double x1 = Math.sin(Math.PI*(1+al/180)) ;
          double a = 65 ;
          double r = 70 ;
          double th = Math.PI/3.5 ;
          double x = r*Math.cos(th) ;
          double y = r*Math.sin(th) ;
          double z = 70 ;
          double xm = 80 ;
          double ym = 60 ;
          double zm = 80 ;



          fEnv("lineWidth", 0.5) ;
          fLine(0,0,0,zm) ;
          fLine(0,0, xm*x0, xm*x1) ;
          fTeXlabel(ym+4,0, "lc", "$y$") ;
          fTeXlabel(0,zm+4, "bc", "$z$") ;
          fTeXlabel(xm*x0-1, xm*x1-1, "tr", "$x$") ;
          fTeXlabel(3,-5, "tc", "$\\theta$") ;
          fLine(x*x0+y,0, ym,0) ;
          canvas.append( new fPsWrite("[3 3] 0.0 setdash\n")) ;
          fLine(0,0, x*x0+y,0) ;
          canvas.append( new fPsWrite("[ ] 0 setdash\n")) ;

          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 1.0) ;
          fLine(0,0, 0,z) ;
          fLine(0,0, x*x0+y,x*x1) ;
          fLine(0,z, x*x0+y,x*x1+z) ;
          fLine(x*x0+y,x*x1, x*x0+y,x*x1+z) ;

          fTeXlabel(20,-50, "tc", "surface of constant $\\theta$") ;
          fTeXlabel(20,-68, "tc", "(a plane)") ;
     }
}



